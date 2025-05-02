package io.github.aabmets.prooffroglang;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ProofFrogFileType extends LanguageFileType {

    public static final ProofFrogFileType INSTANCE = new ProofFrogFileType();

    private ProofFrogFileType() {
        super(ProofFrogLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "ProofFrog File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "ProofFrog language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "frog";
    }

    @Override
    public Icon getIcon() {
        return ProofFrogIcons.FILE;
    }

}
