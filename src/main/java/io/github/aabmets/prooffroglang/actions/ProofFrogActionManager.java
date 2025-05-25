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

        buildContextMenu(am, proofFrogGroup);
        attachGroupToProjectViewPopup(am, proofFrogGroup);
        attachGroupToEditorPopup(am, proofFrogGroup);

    }

    private static void buildContextMenu(ActionManager am, DefaultActionGroup group) {
        AnAction action = new ProofFrogProveFileAction();
        am.registerAction(ProofFrogProveFileAction.ACTION_ID, action);
        group.add(action);

        action = new ProofFrogCheckFileAction();
        am.registerAction(ProofFrogCheckFileAction.ACTION_ID, action);
        group.add(action);

        action = new ProofFrogParseFileAction();
        am.registerAction(ProofFrogParseFileAction.ACTION_ID, action);
        group.add(action);

        group.add(Separator.create());

        AnAction psiStructureAction = am.getAction("PsiViewerForContext");
        group.add(psiStructureAction);

        action = new ProofFrogOpenPluginDirAction();
        am.registerAction(ProofFrogOpenPluginDirAction.ACTION_ID, action);
        group.add(action);
    }

    private static void attachGroupToProjectViewPopup(ActionManager am, DefaultActionGroup group) {
        DefaultActionGroup projectPopup =
            (DefaultActionGroup) am.getAction(IdeActions.GROUP_PROJECT_VIEW_POPUP);
        projectPopup.add(group, new Constraints(
            Anchor.FIRST,
            IdeActions.GROUP_PROJECT_VIEW_POPUP
        ));
        projectPopup.add(Separator.create(), new Constraints(
            Anchor.AFTER,
            PROOFFROG_GROUP_ID
        ));
    }

    private static void attachGroupToEditorPopup(ActionManager am, DefaultActionGroup group) {
        DefaultActionGroup editorPopup =
            (DefaultActionGroup) am.getAction(IdeActions.GROUP_EDITOR_POPUP);
        editorPopup.add(group, new Constraints(
            Anchor.FIRST,
            IdeActions.GROUP_EDITOR_POPUP
        ));
        editorPopup.add(Separator.create(), new Constraints(
            Anchor.AFTER,
            PROOFFROG_GROUP_ID
        ));
    }

}
