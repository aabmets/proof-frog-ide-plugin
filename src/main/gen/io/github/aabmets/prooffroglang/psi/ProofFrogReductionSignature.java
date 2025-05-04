// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ProofFrogReductionSignature extends PsiElement {

  @NotNull
  ProofFrogGameAdversary getGameAdversary();

  @NotNull
  ProofFrogId getId();

  @Nullable
  ProofFrogParamList getParamList();

  @NotNull
  ProofFrogParameterizedGame getParameterizedGame();

}
