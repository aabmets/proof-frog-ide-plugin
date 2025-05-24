package io.github.aabmets.prooffroglang;

import io.github.aabmets.prooffroglang.actions.ProofFrogActionManager;
import io.github.aabmets.prooffroglang.utils.*;

import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManagerCore;
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
            Path exePath = pluginDir.resolve(ProofFrogRunner.getPluginExePath());

            if (Files.notExists(exePath)) {
                try {
                    ProofFrogDownloader.downloadPackageManager(pluginDir);
                    notifier.notifyInfo(
                        "ProofFrog installation successful",
                        "Proof verification actions and run configurations are now available."
                    );
                } catch (IOException e) {
                    notifier.notifyError(
                        "ProofFrog installation failed",
                        "You must manually install the ProofFrog library to run proof verifications."
                    );
                }
            }
            if (Files.exists(exePath)) {
                ProofFrogActionManager.registerContextMenu();
            }
        }
        return Unit.INSTANCE;
    }
}
