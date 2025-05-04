// This is a generated file. Not intended for manual editing.
package io.github.aabmets.prooffroglang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.github.aabmets.prooffroglang.psi.ProofFrogTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
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
  // multiplyExpression ( (OP_ADD | OP_SUB) multiplyExpression )*
  public static boolean addExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADD_EXPRESSION, "<add expression>");
    r = multiplyExpression(b, l + 1);
    r = r && addExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( (OP_ADD | OP_SUB) multiplyExpression )*
  private static boolean addExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!addExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "addExpression_1", c)) break;
    }
    return true;
  }

  // (OP_ADD | OP_SUB) multiplyExpression
  private static boolean addExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = addExpression_1_0_0(b, l + 1);
    r = r && multiplyExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_ADD | OP_SUB
  private static boolean addExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, OP_ADD);
    if (!r) r = consumeToken(b, OP_SUB);
    return r;
  }

  /* ********************************************************** */
  // multiplicativeIntegerExpression
  //     ( (OP_ADD | OP_SUB) multiplicativeIntegerExpression )*
  public static boolean additiveIntegerExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveIntegerExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADDITIVE_INTEGER_EXPRESSION, "<additive integer expression>");
    r = multiplicativeIntegerExpression(b, l + 1);
    r = r && additiveIntegerExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( (OP_ADD | OP_SUB) multiplicativeIntegerExpression )*
  private static boolean additiveIntegerExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveIntegerExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!additiveIntegerExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "additiveIntegerExpression_1", c)) break;
    }
    return true;
  }

  // (OP_ADD | OP_SUB) multiplicativeIntegerExpression
  private static boolean additiveIntegerExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveIntegerExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = additiveIntegerExpression_1_0_0(b, l + 1);
    r = r && multiplicativeIntegerExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_ADD | OP_SUB
  private static boolean additiveIntegerExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveIntegerExpression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, OP_ADD);
    if (!r) r = consumeToken(b, OP_SUB);
    return r;
  }

  /* ********************************************************** */
  // comparisonExpression (OP_AND comparisonExpression)*
  public static boolean andExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AND_EXPRESSION, "<and expression>");
    r = comparisonExpression(b, l + 1);
    r = r && andExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OP_AND comparisonExpression)*
  private static boolean andExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!andExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "andExpression_1", c)) break;
    }
    return true;
  }

  // OP_AND comparisonExpression
  private static boolean andExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_AND);
    r = r && comparisonExpression(b, l + 1);
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
  //     | DT_ARRAY OP_LT type PN_COMMA integerExpression OP_GT
  //     | DT_INT
  //     | DT_BITSTRING OP_LT integerExpression OP_GT
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

  // DT_ARRAY OP_LT type PN_COMMA integerExpression OP_GT
  private static boolean atomicType_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicType_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DT_ARRAY, OP_LT);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, PN_COMMA);
    r = r && integerExpression(b, l + 1);
    r = r && consumeToken(b, OP_GT);
    exit_section_(b, m, null, r);
    return r;
  }

  // DT_BITSTRING OP_LT integerExpression OP_GT
  private static boolean atomicType_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicType_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DT_BITSTRING, OP_LT);
    r = r && integerExpression(b, l + 1);
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
  public static boolean callExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callExpression")) return false;
    if (!nextTokenIs(b, ST_PAREN_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ST_PAREN_L);
    r = r && callExpression_1(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_R);
    exit_section_(b, m, CALL_EXPRESSION, r);
    return r;
  }

  // argList?
  private static boolean callExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callExpression_1")) return false;
    argList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // addExpression (
  //     (OP_EQ | OP_NEQ | OP_GT | OP_LT | OP_GEQ | OP_LEQ | KW_IN | KW_SUBSETS)
  //     addExpression
  // )?
  public static boolean comparisonExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparisonExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARISON_EXPRESSION, "<comparison expression>");
    r = addExpression(b, l + 1);
    r = r && comparisonExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (
  //     (OP_EQ | OP_NEQ | OP_GT | OP_LT | OP_GEQ | OP_LEQ | KW_IN | KW_SUBSETS)
  //     addExpression
  // )?
  private static boolean comparisonExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparisonExpression_1")) return false;
    comparisonExpression_1_0(b, l + 1);
    return true;
  }

  // (OP_EQ | OP_NEQ | OP_GT | OP_LT | OP_GEQ | OP_LEQ | KW_IN | KW_SUBSETS)
  //     addExpression
  private static boolean comparisonExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparisonExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comparisonExpression_1_0_0(b, l + 1);
    r = r && addExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_EQ | OP_NEQ | OP_GT | OP_LT | OP_GEQ | OP_LEQ | KW_IN | KW_SUBSETS
  private static boolean comparisonExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparisonExpression_1_0_0")) return false;
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
  // parameterizedGame PN_PERIOD VL_IDENT
  public static boolean concreteGame(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concreteGame")) return false;
    if (!nextTokenIs(b, VL_IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameterizedGame(b, l + 1);
    r = r && consumeTokens(b, 0, PN_PERIOD, VL_IDENT);
    exit_section_(b, m, CONCRETE_GAME, r);
    return r;
  }

  /* ********************************************************** */
  // setMinusExpression
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = setMinusExpression(b, l + 1);
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
  // primitiveProgram |
  //     schemeProgram |
  //     gameProgram |
  //     proofProgram |
  //     VL_LINE_COMMENT
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    boolean r;
    r = primitiveProgram(b, l + 1);
    if (!r) r = schemeProgram(b, l + 1);
    if (!r) r = gameProgram(b, l + 1);
    if (!r) r = proofProgram(b, l + 1);
    if (!r) r = consumeToken(b, VL_LINE_COMMENT);
    return r;
  }

  /* ********************************************************** */
  // CL_GAME VL_IDENT ST_PAREN_L paramList? ST_PAREN_R ST_BRACE_L gameBody ST_BRACE_R
  public static boolean game(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "game")) return false;
    if (!nextTokenIs(b, CL_GAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CL_GAME, VL_IDENT, ST_PAREN_L);
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
    if (!nextTokenIs(b, VL_IDENT)) return false;
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
  // KW_EXPORT KW_AS VL_IDENT PN_SEMI
  public static boolean gameExport(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameExport")) return false;
    if (!nextTokenIs(b, KW_EXPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_EXPORT, KW_AS, VL_IDENT, PN_SEMI);
    exit_section_(b, m, GAME_EXPORT, r);
    return r;
  }

  /* ********************************************************** */
  // gameStep PN_SEMI (gameStep PN_SEMI | induction | stepAssumption)*
  public static boolean gameList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameList")) return false;
    if (!nextTokenIs(b, VL_IDENT)) return false;
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
  //     ST_BRACKET_L id (PN_COMMA id)* ST_BRACKET_R PN_SEMI ST_BRACE_R
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
    if (!nextTokenIs(b, VL_IDENT)) return false;
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
  // VL_IDENT | KW_IN
  public static boolean id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id")) return false;
    if (!nextTokenIs(b, "<id>", KW_IN, VL_IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ID, "<id>");
    r = consumeToken(b, VL_IDENT);
    if (!r) r = consumeToken(b, KW_IN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_INDUCTION ST_PAREN_L VL_IDENT KW_FROM integerExpression KW_TO
  //     integerExpression ST_PAREN_R ST_BRACE_L gameList ST_BRACE_R
  public static boolean induction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "induction")) return false;
    if (!nextTokenIs(b, KW_INDUCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_INDUCTION, ST_PAREN_L, VL_IDENT, KW_FROM);
    r = r && integerExpression(b, l + 1);
    r = r && consumeToken(b, KW_TO);
    r = r && integerExpression(b, l + 1);
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
  // additiveIntegerExpression
  public static boolean integerExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integerExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTEGER_EXPRESSION, "<integer expression>");
    r = additiveIntegerExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
    if (!nextTokenIs(b, "<lvalue>", KW_IN, VL_IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LVALUE, "<lvalue>");
    r = lvalue_0(b, l + 1);
    r = r && lvalue_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // KW_IMPORT VL_FILESTRING (KW_AS VL_IDENT)? PN_SEMI
  public static boolean moduleImport(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleImport")) return false;
    if (!nextTokenIs(b, KW_IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_IMPORT, VL_FILESTRING);
    r = r && moduleImport_2(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, MODULE_IMPORT, r);
    return r;
  }

  // (KW_AS VL_IDENT)?
  private static boolean moduleImport_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleImport_2")) return false;
    moduleImport_2_0(b, l + 1);
    return true;
  }

  // KW_AS VL_IDENT
  private static boolean moduleImport_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleImport_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_AS, VL_IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // primaryIntegerExpression
  //     ( (OP_MULT | OP_DIV) primaryIntegerExpression )*
  public static boolean multiplicativeIntegerExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeIntegerExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLICATIVE_INTEGER_EXPRESSION, "<multiplicative integer expression>");
    r = primaryIntegerExpression(b, l + 1);
    r = r && multiplicativeIntegerExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( (OP_MULT | OP_DIV) primaryIntegerExpression )*
  private static boolean multiplicativeIntegerExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeIntegerExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiplicativeIntegerExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplicativeIntegerExpression_1", c)) break;
    }
    return true;
  }

  // (OP_MULT | OP_DIV) primaryIntegerExpression
  private static boolean multiplicativeIntegerExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeIntegerExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplicativeIntegerExpression_1_0_0(b, l + 1);
    r = r && primaryIntegerExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_MULT | OP_DIV
  private static boolean multiplicativeIntegerExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeIntegerExpression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, OP_MULT);
    if (!r) r = consumeToken(b, OP_DIV);
    return r;
  }

  /* ********************************************************** */
  // unaryExpression ( (OP_MULT | OP_DIV) unaryExpression )*
  public static boolean multiplyExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLY_EXPRESSION, "<multiply expression>");
    r = unaryExpression(b, l + 1);
    r = r && multiplyExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( (OP_MULT | OP_DIV) unaryExpression )*
  private static boolean multiplyExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiplyExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplyExpression_1", c)) break;
    }
    return true;
  }

  // (OP_MULT | OP_DIV) unaryExpression
  private static boolean multiplyExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplyExpression_1_0_0(b, l + 1);
    r = r && unaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_MULT | OP_DIV
  private static boolean multiplyExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyExpression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, OP_MULT);
    if (!r) r = consumeToken(b, OP_DIV);
    return r;
  }

  /* ********************************************************** */
  // andExpression (OP_OR andExpression)*
  public static boolean orExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OR_EXPRESSION, "<or expression>");
    r = andExpression(b, l + 1);
    r = r && orExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OP_OR andExpression)*
  private static boolean orExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!orExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "orExpression_1", c)) break;
    }
    return true;
  }

  // OP_OR andExpression
  private static boolean orExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_OR);
    r = r && andExpression(b, l + 1);
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
  // VL_IDENT ST_PAREN_L argList? ST_PAREN_R
  public static boolean parameterizedGame(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterizedGame")) return false;
    if (!nextTokenIs(b, VL_IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VL_IDENT, ST_PAREN_L);
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
  public static boolean primaryElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_ELEMENT, "<primary element>");
    r = lvalue(b, l + 1);
    if (!r) r = primaryElement_1(b, l + 1);
    if (!r) r = primaryElement_2(b, l + 1);
    if (!r) r = type(b, l + 1);
    if (!r) r = consumeToken(b, VL_BINARYNUM);
    if (!r) r = consumeToken(b, DT_INT);
    if (!r) r = consumeToken(b, VL_BOOL);
    if (!r) r = consumeToken(b, KW_NONE);
    if (!r) r = primaryElement_8(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ST_BRACKET_L (expression (PN_COMMA expression)*)? ST_BRACKET_R
  private static boolean primaryElement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ST_BRACKET_L);
    r = r && primaryElement_1_1(b, l + 1);
    r = r && consumeToken(b, ST_BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (expression (PN_COMMA expression)*)?
  private static boolean primaryElement_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_1_1")) return false;
    primaryElement_1_1_0(b, l + 1);
    return true;
  }

  // expression (PN_COMMA expression)*
  private static boolean primaryElement_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && primaryElement_1_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (PN_COMMA expression)*
  private static boolean primaryElement_1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_1_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!primaryElement_1_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primaryElement_1_1_0_1", c)) break;
    }
    return true;
  }

  // PN_COMMA expression
  private static boolean primaryElement_1_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_1_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PN_COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ST_BRACE_L  (expression (PN_COMMA expression)*)? ST_BRACE_R
  private static boolean primaryElement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ST_BRACE_L);
    r = r && primaryElement_2_1(b, l + 1);
    r = r && consumeToken(b, ST_BRACE_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (expression (PN_COMMA expression)*)?
  private static boolean primaryElement_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_2_1")) return false;
    primaryElement_2_1_0(b, l + 1);
    return true;
  }

  // expression (PN_COMMA expression)*
  private static boolean primaryElement_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && primaryElement_2_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (PN_COMMA expression)*
  private static boolean primaryElement_2_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_2_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!primaryElement_2_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primaryElement_2_1_0_1", c)) break;
    }
    return true;
  }

  // PN_COMMA expression
  private static boolean primaryElement_2_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_2_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PN_COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ST_PAREN_L expression ST_PAREN_R
  private static boolean primaryElement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ST_PAREN_L);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // primaryElement (callExpression | sliceExpression)*
  public static boolean primaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_EXPRESSION, "<primary expression>");
    r = primaryElement(b, l + 1);
    r = r && primaryExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (callExpression | sliceExpression)*
  private static boolean primaryExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!primaryExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primaryExpression_1", c)) break;
    }
    return true;
  }

  // callExpression | sliceExpression
  private static boolean primaryExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpression_1_0")) return false;
    boolean r;
    r = callExpression(b, l + 1);
    if (!r) r = sliceExpression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // lvalue
  //     | VL_INT
  //     | VL_BINARYNUM
  //     | ST_PAREN_L integerExpression ST_PAREN_R
  public static boolean primaryIntegerExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryIntegerExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_INTEGER_EXPRESSION, "<primary integer expression>");
    r = lvalue(b, l + 1);
    if (!r) r = consumeToken(b, VL_INT);
    if (!r) r = consumeToken(b, VL_BINARYNUM);
    if (!r) r = primaryIntegerExpression_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ST_PAREN_L integerExpression ST_PAREN_R
  private static boolean primaryIntegerExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryIntegerExpression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ST_PAREN_L);
    r = r && integerExpression(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_R);
    exit_section_(b, m, null, r);
    return r;
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
  // CL_PRIMITIVE VL_IDENT ST_PAREN_L paramList? ST_PAREN_R
  //     ST_BRACE_L primitiveBody ST_BRACE_R
  public static boolean primitiveProgram(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitiveProgram")) return false;
    if (!nextTokenIs(b, CL_PRIMITIVE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CL_PRIMITIVE, VL_IDENT, ST_PAREN_L);
    r = r && primitiveProgram_3(b, l + 1);
    r = r && consumeTokens(b, 0, ST_PAREN_R, ST_BRACE_L);
    r = r && primitiveBody(b, l + 1);
    r = r && consumeToken(b, ST_BRACE_R);
    exit_section_(b, m, PRIMITIVE_PROGRAM, r);
    return r;
  }

  // paramList?
  private static boolean primitiveProgram_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitiveProgram_3")) return false;
    paramList(b, l + 1);
    return true;
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
  // CL_REDUCTION VL_IDENT ST_PAREN_L paramList? ST_PAREN_R
  //     KW_COMPOSE parameterizedGame KW_AGAINST gameAdversary
  //     ST_BRACE_L gameBody ST_BRACE_R
  public static boolean reduction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reduction")) return false;
    if (!nextTokenIs(b, CL_REDUCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CL_REDUCTION, VL_IDENT, ST_PAREN_L);
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
  // CL_SCHEME VL_IDENT ST_PAREN_L paramList? ST_PAREN_R
  //     KW_EXTENDS VL_IDENT ST_BRACE_L schemeBody ST_BRACE_R
  public static boolean scheme(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scheme")) return false;
    if (!nextTokenIs(b, CL_SCHEME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CL_SCHEME, VL_IDENT, ST_PAREN_L);
    r = r && scheme_3(b, l + 1);
    r = r && consumeTokens(b, 0, ST_PAREN_R, KW_EXTENDS, VL_IDENT, ST_BRACE_L);
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
  // unionExpression (OP_BSLASH unionExpression)*
  public static boolean setMinusExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setMinusExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SET_MINUS_EXPRESSION, "<set minus expression>");
    r = unionExpression(b, l + 1);
    r = r && setMinusExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OP_BSLASH unionExpression)*
  private static boolean setMinusExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setMinusExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!setMinusExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "setMinusExpression_1", c)) break;
    }
    return true;
  }

  // OP_BSLASH unionExpression
  private static boolean setMinusExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setMinusExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_BSLASH);
    r = r && unionExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ST_BRACKET_L integerExpression PN_COLON integerExpression ST_BRACKET_R
  public static boolean sliceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sliceExpression")) return false;
    if (!nextTokenIs(b, ST_BRACKET_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ST_BRACKET_L);
    r = r && integerExpression(b, l + 1);
    r = r && consumeToken(b, PN_COLON);
    r = r && integerExpression(b, l + 1);
    r = r && consumeToken(b, ST_BRACKET_R);
    exit_section_(b, m, SLICE_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // type id PN_SEMI                                             // varDeclStatement
  // 	| type lvalue OP_ASSIGN expression PN_SEMI                       // varDeclWithValueStatement
  // 	| type lvalue OP_SAMPLE expression PN_SEMI                       // varDeclWithSampleStatement
  // 	| lvalue OP_ASSIGN expression PN_SEMI                            // assignmentStatement
  // 	| lvalue OP_SAMPLE expression PN_SEMI                            // sampleStatement
  // 	| expression ST_PAREN_L argList? ST_PAREN_R PN_SEMI             // functionCallStatement
  // 	| KW_RETURN expression PN_SEMI                                 // returnStatement
  // 	| KW_IF ST_PAREN_L expression ST_PAREN_R block (KW_ELSE KW_IF ST_PAREN_L expression ST_PAREN_R block )* (KW_ELSE block )?  // ifStatement
  // 	| KW_FOR ST_PAREN_L DT_INT id OP_ASSIGN expression KW_TO expression ST_PAREN_R block  // numericForStatement
  // 	| KW_FOR ST_PAREN_L type id KW_IN expression ST_PAREN_R block
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = statement_0(b, l + 1);
    if (!r) r = statement_1(b, l + 1);
    if (!r) r = statement_2(b, l + 1);
    if (!r) r = statement_3(b, l + 1);
    if (!r) r = statement_4(b, l + 1);
    if (!r) r = statement_5(b, l + 1);
    if (!r) r = statement_6(b, l + 1);
    if (!r) r = statement_7(b, l + 1);
    if (!r) r = statement_8(b, l + 1);
    if (!r) r = statement_9(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type id PN_SEMI
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // type lvalue OP_ASSIGN expression PN_SEMI
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && lvalue(b, l + 1);
    r = r && consumeToken(b, OP_ASSIGN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // type lvalue OP_SAMPLE expression PN_SEMI
  private static boolean statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && lvalue(b, l + 1);
    r = r && consumeToken(b, OP_SAMPLE);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // lvalue OP_ASSIGN expression PN_SEMI
  private static boolean statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lvalue(b, l + 1);
    r = r && consumeToken(b, OP_ASSIGN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // lvalue OP_SAMPLE expression PN_SEMI
  private static boolean statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lvalue(b, l + 1);
    r = r && consumeToken(b, OP_SAMPLE);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression ST_PAREN_L argList? ST_PAREN_R PN_SEMI
  private static boolean statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_L);
    r = r && statement_5_2(b, l + 1);
    r = r && consumeTokens(b, 0, ST_PAREN_R, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // argList?
  private static boolean statement_5_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_5_2")) return false;
    argList(b, l + 1);
    return true;
  }

  // KW_RETURN expression PN_SEMI
  private static boolean statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_RETURN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PN_SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_IF ST_PAREN_L expression ST_PAREN_R block (KW_ELSE KW_IF ST_PAREN_L expression ST_PAREN_R block )* (KW_ELSE block )?
  private static boolean statement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_IF, ST_PAREN_L);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_R);
    r = r && block(b, l + 1);
    r = r && statement_7_5(b, l + 1);
    r = r && statement_7_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KW_ELSE KW_IF ST_PAREN_L expression ST_PAREN_R block )*
  private static boolean statement_7_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_7_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement_7_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement_7_5", c)) break;
    }
    return true;
  }

  // KW_ELSE KW_IF ST_PAREN_L expression ST_PAREN_R block
  private static boolean statement_7_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_7_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_ELSE, KW_IF, ST_PAREN_L);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_R);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KW_ELSE block )?
  private static boolean statement_7_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_7_6")) return false;
    statement_7_6_0(b, l + 1);
    return true;
  }

  // KW_ELSE block
  private static boolean statement_7_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_7_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_ELSE);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_FOR ST_PAREN_L DT_INT id OP_ASSIGN expression KW_TO expression ST_PAREN_R block
  private static boolean statement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_8")) return false;
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
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_FOR ST_PAREN_L type id KW_IN expression ST_PAREN_R block
  private static boolean statement_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_FOR, ST_PAREN_L);
    r = r && type(b, l + 1);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, KW_IN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, ST_PAREN_R);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
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
    if (!nextTokenIs(b, VL_IDENT)) return false;
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
  // OP_NOT unaryExpression
  //     | OP_VBAR unaryExpression OP_VBAR
  //     | primaryExpression
  public static boolean unaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_EXPRESSION, "<unary expression>");
    r = unaryExpression_0(b, l + 1);
    if (!r) r = unaryExpression_1(b, l + 1);
    if (!r) r = primaryExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_NOT unaryExpression
  private static boolean unaryExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_NOT);
    r = r && unaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_VBAR unaryExpression OP_VBAR
  private static boolean unaryExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_VBAR);
    r = r && unaryExpression(b, l + 1);
    r = r && consumeToken(b, OP_VBAR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // orExpression (KW_UNION orExpression)*
  public static boolean unionExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unionExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNION_EXPRESSION, "<union expression>");
    r = orExpression(b, l + 1);
    r = r && unionExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (KW_UNION orExpression)*
  private static boolean unionExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unionExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unionExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unionExpression_1", c)) break;
    }
    return true;
  }

  // KW_UNION orExpression
  private static boolean unionExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unionExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_UNION);
    r = r && orExpression(b, l + 1);
    exit_section_(b, m, null, r);
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
