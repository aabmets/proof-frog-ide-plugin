package io.github.aabmets.prooffroglang.utils;

import java.io.IOException;
import java.nio.file.Path;

public class ProofFrogSetup {
    private final Path pluginHome;
    private final Path uvBinary;

    public ProofFrogSetup() {
        this.pluginHome = ProofFrogPaths.getPluginDir();
        this.uvBinary = ProofFrogPaths.getPackageManagerFile();
    }

    public void runSetup() {
        try {
            runUvCommand("python", "install", "3.13.2");
            Path venvPath = pluginHome.resolve(".venv");
            runUvCommand("venv", venvPath.toString());
            runUvCommand("pip", "install", "proof_frog");
        } catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    private void runUvCommand(String... args) throws IOException, InterruptedException {
        String[] cmd = new String[args.length + 1];
        cmd[0] = uvBinary.toString();
        System.arraycopy(args, 0, cmd, 1, args.length);

        ProcessBuilder pb = new ProcessBuilder(cmd)
            .directory(pluginHome.toFile())
            .inheritIO();

        Process proc = pb.start();
        int exit = proc.waitFor();
        if (exit != 0) {
            throw new IOException("`uv " + String.join(" ", args) + "` failed (exit " + exit + ")");
        }
    }

}
