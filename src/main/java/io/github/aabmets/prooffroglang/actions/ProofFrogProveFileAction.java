package io.github.aabmets.prooffroglang.actions;

import com.intellij.openapi.actionSystem.ActionManager;
import io.github.aabmets.prooffroglang.utils.ProofFrogRunner;

import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProofFrogProveFileAction extends ProofFrogBaseAction {
    public static final String ACTION_ID = "ProofFrog.ProveFileAction";
    public static final String ACTION_TEXT = "Verify Security Proof";

    public ProofFrogProveFileAction(ActionManager am) {
        super(am, ACTION_ID, ACTION_TEXT);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        FileDocumentManager.getInstance().saveAllDocuments();
        ProofFrogRunner runner = new ProofFrogRunner(e.getProject());
        runner.prove(e.getData(CommonDataKeys.VIRTUAL_FILE));
    }

    @Override
    protected @NotNull List<String> getAllowedExtensions() {
        return List.of("proof");
    }

}