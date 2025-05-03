// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.github.aabmets.prooffroglang.psi.ProofFrogTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.github.aabmets.prooffroglang.psi.*;

public class ProofFrogGameProgramImpl extends ASTWrapperPsiElement implements ProofFrogGameProgram {

  public ProofFrogGameProgramImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ProofFrogVisitor visitor) {
    visitor.visitGameProgram(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ProofFrogVisitor) accept((ProofFrogVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ProofFrogGame> getGameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ProofFrogGame.class);
  }

  @Override
  @NotNull
  public ProofFrogGameExport getGameExport() {
    return findNotNullChildByClass(ProofFrogGameExport.class);
  }

  @Override
  @NotNull
  public List<ProofFrogModuleImport> getModuleImportList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ProofFrogModuleImport.class);
  }

}
