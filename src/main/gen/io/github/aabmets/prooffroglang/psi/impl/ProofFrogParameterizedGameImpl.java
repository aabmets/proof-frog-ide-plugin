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

public class ProofFrogParameterizedGameImpl extends ASTWrapperPsiElement implements ProofFrogParameterizedGame {

  public ProofFrogParameterizedGameImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ProofFrogVisitor visitor) {
    visitor.visitParameterizedGame(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ProofFrogVisitor) accept((ProofFrogVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ProofFrogArgList getArgList() {
    return findChildByClass(ProofFrogArgList.class);
  }

  @Override
  @NotNull
  public ProofFrogId getId() {
    return findNotNullChildByClass(ProofFrogId.class);
  }

}
