package io.github.aabmets.prooffroglang;

import com.intellij.psi.TokenType;
import io.github.aabmets.prooffroglang.highlighter.*;
import io.github.aabmets.prooffroglang.psi.*;

import java.util.ArrayList;
import java.util.Collection;
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
            this::annotateClassInstantiations,
            this::annotateClassFields,
            this::annotateMethodSignatures,
            this::annotateMethodCalls,
            this::annotateLocalVariables,
            this::annotateProperties,
            this::annotateDatatypes
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
        PsiElement prevElem = PsiTreeUtil.skipWhitespacesBackward(element);
        IElementType prevType = ProofFrogPsiUtils.safeGetElementType(prevElem);
        if (ProofFrogTokenSets.CLASS_KEYWORDS.contains(prevType)) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .textAttributes(ProofFrogSemanticHighlighter.CLASS_NAME)
                .create();
            return true;
        }
        return false;
    }

    private boolean annotateClassInstantiations(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof ProofFrogId && element.getParent() instanceof ProofFrogParameterizedGame) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .textAttributes(ProofFrogSemanticHighlighter.CLASS_INSTANTIATION)
                .create();
            return true;
        }
        return false;
    }

    private boolean annotateClassFields(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (!(element instanceof ProofFrogId)) {
            return false;
        }
        PsiElement parent = element.getParent();
        PsiElement grandParent = parent.getParent();
        if (parent instanceof ProofFrogField || grandParent instanceof ProofFrogField) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .textAttributes(ProofFrogSemanticHighlighter.CLASS_FIELD)
                .create();
            return true;
        }
        return false;
    }

    private boolean annotateMethodSignatures(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (!(element instanceof ProofFrogId)) {
            return false;
        }
        PsiElement parent = element.getParent();
        if (parent instanceof ProofFrogMethodSignature) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .textAttributes(ProofFrogSemanticHighlighter.METHOD_NAME)
                .create();
            return true;
        }
        if (parent instanceof ProofFrogVariable) {
            PsiElement metSig = PsiTreeUtil.getParentOfType(element, ProofFrogMethodSignature.class, true);
            if (metSig != null) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(ProofFrogSemanticHighlighter.PARAMETER)
                    .create();
                return true;
            }
        }
        PsiElement method = PsiTreeUtil.getParentOfType(element, ProofFrogMethod.class, true);
        if (method != null) {
            PsiElement metSig = PsiTreeUtil.getChildOfType(method, ProofFrogMethodSignature.class);
            Collection<ProofFrogVariable> metSigVars = PsiTreeUtil.findChildrenOfType(metSig, ProofFrogVariable.class);
            for (ProofFrogVariable msv : metSigVars) {
                if (element.getText().equals(msv.getId().getText())) {
                    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .textAttributes(ProofFrogSemanticHighlighter.PARAMETER)
                        .create();
                    return true;
                }
            }
        }
        return false;
    }

    private boolean annotateMethodCalls(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (!(element instanceof ProofFrogId)) {
            return false;
        }
        PsiElement parent = PsiTreeUtil.getParentOfType(element, ProofFrogPrimaryElem.class, true);
        boolean isMethodCall = PsiTreeUtil.getNextSiblingOfType(parent, ProofFrogCallExpr.class) != null;
        if (isMethodCall) {
            IElementType prevType = ProofFrogPsiUtils.safeGetPreviousSiblingType(element);
            if (prevType != null && prevType.equals(ProofFrogTypes.PN_PERIOD)) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(ProofFrogSemanticHighlighter.METHOD_CALL)
                    .create();
                return true;
            }
            PsiElement prevElem = PsiTreeUtil.getParentOfType(parent, ProofFrogExpression.class, true);
            prevType = ProofFrogPsiUtils.safeGetPreviousSiblingType(prevElem);
            boolean hasSiblings = ProofFrogPsiUtils.hasSiblings(element);
            if (!hasSiblings && prevType != null && prevType.equals(TokenType.WHITE_SPACE)) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(ProofFrogSemanticHighlighter.METHOD_CALL)
                    .create();
                return true;
            }
        }
        return false;
    }

    private boolean annotateLocalVariables(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        PsiElement method = PsiTreeUtil.getParentOfType(element, ProofFrogMethod.class, true);
        if (method == null || !(element instanceof ProofFrogLvalue)) {
            return false;
        }
        IElementType elemType = ProofFrogPsiUtils.safeGetParentElementType(element);
        if (ProofFrogTokenSets.VARIABLES.contains(elemType)){
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .textAttributes(ProofFrogSemanticHighlighter.LOCAL_VARIABLE)
                .create();
            return true;
        }
        PsiElement metBlock = PsiTreeUtil.getChildOfType(method, ProofFrogBlock.class);
        if (metBlock == null) {
            return false;
        }
        Collection<PsiElement> allVarElements = new ArrayList<>();
        Collection<PsiElement> blockElements = PsiTreeUtil.findChildrenOfType(metBlock, PsiElement.class);
        for (PsiElement blockElement : blockElements) {
            IElementType type = ProofFrogPsiUtils.safeGetElementType(blockElement);
            if (ProofFrogTokenSets.VARIABLES.contains(type)) {
                allVarElements.add(blockElement);
            }
        }
        for (PsiElement varElement : allVarElements) {
            Collection<ProofFrogId> metBodyIds = PsiTreeUtil.findChildrenOfType(varElement, ProofFrogId.class);
            for (ProofFrogId mbi : metBodyIds) {
                if (element.getText().equals(mbi.getText())) {
                    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                        .textAttributes(ProofFrogSemanticHighlighter.LOCAL_VARIABLE)
                        .create();
                    return true;
                }
            }
        }
        return false;
    }

    private boolean annotateProperties(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (!(element instanceof ProofFrogId)) {
            return false;
        } else if (element.getText().equals("challenger")) {
            PsiElement reduction = PsiTreeUtil.getParentOfType(element, ProofFrogReduction.class, true);
            if (reduction != null) {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .textAttributes(ProofFrogVariousHighlighter.PROPERTY)
                    .create();
                return true;
            }
        }
        return false;
    }

    private boolean annotateDatatypes(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (!(element instanceof ProofFrogId)) {
            return false;
        }
        PsiElement grandParent = element.getParent().getParent();
        if (grandParent instanceof ProofFrogAtomicType) {
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .textAttributes(ProofFrogDatatypeHighlighter.KEY)
                .create();
            return true;
        }
        return false;
    }

}
