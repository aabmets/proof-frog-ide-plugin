package io.github.aabmets.prooffroglang.psi.impl;

import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import io.github.aabmets.prooffroglang.ProofFrogFileType;

public class ProofFrogElementFactory {

    public static PsiElement createIdentifier(Project project, String name) {
        String fileName = "filename.__dummy__";
        ProofFrogFileType fileType = ProofFrogFileType.INSTANCE;
        PsiFile file = PsiFileFactory.getInstance(project)
            .createFileFromText(fileName, fileType, name);
        return file.getFirstChild();
    }

}
