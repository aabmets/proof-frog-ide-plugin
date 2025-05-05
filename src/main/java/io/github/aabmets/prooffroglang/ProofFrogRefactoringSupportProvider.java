package io.github.aabmets.prooffroglang;

import io.github.aabmets.prooffroglang.psi.ProofFrogId;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ProofFrogRefactoringSupportProvider extends RefactoringSupportProvider {

    @Override
    public boolean isMemberInplaceRenameAvailable(
            @NotNull PsiElement elementToRename,
            @Nullable PsiElement context) {
        return (elementToRename instanceof ProofFrogId);
    }

}
