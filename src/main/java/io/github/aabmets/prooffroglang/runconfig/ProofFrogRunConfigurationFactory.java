package io.github.aabmets.prooffroglang.runconfig;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class ProofFrogRunConfigurationFactory extends ConfigurationFactory {
    private final String command;
    private final String displayName;

    public ProofFrogRunConfigurationFactory(@NotNull ConfigurationType type, @NotNull String command, @NotNull String displayName) {
        super(type);
        this.command = command;
        this.displayName = displayName;
    }

    @Override
    public @NotNull RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new ProofFrogRunConfiguration(project, this, displayName, command);
    }

    @Override
    public @NotNull String getName() {
        return displayName;
    }

    @Override
    public @NotNull String getId() {
        return "ProofFrog." + command;
    }
}
