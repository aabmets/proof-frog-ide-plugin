package io.github.aabmets.prooffroglang;

import io.github.aabmets.prooffroglang.actions.ProofFrogActionManager;
import io.github.aabmets.prooffroglang.utils.*;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.ProjectActivity;
import com.intellij.openapi.ui.Messages;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ProofFrogProjectActivity implements ProjectActivity {

    @Override
    public @Nullable Object execute(
            @NotNull Project project,
            @NotNull Continuation<? super Unit> continuation) {
        ProofFrogNotifier notifier = new ProofFrogNotifier(project);

        if (ProofFrogPaths.pythonVenvExists(project)) {
            ProofFrogActionManager.registerContextMenu();
            notifier.notifyInfo("ProofFrog library detected");
        } else {
            Application app = ApplicationManager.getApplication();
            app.invokeLater(() -> {
                int result = Messages.showYesNoDialog(
                    project,
                    """
                            Would you like the plugin to automatically install \
                            the ProofFrog library (requires internet connection)?
                            
                            The library is required to enable context menu actions
                            and run configurations for ProofFrog files.
                            """,
                    "ProofFrog Library Not Detected",
                    Messages.getQuestionIcon()
                );
                if (result == Messages.YES) {
                    app.executeOnPooledThread(() -> {
                        try {
                            notifier.notifyInfo("Installing ProofFrog library...");
                            new ProofFrogSetup().runSetup();
                            ProofFrogActionManager.registerContextMenu();
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
                    });
                }
            });
        }
        return Unit.INSTANCE;
    }

}
