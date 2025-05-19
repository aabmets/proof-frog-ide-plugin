// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.github.aabmets.prooffroglang.psi.impl.*;

public interface ProofFrogTypes {

  IElementType ADD_EXPR = new ProofFrogElementType("ADD_EXPR");
  IElementType ADD_INTEGER_EXPR = new ProofFrogElementType("ADD_INTEGER_EXPR");
  IElementType AND_EXPR = new ProofFrogElementType("AND_EXPR");
  IElementType ARG_LIST = new ProofFrogElementType("ARG_LIST");
  IElementType ASSIGN_STMT = new ProofFrogElementType("ASSIGN_STMT");
  IElementType ASSUME_BLOCK = new ProofFrogElementType("ASSUME_BLOCK");
  IElementType ASSUMPTIONS = new ProofFrogElementType("ASSUMPTIONS");
  IElementType ATOMIC_TYPE = new ProofFrogElementType("ATOMIC_TYPE");
  IElementType BLOCK = new ProofFrogElementType("BLOCK");
  IElementType CALL_EXPR = new ProofFrogElementType("CALL_EXPR");
  IElementType COMPARE_EXPR = new ProofFrogElementType("COMPARE_EXPR");
  IElementType CONCRETE_GAME = new ProofFrogElementType("CONCRETE_GAME");
  IElementType CONDITIONAL_STMT = new ProofFrogElementType("CONDITIONAL_STMT");
  IElementType EXPRESSION = new ProofFrogElementType("EXPRESSION");
  IElementType EXPRESSION_STMT = new ProofFrogElementType("EXPRESSION_STMT");
  IElementType FIELD = new ProofFrogElementType("FIELD");
  IElementType FILE_PATH = new ProofFrogElementType("FILE_PATH");
  IElementType GAME = new ProofFrogElementType("GAME");
  IElementType GAMES_BLOCK = new ProofFrogElementType("GAMES_BLOCK");
  IElementType GAME_ADVERSARY = new ProofFrogElementType("GAME_ADVERSARY");
  IElementType GAME_BODY = new ProofFrogElementType("GAME_BODY");
  IElementType GAME_EXPORT = new ProofFrogElementType("GAME_EXPORT");
  IElementType GAME_LIST = new ProofFrogElementType("GAME_LIST");
  IElementType GAME_PHASE = new ProofFrogElementType("GAME_PHASE");
  IElementType GAME_PROGRAM = new ProofFrogElementType("GAME_PROGRAM");
  IElementType GAME_SIGNATURE = new ProofFrogElementType("GAME_SIGNATURE");
  IElementType GAME_STEP = new ProofFrogElementType("GAME_STEP");
  IElementType GENERIC_LOOP_STMT = new ProofFrogElementType("GENERIC_LOOP_STMT");
  IElementType ID = new ProofFrogElementType("ID");
  IElementType INDUCTION = new ProofFrogElementType("INDUCTION");
  IElementType INITIALIZED_FIELD = new ProofFrogElementType("INITIALIZED_FIELD");
  IElementType INTEGER_EXPR = new ProofFrogElementType("INTEGER_EXPR");
  IElementType INTEGER_LOOP_STMT = new ProofFrogElementType("INTEGER_LOOP_STMT");
  IElementType LETS = new ProofFrogElementType("LETS");
  IElementType LETS_BLOCK = new ProofFrogElementType("LETS_BLOCK");
  IElementType LVALUE = new ProofFrogElementType("LVALUE");
  IElementType METHOD = new ProofFrogElementType("METHOD");
  IElementType METHOD_SIGNATURE = new ProofFrogElementType("METHOD_SIGNATURE");
  IElementType MODULE_IMPORT = new ProofFrogElementType("MODULE_IMPORT");
  IElementType MULTIPLY_EXPR = new ProofFrogElementType("MULTIPLY_EXPR");
  IElementType MULTIPLY_INTEGER_EXPR = new ProofFrogElementType("MULTIPLY_INTEGER_EXPR");
  IElementType OR_EXPR = new ProofFrogElementType("OR_EXPR");
  IElementType PARAMETERIZED_GAME = new ProofFrogElementType("PARAMETERIZED_GAME");
  IElementType PARAM_LIST = new ProofFrogElementType("PARAM_LIST");
  IElementType PRIMARY_ELEM = new ProofFrogElementType("PRIMARY_ELEM");
  IElementType PRIMARY_EXPR = new ProofFrogElementType("PRIMARY_EXPR");
  IElementType PRIMARY_INTEGER_EXPR = new ProofFrogElementType("PRIMARY_INTEGER_EXPR");
  IElementType PRIMITIVE = new ProofFrogElementType("PRIMITIVE");
  IElementType PRIMITIVE_BODY = new ProofFrogElementType("PRIMITIVE_BODY");
  IElementType PRIMITIVE_PROGRAM = new ProofFrogElementType("PRIMITIVE_PROGRAM");
  IElementType PRIMITIVE_SIGNATURE = new ProofFrogElementType("PRIMITIVE_SIGNATURE");
  IElementType PROOF = new ProofFrogElementType("PROOF");
  IElementType PROOF_BLOCK = new ProofFrogElementType("PROOF_BLOCK");
  IElementType PROOF_PROGRAM = new ProofFrogElementType("PROOF_PROGRAM");
  IElementType REDUCTION = new ProofFrogElementType("REDUCTION");
  IElementType REDUCTION_GAME_STEP = new ProofFrogElementType("REDUCTION_GAME_STEP");
  IElementType REDUCTION_SIGNATURE = new ProofFrogElementType("REDUCTION_SIGNATURE");
  IElementType REGULAR_GAME_STEP = new ProofFrogElementType("REGULAR_GAME_STEP");
  IElementType RETURN_STMT = new ProofFrogElementType("RETURN_STMT");
  IElementType SAMPLE_STMT = new ProofFrogElementType("SAMPLE_STMT");
  IElementType SCHEME = new ProofFrogElementType("SCHEME");
  IElementType SCHEME_BODY = new ProofFrogElementType("SCHEME_BODY");
  IElementType SCHEME_PROGRAM = new ProofFrogElementType("SCHEME_PROGRAM");
  IElementType SCHEME_SIGNATURE = new ProofFrogElementType("SCHEME_SIGNATURE");
  IElementType SET_MINUS_EXPR = new ProofFrogElementType("SET_MINUS_EXPR");
  IElementType SLICE_EXPR = new ProofFrogElementType("SLICE_EXPR");
  IElementType STATEMENT = new ProofFrogElementType("STATEMENT");
  IElementType STEP_ASSUMPTION = new ProofFrogElementType("STEP_ASSUMPTION");
  IElementType THEOREM = new ProofFrogElementType("THEOREM");
  IElementType THEOREM_BLOCK = new ProofFrogElementType("THEOREM_BLOCK");
  IElementType TYPE = new ProofFrogElementType("TYPE");
  IElementType TYPED_ARRAY = new ProofFrogElementType("TYPED_ARRAY");
  IElementType TYPED_BIT_STRING = new ProofFrogElementType("TYPED_BIT_STRING");
  IElementType TYPED_MAP = new ProofFrogElementType("TYPED_MAP");
  IElementType TYPED_SET = new ProofFrogElementType("TYPED_SET");
  IElementType TYPE_PRODUCT = new ProofFrogElementType("TYPE_PRODUCT");
  IElementType UNARY_EXPR = new ProofFrogElementType("UNARY_EXPR");
  IElementType UNION_EXPR = new ProofFrogElementType("UNION_EXPR");
  IElementType VARIABLE = new ProofFrogElementType("VARIABLE");
  IElementType VAR_DECL_ASSIGN_STMT = new ProofFrogElementType("VAR_DECL_ASSIGN_STMT");
  IElementType VAR_DECL_SAMPLE_STMT = new ProofFrogElementType("VAR_DECL_SAMPLE_STMT");
  IElementType VAR_DECL_STMT = new ProofFrogElementType("VAR_DECL_STMT");

  IElementType CL_GAME = new ProofFrogTokenType("CL_GAME");
  IElementType CL_PRIMITIVE = new ProofFrogTokenType("CL_PRIMITIVE");
  IElementType CL_REDUCTION = new ProofFrogTokenType("CL_REDUCTION");
  IElementType CL_SCHEME = new ProofFrogTokenType("CL_SCHEME");
  IElementType DT_ARRAY = new ProofFrogTokenType("DT_ARRAY");
  IElementType DT_BITSTRING = new ProofFrogTokenType("DT_BITSTRING");
  IElementType DT_BOOL = new ProofFrogTokenType("DT_BOOL");
  IElementType DT_INT = new ProofFrogTokenType("DT_INT");
  IElementType DT_MAP = new ProofFrogTokenType("DT_MAP");
  IElementType DT_SET = new ProofFrogTokenType("DT_SET");
  IElementType DT_VOID = new ProofFrogTokenType("DT_VOID");
  IElementType KW_AGAINST = new ProofFrogTokenType("KW_AGAINST");
  IElementType KW_AS = new ProofFrogTokenType("KW_AS");
  IElementType KW_CALLS = new ProofFrogTokenType("KW_CALLS");
  IElementType KW_COMPOSE = new ProofFrogTokenType("KW_COMPOSE");
  IElementType KW_ELSE = new ProofFrogTokenType("KW_ELSE");
  IElementType KW_EXPORT = new ProofFrogTokenType("KW_EXPORT");
  IElementType KW_EXTENDS = new ProofFrogTokenType("KW_EXTENDS");
  IElementType KW_FOR = new ProofFrogTokenType("KW_FOR");
  IElementType KW_FROM = new ProofFrogTokenType("KW_FROM");
  IElementType KW_IF = new ProofFrogTokenType("KW_IF");
  IElementType KW_IMPORT = new ProofFrogTokenType("KW_IMPORT");
  IElementType KW_IN = new ProofFrogTokenType("KW_IN");
  IElementType KW_INDUCTION = new ProofFrogTokenType("KW_INDUCTION");
  IElementType KW_NONE = new ProofFrogTokenType("KW_NONE");
  IElementType KW_ORACLES = new ProofFrogTokenType("KW_ORACLES");
  IElementType KW_REQUIRES = new ProofFrogTokenType("KW_REQUIRES");
  IElementType KW_RETURN = new ProofFrogTokenType("KW_RETURN");
  IElementType KW_SUBSETS = new ProofFrogTokenType("KW_SUBSETS");
  IElementType KW_TO = new ProofFrogTokenType("KW_TO");
  IElementType KW_UNION = new ProofFrogTokenType("KW_UNION");
  IElementType LB_ASSUME = new ProofFrogTokenType("LB_ASSUME");
  IElementType LB_GAMES = new ProofFrogTokenType("LB_GAMES");
  IElementType LB_LET = new ProofFrogTokenType("LB_LET");
  IElementType LB_PROOF = new ProofFrogTokenType("LB_PROOF");
  IElementType LB_THEOREM = new ProofFrogTokenType("LB_THEOREM");
  IElementType NB_PHASE = new ProofFrogTokenType("NB_PHASE");
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
  IElementType PR_ADVERSARY = new ProofFrogTokenType("PR_ADVERSARY");
  IElementType ST_BRACE_L = new ProofFrogTokenType("ST_BRACE_L");
  IElementType ST_BRACE_R = new ProofFrogTokenType("ST_BRACE_R");
  IElementType ST_BRACKET_L = new ProofFrogTokenType("ST_BRACKET_L");
  IElementType ST_BRACKET_R = new ProofFrogTokenType("ST_BRACKET_R");
  IElementType ST_PAREN_L = new ProofFrogTokenType("ST_PAREN_L");
  IElementType ST_PAREN_R = new ProofFrogTokenType("ST_PAREN_R");
  IElementType VL_BINARYNUM = new ProofFrogTokenType("VL_BINARYNUM");
  IElementType VL_BOOL = new ProofFrogTokenType("VL_BOOL");
  IElementType VL_FILE_PATH = new ProofFrogTokenType("VL_FILE_PATH");
  IElementType VL_IDENTIFIER = new ProofFrogTokenType("VL_IDENTIFIER");
  IElementType VL_INT = new ProofFrogTokenType("VL_INT");
  IElementType VL_LINE_COMMENT = new ProofFrogTokenType("VL_LINE_COMMENT");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADD_EXPR) {
        return new ProofFrogAddExprImpl(node);
      }
      else if (type == ADD_INTEGER_EXPR) {
        return new ProofFrogAddIntegerExprImpl(node);
      }
      else if (type == AND_EXPR) {
        return new ProofFrogAndExprImpl(node);
      }
      else if (type == ARG_LIST) {
        return new ProofFrogArgListImpl(node);
      }
      else if (type == ASSIGN_STMT) {
        return new ProofFrogAssignStmtImpl(node);
      }
      else if (type == ASSUME_BLOCK) {
        return new ProofFrogAssumeBlockImpl(node);
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
      else if (type == CALL_EXPR) {
        return new ProofFrogCallExprImpl(node);
      }
      else if (type == COMPARE_EXPR) {
        return new ProofFrogCompareExprImpl(node);
      }
      else if (type == CONCRETE_GAME) {
        return new ProofFrogConcreteGameImpl(node);
      }
      else if (type == CONDITIONAL_STMT) {
        return new ProofFrogConditionalStmtImpl(node);
      }
      else if (type == EXPRESSION) {
        return new ProofFrogExpressionImpl(node);
      }
      else if (type == EXPRESSION_STMT) {
        return new ProofFrogExpressionStmtImpl(node);
      }
      else if (type == FIELD) {
        return new ProofFrogFieldImpl(node);
      }
      else if (type == FILE_PATH) {
        return new ProofFrogFilePathImpl(node);
      }
      else if (type == GAME) {
        return new ProofFrogGameImpl(node);
      }
      else if (type == GAMES_BLOCK) {
        return new ProofFrogGamesBlockImpl(node);
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
      else if (type == GAME_SIGNATURE) {
        return new ProofFrogGameSignatureImpl(node);
      }
      else if (type == GAME_STEP) {
        return new ProofFrogGameStepImpl(node);
      }
      else if (type == GENERIC_LOOP_STMT) {
        return new ProofFrogGenericLoopStmtImpl(node);
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
      else if (type == INTEGER_EXPR) {
        return new ProofFrogIntegerExprImpl(node);
      }
      else if (type == INTEGER_LOOP_STMT) {
        return new ProofFrogIntegerLoopStmtImpl(node);
      }
      else if (type == LETS) {
        return new ProofFrogLetsImpl(node);
      }
      else if (type == LETS_BLOCK) {
        return new ProofFrogLetsBlockImpl(node);
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
      else if (type == MULTIPLY_EXPR) {
        return new ProofFrogMultiplyExprImpl(node);
      }
      else if (type == MULTIPLY_INTEGER_EXPR) {
        return new ProofFrogMultiplyIntegerExprImpl(node);
      }
      else if (type == OR_EXPR) {
        return new ProofFrogOrExprImpl(node);
      }
      else if (type == PARAMETERIZED_GAME) {
        return new ProofFrogParameterizedGameImpl(node);
      }
      else if (type == PARAM_LIST) {
        return new ProofFrogParamListImpl(node);
      }
      else if (type == PRIMARY_ELEM) {
        return new ProofFrogPrimaryElemImpl(node);
      }
      else if (type == PRIMARY_EXPR) {
        return new ProofFrogPrimaryExprImpl(node);
      }
      else if (type == PRIMARY_INTEGER_EXPR) {
        return new ProofFrogPrimaryIntegerExprImpl(node);
      }
      else if (type == PRIMITIVE) {
        return new ProofFrogPrimitiveImpl(node);
      }
      else if (type == PRIMITIVE_BODY) {
        return new ProofFrogPrimitiveBodyImpl(node);
      }
      else if (type == PRIMITIVE_PROGRAM) {
        return new ProofFrogPrimitiveProgramImpl(node);
      }
      else if (type == PRIMITIVE_SIGNATURE) {
        return new ProofFrogPrimitiveSignatureImpl(node);
      }
      else if (type == PROOF) {
        return new ProofFrogProofImpl(node);
      }
      else if (type == PROOF_BLOCK) {
        return new ProofFrogProofBlockImpl(node);
      }
      else if (type == PROOF_PROGRAM) {
        return new ProofFrogProofProgramImpl(node);
      }
      else if (type == REDUCTION) {
        return new ProofFrogReductionImpl(node);
      }
      else if (type == REDUCTION_GAME_STEP) {
        return new ProofFrogReductionGameStepImpl(node);
      }
      else if (type == REDUCTION_SIGNATURE) {
        return new ProofFrogReductionSignatureImpl(node);
      }
      else if (type == REGULAR_GAME_STEP) {
        return new ProofFrogRegularGameStepImpl(node);
      }
      else if (type == RETURN_STMT) {
        return new ProofFrogReturnStmtImpl(node);
      }
      else if (type == SAMPLE_STMT) {
        return new ProofFrogSampleStmtImpl(node);
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
      else if (type == SCHEME_SIGNATURE) {
        return new ProofFrogSchemeSignatureImpl(node);
      }
      else if (type == SET_MINUS_EXPR) {
        return new ProofFrogSetMinusExprImpl(node);
      }
      else if (type == SLICE_EXPR) {
        return new ProofFrogSliceExprImpl(node);
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
      else if (type == THEOREM_BLOCK) {
        return new ProofFrogTheoremBlockImpl(node);
      }
      else if (type == TYPE) {
        return new ProofFrogTypeImpl(node);
      }
      else if (type == TYPED_ARRAY) {
        return new ProofFrogTypedArrayImpl(node);
      }
      else if (type == TYPED_BIT_STRING) {
        return new ProofFrogTypedBitStringImpl(node);
      }
      else if (type == TYPED_MAP) {
        return new ProofFrogTypedMapImpl(node);
      }
      else if (type == TYPED_SET) {
        return new ProofFrogTypedSetImpl(node);
      }
      else if (type == TYPE_PRODUCT) {
        return new ProofFrogTypeProductImpl(node);
      }
      else if (type == UNARY_EXPR) {
        return new ProofFrogUnaryExprImpl(node);
      }
      else if (type == UNION_EXPR) {
        return new ProofFrogUnionExprImpl(node);
      }
      else if (type == VARIABLE) {
        return new ProofFrogVariableImpl(node);
      }
      else if (type == VAR_DECL_ASSIGN_STMT) {
        return new ProofFrogVarDeclAssignStmtImpl(node);
      }
      else if (type == VAR_DECL_SAMPLE_STMT) {
        return new ProofFrogVarDeclSampleStmtImpl(node);
      }
      else if (type == VAR_DECL_STMT) {
        return new ProofFrogVarDeclStmtImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
