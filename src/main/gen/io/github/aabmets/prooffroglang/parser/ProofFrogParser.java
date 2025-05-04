// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.github.aabmets.prooffroglang.psi.ProofFrogTypes.*;
import static io.github.aabmets.prooffroglang.parser.ProofFrogParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ProofFrogParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return file(b, l + 1);
  }

  /* ********************************************************** */
  // multiplyExpr ( (OP_ADD | OP_SUB) multiplyExpr )*
  public static boolean addExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADD_EXPR, "<add expr>");
    r = multiplyExpr(b, l + 1);
    r = r && addExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( (OP_ADD | OP_SUB) multiplyExpr )*
  private static boolean addExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!addExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "addExpr_1", c)) break;
    }
    return true;
  }

  // (OP_ADD | OP_SUB) multiplyExpr
  private static boolean addExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = addExpr_1_0_0(b, l + 1);
    r = r && multiplyExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_ADD | OP_SUB
  private static boolean addExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpr_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, OP_ADD);
    if (!r) r = consumeToken(b, OP_SUB);
    return r;
  }

  /* ********************************************************** */
  // multiplyIntegerExpr
  //     ( (OP_ADD | OP_SUB) multiplyIntegerExpr )*
  public static boolean addIntegerExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addIntegerExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADD_INTEGER_EXPR, "<add integer expr>");
    r = multiplyIntegerExpr(b, l + 1);
    r = r && addIntegerExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( (OP_ADD | OP_SUB) multiplyIntegerExpr )*
  private static boolean addIntegerExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addIntegerExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!addIntegerExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "addIntegerExpr_1", c)) break;
    }
    return true;
  }

  // (OP_ADD | OP_SUB) multiplyIntegerExpr
  private static boolean addIntegerExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addIntegerExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = addIntegerExpr_1_0_0(b, l + 1);
    r = r && multiplyIntegerExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_ADD | OP_SUB
  private static boolean addIntegerExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addIntegerExpr_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, OP_ADD);
    if (!r) r = consumeToken(b, OP_SUB);
    return r;
  }

  /* ********************************************************** */
  // compareExpr (OP_AND compareExpr)*
  public static boolean andExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AND_EXPR, "<and expr>");
    r = compareExpr(b, l + 1);
    r = r && andExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OP_AND compareExpr)*
  private static boolean andExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!andExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "andExpr_1", c)) break;
    }
    return true;
  }

  // OP_AND compareExpr
  private static boolean andExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_AND);
    r = r && compareExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression (PN_COMMA expression)*
  public static boolean argList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARG_LIST, "<arg list>");
    r = expression(b, l + 1);
    r = r && argList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (PN_COMMA expression)*
  private static boolean argList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argList_1", c)) break;
    }
    return true;
  }

  // PN_COMMA expression
  private static boolean argList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PN_COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // lvalue OP_ASSIGN expression PN_SEMI
  public static boolean assignStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignStmt")) return false;
    if (!nextTokenIs(b, VL_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lvalue(b, l + 1);
    r = r && consumeToken(b, OP_ASSIGN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, ASSIGN_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // (parameterizedGame PN_SEMI)* (KW_CALLS (OP_LEQ | OP_LT) expression PN_SEMI)?
  public static boolean assumptions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assumptions")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSUMPTIONS, "<assumptions>");
    r = assumptions_0(b, l + 1);
    r = r && assumptions_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (parameterizedGame PN_SEMI)*
  private static boolean assumptions_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assumptions_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!assumptions_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "assumptions_0", c)) break;
    }
    return true;
  }

  // parameterizedGame PN_SEMI
  private static boolean assumptions_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assumptions_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameterizedGame(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KW_CALLS (OP_LEQ | OP_LT) expression PN_SEMI)?
  private static boolean assumptions_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assumptions_1")) return false;
    assumptions_1_0(b, l + 1);
    return true;
  }

  // KW_CALLS (OP_LEQ | OP_LT) expression PN_SEMI
  private static boolean assumptions_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assumptions_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_CALLS);
    r = r && assumptions_1_0_1(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_LEQ | OP_LT
  private static boolean assumptions_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assumptions_1_0_1")) return false;
    boolean r;
    r = consumeToken(b, OP_LEQ);
    if (!r) r = consumeToken(b, OP_LT);
    return r;
  }

  /* ********************************************************** */
  // DT_SET OP_LT type OP_GT
  //     | DT_SET
  //     | DT_BOOL
  //     | DT_VOID
  //     | DT_MAP OP_LT type PN_COMMA type OP_GT
  //     | DT_ARRAY OP_LT type PN_COMMA integerExpr OP_GT
  //     | DT_INT
  //     | DT_BITSTRING OP_LT integerExpr OP_GT
  //     | DT_BITSTRING
  //     | lvalue
  public static boolean atomicType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOMIC_TYPE, "<atomic type>");
    r = atomicType_0(b, l + 1);
    if (!r) r = consumeToken(b, DT_SET);
    if (!r) r = consumeToken(b, DT_BOOL);
    if (!r) r = consumeToken(b, DT_VOID);
    if (!r) r = atomicType_4(b, l + 1);
    if (!r) r = atomicType_5(b, l + 1);
    if (!r) r = consumeToken(b, DT_INT);
    if (!r) r = atomicType_7(b, l + 1);
    if (!r) r = consumeToken(b, DT_BITSTRING);
    if (!r) r = lvalue(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DT_SET OP_LT type OP_GT
  private static boolean atomicType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicType_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DT_SET, OP_LT);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, OP_GT);
    exit_section_(b, m, null, r);
    return r;
  }

  // DT_MAP OP_LT type PN_COMMA type OP_GT
  private static boolean atomicType_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicType_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DT_MAP, OP_LT);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, PN_COMMA);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, OP_GT);
    exit_section_(b, m, null, r);
    return r;
  }

  // DT_ARRAY OP_LT type PN_COMMA integerExpr OP_GT
  private static boolean atomicType_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicType_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DT_ARRAY, OP_LT);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, PN_COMMA);
    r = r && integerExpr(b, l + 1);
    r = r && consumeToken(b, OP_GT);
    exit_section_(b, m, null, r);
    return r;
  }

  // DT_BITSTRING OP_LT integerExpr OP_GT
  private static boolean atomicType_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicType_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DT_BITSTRING, OP_LT);
    r = r && integerExpr(b, l + 1);
    r = r && consumeToken(b, OP_GT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ST_BRACE_L statement* ST_BRACE_R
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, ST_BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ST_BRACE_L);
    r = r && block_1(b, l + 1);
    r = r && consumeToken(b, ST_BRACE_R);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  // statement*
  private static boolean block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ST_PAREN_L argList? ST_PAREN_R
  public static boolean callExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callExpr")) return false;
    if (!nextTokenIs(b, ST_PAREN_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ST_PAREN_L);
    r = r && callExpr_1(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_R);
    exit_section_(b, m, CALL_EXPR, r);
    return r;
  }

  // argList?
  private static boolean callExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callExpr_1")) return false;
    argList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // expression ST_PAREN_L argList? ST_PAREN_R PN_SEMI
  public static boolean callStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callStmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CALL_STMT, "<call stmt>");
    r = expression(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_L);
    r = r && callStmt_2(b, l + 1);
    r = r && consumeTokens(b, 0, ST_PAREN_R, PN_SEMI);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // argList?
  private static boolean callStmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callStmt_2")) return false;
    argList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // addExpr (
  //     (OP_EQ | OP_NEQ | OP_GT | OP_LT | OP_GEQ | OP_LEQ | KW_IN | KW_SUBSETS)
  //     addExpr
  // )?
  public static boolean compareExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARE_EXPR, "<compare expr>");
    r = addExpr(b, l + 1);
    r = r && compareExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (
  //     (OP_EQ | OP_NEQ | OP_GT | OP_LT | OP_GEQ | OP_LEQ | KW_IN | KW_SUBSETS)
  //     addExpr
  // )?
  private static boolean compareExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpr_1")) return false;
    compareExpr_1_0(b, l + 1);
    return true;
  }

  // (OP_EQ | OP_NEQ | OP_GT | OP_LT | OP_GEQ | OP_LEQ | KW_IN | KW_SUBSETS)
  //     addExpr
  private static boolean compareExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = compareExpr_1_0_0(b, l + 1);
    r = r && addExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_EQ | OP_NEQ | OP_GT | OP_LT | OP_GEQ | OP_LEQ | KW_IN | KW_SUBSETS
  private static boolean compareExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compareExpr_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, OP_EQ);
    if (!r) r = consumeToken(b, OP_NEQ);
    if (!r) r = consumeToken(b, OP_GT);
    if (!r) r = consumeToken(b, OP_LT);
    if (!r) r = consumeToken(b, OP_GEQ);
    if (!r) r = consumeToken(b, OP_LEQ);
    if (!r) r = consumeToken(b, KW_IN);
    if (!r) r = consumeToken(b, KW_SUBSETS);
    return r;
  }

  /* ********************************************************** */
  // parameterizedGame PN_PERIOD id
  public static boolean concreteGame(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concreteGame")) return false;
    if (!nextTokenIs(b, VL_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameterizedGame(b, l + 1);
    r = r && consumeToken(b, PN_PERIOD);
    r = r && id(b, l + 1);
    exit_section_(b, m, CONCRETE_GAME, r);
    return r;
  }

  /* ********************************************************** */
  // KW_IF ST_PAREN_L expression ST_PAREN_R block
  //     (KW_ELSE KW_IF ST_PAREN_L expression ST_PAREN_R block)*
  //     (KW_ELSE block)?
  public static boolean conditionalStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalStmt")) return false;
    if (!nextTokenIs(b, KW_IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_IF, ST_PAREN_L);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_R);
    r = r && block(b, l + 1);
    r = r && conditionalStmt_5(b, l + 1);
    r = r && conditionalStmt_6(b, l + 1);
    exit_section_(b, m, CONDITIONAL_STMT, r);
    return r;
  }

  // (KW_ELSE KW_IF ST_PAREN_L expression ST_PAREN_R block)*
  private static boolean conditionalStmt_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalStmt_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!conditionalStmt_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conditionalStmt_5", c)) break;
    }
    return true;
  }

  // KW_ELSE KW_IF ST_PAREN_L expression ST_PAREN_R block
  private static boolean conditionalStmt_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalStmt_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_ELSE, KW_IF, ST_PAREN_L);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_R);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KW_ELSE block)?
  private static boolean conditionalStmt_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalStmt_6")) return false;
    conditionalStmt_6_0(b, l + 1);
    return true;
  }

  // KW_ELSE block
  private static boolean conditionalStmt_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalStmt_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_ELSE);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // setMinusExpr
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = setMinusExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // variable (OP_ASSIGN expression)?
  public static boolean field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD, "<field>");
    r = variable(b, l + 1);
    r = r && field_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OP_ASSIGN expression)?
  private static boolean field_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_1")) return false;
    field_1_0(b, l + 1);
    return true;
  }

  // OP_ASSIGN expression
  private static boolean field_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_ASSIGN);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // <<fileContent>> | VL_LINE_COMMENT
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fileContent(b, l + 1);
    if (!r) r = consumeToken(b, VL_LINE_COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // primitiveContent | schemeContent | gameContent | proofContent
  static boolean fileContent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fileContent")) return false;
    boolean r;
    r = primitiveContent(b, l + 1);
    if (!r) r = schemeContent(b, l + 1);
    if (!r) r = gameContent(b, l + 1);
    if (!r) r = proofContent(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // CL_GAME id ST_PAREN_L paramList? ST_PAREN_R ST_BRACE_L gameBody ST_BRACE_R
  public static boolean game(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "game")) return false;
    if (!nextTokenIs(b, CL_GAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CL_GAME);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_L);
    r = r && game_3(b, l + 1);
    r = r && consumeTokens(b, 0, ST_PAREN_R, ST_BRACE_L);
    r = r && gameBody(b, l + 1);
    r = r && consumeToken(b, ST_BRACE_R);
    exit_section_(b, m, GAME, r);
    return r;
  }

  // paramList?
  private static boolean game_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "game_3")) return false;
    paramList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // parameterizedGame PN_PERIOD PR_ADVERSARY
  public static boolean gameAdversary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameAdversary")) return false;
    if (!nextTokenIs(b, VL_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameterizedGame(b, l + 1);
    r = r && consumeTokens(b, 0, PN_PERIOD, PR_ADVERSARY);
    exit_section_(b, m, GAME_ADVERSARY, r);
    return r;
  }

  /* ********************************************************** */
  // (field PN_SEMI)* method+ |
  //     (field PN_SEMI)* method* gamePhase+
  public static boolean gameBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GAME_BODY, "<game body>");
    r = gameBody_0(b, l + 1);
    if (!r) r = gameBody_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (field PN_SEMI)* method+
  private static boolean gameBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gameBody_0_0(b, l + 1);
    r = r && gameBody_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (field PN_SEMI)*
  private static boolean gameBody_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!gameBody_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gameBody_0_0", c)) break;
    }
    return true;
  }

  // field PN_SEMI
  private static boolean gameBody_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // method+
  private static boolean gameBody_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = method(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!method(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gameBody_0_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (field PN_SEMI)* method* gamePhase+
  private static boolean gameBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gameBody_1_0(b, l + 1);
    r = r && gameBody_1_1(b, l + 1);
    r = r && gameBody_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (field PN_SEMI)*
  private static boolean gameBody_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!gameBody_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gameBody_1_0", c)) break;
    }
    return true;
  }

  // field PN_SEMI
  private static boolean gameBody_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // method*
  private static boolean gameBody_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!method(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gameBody_1_1", c)) break;
    }
    return true;
  }

  // gamePhase+
  private static boolean gameBody_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gamePhase(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!gamePhase(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gameBody_1_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // &<<isGameFile>> gameProgram
  static boolean gameContent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameContent")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gameContent_0(b, l + 1);
    r = r && gameProgram(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &<<isGameFile>>
  private static boolean gameContent_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameContent_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = isGameFile(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_EXPORT KW_AS id PN_SEMI
  public static boolean gameExport(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameExport")) return false;
    if (!nextTokenIs(b, KW_EXPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_EXPORT, KW_AS);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, GAME_EXPORT, r);
    return r;
  }

  /* ********************************************************** */
  // gameStep PN_SEMI (gameStep PN_SEMI | induction | stepAssumption)*
  public static boolean gameList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameList")) return false;
    if (!nextTokenIs(b, VL_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gameStep(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    r = r && gameList_2(b, l + 1);
    exit_section_(b, m, GAME_LIST, r);
    return r;
  }

  // (gameStep PN_SEMI | induction | stepAssumption)*
  private static boolean gameList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameList_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!gameList_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gameList_2", c)) break;
    }
    return true;
  }

  // gameStep PN_SEMI | induction | stepAssumption
  private static boolean gameList_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameList_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gameList_2_0_0(b, l + 1);
    if (!r) r = induction(b, l + 1);
    if (!r) r = stepAssumption(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // gameStep PN_SEMI
  private static boolean gameList_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameList_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gameStep(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NB_PHASE ST_BRACE_L (method)+ KW_ORACLES PN_COLON
  //     ST_BRACKET_L id (PN_COMMA id)* ST_BRACKET_R
  //     PN_SEMI ST_BRACE_R
  public static boolean gamePhase(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gamePhase")) return false;
    if (!nextTokenIs(b, NB_PHASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NB_PHASE, ST_BRACE_L);
    r = r && gamePhase_2(b, l + 1);
    r = r && consumeTokens(b, 0, KW_ORACLES, PN_COLON, ST_BRACKET_L);
    r = r && id(b, l + 1);
    r = r && gamePhase_7(b, l + 1);
    r = r && consumeTokens(b, 0, ST_BRACKET_R, PN_SEMI, ST_BRACE_R);
    exit_section_(b, m, GAME_PHASE, r);
    return r;
  }

  // (method)+
  private static boolean gamePhase_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gamePhase_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gamePhase_2_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!gamePhase_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gamePhase_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (method)
  private static boolean gamePhase_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gamePhase_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = method(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (PN_COMMA id)*
  private static boolean gamePhase_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gamePhase_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!gamePhase_7_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gamePhase_7", c)) break;
    }
    return true;
  }

  // PN_COMMA id
  private static boolean gamePhase_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gamePhase_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PN_COMMA);
    r = r && id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // moduleImport* game game gameExport
  public static boolean gameProgram(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameProgram")) return false;
    if (!nextTokenIs(b, "<game program>", CL_GAME, KW_IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GAME_PROGRAM, "<game program>");
    r = gameProgram_0(b, l + 1);
    r = r && game(b, l + 1);
    r = r && game(b, l + 1);
    r = r && gameExport(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // moduleImport*
  private static boolean gameProgram_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameProgram_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!moduleImport(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gameProgram_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // concreteGame KW_COMPOSE parameterizedGame KW_AGAINST gameAdversary |  // reductionStep
  // 	(concreteGame | parameterizedGame) KW_AGAINST gameAdversary
  public static boolean gameStep(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameStep")) return false;
    if (!nextTokenIs(b, VL_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gameStep_0(b, l + 1);
    if (!r) r = gameStep_1(b, l + 1);
    exit_section_(b, m, GAME_STEP, r);
    return r;
  }

  // concreteGame KW_COMPOSE parameterizedGame KW_AGAINST gameAdversary
  private static boolean gameStep_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameStep_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = concreteGame(b, l + 1);
    r = r && consumeToken(b, KW_COMPOSE);
    r = r && parameterizedGame(b, l + 1);
    r = r && consumeToken(b, KW_AGAINST);
    r = r && gameAdversary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (concreteGame | parameterizedGame) KW_AGAINST gameAdversary
  private static boolean gameStep_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameStep_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gameStep_1_0(b, l + 1);
    r = r && consumeToken(b, KW_AGAINST);
    r = r && gameAdversary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // concreteGame | parameterizedGame
  private static boolean gameStep_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameStep_1_0")) return false;
    boolean r;
    r = concreteGame(b, l + 1);
    if (!r) r = parameterizedGame(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_FOR ST_PAREN_L variable KW_IN expression ST_PAREN_R block
  public static boolean genericLoopStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericLoopStmt")) return false;
    if (!nextTokenIs(b, KW_FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_FOR, ST_PAREN_L);
    r = r && variable(b, l + 1);
    r = r && consumeToken(b, KW_IN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_R);
    r = r && block(b, l + 1);
    exit_section_(b, m, GENERIC_LOOP_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // VL_IDENTIFIER
  public static boolean id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id")) return false;
    if (!nextTokenIs(b, VL_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VL_IDENTIFIER);
    exit_section_(b, m, ID, r);
    return r;
  }

  /* ********************************************************** */
  // KW_INDUCTION ST_PAREN_L id KW_FROM integerExpr KW_TO
  //     integerExpr ST_PAREN_R ST_BRACE_L gameList ST_BRACE_R
  public static boolean induction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "induction")) return false;
    if (!nextTokenIs(b, KW_INDUCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_INDUCTION, ST_PAREN_L);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, KW_FROM);
    r = r && integerExpr(b, l + 1);
    r = r && consumeToken(b, KW_TO);
    r = r && integerExpr(b, l + 1);
    r = r && consumeTokens(b, 0, ST_PAREN_R, ST_BRACE_L);
    r = r && gameList(b, l + 1);
    r = r && consumeToken(b, ST_BRACE_R);
    exit_section_(b, m, INDUCTION, r);
    return r;
  }

  /* ********************************************************** */
  // variable OP_ASSIGN expression
  public static boolean initializedField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "initializedField")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INITIALIZED_FIELD, "<initialized field>");
    r = variable(b, l + 1);
    r = r && consumeToken(b, OP_ASSIGN);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // addIntegerExpr
  public static boolean integerExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integerExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTEGER_EXPR, "<integer expr>");
    r = addIntegerExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_FOR ST_PAREN_L DT_INT id OP_ASSIGN
  //     expression KW_TO expression ST_PAREN_R block
  public static boolean integerLoopStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integerLoopStmt")) return false;
    if (!nextTokenIs(b, KW_FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_FOR, ST_PAREN_L, DT_INT);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, OP_ASSIGN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, KW_TO);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_R);
    r = r && block(b, l + 1);
    exit_section_(b, m, INTEGER_LOOP_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // (field PN_SEMI)*
  public static boolean lets(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lets")) return false;
    Marker m = enter_section_(b, l, _NONE_, LETS, "<lets>");
    while (true) {
      int c = current_position_(b);
      if (!lets_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lets", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // field PN_SEMI
  private static boolean lets_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lets_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (id | parameterizedGame) (PN_PERIOD id | ST_BRACKET_L expression ST_BRACKET_R)*
  public static boolean lvalue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue")) return false;
    if (!nextTokenIs(b, VL_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lvalue_0(b, l + 1);
    r = r && lvalue_1(b, l + 1);
    exit_section_(b, m, LVALUE, r);
    return r;
  }

  // id | parameterizedGame
  private static boolean lvalue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue_0")) return false;
    boolean r;
    r = id(b, l + 1);
    if (!r) r = parameterizedGame(b, l + 1);
    return r;
  }

  // (PN_PERIOD id | ST_BRACKET_L expression ST_BRACKET_R)*
  private static boolean lvalue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lvalue_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lvalue_1", c)) break;
    }
    return true;
  }

  // PN_PERIOD id | ST_BRACKET_L expression ST_BRACKET_R
  private static boolean lvalue_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lvalue_1_0_0(b, l + 1);
    if (!r) r = lvalue_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PN_PERIOD id
  private static boolean lvalue_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PN_PERIOD);
    r = r && id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ST_BRACKET_L expression ST_BRACKET_R
  private static boolean lvalue_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ST_BRACKET_L);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, ST_BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // methodSignature block
  public static boolean method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD, "<method>");
    r = methodSignature(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // type id ST_PAREN_L paramList? ST_PAREN_R
  public static boolean methodSignature(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodSignature")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_SIGNATURE, "<method signature>");
    r = type(b, l + 1);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_L);
    r = r && methodSignature_3(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_R);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // paramList?
  private static boolean methodSignature_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodSignature_3")) return false;
    paramList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_IMPORT VL_FILE_PATH (KW_AS id)? PN_SEMI
  public static boolean moduleImport(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleImport")) return false;
    if (!nextTokenIs(b, KW_IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_IMPORT, VL_FILE_PATH);
    r = r && moduleImport_2(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, MODULE_IMPORT, r);
    return r;
  }

  // (KW_AS id)?
  private static boolean moduleImport_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleImport_2")) return false;
    moduleImport_2_0(b, l + 1);
    return true;
  }

  // KW_AS id
  private static boolean moduleImport_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleImport_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AS);
    r = r && id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unaryExpr ( (OP_MULT | OP_DIV) unaryExpr )*
  public static boolean multiplyExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLY_EXPR, "<multiply expr>");
    r = unaryExpr(b, l + 1);
    r = r && multiplyExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( (OP_MULT | OP_DIV) unaryExpr )*
  private static boolean multiplyExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiplyExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplyExpr_1", c)) break;
    }
    return true;
  }

  // (OP_MULT | OP_DIV) unaryExpr
  private static boolean multiplyExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplyExpr_1_0_0(b, l + 1);
    r = r && unaryExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_MULT | OP_DIV
  private static boolean multiplyExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyExpr_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, OP_MULT);
    if (!r) r = consumeToken(b, OP_DIV);
    return r;
  }

  /* ********************************************************** */
  // primaryIntegerExpr
  //     ( (OP_MULT | OP_DIV) primaryIntegerExpr )*
  public static boolean multiplyIntegerExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyIntegerExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLY_INTEGER_EXPR, "<multiply integer expr>");
    r = primaryIntegerExpr(b, l + 1);
    r = r && multiplyIntegerExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( (OP_MULT | OP_DIV) primaryIntegerExpr )*
  private static boolean multiplyIntegerExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyIntegerExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiplyIntegerExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplyIntegerExpr_1", c)) break;
    }
    return true;
  }

  // (OP_MULT | OP_DIV) primaryIntegerExpr
  private static boolean multiplyIntegerExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyIntegerExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplyIntegerExpr_1_0_0(b, l + 1);
    r = r && primaryIntegerExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_MULT | OP_DIV
  private static boolean multiplyIntegerExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyIntegerExpr_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, OP_MULT);
    if (!r) r = consumeToken(b, OP_DIV);
    return r;
  }

  /* ********************************************************** */
  // andExpr (OP_OR andExpr)*
  public static boolean orExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OR_EXPR, "<or expr>");
    r = andExpr(b, l + 1);
    r = r && orExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OP_OR andExpr)*
  private static boolean orExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!orExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "orExpr_1", c)) break;
    }
    return true;
  }

  // OP_OR andExpr
  private static boolean orExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_OR);
    r = r && andExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // variable (PN_COMMA variable)*
  public static boolean paramList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM_LIST, "<param list>");
    r = variable(b, l + 1);
    r = r && paramList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (PN_COMMA variable)*
  private static boolean paramList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!paramList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "paramList_1", c)) break;
    }
    return true;
  }

  // PN_COMMA variable
  private static boolean paramList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PN_COMMA);
    r = r && variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id ST_PAREN_L argList? ST_PAREN_R
  public static boolean parameterizedGame(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterizedGame")) return false;
    if (!nextTokenIs(b, VL_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = id(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_L);
    r = r && parameterizedGame_2(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_R);
    exit_section_(b, m, PARAMETERIZED_GAME, r);
    return r;
  }

  // argList?
  private static boolean parameterizedGame_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterizedGame_2")) return false;
    argList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // lvalue
  //     | ST_BRACKET_L (expression (PN_COMMA expression)*)? ST_BRACKET_R
  //     | ST_BRACE_L  (expression (PN_COMMA expression)*)? ST_BRACE_R
  //     | type
  //     | VL_BINARYNUM
  //     | DT_INT
  //     | VL_BOOL
  //     | KW_NONE
  //     | ST_PAREN_L expression ST_PAREN_R
  public static boolean primaryElem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElem")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_ELEM, "<primary elem>");
    r = lvalue(b, l + 1);
    if (!r) r = primaryElem_1(b, l + 1);
    if (!r) r = primaryElem_2(b, l + 1);
    if (!r) r = type(b, l + 1);
    if (!r) r = consumeToken(b, VL_BINARYNUM);
    if (!r) r = consumeToken(b, DT_INT);
    if (!r) r = consumeToken(b, VL_BOOL);
    if (!r) r = consumeToken(b, KW_NONE);
    if (!r) r = primaryElem_8(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ST_BRACKET_L (expression (PN_COMMA expression)*)? ST_BRACKET_R
  private static boolean primaryElem_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElem_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ST_BRACKET_L);
    r = r && primaryElem_1_1(b, l + 1);
    r = r && consumeToken(b, ST_BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (expression (PN_COMMA expression)*)?
  private static boolean primaryElem_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElem_1_1")) return false;
    primaryElem_1_1_0(b, l + 1);
    return true;
  }

  // expression (PN_COMMA expression)*
  private static boolean primaryElem_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElem_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && primaryElem_1_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (PN_COMMA expression)*
  private static boolean primaryElem_1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElem_1_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!primaryElem_1_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primaryElem_1_1_0_1", c)) break;
    }
    return true;
  }

  // PN_COMMA expression
  private static boolean primaryElem_1_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElem_1_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PN_COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ST_BRACE_L  (expression (PN_COMMA expression)*)? ST_BRACE_R
  private static boolean primaryElem_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElem_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ST_BRACE_L);
    r = r && primaryElem_2_1(b, l + 1);
    r = r && consumeToken(b, ST_BRACE_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (expression (PN_COMMA expression)*)?
  private static boolean primaryElem_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElem_2_1")) return false;
    primaryElem_2_1_0(b, l + 1);
    return true;
  }

  // expression (PN_COMMA expression)*
  private static boolean primaryElem_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElem_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && primaryElem_2_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (PN_COMMA expression)*
  private static boolean primaryElem_2_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElem_2_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!primaryElem_2_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primaryElem_2_1_0_1", c)) break;
    }
    return true;
  }

  // PN_COMMA expression
  private static boolean primaryElem_2_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElem_2_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PN_COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ST_PAREN_L expression ST_PAREN_R
  private static boolean primaryElem_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElem_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ST_PAREN_L);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // primaryElem (callExpr | sliceExpr)*
  public static boolean primaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_EXPR, "<primary expr>");
    r = primaryElem(b, l + 1);
    r = r && primaryExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (callExpr | sliceExpr)*
  private static boolean primaryExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!primaryExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primaryExpr_1", c)) break;
    }
    return true;
  }

  // callExpr | sliceExpr
  private static boolean primaryExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpr_1_0")) return false;
    boolean r;
    r = callExpr(b, l + 1);
    if (!r) r = sliceExpr(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // lvalue
  //     | VL_INT
  //     | VL_BINARYNUM
  //     | ST_PAREN_L integerExpr ST_PAREN_R
  public static boolean primaryIntegerExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryIntegerExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_INTEGER_EXPR, "<primary integer expr>");
    r = lvalue(b, l + 1);
    if (!r) r = consumeToken(b, VL_INT);
    if (!r) r = consumeToken(b, VL_BINARYNUM);
    if (!r) r = primaryIntegerExpr_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ST_PAREN_L integerExpr ST_PAREN_R
  private static boolean primaryIntegerExpr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryIntegerExpr_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ST_PAREN_L);
    r = r && integerExpr(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CL_PRIMITIVE id ST_PAREN_L paramList? ST_PAREN_R
  //     ST_BRACE_L primitiveBody ST_BRACE_R
  public static boolean primitive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive")) return false;
    if (!nextTokenIs(b, CL_PRIMITIVE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CL_PRIMITIVE);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_L);
    r = r && primitive_3(b, l + 1);
    r = r && consumeTokens(b, 0, ST_PAREN_R, ST_BRACE_L);
    r = r && primitiveBody(b, l + 1);
    r = r && consumeToken(b, ST_BRACE_R);
    exit_section_(b, m, PRIMITIVE, r);
    return r;
  }

  // paramList?
  private static boolean primitive_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive_3")) return false;
    paramList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ((initializedField | methodSignature) PN_SEMI)*
  public static boolean primitiveBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitiveBody")) return false;
    Marker m = enter_section_(b, l, _NONE_, PRIMITIVE_BODY, "<primitive body>");
    while (true) {
      int c = current_position_(b);
      if (!primitiveBody_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primitiveBody", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // (initializedField | methodSignature) PN_SEMI
  private static boolean primitiveBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitiveBody_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primitiveBody_0_0(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // initializedField | methodSignature
  private static boolean primitiveBody_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitiveBody_0_0")) return false;
    boolean r;
    r = initializedField(b, l + 1);
    if (!r) r = methodSignature(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // &<<isPrimitiveFile>> primitiveProgram
  static boolean primitiveContent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitiveContent")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primitiveContent_0(b, l + 1);
    r = r && primitiveProgram(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &<<isPrimitiveFile>>
  private static boolean primitiveContent_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitiveContent_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = isPrimitiveFile(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // primitive
  public static boolean primitiveProgram(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitiveProgram")) return false;
    if (!nextTokenIs(b, CL_PRIMITIVE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primitive(b, l + 1);
    exit_section_(b, m, PRIMITIVE_PROGRAM, r);
    return r;
  }

  /* ********************************************************** */
  // LB_PROOF PN_COLON
  //     (LB_LET PN_COLON lets)?
  //     (LB_ASSUME PN_COLON assumptions)?
  //     LB_THEOREM PN_COLON theorem
  //     LB_GAMES PN_COLON gameList
  public static boolean proof(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proof")) return false;
    if (!nextTokenIs(b, LB_PROOF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LB_PROOF, PN_COLON);
    r = r && proof_2(b, l + 1);
    r = r && proof_3(b, l + 1);
    r = r && consumeTokens(b, 0, LB_THEOREM, PN_COLON);
    r = r && theorem(b, l + 1);
    r = r && consumeTokens(b, 0, LB_GAMES, PN_COLON);
    r = r && gameList(b, l + 1);
    exit_section_(b, m, PROOF, r);
    return r;
  }

  // (LB_LET PN_COLON lets)?
  private static boolean proof_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proof_2")) return false;
    proof_2_0(b, l + 1);
    return true;
  }

  // LB_LET PN_COLON lets
  private static boolean proof_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proof_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LB_LET, PN_COLON);
    r = r && lets(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LB_ASSUME PN_COLON assumptions)?
  private static boolean proof_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proof_3")) return false;
    proof_3_0(b, l + 1);
    return true;
  }

  // LB_ASSUME PN_COLON assumptions
  private static boolean proof_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proof_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LB_ASSUME, PN_COLON);
    r = r && assumptions(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // &<<isProofFile>> proofProgram
  static boolean proofContent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proofContent")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = proofContent_0(b, l + 1);
    r = r && proofProgram(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &<<isProofFile>>
  private static boolean proofContent_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proofContent_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = isProofFile(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (reduction | game)*
  public static boolean proofHelpers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proofHelpers")) return false;
    Marker m = enter_section_(b, l, _NONE_, PROOF_HELPERS, "<proof helpers>");
    while (true) {
      int c = current_position_(b);
      if (!proofHelpers_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "proofHelpers", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // reduction | game
  private static boolean proofHelpers_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proofHelpers_0")) return false;
    boolean r;
    r = reduction(b, l + 1);
    if (!r) r = game(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // moduleImport* proofHelpers proof
  public static boolean proofProgram(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proofProgram")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROOF_PROGRAM, "<proof program>");
    r = proofProgram_0(b, l + 1);
    r = r && proofHelpers(b, l + 1);
    r = r && proof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // moduleImport*
  private static boolean proofProgram_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proofProgram_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!moduleImport(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "proofProgram_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // CL_REDUCTION id ST_PAREN_L paramList? ST_PAREN_R
  //     KW_COMPOSE parameterizedGame KW_AGAINST gameAdversary
  //     ST_BRACE_L gameBody ST_BRACE_R
  public static boolean reduction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reduction")) return false;
    if (!nextTokenIs(b, CL_REDUCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CL_REDUCTION);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_L);
    r = r && reduction_3(b, l + 1);
    r = r && consumeTokens(b, 0, ST_PAREN_R, KW_COMPOSE);
    r = r && parameterizedGame(b, l + 1);
    r = r && consumeToken(b, KW_AGAINST);
    r = r && gameAdversary(b, l + 1);
    r = r && consumeToken(b, ST_BRACE_L);
    r = r && gameBody(b, l + 1);
    r = r && consumeToken(b, ST_BRACE_R);
    exit_section_(b, m, REDUCTION, r);
    return r;
  }

  // paramList?
  private static boolean reduction_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reduction_3")) return false;
    paramList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_RETURN expression PN_SEMI
  public static boolean returnStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnStmt")) return false;
    if (!nextTokenIs(b, KW_RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_RETURN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, RETURN_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // lvalue OP_SAMPLE expression PN_SEMI
  public static boolean sampleStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sampleStmt")) return false;
    if (!nextTokenIs(b, VL_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lvalue(b, l + 1);
    r = r && consumeToken(b, OP_SAMPLE);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, SAMPLE_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // CL_SCHEME id ST_PAREN_L paramList? ST_PAREN_R
  //     KW_EXTENDS id ST_BRACE_L schemeBody ST_BRACE_R
  public static boolean scheme(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scheme")) return false;
    if (!nextTokenIs(b, CL_SCHEME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CL_SCHEME);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_L);
    r = r && scheme_3(b, l + 1);
    r = r && consumeTokens(b, 0, ST_PAREN_R, KW_EXTENDS);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, ST_BRACE_L);
    r = r && schemeBody(b, l + 1);
    r = r && consumeToken(b, ST_BRACE_R);
    exit_section_(b, m, SCHEME, r);
    return r;
  }

  // paramList?
  private static boolean scheme_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scheme_3")) return false;
    paramList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (KW_REQUIRES expression PN_SEMI)*
  //     (field PN_SEMI | method)+
  public static boolean schemeBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeBody")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCHEME_BODY, "<scheme body>");
    r = schemeBody_0(b, l + 1);
    r = r && schemeBody_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (KW_REQUIRES expression PN_SEMI)*
  private static boolean schemeBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeBody_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!schemeBody_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "schemeBody_0", c)) break;
    }
    return true;
  }

  // KW_REQUIRES expression PN_SEMI
  private static boolean schemeBody_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeBody_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_REQUIRES);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // (field PN_SEMI | method)+
  private static boolean schemeBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeBody_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = schemeBody_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!schemeBody_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "schemeBody_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // field PN_SEMI | method
  private static boolean schemeBody_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeBody_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = schemeBody_1_0_0(b, l + 1);
    if (!r) r = method(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // field PN_SEMI
  private static boolean schemeBody_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeBody_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // &<<isSchemeFile>> schemeProgram
  static boolean schemeContent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeContent")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = schemeContent_0(b, l + 1);
    r = r && schemeProgram(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &<<isSchemeFile>>
  private static boolean schemeContent_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeContent_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = isSchemeFile(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // moduleImport* scheme
  public static boolean schemeProgram(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeProgram")) return false;
    if (!nextTokenIs(b, "<scheme program>", CL_SCHEME, KW_IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCHEME_PROGRAM, "<scheme program>");
    r = schemeProgram_0(b, l + 1);
    r = r && scheme(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // moduleImport*
  private static boolean schemeProgram_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeProgram_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!moduleImport(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "schemeProgram_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // unionExpr (OP_BSLASH unionExpr)*
  public static boolean setMinusExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setMinusExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SET_MINUS_EXPR, "<set minus expr>");
    r = unionExpr(b, l + 1);
    r = r && setMinusExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OP_BSLASH unionExpr)*
  private static boolean setMinusExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setMinusExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!setMinusExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "setMinusExpr_1", c)) break;
    }
    return true;
  }

  // OP_BSLASH unionExpr
  private static boolean setMinusExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setMinusExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_BSLASH);
    r = r && unionExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ST_BRACKET_L integerExpr PN_COLON integerExpr ST_BRACKET_R
  public static boolean sliceExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sliceExpr")) return false;
    if (!nextTokenIs(b, ST_BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ST_BRACKET_L);
    r = r && integerExpr(b, l + 1);
    r = r && consumeToken(b, PN_COLON);
    r = r && integerExpr(b, l + 1);
    r = r && consumeToken(b, ST_BRACKET_R);
    exit_section_(b, m, SLICE_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // varDeclStmt
  //     | varDeclAssignStmt
  //     | varDeclSampleStmt
  //     | assignStmt
  //     | sampleStmt
  //     | callStmt
  //     | returnStmt
  //     | conditionalStmt
  //     | integerLoopStmt
  //     | genericLoopStmt
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = varDeclStmt(b, l + 1);
    if (!r) r = varDeclAssignStmt(b, l + 1);
    if (!r) r = varDeclSampleStmt(b, l + 1);
    if (!r) r = assignStmt(b, l + 1);
    if (!r) r = sampleStmt(b, l + 1);
    if (!r) r = callStmt(b, l + 1);
    if (!r) r = returnStmt(b, l + 1);
    if (!r) r = conditionalStmt(b, l + 1);
    if (!r) r = integerLoopStmt(b, l + 1);
    if (!r) r = genericLoopStmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LB_ASSUME expression PN_SEMI
  public static boolean stepAssumption(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stepAssumption")) return false;
    if (!nextTokenIs(b, LB_ASSUME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LB_ASSUME);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, STEP_ASSUMPTION, r);
    return r;
  }

  /* ********************************************************** */
  // parameterizedGame PN_SEMI
  public static boolean theorem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "theorem")) return false;
    if (!nextTokenIs(b, VL_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameterizedGame(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, THEOREM, r);
    return r;
  }

  /* ********************************************************** */
  // typeProduct
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = typeProduct(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // atomicType OP_OPT*
  public static boolean typePostfix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typePostfix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_POSTFIX, "<type postfix>");
    r = atomicType(b, l + 1);
    r = r && typePostfix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_OPT*
  private static boolean typePostfix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typePostfix_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, OP_OPT)) break;
      if (!empty_element_parsed_guard_(b, "typePostfix_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // typePostfix (OP_MULT typePostfix)*
  public static boolean typeProduct(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeProduct")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_PRODUCT, "<type product>");
    r = typePostfix(b, l + 1);
    r = r && typeProduct_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OP_MULT typePostfix)*
  private static boolean typeProduct_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeProduct_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeProduct_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeProduct_1", c)) break;
    }
    return true;
  }

  // OP_MULT typePostfix
  private static boolean typeProduct_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeProduct_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_MULT);
    r = r && typePostfix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OP_NOT unaryExpr
  //     | OP_VBAR unaryExpr OP_VBAR
  //     | primaryExpr
  public static boolean unaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_EXPR, "<unary expr>");
    r = unaryExpr_0(b, l + 1);
    if (!r) r = unaryExpr_1(b, l + 1);
    if (!r) r = primaryExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_NOT unaryExpr
  private static boolean unaryExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_NOT);
    r = r && unaryExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_VBAR unaryExpr OP_VBAR
  private static boolean unaryExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_VBAR);
    r = r && unaryExpr(b, l + 1);
    r = r && consumeToken(b, OP_VBAR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // orExpr (KW_UNION orExpr)*
  public static boolean unionExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unionExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNION_EXPR, "<union expr>");
    r = orExpr(b, l + 1);
    r = r && unionExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (KW_UNION orExpr)*
  private static boolean unionExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unionExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unionExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unionExpr_1", c)) break;
    }
    return true;
  }

  // KW_UNION orExpr
  private static boolean unionExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unionExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_UNION);
    r = r && orExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type lvalue OP_ASSIGN expression PN_SEMI
  public static boolean varDeclAssignStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDeclAssignStmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_DECL_ASSIGN_STMT, "<var decl assign stmt>");
    r = type(b, l + 1);
    r = r && lvalue(b, l + 1);
    r = r && consumeToken(b, OP_ASSIGN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // type lvalue OP_SAMPLE expression PN_SEMI
  public static boolean varDeclSampleStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDeclSampleStmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_DECL_SAMPLE_STMT, "<var decl sample stmt>");
    r = type(b, l + 1);
    r = r && lvalue(b, l + 1);
    r = r && consumeToken(b, OP_SAMPLE);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // variable PN_SEMI
  public static boolean varDeclStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDeclStmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_DECL_STMT, "<var decl stmt>");
    r = variable(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // type id
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE, "<variable>");
    r = type(b, l + 1);
    r = r && id(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
