package io.github.aabmets.prooffroglang.actions;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.util.IconLoader;

public class ProofFrogActionManager {
    private static final String PROOFFROG_GROUP_ID = "ProofFrog.ContextMenuGroup";

    public static void registerContextMenu() {
        ActionManager am = ActionManager.getInstance();

        DefaultActionGroup proofFrogGroup =
            new DefaultActionGroup("ProofFrog", true);

        proofFrogGroup.getTemplatePresentation()
            .setIcon(IconLoader.getIcon("/icons/frog.png", ProofFrogActionManager.class));

        am.registerAction(PROOFFROG_GROUP_ID, proofFrogGroup);

        AnAction action = new ProofFrogProveFileAction();
        am.registerAction(ProofFrogProveFileAction.ACTION_ID, action);
        proofFrogGroup.add(action);

        action = new ProofFrogCheckFileAction();
        am.registerAction(ProofFrogCheckFileAction.ACTION_ID, action);
        proofFrogGroup.add(action);

        action = new ProofFrogParseFileAction();
        am.registerAction(ProofFrogParseFileAction.ACTION_ID, action);
        proofFrogGroup.add(action);

        proofFrogGroup.add(Separator.create());
        AnAction psiStructureAction = am.getAction("PsiViewerForContext");
        proofFrogGroup.add(psiStructureAction);

        DefaultActionGroup projectPopup =
            (DefaultActionGroup) am.getAction(IdeActions.GROUP_PROJECT_VIEW_POPUP);
        projectPopup.add(proofFrogGroup, new Constraints(
            Anchor.FIRST,
            IdeActions.GROUP_PROJECT_VIEW_POPUP
        ));
        projectPopup.add(Separator.create(), new Constraints(
            Anchor.AFTER,
            PROOFFROG_GROUP_ID
        ));

        DefaultActionGroup editorPopup =
            (DefaultActionGroup) am.getAction(IdeActions.GROUP_EDITOR_POPUP);
        editorPopup.add(proofFrogGroup, new Constraints(
            Anchor.FIRST,
            IdeActions.GROUP_EDITOR_POPUP
        ));
        editorPopup.add(Separator.create(), new Constraints(
            Anchor.AFTER,
            PROOFFROG_GROUP_ID
        ));
    }

}
