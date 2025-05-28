package io.github.aabmets.prooffroglang.utils;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Files;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ProofFrogDownloader {
    private static final HttpClient client = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.NEVER)
            .build();

    public static String locateGithubRelease(String latestUrl, String releaseNameConstraint) {
        String component = URI.create(latestUrl).getPath().split("/")[1];
        RuntimeException error = new RuntimeException("Cannot find latest release for " + component + ".");
        try {
            // 1) HEAD to get redirect location
            HttpRequest req1 = HttpRequest.newBuilder()
                    .uri(URI.create(latestUrl))
                    .GET()
                    .build();
            HttpResponse<Void> res1 = client.send(req1, HttpResponse.BodyHandlers.discarding());
            Optional<String> loc1 = res1.headers().firstValue("location");
            if ((res1.statusCode() != 301 && res1.statusCode() != 302) || loc1.isEmpty()) throw error;

            // 2) GET expanded assets page
            String expandedUrl = loc1.get();
            HttpResponse<String> res2 = client.send(
                    HttpRequest.newBuilder().uri(URI.create(expandedUrl)).GET().build(),
                    HttpResponse.BodyHandlers.ofString()
            );
            if (res2.statusCode() != 200) throw error;
            Matcher m1 = Pattern.compile("\"(https://[\\w/.\\-]+/expanded_assets/[\\w/.\\-]+)\"")
                    .matcher(res2.body());
            if (!m1.find()) throw error;

            // 3) GET asset listing
            String assetsUrl = m1.group(1);
            HttpResponse<String> res3 = client.send(
                    HttpRequest.newBuilder().uri(URI.create(assetsUrl)).GET().build(),
                    HttpResponse.BodyHandlers.ofString()
            );
            if (res3.statusCode() != 200) throw error;
            String constraint = Pattern.quote(releaseNameConstraint);
            Pattern p2 = Pattern.compile("\"([\\w/.\\-]+/download/[\\w/.\\-]+" + constraint + ")\"");
            Matcher m2 = p2.matcher(res3.body());
            if (!m2.find()) throw error;

            // 4) HEAD to get final download URL
            String downloadPath = m2.group(1);
            HttpResponse<Void> res4 = client.send(
                    HttpRequest.newBuilder().uri(URI.create("https://github.com" + downloadPath)).GET().build(),
                    HttpResponse.BodyHandlers.discarding()
            );
            Optional<String> loc4 = res4.headers().firstValue("location");
            if ((res4.statusCode() != 301 && res4.statusCode() != 302) || loc4.isEmpty()) throw error;

            return loc4.get();
        } catch (IOException | InterruptedException e) {
            throw error;
        }
    }

    public static void downloadFileToDisk(String url, Path destPath) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                throw new IOException("Failed to download, HTTP status: " + response.statusCode());
            }
            try (InputStream in = response.body();
                 OutputStream out = Files.newOutputStream(destPath)) {
                byte[] buf = new byte[8192];
                int n;
                while ((n = in.read(buf)) > 0) {
                    out.write(buf, 0, n);
                }
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error downloading file from " + url, e);
        }
    }

    private static void extractArchive(Path archive, Path targetPath) throws IOException {
        String name = archive.getFileName().toString().toLowerCase(Locale.ROOT);
        if (name.endsWith(".zip")) {
            extractZip(archive, targetPath);
        } else if (name.endsWith(".tar.gz") || name.endsWith(".tgz")) {
            extractTarGz(archive, targetPath);
        } else {
            throw new IllegalArgumentException("Unsupported archive format: " + name);
        }
    }

    private static void extractZip(Path zipPath, Path targetPath) throws IOException {
        Path canonicalBase = targetPath.toAbsolutePath().normalize();
        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(zipPath))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                Path resolvedPath = targetPath.resolve(entry.getName());
                Path canonicalOut = resolvedPath.toAbsolutePath().normalize();
                if (!canonicalOut.startsWith(canonicalBase)) {
                    throw new IOException("Bad zip entry: " + entry.getName());
                }
                if (entry.isDirectory()) {
                    Files.createDirectories(canonicalOut);
                } else {
                    Files.createDirectories(canonicalOut.getParent());
                    try (OutputStream out = Files.newOutputStream(canonicalOut)) {
                        byte[] buffer = new byte[8192];
                        int len;
                        while ((len = zis.read(buffer)) != -1) {
                            out.write(buffer, 0, len);
                        }
                    }
                }
                zis.closeEntry();
            }
        }
    }

    private static void extractTarGz(Path tarGzPath, Path targetPath) throws IOException {
        Path canonicalBase = targetPath.toAbsolutePath().normalize();
        try (InputStream fis = Files.newInputStream(tarGzPath);
            GzipCompressorInputStream gis = new GzipCompressorInputStream(fis);
            TarArchiveInputStream tis = new TarArchiveInputStream(gis)
        ) {
            TarArchiveEntry entry;
            while ((entry = tis.getNextEntry()) != null) {
                Path resolvedPath = targetPath.resolve(entry.getName());
                Path canonicalOut = resolvedPath.toAbsolutePath().normalize();
                if (!canonicalOut.startsWith(canonicalBase)) {
                    throw new IOException("Bad tar entry: " + entry.getName());
                }
                if (entry.isDirectory()) {
                    Files.createDirectories(canonicalOut);
                } else {
                    Files.createDirectories(canonicalOut.getParent());
                    try (OutputStream out = Files.newOutputStream(canonicalOut)) {
                        byte[] buffer = new byte[8192];
                        int len;
                        while ((len = tis.read(buffer)) != -1) {
                            out.write(buffer, 0, len);
                        }
                    }
                }
            }
        }
    }

    private static void setExecutablePermission(Path targetPath) throws IOException {
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        if (!os.contains("win")) {
            Path uvBin = targetPath.resolve("uv");
            if (Files.exists(uvBin)) {
                boolean execOk = uvBin.toFile().setExecutable(true, false);
                if (!execOk) {
                    throw new IOException("Failed to set executable permission on " + uvBin);
                }
            }
        }
    }

    public static void downloadPackageManager(Path downloadDir) throws IOException {
        String latestReleaseUrl = "https://github.com/astral-sh/uv/releases/latest";
        String osName = System.getProperty("os.name").toLowerCase();

        String releaseNameConstraint;
        Path zipPath;

        if (osName.contains("win")) {
            releaseNameConstraint = "uv-x86_64-pc-windows-msvc.zip";
            zipPath = downloadDir.resolve("uv.zip");
        } else if (osName.contains("mac")) {
            releaseNameConstraint = "uv-aarch64-apple-darwin.tar.gz";
            zipPath = downloadDir.resolve("uv.tar.gz");
        } else if (osName.contains("linux")) {
            releaseNameConstraint = "uv-x86_64-unknown-linux-gnu.tar.gz";
            zipPath = downloadDir.resolve("uv.tar.gz");
        } else {
            throw new UnsupportedOperationException("Unsupported operating system: " + osName);
        }

        String location = locateGithubRelease(latestReleaseUrl, releaseNameConstraint);
        downloadFileToDisk(location, zipPath);
        extractArchive(zipPath, downloadDir);
        setExecutablePermission(zipPath);
        Files.deleteIfExists(zipPath);
    }
}