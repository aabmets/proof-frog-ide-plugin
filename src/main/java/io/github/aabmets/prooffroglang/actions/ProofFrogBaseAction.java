package io.github.aabmets.prooffroglang.actions;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class ProofFrogBaseAction extends AnAction implements DumbAware {
    protected AnAction delegate = null;

    protected ProofFrogBaseAction(String text) {
        super(text);
    }

    protected ProofFrogBaseAction(ActionManager am, String actionId, String actionText) {
        super(actionText);
        am.registerAction(actionId, this);
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        List<String> extensions = getAllowedExtensions();
        boolean visible = file != null && extensions.contains(file.getExtension());
        e.getPresentation().setEnabledAndVisible(visible);

        if (delegate != null && visible) {
            delegate.update(e);
        }
    }

    protected @NotNull List<String> getAllowedExtensions() {
        return List.of("primitive", "scheme", "game", "proof");
    }

}
