package io.github.aabmets.prooffroglang.utils;

import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManagerCore;
import com.intellij.openapi.extensions.PluginId;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Files;
import java.nio.file.Path;

public class ProofFrogPaths {

    public static @Nullable Path getPluginDir() {
        PluginId id = PluginId.getId("io.github.aabmets.proof-frog-lang");
        IdeaPluginDescriptor descriptor = PluginManagerCore.getPlugin(id);
        return descriptor == null ? null : descriptor.getPluginPath();
    }

    public static Path getPackageManagerFile() {
        Path pluginDir = getPluginDir();
        if (pluginDir == null) {
            return null;
        }
        String osName = System.getProperty("os.name").toLowerCase();
        String pmFile = osName.contains("win") ? "uv.exe" : "uv";
        return pluginDir.resolve(pmFile);
    }

    public static boolean isPackageManagerInstalled() {
        Path pmFile = ProofFrogPaths.getPackageManagerFile();
        return pmFile != null && Files.exists(pmFile);
    }

}
