package io.github.aabmets.prooffroglang.actions;

import io.github.aabmets.prooffroglang.utils.ProofFrogNotifier;
import io.github.aabmets.prooffroglang.utils.ProofFrogSetup;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ProofFrogUpdateLibraryAction extends AnAction implements DumbAware {
    public static final String ACTION_ID = "ProofFrog.UpdateLibraryAction";

    public ProofFrogUpdateLibraryAction() {
        super("Update Library");
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        ProofFrogNotifier notifier = new ProofFrogNotifier(e.getProject());
        try {
            ProofFrogSetup setup = new ProofFrogSetup();
            String message = setup.updateProofFrogLibrary();
            if (message == null) {
                notifier.notifyError("Cannot update ProofFrog library, unable to find UV package manager.");
            } else {
                notifier.notifyInfo(message);
            }
        } catch (IOException ex) {
            notifier.notifyError("An error occurred while updating ProofFrog library: " + ex.getMessage());
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            notifier.notifyError("The update operation was interrupted.");
        }
    }

}
