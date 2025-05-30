package io.github.aabmets.prooffroglang.actions;

import com.intellij.openapi.actionSystem.*;

public class ProofFrogActionManager {
    private static final String PROOFFROG_GROUP_ID = "ProofFrog.ContextMenuGroup";

    private ProofFrogActionManager() {}

    public static void registerContextMenu() {
        ActionManager am = ActionManager.getInstance();

        if (am.getAction(PROOFFROG_GROUP_ID) == null) {
            ProofFrogContextualGroup group = new ProofFrogContextualGroup();
            am.registerAction(PROOFFROG_GROUP_ID, group);

            buildContextMenu(am, group);
            attachGroupToProjectViewPopup(am, group);
            attachGroupToEditorPopup(am, group);
        }
    }

    private static void buildContextMenu(ActionManager am, DefaultActionGroup group) {
        group.add(new ProofFrogProveFileAction(am));
        group.add(new ProofFrogCheckFileAction(am));
        group.add(new ProofFrogParseFileAction(am));
        group.add(Separator.create());
        group.add(new ProofFrogPsiViewerAction(am));
        group.add(new ProofFrogOpenPluginDirAction(am));
        group.add(Separator.create());
        group.add(new ProofFrogUpdateLibraryAction(am));
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
