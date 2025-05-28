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
    public static final String ACTION_TEXT = "Open Plugin Directory";

    public ProofFrogOpenPluginDirAction() {
        super(ACTION_TEXT);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Path pluginDir = ProofFrogPaths.getPluginDir();
        if (pluginDir == null) {
            String msg = "Cannot locate the Proof Frog plugin directory.";
            Messages.showErrorDialog(msg, ACTION_TEXT);
            return;
        }
        try {
            Desktop.getDesktop().open(pluginDir.toFile());
        } catch (IOException | UnsupportedOperationException e) {
            String msg = "Failed to open the plugin directory:\n" + e.getMessage();
            Messages.showErrorDialog(msg, ACTION_TEXT);
        }
    }

}
