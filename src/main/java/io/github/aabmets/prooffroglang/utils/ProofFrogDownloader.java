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
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ProofFrogDownloader {
    private static final HttpClient client = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.NEVER)
            .build();

    public static String locateGithubRelease(String releasesUrl, String fileName) {
        String latestUrl = releasesUrl.endsWith("/") ? releasesUrl + "latest" : releasesUrl + "/latest";
        try {
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(latestUrl))
                    .GET()
                    .build();
            HttpResponse<Void> res = client.send(req, HttpResponse.BodyHandlers.discarding());
            Optional<String> loc = res.headers().firstValue("location");
            if ((res.statusCode() != 301 && res.statusCode() != 302) || loc.isEmpty()) {
                throw new RuntimeException("Cannot find latest release for " + releasesUrl + ".");
            }

            String redirectUrl = loc.get();
            String path = URI.create(redirectUrl).getPath();
            String tag = path.substring(path.lastIndexOf('/') + 1);

            String downloadUrl = releasesUrl.endsWith("/")
                    ? releasesUrl + "download/" + tag + "/" + fileName
                    : releasesUrl + "/download/" + tag + "/" + fileName;
            res = client.send(
                    HttpRequest.newBuilder().uri(URI.create(downloadUrl)).GET().build(),
                    HttpResponse.BodyHandlers.discarding()
            );
            loc = res.headers().firstValue("location");
            if ((res.statusCode() != 301 && res.statusCode() != 302) || loc.isEmpty()) {
                throw new RuntimeException("Cannot find latest release for " + releasesUrl + ".");
            }

            return loc.get();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error locating release for " + releasesUrl, e);
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
        String latestReleaseUrl = "https://github.com/astral-sh/uv/releases";
        String osName = System.getProperty("os.name").toLowerCase(Locale.ROOT);

        String fileName;
        Path zipPath;

        if (osName.contains("win")) {
            fileName = "uv-x86_64-pc-windows-msvc.zip";
            zipPath = downloadDir.resolve("uv.zip");
        } else if (osName.contains("mac")) {
            fileName = "uv-aarch64-apple-darwin.tar.gz";
            zipPath = downloadDir.resolve("uv.tar.gz");
        } else if (osName.contains("linux")) {
            fileName = "uv-x86_64-unknown-linux-gnu.tar.gz";
            zipPath = downloadDir.resolve("uv.tar.gz");
        } else {
            throw new UnsupportedOperationException("Unsupported operating system: " + osName);
        }

        String location = locateGithubRelease(latestReleaseUrl, fileName);
        downloadFileToDisk(location, zipPath);
        extractArchive(zipPath, downloadDir);
        setExecutablePermission(zipPath);
        Files.deleteIfExists(zipPath);
    }
}