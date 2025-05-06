package io.github.aabmets.prooffroglang.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ProofFrogPsiUtils {

    @Nullable
    public static IElementType safeGetElementType(@NotNull PsiElement element) {
        ASTNode elemNode = element.getNode();
        return elemNode == null ? null : elemNode.getElementType();
    }

    @Nullable
    public static IElementType safeGetParentElementType(@NotNull PsiElement element) {
        PsiElement parent = element.getParent();
        return parent == null ? null : safeGetElementType(parent);
    }

    @Nullable
    public static IElementType safeGetPreviousSiblingType(@NotNull PsiElement element) {
        PsiElement sibling = element.getPrevSibling();
        return sibling == null ? null : safeGetElementType(sibling);
    }

    @Nullable
    public static IElementType safeGetNextSiblingType(@NotNull PsiElement element) {
        PsiElement sibling = element.getNextSibling();
        return sibling == null ? null : safeGetElementType(sibling);
    }

}
