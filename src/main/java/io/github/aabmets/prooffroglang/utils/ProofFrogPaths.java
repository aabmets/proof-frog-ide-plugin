package io.github.aabmets.prooffroglang.utils;

import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManagerCore;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectUtil;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProofFrogPaths {

    public static @Nullable Path getProjectDir(@Nullable Project project) {
        if (project == null) return null;
        VirtualFile projectDir = ProjectUtil.guessProjectDir(project);
        return projectDir == null ? null : Paths.get(projectDir.getPath());
    }

    public static @Nullable Path getPluginDir() {
        PluginId id = PluginId.getId("io.github.aabmets.proof-frog-lang");
        IdeaPluginDescriptor descriptor = PluginManagerCore.getPlugin(id);
        return descriptor == null ? null : descriptor.getPluginPath();
    }

    public static @Nullable Path getPackageManagerFile() {
        Path pluginDir = getPluginDir();
        if (pluginDir == null) {
            return null;
        }
        String osName = System.getProperty("os.name").toLowerCase();
        String pmFile = osName.contains("win") ? "uv.exe" : "uv";
        return pluginDir.resolve(pmFile);
    }

    public static @Nullable Path getVenvPythonBinaryFile(Project project) {
        String osName = System.getProperty("os.name").toLowerCase();
        String binDir = osName.contains("win") ? "Scripts" : "bin";
        String pyBin = osName.contains("win") ? "python.exe" : "python";
        Path[] searchDirs = {getProjectDir(project), getPluginDir()};
        String[] venvDirs = {".venv", "venv"};

        for (Path searchDir : searchDirs) {
            if (searchDir == null) continue;
            for (String venvDir : venvDirs) {
                Path searchVenvDir = searchDir.resolve(venvDir);
                if (Files.exists(searchVenvDir) && Files.isDirectory(searchVenvDir)) {
                    return searchVenvDir.resolve(binDir).resolve(pyBin);
                }
            }
        }
        return null;
    }

    public static boolean isPackageManagerInstalled() {
        Path pmBin = ProofFrogPaths.getPackageManagerFile();
        return pmBin != null && Files.exists(pmBin);
    }

    public static boolean pythonVenvExists(Project project) {
        Path pyBin = ProofFrogPaths.getVenvPythonBinaryFile(project);
        return pyBin != null && Files.exists(pyBin);
    }

}
