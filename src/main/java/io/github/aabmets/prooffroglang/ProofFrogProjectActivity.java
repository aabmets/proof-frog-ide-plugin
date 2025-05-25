package io.github.aabmets.prooffroglang;

import io.github.aabmets.prooffroglang.actions.ProofFrogActionManager;
import io.github.aabmets.prooffroglang.utils.*;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.ProjectActivity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ProofFrogProjectActivity implements ProjectActivity {

    @Override
    public @Nullable Object execute(
            @NotNull Project project,
            @NotNull Continuation<? super Unit> continuation) {

        if (!ProofFrogPaths.pythonVenvExists(project)) {
            ProofFrogNotifier notifier = new ProofFrogNotifier(project);

            try {
                notifier.notifyInfo("Installing ProofFrog library...");
                new ProofFrogSetup().runSetup();
                notifier.notifyInfo(
                    "ProofFrog installation successful",
                    "Context menu actions and run configurations are now available."
                );
            } catch (RuntimeException e) {
                notifier.notifyError(
                    "ProofFrog installation failed",
                    "You must manually install the ProofFrog library to" +
                    "enable context menu actions and run configurations."
                );
            }
        }
        if (ProofFrogPaths.pythonVenvExists(project)) {
            ProofFrogActionManager.registerContextMenu();
        }
        return Unit.INSTANCE;
    }

}
