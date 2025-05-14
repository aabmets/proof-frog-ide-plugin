package io.github.aabmets.prooffroglang.runconfig;

import io.github.aabmets.prooffroglang.utils.ProofFrogRunner;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.DefaultExecutionResult;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class ProofFrogRunConfiguration extends RunConfigurationBase<ProofFrogRunConfiguration> {
    private String filePath = "";
    private final String command;
    private final Project project;

    protected ProofFrogRunConfiguration(@NotNull Project project,
                                        @NotNull ProofFrogRunConfigurationFactory factory,
                                        @NotNull String name,
                                        @NotNull String command) {
        super(project, factory, name);
        this.project = project;
        this.command = command;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(@NotNull String filePath) {
        this.filePath = filePath;
    }

    @Override
    public @NotNull SettingsEditor<ProofFrogRunConfiguration> getConfigurationEditor() {
        return new ProofFrogSettingsEditor(this.project);
    }

    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {
        if (filePath.isEmpty()) {
            throw new RuntimeConfigurationError("Please specify a ProofFrog file path");
        }
        if (!new File(filePath).exists()) {
            throw new RuntimeConfigurationWarning("File does not exist: " + filePath);
        }
    }

    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment env) {
        ProofFrogRunner runner = new ProofFrogRunner(this.project);

        return new CommandLineState(env) {
            @Override
            protected @NotNull ProcessHandler startProcess() throws ExecutionException {
                return runner.createProcessHandler(command, filePath);
            }

            @Override
            public @NotNull ExecutionResult execute(
                    @NotNull Executor executor,
                    @NotNull ProgramRunner<?> runnerProg) throws ExecutionException {
                ProcessHandler handler = startProcess();
                ConsoleView console = runner.createConsoleView(handler);
                return new DefaultExecutionResult(console, handler);
            }
        };
    }

    @Override
    public void writeExternal(@NotNull Element element) throws WriteExternalException {
        super.writeExternal(element);
        element.setAttribute("filePath", filePath);
    }

    @Override
    public void readExternal(@NotNull Element element) throws InvalidDataException {
        super.readExternal(element);
        String fp = element.getAttributeValue("filePath");
        if (fp != null) {
            filePath = fp;
        }
    }
}