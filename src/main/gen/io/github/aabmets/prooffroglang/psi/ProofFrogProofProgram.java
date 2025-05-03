// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ProofFrogProofProgram extends PsiElement {

  @NotNull
  List<ProofFrogModuleImport> getModuleImportList();

  @NotNull
  ProofFrogProof getProof();

  @NotNull
  ProofFrogProofHelpers getProofHelpers();

}
