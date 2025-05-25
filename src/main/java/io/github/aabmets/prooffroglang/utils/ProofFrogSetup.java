package io.github.aabmets.prooffroglang.utils;

import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Objects;

public class ProofFrogSetup {
    private final Path pluginHome;

    public ProofFrogSetup() {
        this.pluginHome = ProofFrogPaths.getPluginDir();
    }

    public void runSetup() {
        try {
            if (!ProofFrogPaths.isPackageManagerInstalled()) {
                ProofFrogDownloader.downloadPackageManager(pluginHome);
            }
            Path uvBinPath = ProofFrogPaths.getPackageManagerFile();
            if (uvBinPath != null) {
                String uvBin = uvBinPath.toString();
                Path venvPath = pluginHome.resolve(".venv");

                runCommand(uvBin, "python", "install", "3.13.2");
                runCommand(uvBin, "venv", venvPath.toString());
                runCommand(uvBin, "pip", "install", "-U", "proof_frog");
            }
        } catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @Nullable
    public String updateProofFrogLibrary() throws IOException, InterruptedException {
        Path uvBinPath = ProofFrogPaths.getPackageManagerFile();

        if (uvBinPath != null) {
            String uvBin = uvBinPath.toString();
            String oldVersion = getInstalledProofFrogVersion(uvBin);
            runCommand(uvBin, "pip", "install", "-U", "proof_frog");
            String newVersion = getInstalledProofFrogVersion(uvBin);

            if (Objects.equals(oldVersion, newVersion)) {
                return "ProofFrog library already up-to-date (version " + newVersion + ").";
            } else {
                return "ProofFrog library updated: " + oldVersion + " → " + newVersion;
            }
        }
        return null;
    }

    private String getInstalledProofFrogVersion(String uvBin) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(uvBin, "pip", "show", "proof_frog")
            .directory(pluginHome.toFile());
        Process proc = pb.start();
        int exit = proc.waitFor();
        if (exit != 0) {
            return null;
        }
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(proc.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Version:")) {
                    return line.split(":", 2)[1].trim();
                }
            }
        }
        return null;
    }

    private void runCommand(String... args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(args)
            .directory(pluginHome.toFile())
            .inheritIO();

        Process proc = pb.start();
        int exit = proc.waitFor();
        if (exit != 0) {
            throw new IOException(
                "`uv " + String.join(" ", args) +
                "` failed (exit " + exit + ")"
            );
        }
    }

}
