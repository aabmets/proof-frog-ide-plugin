// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ProofFrogAssumptions extends PsiElement {

  @Nullable
  ProofFrogExpression getExpression();

  @NotNull
  List<ProofFrogParameterizedGame> getParameterizedGameList();

}
