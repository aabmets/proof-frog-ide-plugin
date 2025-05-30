package io.github.aabmets.prooffroglang.actions;

import com.intellij.openapi.vfs.VirtualFile;
import io.github.aabmets.prooffroglang.ProofFrogIcons;

import com.intellij.openapi.actionSystem.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProofFrogContextualGroup extends DefaultActionGroup {
    private static final List<String> ALLOWED = List.of("primitive","scheme","game","proof");

    public ProofFrogContextualGroup() {
        super("ProofFrog", true);
        getTemplatePresentation().setIcon(ProofFrogIcons.FILE);
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        boolean show = file != null && ALLOWED.contains(file.getExtension());

        Presentation p = e.getPresentation();
        p.setVisible(show);
        p.setEnabled(show);

        if (show) {
            super.update(e);
        }
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }

}
