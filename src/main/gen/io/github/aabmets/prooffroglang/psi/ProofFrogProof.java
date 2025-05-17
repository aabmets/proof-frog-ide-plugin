// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ProofFrogProof extends PsiElement {

  @Nullable
  ProofFrogAssumeBlock getAssumeBlock();

  @NotNull
  ProofFrogGamesBlock getGamesBlock();

  @Nullable
  ProofFrogLetsBlock getLetsBlock();

  @NotNull
  ProofFrogProofBlock getProofBlock();

  @NotNull
  ProofFrogTheoremBlock getTheoremBlock();

}
