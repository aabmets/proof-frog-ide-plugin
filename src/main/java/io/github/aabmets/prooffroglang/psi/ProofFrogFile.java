package io.github.aabmets.prooffroglang.psi;

import io.github.aabmets.prooffroglang.ProofFrogFileType;
import io.github.aabmets.prooffroglang.ProofFrogLanguage;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class ProofFrogFile extends PsiFileBase {

    public ProofFrogFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ProofFrogLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return ProofFrogFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "ProofFrog File";
    }

}
