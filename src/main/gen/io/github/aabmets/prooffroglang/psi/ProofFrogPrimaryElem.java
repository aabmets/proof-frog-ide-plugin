// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ProofFrogPrimaryElem extends PsiElement {

  @NotNull
  List<ProofFrogExpression> getExpressionList();

  @Nullable
  ProofFrogLvalue getLvalue();

  @Nullable
  ProofFrogType getType();

}
