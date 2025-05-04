package io.github.aabmets.prooffroglang.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

public class ProofFrogPsiUtils {

    public static PsiElement skipWhitespaceToPreviousSibling(@NotNull PsiElement element) {
        PsiElement prevElem = PsiTreeUtil.prevLeaf(element);
        while (prevElem != null && prevElem.getNode().getElementType() == TokenType.WHITE_SPACE) {
            prevElem = PsiTreeUtil.prevLeaf(prevElem);
        }
        return prevElem;
    }

}
