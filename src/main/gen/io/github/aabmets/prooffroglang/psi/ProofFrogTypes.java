// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.aabmets.prooffroglang.psi.impl.*;

public interface ProofFrogTypes {

  IElementType ADDITIVE_INTEGER_EXPRESSION = new ProofFrogElementType("ADDITIVE_INTEGER_EXPRESSION");
  IElementType ADD_EXPRESSION = new ProofFrogElementType("ADD_EXPRESSION");
  IElementType AND_EXPRESSION = new ProofFrogElementType("AND_EXPRESSION");
  IElementType ARG_LIST = new ProofFrogElementType("ARG_LIST");
  IElementType ASSUMPTIONS = new ProofFrogElementType("ASSUMPTIONS");
  IElementType ATOMIC_TYPE = new ProofFrogElementType("ATOMIC_TYPE");
  IElementType BLOCK = new ProofFrogElementType("BLOCK");
  IElementType COMPARISON_EXPRESSION = new ProofFrogElementType("COMPARISON_EXPRESSION");
  IElementType CONCRETE_GAME = new ProofFrogElementType("CONCRETE_GAME");
  IElementType EXPRESSION = new ProofFrogElementType("EXPRESSION");
  IElementType FIELD = new ProofFrogElementType("FIELD");
  IElementType GAME = new ProofFrogElementType("GAME");
  IElementType GAME_ADVERSARY = new ProofFrogElementType("GAME_ADVERSARY");
  IElementType GAME_BODY = new ProofFrogElementType("GAME_BODY");
  IElementType GAME_EXPORT = new ProofFrogElementType("GAME_EXPORT");
  IElementType GAME_LIST = new ProofFrogElementType("GAME_LIST");
  IElementType GAME_PHASE = new ProofFrogElementType("GAME_PHASE");
  IElementType GAME_PROGRAM = new ProofFrogElementType("GAME_PROGRAM");
  IElementType GAME_STEP = new ProofFrogElementType("GAME_STEP");
  IElementType ID = new ProofFrogElementType("ID");
  IElementType INDUCTION = new ProofFrogElementType("INDUCTION");
  IElementType INITIALIZED_FIELD = new ProofFrogElementType("INITIALIZED_FIELD");
  IElementType INTEGER_EXPRESSION = new ProofFrogElementType("INTEGER_EXPRESSION");
  IElementType LETS = new ProofFrogElementType("LETS");
  IElementType LVALUE = new ProofFrogElementType("LVALUE");
  IElementType METHOD = new ProofFrogElementType("METHOD");
  IElementType METHOD_SIGNATURE = new ProofFrogElementType("METHOD_SIGNATURE");
  IElementType MODULE_IMPORT = new ProofFrogElementType("MODULE_IMPORT");
  IElementType MULTIPLICATIVE_INTEGER_EXPRESSION = new ProofFrogElementType("MULTIPLICATIVE_INTEGER_EXPRESSION");
  IElementType MULTIPLY_EXPRESSION = new ProofFrogElementType("MULTIPLY_EXPRESSION");
  IElementType OR_EXPRESSION = new ProofFrogElementType("OR_EXPRESSION");
  IElementType PARAMETERIZED_GAME = new ProofFrogElementType("PARAMETERIZED_GAME");
  IElementType PARAM_LIST = new ProofFrogElementType("PARAM_LIST");
  IElementType POSTFIX_OPERATION = new ProofFrogElementType("POSTFIX_OPERATION");
  IElementType PRIMARY_ELEMENT = new ProofFrogElementType("PRIMARY_ELEMENT");
  IElementType PRIMARY_EXPRESSION = new ProofFrogElementType("PRIMARY_EXPRESSION");
  IElementType PRIMARY_INTEGER_EXPRESSION = new ProofFrogElementType("PRIMARY_INTEGER_EXPRESSION");
  IElementType PRIMITIVE_BODY = new ProofFrogElementType("PRIMITIVE_BODY");
  IElementType PRIMITIVE_PROGRAM = new ProofFrogElementType("PRIMITIVE_PROGRAM");
  IElementType PROOF = new ProofFrogElementType("PROOF");
  IElementType PROOF_HELPERS = new ProofFrogElementType("PROOF_HELPERS");
  IElementType PROOF_PROGRAM = new ProofFrogElementType("PROOF_PROGRAM");
  IElementType REDUCTION = new ProofFrogElementType("REDUCTION");
  IElementType SCHEME = new ProofFrogElementType("SCHEME");
  IElementType SCHEME_BODY = new ProofFrogElementType("SCHEME_BODY");
  IElementType SCHEME_PROGRAM = new ProofFrogElementType("SCHEME_PROGRAM");
  IElementType SET_MINUS_EXPRESSION = new ProofFrogElementType("SET_MINUS_EXPRESSION");
  IElementType STATEMENT = new ProofFrogElementType("STATEMENT");
  IElementType STEP_ASSUMPTION = new ProofFrogElementType("STEP_ASSUMPTION");
  IElementType THEOREM = new ProofFrogElementType("THEOREM");
  IElementType TYPE = new ProofFrogElementType("TYPE");
  IElementType TYPE_POSTFIX = new ProofFrogElementType("TYPE_POSTFIX");
  IElementType TYPE_PRODUCT = new ProofFrogElementType("TYPE_PRODUCT");
  IElementType UNARY_EXPRESSION = new ProofFrogElementType("UNARY_EXPRESSION");
  IElementType UNION_EXPRESSION = new ProofFrogElementType("UNION_EXPRESSION");
  IElementType VARIABLE = new ProofFrogElementType("VARIABLE");

  IElementType DT_ARRAY = new ProofFrogTokenType("DT_ARRAY");
  IElementType DT_BITSTRING = new ProofFrogTokenType("DT_BITSTRING");
  IElementType DT_BOOL = new ProofFrogTokenType("DT_BOOL");
  IElementType DT_INT = new ProofFrogTokenType("DT_INT");
  IElementType DT_MAP = new ProofFrogTokenType("DT_MAP");
  IElementType DT_SET = new ProofFrogTokenType("DT_SET");
  IElementType DT_VOID = new ProofFrogTokenType("DT_VOID");
  IElementType FN_ADVERSARY = new ProofFrogTokenType("FN_ADVERSARY");
  IElementType FN_GAME = new ProofFrogTokenType("FN_GAME");
  IElementType FN_PHASE = new ProofFrogTokenType("FN_PHASE");
  IElementType FN_PRIMITIVE = new ProofFrogTokenType("FN_PRIMITIVE");
  IElementType FN_REDUCTION = new ProofFrogTokenType("FN_REDUCTION");
  IElementType FN_SCHEME = new ProofFrogTokenType("FN_SCHEME");
  IElementType KW_AGAINST = new ProofFrogTokenType("KW_AGAINST");
  IElementType KW_AS = new ProofFrogTokenType("KW_AS");
  IElementType KW_ASSUME = new ProofFrogTokenType("KW_ASSUME");
  IElementType KW_CALLS = new ProofFrogTokenType("KW_CALLS");
  IElementType KW_COMPOSE = new ProofFrogTokenType("KW_COMPOSE");
  IElementType KW_ELSE = new ProofFrogTokenType("KW_ELSE");
  IElementType KW_EXPORT = new ProofFrogTokenType("KW_EXPORT");
  IElementType KW_EXTENDS = new ProofFrogTokenType("KW_EXTENDS");
  IElementType KW_FOR = new ProofFrogTokenType("KW_FOR");
  IElementType KW_FROM = new ProofFrogTokenType("KW_FROM");
  IElementType KW_GAMES = new ProofFrogTokenType("KW_GAMES");
  IElementType KW_IF = new ProofFrogTokenType("KW_IF");
  IElementType KW_IMPORT = new ProofFrogTokenType("KW_IMPORT");
  IElementType KW_IN = new ProofFrogTokenType("KW_IN");
  IElementType KW_INDUCTION = new ProofFrogTokenType("KW_INDUCTION");
  IElementType KW_LET = new ProofFrogTokenType("KW_LET");
  IElementType KW_NONE = new ProofFrogTokenType("KW_NONE");
  IElementType KW_ORACLES = new ProofFrogTokenType("KW_ORACLES");
  IElementType KW_PROOF = new ProofFrogTokenType("KW_PROOF");
  IElementType KW_REQUIRES = new ProofFrogTokenType("KW_REQUIRES");
  IElementType KW_RETURN = new ProofFrogTokenType("KW_RETURN");
  IElementType KW_SUBSETS = new ProofFrogTokenType("KW_SUBSETS");
  IElementType KW_THEOREM = new ProofFrogTokenType("KW_THEOREM");
  IElementType KW_TO = new ProofFrogTokenType("KW_TO");
  IElementType KW_UNION = new ProofFrogTokenType("KW_UNION");
  IElementType OP_ADD = new ProofFrogTokenType("OP_ADD");
  IElementType OP_AND = new ProofFrogTokenType("OP_AND");
  IElementType OP_ASSIGN = new ProofFrogTokenType("OP_ASSIGN");
  IElementType OP_BSLASH = new ProofFrogTokenType("OP_BSLASH");
  IElementType OP_DIV = new ProofFrogTokenType("OP_DIV");
  IElementType OP_EQ = new ProofFrogTokenType("OP_EQ");
  IElementType OP_GEQ = new ProofFrogTokenType("OP_GEQ");
  IElementType OP_GT = new ProofFrogTokenType("OP_GT");
  IElementType OP_LEQ = new ProofFrogTokenType("OP_LEQ");
  IElementType OP_LT = new ProofFrogTokenType("OP_LT");
  IElementType OP_MULT = new ProofFrogTokenType("OP_MULT");
  IElementType OP_NEQ = new ProofFrogTokenType("OP_NEQ");
  IElementType OP_NOT = new ProofFrogTokenType("OP_NOT");
  IElementType OP_OPT = new ProofFrogTokenType("OP_OPT");
  IElementType OP_OR = new ProofFrogTokenType("OP_OR");
  IElementType OP_SAMPLE = new ProofFrogTokenType("OP_SAMPLE");
  IElementType OP_SUB = new ProofFrogTokenType("OP_SUB");
  IElementType OP_VBAR = new ProofFrogTokenType("OP_VBAR");
  IElementType PN_COLON = new ProofFrogTokenType("PN_COLON");
  IElementType PN_COMMA = new ProofFrogTokenType("PN_COMMA");
  IElementType PN_PERIOD = new ProofFrogTokenType("PN_PERIOD");
  IElementType PN_SEMI = new ProofFrogTokenType("PN_SEMI");
  IElementType ST_BRACE_L = new ProofFrogTokenType("ST_BRACE_L");
  IElementType ST_BRACE_R = new ProofFrogTokenType("ST_BRACE_R");
  IElementType ST_BRACKET_L = new ProofFrogTokenType("ST_BRACKET_L");
  IElementType ST_BRACKET_R = new ProofFrogTokenType("ST_BRACKET_R");
  IElementType ST_PAREN_L = new ProofFrogTokenType("ST_PAREN_L");
  IElementType ST_PAREN_R = new ProofFrogTokenType("ST_PAREN_R");
  IElementType VL_BINARYNUM = new ProofFrogTokenType("VL_BINARYNUM");
  IElementType VL_BOOL = new ProofFrogTokenType("VL_BOOL");
  IElementType VL_FILESTRING = new ProofFrogTokenType("VL_FILESTRING");
  IElementType VL_IDENT = new ProofFrogTokenType("VL_IDENT");
  IElementType VL_INT = new ProofFrogTokenType("VL_INT");
  IElementType VL_LINE_COMMENT = new ProofFrogTokenType("VL_LINE_COMMENT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADDITIVE_INTEGER_EXPRESSION) {
        return new ProofFrogAdditiveIntegerExpressionImpl(node);
      }
      else if (type == ADD_EXPRESSION) {
        return new ProofFrogAddExpressionImpl(node);
      }
      else if (type == AND_EXPRESSION) {
        return new ProofFrogAndExpressionImpl(node);
      }
      else if (type == ARG_LIST) {
        return new ProofFrogArgListImpl(node);
      }
      else if (type == ASSUMPTIONS) {
        return new ProofFrogAssumptionsImpl(node);
      }
      else if (type == ATOMIC_TYPE) {
        return new ProofFrogAtomicTypeImpl(node);
      }
      else if (type == BLOCK) {
        return new ProofFrogBlockImpl(node);
      }
      else if (type == COMPARISON_EXPRESSION) {
        return new ProofFrogComparisonExpressionImpl(node);
      }
      else if (type == CONCRETE_GAME) {
        return new ProofFrogConcreteGameImpl(node);
      }
      else if (type == EXPRESSION) {
        return new ProofFrogExpressionImpl(node);
      }
      else if (type == FIELD) {
        return new ProofFrogFieldImpl(node);
      }
      else if (type == GAME) {
        return new ProofFrogGameImpl(node);
      }
      else if (type == GAME_ADVERSARY) {
        return new ProofFrogGameAdversaryImpl(node);
      }
      else if (type == GAME_BODY) {
        return new ProofFrogGameBodyImpl(node);
      }
      else if (type == GAME_EXPORT) {
        return new ProofFrogGameExportImpl(node);
      }
      else if (type == GAME_LIST) {
        return new ProofFrogGameListImpl(node);
      }
      else if (type == GAME_PHASE) {
        return new ProofFrogGamePhaseImpl(node);
      }
      else if (type == GAME_PROGRAM) {
        return new ProofFrogGameProgramImpl(node);
      }
      else if (type == GAME_STEP) {
        return new ProofFrogGameStepImpl(node);
      }
      else if (type == ID) {
        return new ProofFrogIdImpl(node);
      }
      else if (type == INDUCTION) {
        return new ProofFrogInductionImpl(node);
      }
      else if (type == INITIALIZED_FIELD) {
        return new ProofFrogInitializedFieldImpl(node);
      }
      else if (type == INTEGER_EXPRESSION) {
        return new ProofFrogIntegerExpressionImpl(node);
      }
      else if (type == LETS) {
        return new ProofFrogLetsImpl(node);
      }
      else if (type == LVALUE) {
        return new ProofFrogLvalueImpl(node);
      }
      else if (type == METHOD) {
        return new ProofFrogMethodImpl(node);
      }
      else if (type == METHOD_SIGNATURE) {
        return new ProofFrogMethodSignatureImpl(node);
      }
      else if (type == MODULE_IMPORT) {
        return new ProofFrogModuleImportImpl(node);
      }
      else if (type == MULTIPLICATIVE_INTEGER_EXPRESSION) {
        return new ProofFrogMultiplicativeIntegerExpressionImpl(node);
      }
      else if (type == MULTIPLY_EXPRESSION) {
        return new ProofFrogMultiplyExpressionImpl(node);
      }
      else if (type == OR_EXPRESSION) {
        return new ProofFrogOrExpressionImpl(node);
      }
      else if (type == PARAMETERIZED_GAME) {
        return new ProofFrogParameterizedGameImpl(node);
      }
      else if (type == PARAM_LIST) {
        return new ProofFrogParamListImpl(node);
      }
      else if (type == POSTFIX_OPERATION) {
        return new ProofFrogPostfixOperationImpl(node);
      }
      else if (type == PRIMARY_ELEMENT) {
        return new ProofFrogPrimaryElementImpl(node);
      }
      else if (type == PRIMARY_EXPRESSION) {
        return new ProofFrogPrimaryExpressionImpl(node);
      }
      else if (type == PRIMARY_INTEGER_EXPRESSION) {
        return new ProofFrogPrimaryIntegerExpressionImpl(node);
      }
      else if (type == PRIMITIVE_BODY) {
        return new ProofFrogPrimitiveBodyImpl(node);
      }
      else if (type == PRIMITIVE_PROGRAM) {
        return new ProofFrogPrimitiveProgramImpl(node);
      }
      else if (type == PROOF) {
        return new ProofFrogProofImpl(node);
      }
      else if (type == PROOF_HELPERS) {
        return new ProofFrogProofHelpersImpl(node);
      }
      else if (type == PROOF_PROGRAM) {
        return new ProofFrogProofProgramImpl(node);
      }
      else if (type == REDUCTION) {
        return new ProofFrogReductionImpl(node);
      }
      else if (type == SCHEME) {
        return new ProofFrogSchemeImpl(node);
      }
      else if (type == SCHEME_BODY) {
        return new ProofFrogSchemeBodyImpl(node);
      }
      else if (type == SCHEME_PROGRAM) {
        return new ProofFrogSchemeProgramImpl(node);
      }
      else if (type == SET_MINUS_EXPRESSION) {
        return new ProofFrogSetMinusExpressionImpl(node);
      }
      else if (type == STATEMENT) {
        return new ProofFrogStatementImpl(node);
      }
      else if (type == STEP_ASSUMPTION) {
        return new ProofFrogStepAssumptionImpl(node);
      }
      else if (type == THEOREM) {
        return new ProofFrogTheoremImpl(node);
      }
      else if (type == TYPE) {
        return new ProofFrogTypeImpl(node);
      }
      else if (type == TYPE_POSTFIX) {
        return new ProofFrogTypePostfixImpl(node);
      }
      else if (type == TYPE_PRODUCT) {
        return new ProofFrogTypeProductImpl(node);
      }
      else if (type == UNARY_EXPRESSION) {
        return new ProofFrogUnaryExpressionImpl(node);
      }
      else if (type == UNION_EXPRESSION) {
        return new ProofFrogUnionExpressionImpl(node);
      }
      else if (type == VARIABLE) {
        return new ProofFrogVariableImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
