// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ProofFrogAtomicType extends PsiElement {

  @Nullable
  ProofFrogLvalue getLvalue();

  @Nullable
  ProofFrogTypedArray getTypedArray();

  @Nullable
  ProofFrogTypedBitString getTypedBitString();

  @Nullable
  ProofFrogTypedMap getTypedMap();

  @Nullable
  ProofFrogTypedSet getTypedSet();

}
