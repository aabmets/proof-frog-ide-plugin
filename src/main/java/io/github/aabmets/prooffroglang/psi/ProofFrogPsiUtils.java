package io.github.aabmets.prooffroglang.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ProofFrogPsiUtils {

    @Nullable
    public static IElementType safeGetElementType(@Nullable PsiElement element) {
        ASTNode node = element == null ? null : element.getNode();
        return node == null ? null : node.getElementType();
    }

    @Nullable
    public static IElementType safeGetParentElementType(@Nullable PsiElement element) {
        PsiElement parent = element == null ? null : element.getParent();
        return parent == null ? null : safeGetElementType(parent);
    }

    @Nullable
    public static IElementType safeGetPreviousSiblingType(@Nullable PsiElement element) {
        PsiElement sibling = element == null ? null : element.getPrevSibling();
        return sibling == null ? null : safeGetElementType(sibling);
    }

    @Nullable
    public static IElementType safeGetNextSiblingType(@Nullable PsiElement element) {
        PsiElement sibling = element == null ? null : element.getNextSibling();
        return sibling == null ? null : safeGetElementType(sibling);
    }

}
