package io.github.aabmets.prooffroglang.actions;

import io.github.aabmets.prooffroglang.utils.ProofFrogRunner;

import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class ProofFrogProveFileAction extends AnAction implements DumbAware {
    public static final String ACTION_ID = "ProofFrog.ProveFileAction";

    public ProofFrogProveFileAction() {
        super("Verify Security Proof");
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        boolean visible = file != null && "proof".equals(file.getExtension());
        e.getPresentation().setEnabledAndVisible(visible);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        FileDocumentManager.getInstance().saveAllDocuments();
        ProofFrogRunner runner = new ProofFrogRunner(e.getProject());
        runner.prove(e.getData(CommonDataKeys.VIRTUAL_FILE));
    }

}