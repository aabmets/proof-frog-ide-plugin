package io.github.aabmets.prooffroglang;

import io.github.aabmets.prooffroglang.psi.ProofFrogTokenSets;
import io.github.aabmets.prooffroglang.psi.ProofFrogTypes;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.TokenType;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class ProofFrogAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element.getNode().getElementType() != ProofFrogTypes.VL_IDENTIFIER) {
            return;
        }

        PsiElement prevSibling = PsiTreeUtil.prevLeaf(element);
        while (prevSibling != null && (prevSibling.getNode().getElementType() == TokenType.WHITE_SPACE)) {
            prevSibling = PsiTreeUtil.prevLeaf(prevSibling);
        }

        if (prevSibling != null) {
            IElementType elemType = prevSibling.getNode().getElementType();
            if (ProofFrogTokenSets.CLASS_DECLARATORS.contains(elemType)) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(ProofFrogSyntaxHighlighter.CLASS_NAME)
                    .create();
            }
        }
    }

}
