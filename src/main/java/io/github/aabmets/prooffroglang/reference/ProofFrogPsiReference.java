package io.github.aabmets.prooffroglang.reference;

import com.intellij.psi.*;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import io.github.aabmets.prooffroglang.psi.ProofFrogNamedElement;
import io.github.aabmets.prooffroglang.psi.ProofFrogTypes;
import org.jetbrains.annotations.*;

import java.util.Objects;

public class ProofFrogPsiReference extends PsiReferenceBase<PsiElement> {

    private final IElementType elementType;

    public ProofFrogPsiReference(@NotNull PsiElement element, IElementType elementType) {
        super(element, new TextRange(0, element.getTextLength()));
        this.elementType = elementType;
    }

    @Override
    public PsiElement resolve() {
        if (elementType == ProofFrogTypes.ID) {
            String name = myElement.getText();
            PsiFile file = myElement.getContainingFile();
            for (ProofFrogNamedElement elem : PsiTreeUtil.findChildrenOfType(file, ProofFrogNamedElement.class)) {
                if (name.equals(elem.getName())) {
                    return elem;
                };
            }
        }
        return null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        if (elementType == ProofFrogTypes.ID) {
            PsiFile file = myElement.getContainingFile();
            return PsiTreeUtil.findChildrenOfType(file, ProofFrogNamedElement.class)
                .stream()
                .map( e -> LookupElementBuilder.create(
                    Objects.requireNonNull(e.getName())
                )).toArray();
        }
        return PsiReference.EMPTY_ARRAY;
    }

}
