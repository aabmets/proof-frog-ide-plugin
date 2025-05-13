package io.github.aabmets.prooffroglang.utils;

import com.intellij.execution.Executor;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.filters.TextConsoleBuilder;
import com.intellij.execution.filters.TextConsoleBuilderFactory;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.RunContentDescriptor;
import com.intellij.execution.ui.RunContentManager;
import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManagerCore;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

import java.nio.file.Files;
import java.nio.file.Path;

public class ProofFrogRunner {
    private final ProofFrogNotifier notifier;
    private final Project project;
    private String exePath = null;
    private String errMsg = null;

    public ProofFrogRunner(Project project) {
        this.notifier = new ProofFrogNotifier(project);
        this.project = project;

        if (project == null) {
            this.errMsg = "No project selected";
            return;
        }
        PluginId pid = PluginId.getId("io.github.aabmets.proof-frog-lang");
        IdeaPluginDescriptor pluginDesc = PluginManagerCore.getPlugin(pid);

        if (pluginDesc == null) {
            this.errMsg = "ProofFrog plugin directory not found";
            return;
        }
        Path exePath = pluginDesc.getPluginPath().resolve("proof_frog/proof_frog.exe");
        if (!Files.isExecutable(exePath)) {
            this.errMsg = "ProofFrog runtime missing at:\n" + exePath;
            return;
        }
        this.exePath = exePath.toString();
    }

    private void run(VirtualFile targetFile, String command) {
        if (targetFile == null) {
            this.errMsg = "No file selected";
        }
        if (this.errMsg != null) {
            this.notifier.notifyError(this.errMsg);
            return;
        }
        try {
            String filePath = Path.of(targetFile.getPath()).toString();
            GeneralCommandLine cmd = new GeneralCommandLine(this.exePath, command, filePath);
            cmd.withWorkDirectory(this.project.getBasePath());

            ProcessHandler handler = new OSProcessHandler(cmd);
            TextConsoleBuilder builder = TextConsoleBuilderFactory
                .getInstance().createBuilder(this.project);

            ConsoleView console = builder.getConsole();
            console.attachToProcess(handler);

            Executor executor = DefaultRunExecutor.getRunExecutorInstance();
            String displayName = "ProofFrog: " + targetFile.getName();
            RunContentDescriptor runDesc = new RunContentDescriptor(
                    console, handler, console.getComponent(), displayName
            );
            RunContentManager.getInstance(project).showRunContent(executor, runDesc);
            handler.startNotify();
        }
        catch (Exception ex) {
            this.notifier.notifyError("Failed to run ProofFrog: " + ex.getMessage());
        }
    }

    public void parse(VirtualFile targetFile) {
        this.run(targetFile, "parse");
    }

    public void check(VirtualFile targetFile) {
        this.run(targetFile, "check");
    }

    public void prove(VirtualFile targetFile) {
        this.run(targetFile, "prove");
    }

}
