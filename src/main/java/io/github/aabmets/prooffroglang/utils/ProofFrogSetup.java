package io.github.aabmets.prooffroglang.utils;

import java.io.IOException;
import java.nio.file.Path;

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

    public void updateProofFrogLibrary() throws IOException, InterruptedException {
        Path uvBinPath = ProofFrogPaths.getPackageManagerFile();
        if (uvBinPath != null) {
            String uvBin = uvBinPath.toString();
            runCommand(uvBin, "pip", "install", "-U", "proof_frog");
        }
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
