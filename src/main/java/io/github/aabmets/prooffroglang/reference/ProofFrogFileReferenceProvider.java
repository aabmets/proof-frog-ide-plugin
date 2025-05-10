package io.github.aabmets.prooffroglang.reference;

import io.github.aabmets.prooffroglang.psi.ProofFrogTypes;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectUtil;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.tree.Factory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class ProofFrogFileReferenceProvider extends ASTWrapperPsiElement {

    public ProofFrogFileReferenceProvider(@NotNull ASTNode node) {
        super(node);
    }

    public PsiReference getReference() {
        return new PsiReferenceBase<PsiElement>(this) {
            @Override
            public @Nullable PsiElement resolve() {
                PsiElement element = getElement();
                Project project = element.getProject();
                VirtualFile projectDir = ProjectUtil.guessProjectDir(project);
                if (projectDir != null) {
                    String path = StringUtil.unquoteString(element.getText());
                    VirtualFile targetFile = projectDir.findFileByRelativePath(path);
                    if (targetFile != null) {
                        return PsiManager.getInstance(project).findFile(targetFile);
                    }
                }
                return null;
            }

            @Override
            public @NotNull TextRange getRangeInElement() {
                return TextRange.create(1, getElement().getTextLength() - 1);
            }

            @Override
            public PsiElement handleElementRename(@NotNull String newElementName) {
                PsiElement element = getElement();
                String oldPath = StringUtil.unquoteString(element.getText());

                int lastSlash = oldPath.lastIndexOf('/');
                String directory = lastSlash != -1 ? oldPath.substring(0, lastSlash + 1) : "";
                String newPath = "'" + directory + newElementName + "'";

                PsiElement newLeaf = (PsiElement) Factory.createSingleLeafElement(
                    ProofFrogTypes.VL_FILE_PATH,
                    newPath,
                    0,
                    newPath.length(),
                    null,
                    element.getManager()
                );
                return getElement().replace(newLeaf);
            }

            @Override
            public boolean isSoft() {
                return false;
            }

        };
    }

}
