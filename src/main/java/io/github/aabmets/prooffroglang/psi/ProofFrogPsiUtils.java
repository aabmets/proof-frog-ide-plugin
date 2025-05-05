package io.github.aabmets.prooffroglang.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ProofFrogPsiUtils {

    @Nullable
    public static IElementType safeGetElementType(@NotNull PsiElement element) {
        ASTNode elemNode = element.getNode();
        if (elemNode == null) {
            return null;
        }
        return elemNode.getElementType();
    }

    @Nullable
    public static IElementType safeGetParentElementType(@NotNull PsiElement element) {
        PsiElement parentElem = element.getParent();
        if (parentElem == null) {
            return null;
        }
        return safeGetElementType(parentElem);
    }

    @Nullable
    public static IElementType safeGetPreviousElementType(@Nullable PsiElement element) {
        PsiElement prevElem = PsiTreeUtil.skipWhitespacesBackward(element);
        if (prevElem == null) {
            return null;
        }
        return safeGetElementType(prevElem);
    }

    @Nullable
    public static IElementType safeGetNextElementType(@Nullable PsiElement element) {
        PsiElement prevElem = PsiTreeUtil.skipWhitespacesForward(element);
        if (prevElem == null) {
            return null;
        }
        return safeGetElementType(prevElem);
    }

}
