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
            this::annotateMethodSignatures,
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
        IElementType prevType = ProofFrogPsiUtils.safeGetPreviousElementType(element);
        if (ProofFrogTokenSets.CLASS_KEYWORDS.contains(prevType)) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .textAttributes(ProofFrogSemanticHighlighter.CLASS_NAME)
                .create();
            return true;
        }
        return false;
    }

    private boolean annotateMethodSignatures(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element.getParent() instanceof ProofFrogVariable) {
            PsiElement parent = PsiTreeUtil.getParentOfType(element, ProofFrogMethodSignature.class, true);
            if (parent != null && element instanceof ProofFrogId) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(ProofFrogSemanticHighlighter.PARAMETER)
                    .create();
                return true;
            }
        }
        return false;
    }

    private boolean annotateLocalVariables(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        IElementType parentType = ProofFrogPsiUtils.safeGetParentElementType(element);
        if (ProofFrogTokenSets.VARIABLES.contains(parentType)) {
            PsiElement parent = PsiTreeUtil.getParentOfType(element, ProofFrogMethod.class, true);
            if (parent != null && element instanceof ProofFrogId) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(ProofFrogSemanticHighlighter.LOCAL_VARIABLE)
                    .create();
                return true;
            }
        }
        return false;
    }

}
