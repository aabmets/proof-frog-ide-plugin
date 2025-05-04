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

public class ProofFrogAtomicTypeImpl extends ASTWrapperPsiElement implements ProofFrogAtomicType {

  public ProofFrogAtomicTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ProofFrogVisitor visitor) {
    visitor.visitAtomicType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ProofFrogVisitor) accept((ProofFrogVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ProofFrogLvalue getLvalue() {
    return findChildByClass(ProofFrogLvalue.class);
  }

  @Override
  @Nullable
  public ProofFrogTypedArray getTypedArray() {
    return findChildByClass(ProofFrogTypedArray.class);
  }

  @Override
  @Nullable
  public ProofFrogTypedBitString getTypedBitString() {
    return findChildByClass(ProofFrogTypedBitString.class);
  }

  @Override
  @Nullable
  public ProofFrogTypedMap getTypedMap() {
    return findChildByClass(ProofFrogTypedMap.class);
  }

  @Override
  @Nullable
  public ProofFrogTypedSet getTypedSet() {
    return findChildByClass(ProofFrogTypedSet.class);
  }

}
