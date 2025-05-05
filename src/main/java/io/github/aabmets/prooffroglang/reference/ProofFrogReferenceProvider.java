package io.github.aabmets.prooffroglang.reference;

import io.github.aabmets.prooffroglang.psi.ProofFrogPsiUtils;

import com.intellij.psi.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class ProofFrogReferenceProvider extends PsiReferenceProvider {

    private final IElementType elementType;

    public ProofFrogReferenceProvider(IElementType elementType) {
        this.elementType = elementType;
    }

    @Override
    public PsiReference @NotNull [] getReferencesByElement(
            @NotNull PsiElement element,
            @NotNull ProcessingContext context) {

        if (ProofFrogPsiUtils.safeGetElementType(element) == this.elementType) {
            return new PsiReference[]{new ProofFrogPsiReference(element, this.elementType)};
        }

        return PsiReference.EMPTY_ARRAY;
    }

}
