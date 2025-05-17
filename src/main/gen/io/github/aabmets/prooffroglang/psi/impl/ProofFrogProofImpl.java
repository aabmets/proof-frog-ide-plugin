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

public class ProofFrogProofImpl extends ASTWrapperPsiElement implements ProofFrogProof {

  public ProofFrogProofImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ProofFrogVisitor visitor) {
    visitor.visitProof(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ProofFrogVisitor) accept((ProofFrogVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ProofFrogAssumeBlock getAssumeBlock() {
    return findChildByClass(ProofFrogAssumeBlock.class);
  }

  @Override
  @NotNull
  public ProofFrogGamesBlock getGamesBlock() {
    return findNotNullChildByClass(ProofFrogGamesBlock.class);
  }

  @Override
  @Nullable
  public ProofFrogLetsBlock getLetsBlock() {
    return findChildByClass(ProofFrogLetsBlock.class);
  }

  @Override
  @NotNull
  public ProofFrogProofBlock getProofBlock() {
    return findNotNullChildByClass(ProofFrogProofBlock.class);
  }

  @Override
  @NotNull
  public ProofFrogTheoremBlock getTheoremBlock() {
    return findNotNullChildByClass(ProofFrogTheoremBlock.class);
  }

}
