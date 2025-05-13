package io.github.aabmets.prooffroglang;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Files;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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

    public static void extractArchive(Path archivePath, Path destDir) throws IOException {
        Files.createDirectories(destDir);

        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(archivePath))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                Path outPath = destDir.resolve(entry.getName());
                if (entry.isDirectory()) {
                    Files.createDirectories(outPath);
                } else {
                    Files.createDirectories(outPath.getParent());
                    try (OutputStream os = Files.newOutputStream(outPath)) {
                        byte[] buffer = new byte[8192];
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            os.write(buffer, 0, len);
                        }
                    }
                }
                zis.closeEntry();
            }
        }
    }

    public static void downloadProofFrogBinaries(Path downloadDir) throws IOException {
        String latestReleaseUrl = "https://github.com/aabmets/proof-frog-ide-plugin/releases/latest";
        Path zipPath = downloadDir.resolve("proof_frog.zip");

        String osName = System.getProperty("os.name").toLowerCase();
        String releaseNameConstraint;

        if (osName.contains("win")) {
            releaseNameConstraint = "win_amd64.zip";
        } else if (osName.contains("mac")) {
            releaseNameConstraint = "macosx_14_0_arm64.zip";
        } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            releaseNameConstraint = "manylinux_2_39_x86_64.zip";
        } else {
            throw new UnsupportedOperationException("Unsupported operating system: " + osName);
        }

        String location = locateGithubRelease(latestReleaseUrl, releaseNameConstraint);
        downloadFileToDisk(location, zipPath);
        extractArchive(zipPath, downloadDir);
        Files.delete(zipPath);
    }
}