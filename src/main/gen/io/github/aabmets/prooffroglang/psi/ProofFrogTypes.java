// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.aabmets.prooffroglang.psi.impl.*;

public interface ProofFrogTypes {

  IElementType MODULE_IMPORT = new ProofFrogElementType("MODULE_IMPORT");

  IElementType AS = new ProofFrogTokenType("AS");
  IElementType FILESTRING = new ProofFrogTokenType("FILESTRING");
  IElementType ID = new ProofFrogTokenType("ID");
  IElementType IMPORT = new ProofFrogTokenType("IMPORT");
  IElementType LINE_COMMENT = new ProofFrogTokenType("LINE_COMMENT");
  IElementType SEMI = new ProofFrogTokenType("SEMI");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == MODULE_IMPORT) {
        return new ProofFrogModuleImportImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
