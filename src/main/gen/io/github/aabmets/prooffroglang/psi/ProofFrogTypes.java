// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.aabmets.prooffroglang.psi.impl.*;

public interface ProofFrogTypes {

  IElementType MODULE_EXPORT = new ProofFrogElementType("MODULE_EXPORT");
  IElementType MODULE_IMPORT = new ProofFrogElementType("MODULE_IMPORT");

  IElementType F_ADVERSARY = new ProofFrogTokenType("F_ADVERSARY");
  IElementType F_GAME = new ProofFrogTokenType("F_GAME");
  IElementType F_PHASE = new ProofFrogTokenType("F_PHASE");
  IElementType F_PRIMITIVE = new ProofFrogTokenType("F_PRIMITIVE");
  IElementType F_REDUCTION = new ProofFrogTokenType("F_REDUCTION");
  IElementType F_SCHEME = new ProofFrogTokenType("F_SCHEME");
  IElementType K_AGAINST = new ProofFrogTokenType("K_AGAINST");
  IElementType K_AS = new ProofFrogTokenType("K_AS");
  IElementType K_ASSUME = new ProofFrogTokenType("K_ASSUME");
  IElementType K_CALLS = new ProofFrogTokenType("K_CALLS");
  IElementType K_COMPOSE = new ProofFrogTokenType("K_COMPOSE");
  IElementType K_ELSE = new ProofFrogTokenType("K_ELSE");
  IElementType K_EXPORT = new ProofFrogTokenType("K_EXPORT");
  IElementType K_EXTENDS = new ProofFrogTokenType("K_EXTENDS");
  IElementType K_FOR = new ProofFrogTokenType("K_FOR");
  IElementType K_FROM = new ProofFrogTokenType("K_FROM");
  IElementType K_GAMES = new ProofFrogTokenType("K_GAMES");
  IElementType K_IF = new ProofFrogTokenType("K_IF");
  IElementType K_IMPORT = new ProofFrogTokenType("K_IMPORT");
  IElementType K_IN = new ProofFrogTokenType("K_IN");
  IElementType K_INDUCTION = new ProofFrogTokenType("K_INDUCTION");
  IElementType K_LET = new ProofFrogTokenType("K_LET");
  IElementType K_NONE = new ProofFrogTokenType("K_NONE");
  IElementType K_ORACLES = new ProofFrogTokenType("K_ORACLES");
  IElementType K_PROOF = new ProofFrogTokenType("K_PROOF");
  IElementType K_REQUIRES = new ProofFrogTokenType("K_REQUIRES");
  IElementType K_RETURN = new ProofFrogTokenType("K_RETURN");
  IElementType K_SUBSETS = new ProofFrogTokenType("K_SUBSETS");
  IElementType K_THEOREM = new ProofFrogTokenType("K_THEOREM");
  IElementType K_TO = new ProofFrogTokenType("K_TO");
  IElementType K_UNION = new ProofFrogTokenType("K_UNION");
  IElementType O_ADD = new ProofFrogTokenType("O_ADD");
  IElementType O_AND = new ProofFrogTokenType("O_AND");
  IElementType O_ASGN = new ProofFrogTokenType("O_ASGN");
  IElementType O_BSLASH = new ProofFrogTokenType("O_BSLASH");
  IElementType O_DIV = new ProofFrogTokenType("O_DIV");
  IElementType O_EQ = new ProofFrogTokenType("O_EQ");
  IElementType O_GEQ = new ProofFrogTokenType("O_GEQ");
  IElementType O_GT = new ProofFrogTokenType("O_GT");
  IElementType O_LEQ = new ProofFrogTokenType("O_LEQ");
  IElementType O_LT = new ProofFrogTokenType("O_LT");
  IElementType O_MULT = new ProofFrogTokenType("O_MULT");
  IElementType O_NEQ = new ProofFrogTokenType("O_NEQ");
  IElementType O_NOT = new ProofFrogTokenType("O_NOT");
  IElementType O_OPT = new ProofFrogTokenType("O_OPT");
  IElementType O_OR = new ProofFrogTokenType("O_OR");
  IElementType O_SMPL = new ProofFrogTokenType("O_SMPL");
  IElementType O_SUB = new ProofFrogTokenType("O_SUB");
  IElementType O_VBAR = new ProofFrogTokenType("O_VBAR");
  IElementType P_COLON = new ProofFrogTokenType("P_COLON");
  IElementType P_COMMA = new ProofFrogTokenType("P_COMMA");
  IElementType P_PERIOD = new ProofFrogTokenType("P_PERIOD");
  IElementType P_SEMI = new ProofFrogTokenType("P_SEMI");
  IElementType P_SEMIC = new ProofFrogTokenType("P_SEMIC");
  IElementType S_BRACE_L = new ProofFrogTokenType("S_BRACE_L");
  IElementType S_BRACE_R = new ProofFrogTokenType("S_BRACE_R");
  IElementType S_BRACKET_L = new ProofFrogTokenType("S_BRACKET_L");
  IElementType S_BRACKET_R = new ProofFrogTokenType("S_BRACKET_R");
  IElementType S_PAREN_L = new ProofFrogTokenType("S_PAREN_L");
  IElementType S_PAREN_R = new ProofFrogTokenType("S_PAREN_R");
  IElementType T_ARRAY = new ProofFrogTokenType("T_ARRAY");
  IElementType T_BITSTRING = new ProofFrogTokenType("T_BITSTRING");
  IElementType T_BOOL = new ProofFrogTokenType("T_BOOL");
  IElementType T_INT = new ProofFrogTokenType("T_INT");
  IElementType T_MAP = new ProofFrogTokenType("T_MAP");
  IElementType T_SET = new ProofFrogTokenType("T_SET");
  IElementType T_VOID = new ProofFrogTokenType("T_VOID");
  IElementType V_BINARYNUM = new ProofFrogTokenType("V_BINARYNUM");
  IElementType V_BOOL = new ProofFrogTokenType("V_BOOL");
  IElementType V_FILESTRING = new ProofFrogTokenType("V_FILESTRING");
  IElementType V_IDENT = new ProofFrogTokenType("V_IDENT");
  IElementType V_INT = new ProofFrogTokenType("V_INT");
  IElementType V_LINE_COMMENT = new ProofFrogTokenType("V_LINE_COMMENT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == MODULE_EXPORT) {
        return new ProofFrogModuleExportImpl(node);
      }
      else if (type == MODULE_IMPORT) {
        return new ProofFrogModuleImportImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
