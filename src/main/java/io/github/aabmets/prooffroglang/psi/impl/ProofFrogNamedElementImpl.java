package io.github.aabmets.prooffroglang.psi.impl;

import io.github.aabmets.prooffroglang.psi.ProofFrogNamedElement;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ProofFrogNamedElementImpl extends ASTWrapperPsiElement implements ProofFrogNamedElement {

    public ProofFrogNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String getName() {
        PsiElement identifier = getNameIdentifier();
        return identifier != null ? identifier.getText() : null;
    }

    @Override
    public PsiElement setName(@NotNull String name) {
        PsiElement identifier = getNameIdentifier();
        if (identifier != null) {
            PsiElement newIdentifier = ProofFrogElementFactory.createIdentifier(getProject(), name);
            identifier.replace(newIdentifier);
        }
        return this;
    }

    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        return PsiTreeUtil.getChildOfType(this, PsiElement.class);
    }

}
