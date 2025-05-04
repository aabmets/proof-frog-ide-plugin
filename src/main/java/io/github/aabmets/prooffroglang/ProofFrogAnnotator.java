package io.github.aabmets.prooffroglang;

import io.github.aabmets.prooffroglang.highlighter.ProofFrogSemanticHighlighter;
import io.github.aabmets.prooffroglang.psi.*;

import java.util.List;
import java.util.function.BiFunction;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class ProofFrogAnnotator implements Annotator {

    private final List<BiFunction<PsiElement,AnnotationHolder,Boolean>> annotators =
        List.of(
            this::annotateClassNames,
            this::annotateLocalVariables
        );

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        for (BiFunction<PsiElement,AnnotationHolder,Boolean> fn : annotators) {
            if (fn.apply(element, holder)) {
                break;
            }
        }
    }

    private boolean annotateClassNames(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        PsiElement prevElem = ProofFrogPsiUtils.skipWhitespaceToPreviousSibling(element);
        if (prevElem != null) {
            IElementType elemType = prevElem.getNode().getElementType();
            if (ProofFrogTokenSets.CLASS_KEYWORDS.contains(elemType)) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(ProofFrogSemanticHighlighter.CLASS_NAME)
                    .create();
                return true;
            }
        }
        return false;
    }

    private boolean annotateLocalVariables(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        IElementType parentType = element.getParent().getNode().getElementType();
        if (ProofFrogTokenSets.VARIABLES.contains(parentType)) {
            PsiElement parent = PsiTreeUtil.getParentOfType(element, ProofFrogMethod.class, true);
            if (parent != null) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(ProofFrogSemanticHighlighter.LOCAL_VARIABLE)
                    .create();
                return true;
            }
        }
        return false;
    }


}
