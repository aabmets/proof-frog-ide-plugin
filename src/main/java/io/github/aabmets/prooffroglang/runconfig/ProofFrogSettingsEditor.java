package io.github.aabmets.prooffroglang.runconfig;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import javax.swing.*;
import java.awt.*;

public class ProofFrogSettingsEditor extends SettingsEditor<ProofFrogRunConfiguration> {
    private final JPanel panel;
    private final TextFieldWithBrowseButton filePathField;

    public ProofFrogSettingsEditor(@NotNull Project project) {
        panel = new JPanel(new BorderLayout(5,5));
        filePathField = new TextFieldWithBrowseButton();

        FileChooserDescriptor chooser = getFileChooserDescriptor(project);

        filePathField.addBrowseFolderListener(new TextBrowseFolderListener(chooser, project));

        panel.add(new JLabel("ProofFrog file:"), BorderLayout.WEST);
        panel.add(filePathField, BorderLayout.CENTER);
    }

    private static @NotNull FileChooserDescriptor getFileChooserDescriptor(@NotNull Project project) {
        FileChooserDescriptor chooser = new FileChooserDescriptor(
                true,  false, false, false, false, false
        );
        chooser.withTitle("Select ProofFrog File");
        chooser.withFileFilter(file -> {
            String ext = file.getExtension();
            return ext != null && List.of("primitive","scheme","game","proof").contains(ext);
        });
        String basePath = project.getBasePath();
        if (basePath != null) {
            VirtualFile projectRoot = LocalFileSystem.getInstance().findFileByPath(basePath);
            if (projectRoot != null) {
                chooser.withRoots(projectRoot);
            }
        }
        return chooser;
    }

    @Override
    protected void resetEditorFrom(@NotNull ProofFrogRunConfiguration config) {
        filePathField.setText(config.getFilePath());
    }

    @Override
    protected void applyEditorTo(@NotNull ProofFrogRunConfiguration config) {
        config.setFilePath(filePathField.getText());
    }

    @Override
    protected @NotNull JComponent createEditor() {
        return panel;
    }
}