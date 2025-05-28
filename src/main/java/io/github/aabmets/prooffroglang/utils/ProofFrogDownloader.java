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
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ProofFrogDownloader {

    private ProofFrogDownloader() {}

    private static final HttpClient client = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.NEVER)
            .build();

    @FunctionalInterface
    private interface EntrySupplier<E> {
        E getNextEntry() throws IOException;
    }

    @FunctionalInterface
    private interface EntryReader {
        int read(byte[] buffer) throws IOException;
    }

    public static String locateGithubRelease(
            String releasesUrl, String fileName) throws IOException, InterruptedException {
        String latestUrl = releasesUrl.endsWith("/") ? releasesUrl + "latest" : releasesUrl + "/latest";
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(latestUrl))
                .GET()
                .build();
        HttpResponse<Void> res = client.send(req, HttpResponse.BodyHandlers.discarding());
        Optional<String> loc = res.headers().firstValue("location");
        if ((res.statusCode() != 301 && res.statusCode() != 302) || loc.isEmpty()) {
            throw new IOException("Cannot find latest release for " + releasesUrl + ".");
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
            throw new IOException("Cannot find latest release for " + releasesUrl + ".");
        }
        return loc.get();
    }

    public static void downloadFileToDisk(String url, Path destPath) throws IOException, InterruptedException {
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
    }

    private static <E> void extractArchive(
            EntrySupplier<E> entrySupplier,
            Function<E, String> entryNameFn,
            Predicate<E> entryIsDirectoryFn,
            EntryReader entryReader,
            Path targetPath,
            Path canonicalBase
    ) throws IOException {
        E entry;
        while ((entry = entrySupplier.getNextEntry()) != null) {
            String entryName = entryNameFn.apply(entry);
            Path resolvedPath = targetPath.resolve(entryName);
            Path canonicalOut = resolvedPath.toAbsolutePath().normalize();
            if (!canonicalOut.startsWith(canonicalBase)) {
                throw new IOException("Bad archive entry: " + entryName);
            }
            if (entryIsDirectoryFn.test(entry)) {
                Files.createDirectories(canonicalOut);
            } else {
                Files.createDirectories(canonicalOut.getParent());
                try (OutputStream out = Files.newOutputStream(canonicalOut)) {
                    byte[] buffer = new byte[8192];
                    int len;
                    while ((len = entryReader.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                    }
                }
            }
        }
    }

    private static void extractZip(Path zipPath, Path targetPath) throws IOException {
        Path canonicalBase = targetPath.toAbsolutePath().normalize();
        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(zipPath))) {
            extractArchive(
                zis::getNextEntry,
                ZipEntry::getName,
                ZipEntry::isDirectory,
                zis::read,
                targetPath,
                canonicalBase
            );
        }
    }

    private static void extractTarGz(Path tarGzPath, Path targetPath) throws IOException {
        Path canonicalBase = targetPath.toAbsolutePath().normalize();
        try (InputStream fis = Files.newInputStream(tarGzPath);
             GzipCompressorInputStream gis = new GzipCompressorInputStream(fis);
             TarArchiveInputStream tis = new TarArchiveInputStream(gis)
        ) {
            extractArchive(
                tis::getNextEntry,
                TarArchiveEntry::getName,
                TarArchiveEntry::isDirectory,
                tis::read,
                targetPath,
                canonicalBase
            );
        }
    }

    private static void setExecutablePermission(Path targetPath) throws IOException {
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        Path uvBin = targetPath.resolve("uv");
        if (!os.contains("win") && Files.exists(uvBin) && !uvBin.toFile().setExecutable(true, false)) {
            throw new IOException("Failed to set executable permission on " + uvBin);
        }
    }

    public static void downloadPackageManager(Path downloadDir) throws IOException, InterruptedException {
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

        String name = zipPath.toString();
        if (name.endsWith(".zip")) {
            extractZip(zipPath, downloadDir);
        } else if (name.endsWith(".tar.gz") || name.endsWith(".tgz")) {
            extractTarGz(zipPath, downloadDir);
        }

        setExecutablePermission(zipPath);
        Files.deleteIfExists(zipPath);
    }
}