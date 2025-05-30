package io.github.aabmets.prooffroglang.actions;

import com.intellij.openapi.actionSystem.ActionManager;
import io.github.aabmets.prooffroglang.utils.ProofFrogRunner;

import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import org.jetbrains.annotations.NotNull;

public class ProofFrogParseFileAction extends ProofFrogBaseAction {
    public static final String ACTION_ID = "ProofFrog.ParseFileAction";
    public static final String ACTION_TEXT = "Check Only Syntax";

    public ProofFrogParseFileAction(ActionManager am) {
        super(am, ACTION_ID, ACTION_TEXT);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        FileDocumentManager.getInstance().saveAllDocuments();
        ProofFrogRunner runner = new ProofFrogRunner(e.getProject());
        runner.parse(e.getData(CommonDataKeys.VIRTUAL_FILE));
    }

}