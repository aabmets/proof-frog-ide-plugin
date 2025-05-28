package io.github.aabmets.prooffroglang.utils;

import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;

public class ProofFrogNotifier {
    private static final String NOTIFICATION_GROUP = "ProofFrog Notifications";
    private final Project project;

    public ProofFrogNotifier(Project project) {
        this.project = project;
    }

    private void notify(String title, String content, NotificationType type) {
        NotificationGroupManager.getInstance()
            .getNotificationGroup(NOTIFICATION_GROUP)
            .createNotification(title, content, type)
            .notify(project);
    }

    private void notify(String title, NotificationType type) {
        NotificationGroupManager.getInstance()
            .getNotificationGroup(NOTIFICATION_GROUP)
            .createNotification(title, type)
            .notify(project);
    }

    public void notifyInfo(String title) {
        notify(title, NotificationType.INFORMATION);
    }

    public void notifyInfo(String title, String content) {
        notify(title, content, NotificationType.INFORMATION);
    }

    public void notifyError(String title) {
        notify(title, NotificationType.ERROR);
    }

    public void notifyError(String title, String content) {
        notify(title, content, NotificationType.ERROR);
    }

}
