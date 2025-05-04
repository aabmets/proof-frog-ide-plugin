// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ProofFrogStatement extends PsiElement {

  @Nullable
  ProofFrogAssignStmt getAssignStmt();

  @Nullable
  ProofFrogCallStmt getCallStmt();

  @Nullable
  ProofFrogConditionalStmt getConditionalStmt();

  @Nullable
  ProofFrogGenericLoopStmt getGenericLoopStmt();

  @Nullable
  ProofFrogIntegerLoopStmt getIntegerLoopStmt();

  @Nullable
  ProofFrogReturnStmt getReturnStmt();

  @Nullable
  ProofFrogSampleStmt getSampleStmt();

  @Nullable
  ProofFrogVarDeclAssignStmt getVarDeclAssignStmt();

  @Nullable
  ProofFrogVarDeclSampleStmt getVarDeclSampleStmt();

  @Nullable
  ProofFrogVarDeclStmt getVarDeclStmt();

}
