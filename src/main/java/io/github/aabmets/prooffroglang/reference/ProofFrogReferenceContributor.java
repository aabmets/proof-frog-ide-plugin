package io.github.aabmets.prooffroglang.reference;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import io.github.aabmets.prooffroglang.psi.ProofFrogTypes;
import org.jetbrains.annotations.NotNull;

public class ProofFrogReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(ProofFrogTypes.ID),
            new ProofFrogReferenceProvider(ProofFrogTypes.ID)
        );
    }

}
