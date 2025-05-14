package io.github.aabmets.prooffroglang.runconfig;

import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;

public class ProofFrogRunConfigurationType implements ConfigurationType {
    private final ConfigurationFactory[] factories;

    public ProofFrogRunConfigurationType() {
        factories = new ConfigurationFactory[]{
                new ProofFrogRunConfigurationFactory(this, "prove", "Verify Security Proof"),
                new ProofFrogRunConfigurationFactory(this, "check", "Check Syntax and Types"),
                new ProofFrogRunConfigurationFactory(this, "parse", "Check Only Syntax")
        };
    }

    @Override
    public @NotNull String getDisplayName() {
        return "ProofFrog";
    }

    @Override
    public String getConfigurationTypeDescription() {
        return "ProofFrog run configurations";
    }

    @Override
    public @NotNull Icon getIcon() {
        return IconLoader.getIcon("/icons/frog.png", ProofFrogRunConfigurationType.class);
    }

    @Override
    public @NotNull String getId() {
        return "ProofFrogRunConfiguration";
    }

    @Override
    public ConfigurationFactory @NotNull [] getConfigurationFactories() {
        return factories;
    }
}
