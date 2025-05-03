// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ProofFrogStatement extends PsiElement {

  @Nullable
  ProofFrogArgList getArgList();

  @NotNull
  List<ProofFrogBlock> getBlockList();

  @Nullable
  ProofFrogExpression getExpression();

  @Nullable
  ProofFrogId getId();

  @Nullable
  ProofFrogLvalue getLvalue();

  @Nullable
  ProofFrogType getType();

}
