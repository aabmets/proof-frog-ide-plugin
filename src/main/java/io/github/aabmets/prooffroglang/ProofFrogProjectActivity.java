package io.github.aabmets.prooffroglang;

import com.intellij.openapi.actionSystem.AnAction;
import io.github.aabmets.prooffroglang.actions.ProofFrogProveFileAction;
import io.github.aabmets.prooffroglang.actions.ProofFrogParseFileAction;
import io.github.aabmets.prooffroglang.actions.ProofFrogCheckFileAction;
import io.github.aabmets.prooffroglang.utils.ProofFrogDownloader;
import io.github.aabmets.prooffroglang.utils.ProofFrogNotifier;

import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManagerCore;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.IdeActions;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.ProjectActivity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProofFrogProjectActivity implements ProjectActivity {
    @Override
    public @Nullable Object execute(
            @NotNull Project project,
            @NotNull Continuation<? super Unit> continuation) {
        PluginId id = PluginId.getId("io.github.aabmets.proof-frog-lang");
        IdeaPluginDescriptor descriptor = PluginManagerCore.getPlugin(id);
        ProofFrogNotifier notifier = new ProofFrogNotifier(project);

        if (descriptor != null) {
            Path pluginDir = descriptor.getPluginPath();
            Path exePath = pluginDir.resolve("proof_frog/proof_frog.exe");  // TODO: multiplatform compatibility

            if (Files.notExists(exePath)) {
                try {
                    ProofFrogDownloader.downloadProofFrogBinaries(pluginDir);
                    notifier.notifyInfo(
                        "ProofFrog download successful",
                        "Successfully downloaded ProofFrog binaries from GitHub. " +
                        "Proof verification run tasks are available in IDE."
                    );
                } catch (IOException e) {
                    notifier.notifyError(
                        "ProofFrog download failed",
                        "Failed to download ProofFrog binaries from GitHub. " +
                        "You must manually set up ProofFrog to run proof verifications."
                    );
                }
            }
            if (Files.exists(exePath)) {
                ActionManager am = ActionManager.getInstance();
                DefaultActionGroup group =
                    (DefaultActionGroup) am.getAction(IdeActions.GROUP_PROJECT_VIEW_POPUP);

                AnAction action = new ProofFrogProveFileAction();
                am.registerAction(ProofFrogProveFileAction.ACTION_ID, action);
                group.add(action);

                action = new ProofFrogParseFileAction();
                am.registerAction(ProofFrogParseFileAction.ACTION_ID, action);
                group.add(action);

                action = new ProofFrogCheckFileAction();
                am.registerAction(ProofFrogCheckFileAction.ACTION_ID, action);
                group.add(action);
            }
        }
        return Unit.INSTANCE;
    }
}
