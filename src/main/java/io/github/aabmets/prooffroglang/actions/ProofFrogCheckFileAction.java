package io.github.aabmets.prooffroglang.actions;

import com.intellij.openapi.actionSystem.ActionManager;
import io.github.aabmets.prooffroglang.utils.ProofFrogRunner;

import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import org.jetbrains.annotations.NotNull;

public class ProofFrogCheckFileAction extends ProofFrogBaseAction {
    public static final String ACTION_ID = "ProofFrog.CheckFileAction";
    public static final String ACTION_TEXT = "Check Syntax and Types";

    public ProofFrogCheckFileAction(ActionManager am) {
        super(am, ACTION_ID, ACTION_TEXT);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        FileDocumentManager.getInstance().saveAllDocuments();
        ProofFrogRunner runner = new ProofFrogRunner(e.getProject());
        runner.check(e.getData(CommonDataKeys.VIRTUAL_FILE));
    }

}