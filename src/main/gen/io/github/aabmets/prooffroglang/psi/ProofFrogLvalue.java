// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ProofFrogLvalue extends PsiElement {

  @NotNull
  List<ProofFrogExpression> getExpressionList();

  @NotNull
  List<ProofFrogId> getIdList();

  @Nullable
  ProofFrogParameterizedGame getParameterizedGame();

}
