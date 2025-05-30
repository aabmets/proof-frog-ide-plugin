package io.github.aabmets.prooffroglang.actions;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class ProofFrogPsiViewerAction extends ProofFrogBaseAction {

    public ProofFrogPsiViewerAction(ActionManager am) {
        super(am.getAction("PsiViewerForContext").getTemplatePresentation().getText());
        this.delegate = am.getAction("PsiViewerForContext");
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        delegate.actionPerformed(e);
    }

}
