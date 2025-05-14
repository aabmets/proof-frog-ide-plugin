package io.github.aabmets.prooffroglang.utils;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.executors.DefaultRunExecutor;
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
        Path exePath = pluginDesc.getPluginPath().resolve("proof_frog/proof_frog.exe");  // TODO: multiplatform compatibility
        if (!Files.isExecutable(exePath)) {
            this.errMsg = "ProofFrog runtime missing at:\n" + exePath;
            return;
        }
        this.exePath = exePath.toString();
    }

    public ProcessHandler createProcessHandler(String command, String filePath) throws ExecutionException {
        if (this.errMsg != null) {
            throw new ExecutionException(this.errMsg);
        }
        GeneralCommandLine cmd = new GeneralCommandLine(this.exePath, command, filePath);
        cmd.withWorkDirectory(this.project.getBasePath());
        return new OSProcessHandler(cmd);
    }

    public ConsoleView createConsoleView(ProcessHandler handler) {
        ConsoleView console = TextConsoleBuilderFactory
            .getInstance().createBuilder(this.project).getConsole();
        console.attachToProcess(handler);
        return console;
    }

    private void run(String command, VirtualFile targetFile) {
        if (targetFile == null) {
            this.errMsg = "No file selected";
        }
        if (this.errMsg != null) {
            this.notifier.notifyError(this.errMsg);
            return;
        }
        try {
            String filePath = Path.of(targetFile.getPath()).toString();
            ProcessHandler handler = createProcessHandler(command, filePath);
            ConsoleView console = createConsoleView(handler);

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
        this.run("parse", targetFile);
    }

    public void check(VirtualFile targetFile) {
        this.run("check", targetFile);
    }

    public void prove(VirtualFile targetFile) {
        this.run("prove", targetFile);
    }

}
