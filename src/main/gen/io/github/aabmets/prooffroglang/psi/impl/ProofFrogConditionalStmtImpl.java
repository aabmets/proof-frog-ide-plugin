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

public class ProofFrogConditionalStmtImpl extends ASTWrapperPsiElement implements ProofFrogConditionalStmt {

  public ProofFrogConditionalStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ProofFrogVisitor visitor) {
    visitor.visitConditionalStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ProofFrogVisitor) accept((ProofFrogVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ProofFrogBlock> getBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ProofFrogBlock.class);
  }

  @Override
  @NotNull
  public List<ProofFrogExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ProofFrogExpression.class);
  }

}
