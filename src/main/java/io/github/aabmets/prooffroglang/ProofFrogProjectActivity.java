package io.github.aabmets.prooffroglang;

import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManagerCore;
import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
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

        if (descriptor != null) {
            Path pluginDir = descriptor.getPluginPath();
            Path exePath = pluginDir.resolve("proof_frog/proof_frog.exe");

            if (Files.notExists(exePath)) {
                String notifTitle = "ProofFrog download successful";
                String notifContent = "Successfully downloaded ProofFrog binaries from GitHub. " +
                    "Proof verification run tasks are available in IDE.";
                NotificationType notifType = NotificationType.INFORMATION;

                try {
                    ProofFrogDownloader.downloadProofFrogBinaries(pluginDir);
                } catch (IOException e) {
                    notifTitle = "ProofFrog download failed";
                    notifContent = "Failed to download ProofFrog binaries from GitHub. " +
                        "You must manually set up ProofFrog to run proof verifications.";
                    notifType = NotificationType.ERROR;
                }
                NotificationGroupManager.getInstance()
                    .getNotificationGroup("ProofFrog Notifications")
                    .createNotification(notifTitle, notifContent, notifType).notify(project);
            }
        }
        return Unit.INSTANCE;
    }
}
