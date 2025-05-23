package io.github.aabmets.prooffroglang.actions;

import io.github.aabmets.prooffroglang.utils.ProofFrogRunner;

import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProofFrogParseFileAction extends AnAction implements DumbAware {
    public static final String ACTION_ID = "ProofFrog.ParseFileAction";

    public ProofFrogParseFileAction() {
        super("Check Only Syntax");
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        List<String> extensions = List.of("primitive", "scheme", "game", "proof");
        boolean visible = file != null && extensions.contains(file.getExtension());
        e.getPresentation().setEnabledAndVisible(visible);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        FileDocumentManager.getInstance().saveAllDocuments();
        ProofFrogRunner runner = new ProofFrogRunner(e.getProject());
        runner.parse(e.getData(CommonDataKeys.VIRTUAL_FILE));
    }

}