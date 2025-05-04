package io.github.aabmets.prooffroglang.highlighter;

import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import org.jetbrains.annotations.Nullable;

public interface ProofFrogTokenHighlighter {

    @Nullable
    TextAttributesKey[] getKeys(IElementType elementType);

    default @Nullable TextAttributesKey[] getKeys(@Nullable PsiElement element) {
        if (element == null || element.getNode() == null) {
            return null;
        }
        IElementType elementType = element.getNode().getElementType();
        return getKeys(elementType);
    }

}
