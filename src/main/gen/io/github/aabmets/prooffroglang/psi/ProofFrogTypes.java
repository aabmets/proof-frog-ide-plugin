// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.aabmets.prooffroglang.psi.impl.*;

public interface ProofFrogTypes {

  IElementType DATATYPE = new ProofFrogElementType("DATATYPE");
  IElementType MODULE_EXPORT = new ProofFrogElementType("MODULE_EXPORT");
  IElementType MODULE_IMPORT = new ProofFrogElementType("MODULE_IMPORT");

  IElementType ARRAY = new ProofFrogTokenType("ARRAY");
  IElementType AS = new ProofFrogTokenType("AS");
  IElementType BITSTRING = new ProofFrogTokenType("BITSTRING");
  IElementType BOOL = new ProofFrogTokenType("BOOL");
  IElementType EXPORT = new ProofFrogTokenType("EXPORT");
  IElementType FILESTRING = new ProofFrogTokenType("FILESTRING");
  IElementType ID = new ProofFrogTokenType("ID");
  IElementType IMPORT = new ProofFrogTokenType("IMPORT");
  IElementType INT = new ProofFrogTokenType("INT");
  IElementType LINE_COMMENT = new ProofFrogTokenType("LINE_COMMENT");
  IElementType MAP = new ProofFrogTokenType("MAP");
  IElementType SEMI = new ProofFrogTokenType("SEMI");
  IElementType SET = new ProofFrogTokenType("SET");
  IElementType VOID = new ProofFrogTokenType("VOID");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == DATATYPE) {
        return new ProofFrogDatatypeImpl(node);
      }
      else if (type == MODULE_EXPORT) {
        return new ProofFrogModuleExportImpl(node);
      }
      else if (type == MODULE_IMPORT) {
        return new ProofFrogModuleImportImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
