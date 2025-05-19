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

public class ProofFrogStatementImpl extends ASTWrapperPsiElement implements ProofFrogStatement {

  public ProofFrogStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ProofFrogVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ProofFrogVisitor) accept((ProofFrogVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ProofFrogAssignStmt getAssignStmt() {
    return findChildByClass(ProofFrogAssignStmt.class);
  }

  @Override
  @Nullable
  public ProofFrogConditionalStmt getConditionalStmt() {
    return findChildByClass(ProofFrogConditionalStmt.class);
  }

  @Override
  @Nullable
  public ProofFrogExpressionStmt getExpressionStmt() {
    return findChildByClass(ProofFrogExpressionStmt.class);
  }

  @Override
  @Nullable
  public ProofFrogGenericLoopStmt getGenericLoopStmt() {
    return findChildByClass(ProofFrogGenericLoopStmt.class);
  }

  @Override
  @Nullable
  public ProofFrogIntegerLoopStmt getIntegerLoopStmt() {
    return findChildByClass(ProofFrogIntegerLoopStmt.class);
  }

  @Override
  @Nullable
  public ProofFrogReturnStmt getReturnStmt() {
    return findChildByClass(ProofFrogReturnStmt.class);
  }

  @Override
  @Nullable
  public ProofFrogSampleStmt getSampleStmt() {
    return findChildByClass(ProofFrogSampleStmt.class);
  }

  @Override
  @Nullable
  public ProofFrogVarDeclAssignStmt getVarDeclAssignStmt() {
    return findChildByClass(ProofFrogVarDeclAssignStmt.class);
  }

  @Override
  @Nullable
  public ProofFrogVarDeclSampleStmt getVarDeclSampleStmt() {
    return findChildByClass(ProofFrogVarDeclSampleStmt.class);
  }

  @Override
  @Nullable
  public ProofFrogVarDeclStmt getVarDeclStmt() {
    return findChildByClass(ProofFrogVarDeclStmt.class);
  }

}
