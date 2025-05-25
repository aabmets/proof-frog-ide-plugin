package io.github.aabmets.prooffroglang.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.ui.Messages;
import io.github.aabmets.prooffroglang.utils.ProofFrogPaths;
import org.jetbrains.annotations.NotNull;

import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.Path;

public class ProofFrogOpenPluginDirAction extends AnAction implements DumbAware {
    public static final String ACTION_ID = "ProofFrog.OpenPluginDirAction";

    public ProofFrogOpenPluginDirAction() {
        super("Open Plugin Directory");
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Path pluginDir = ProofFrogPaths.getPluginDir();
        if (pluginDir == null) {
            Messages.showErrorDialog(
                "Cannot locate the Proof Frog plugin directory.",
                "Open Plugin Directory"
            );
            return;
        }
        try {
            Desktop.getDesktop().open(pluginDir.toFile());
            Messages.showInfoMessage("Directory opened.", "Open Plugin Directory");
        } catch (IOException | UnsupportedOperationException ex) {
            Messages.showErrorDialog(
                "Failed to open the plugin directory:\n" + ex.getMessage(),
                "Open Plugin Directory"
            );
        }
    }

}
