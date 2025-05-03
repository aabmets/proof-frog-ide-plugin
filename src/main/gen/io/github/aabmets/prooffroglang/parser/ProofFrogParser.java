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
  // multiplyExpression ( (O_ADD | O_SUB) multiplyExpression )*
  public static boolean addExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADD_EXPRESSION, "<add expression>");
    r = multiplyExpression(b, l + 1);
    r = r && addExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( (O_ADD | O_SUB) multiplyExpression )*
  private static boolean addExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!addExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "addExpression_1", c)) break;
    }
    return true;
  }

  // (O_ADD | O_SUB) multiplyExpression
  private static boolean addExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = addExpression_1_0_0(b, l + 1);
    r = r && multiplyExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // O_ADD | O_SUB
  private static boolean addExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addExpression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, O_ADD);
    if (!r) r = consumeToken(b, O_SUB);
    return r;
  }

  /* ********************************************************** */
  // multiplicativeIntegerExpression
  //     ( (O_ADD | O_SUB) multiplicativeIntegerExpression )*
  public static boolean additiveIntegerExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveIntegerExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADDITIVE_INTEGER_EXPRESSION, "<additive integer expression>");
    r = multiplicativeIntegerExpression(b, l + 1);
    r = r && additiveIntegerExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( (O_ADD | O_SUB) multiplicativeIntegerExpression )*
  private static boolean additiveIntegerExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveIntegerExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!additiveIntegerExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "additiveIntegerExpression_1", c)) break;
    }
    return true;
  }

  // (O_ADD | O_SUB) multiplicativeIntegerExpression
  private static boolean additiveIntegerExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveIntegerExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = additiveIntegerExpression_1_0_0(b, l + 1);
    r = r && multiplicativeIntegerExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // O_ADD | O_SUB
  private static boolean additiveIntegerExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveIntegerExpression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, O_ADD);
    if (!r) r = consumeToken(b, O_SUB);
    return r;
  }

  /* ********************************************************** */
  // comparisonExpression (O_AND comparisonExpression)*
  public static boolean andExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AND_EXPRESSION, "<and expression>");
    r = comparisonExpression(b, l + 1);
    r = r && andExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (O_AND comparisonExpression)*
  private static boolean andExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!andExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "andExpression_1", c)) break;
    }
    return true;
  }

  // O_AND comparisonExpression
  private static boolean andExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, O_AND);
    r = r && comparisonExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression (P_COMMA expression)*
  public static boolean argList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARG_LIST, "<arg list>");
    r = expression(b, l + 1);
    r = r && argList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (P_COMMA expression)*
  private static boolean argList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argList_1", c)) break;
    }
    return true;
  }

  // P_COMMA expression
  private static boolean argList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, P_COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (parameterizedGame P_SEMIC)* (K_CALLS (O_LEQ | O_LT) expression P_SEMIC)?
  public static boolean assumptions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assumptions")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSUMPTIONS, "<assumptions>");
    r = assumptions_0(b, l + 1);
    r = r && assumptions_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (parameterizedGame P_SEMIC)*
  private static boolean assumptions_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assumptions_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!assumptions_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "assumptions_0", c)) break;
    }
    return true;
  }

  // parameterizedGame P_SEMIC
  private static boolean assumptions_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assumptions_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameterizedGame(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
    exit_section_(b, m, null, r);
    return r;
  }

  // (K_CALLS (O_LEQ | O_LT) expression P_SEMIC)?
  private static boolean assumptions_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assumptions_1")) return false;
    assumptions_1_0(b, l + 1);
    return true;
  }

  // K_CALLS (O_LEQ | O_LT) expression P_SEMIC
  private static boolean assumptions_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assumptions_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_CALLS);
    r = r && assumptions_1_0_1(b, l + 1);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
    exit_section_(b, m, null, r);
    return r;
  }

  // O_LEQ | O_LT
  private static boolean assumptions_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assumptions_1_0_1")) return false;
    boolean r;
    r = consumeToken(b, O_LEQ);
    if (!r) r = consumeToken(b, O_LT);
    return r;
  }

  /* ********************************************************** */
  // T_SET O_LT type O_GT
  //     | T_SET
  //     | T_BOOL
  //     | T_VOID
  //     | T_MAP O_LT type P_COMMA type O_GT
  //     | T_ARRAY O_LT type P_COMMA integerExpression O_GT
  //     | T_INT
  //     | T_BITSTRING O_LT integerExpression O_GT
  //     | T_BITSTRING
  //     | lvalue
  public static boolean atomicType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOMIC_TYPE, "<atomic type>");
    r = atomicType_0(b, l + 1);
    if (!r) r = consumeToken(b, T_SET);
    if (!r) r = consumeToken(b, T_BOOL);
    if (!r) r = consumeToken(b, T_VOID);
    if (!r) r = atomicType_4(b, l + 1);
    if (!r) r = atomicType_5(b, l + 1);
    if (!r) r = consumeToken(b, T_INT);
    if (!r) r = atomicType_7(b, l + 1);
    if (!r) r = consumeToken(b, T_BITSTRING);
    if (!r) r = lvalue(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // T_SET O_LT type O_GT
  private static boolean atomicType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicType_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_SET, O_LT);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, O_GT);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_MAP O_LT type P_COMMA type O_GT
  private static boolean atomicType_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicType_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_MAP, O_LT);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, P_COMMA);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, O_GT);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_ARRAY O_LT type P_COMMA integerExpression O_GT
  private static boolean atomicType_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicType_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_ARRAY, O_LT);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, P_COMMA);
    r = r && integerExpression(b, l + 1);
    r = r && consumeToken(b, O_GT);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_BITSTRING O_LT integerExpression O_GT
  private static boolean atomicType_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicType_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_BITSTRING, O_LT);
    r = r && integerExpression(b, l + 1);
    r = r && consumeToken(b, O_GT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // S_BRACE_L statement* S_BRACE_R
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, S_BRACE_L)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, S_BRACE_L);
    r = r && block_1(b, l + 1);
    r = r && consumeToken(b, S_BRACE_R);
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
  // addExpression (
  //     (O_EQ | O_NEQ | O_GT | O_LT | O_GEQ | O_LEQ | K_IN | K_SUBSETS)
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
  //     (O_EQ | O_NEQ | O_GT | O_LT | O_GEQ | O_LEQ | K_IN | K_SUBSETS)
  //     addExpression
  // )?
  private static boolean comparisonExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparisonExpression_1")) return false;
    comparisonExpression_1_0(b, l + 1);
    return true;
  }

  // (O_EQ | O_NEQ | O_GT | O_LT | O_GEQ | O_LEQ | K_IN | K_SUBSETS)
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

  // O_EQ | O_NEQ | O_GT | O_LT | O_GEQ | O_LEQ | K_IN | K_SUBSETS
  private static boolean comparisonExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparisonExpression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, O_EQ);
    if (!r) r = consumeToken(b, O_NEQ);
    if (!r) r = consumeToken(b, O_GT);
    if (!r) r = consumeToken(b, O_LT);
    if (!r) r = consumeToken(b, O_GEQ);
    if (!r) r = consumeToken(b, O_LEQ);
    if (!r) r = consumeToken(b, K_IN);
    if (!r) r = consumeToken(b, K_SUBSETS);
    return r;
  }

  /* ********************************************************** */
  // parameterizedGame P_PERIOD V_IDENT
  public static boolean concreteGame(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concreteGame")) return false;
    if (!nextTokenIs(b, V_IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameterizedGame(b, l + 1);
    r = r && consumeTokens(b, 0, P_PERIOD, V_IDENT);
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
  // variable (O_ASGN expression)?
  public static boolean field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD, "<field>");
    r = variable(b, l + 1);
    r = r && field_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (O_ASGN expression)?
  private static boolean field_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_1")) return false;
    field_1_0(b, l + 1);
    return true;
  }

  // O_ASGN expression
  private static boolean field_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, O_ASGN);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // primitiveProgram |
  //     schemeProgram |
  //     gameProgram |
  //     proofProgram |
  //     V_LINE_COMMENT
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    boolean r;
    r = primitiveProgram(b, l + 1);
    if (!r) r = schemeProgram(b, l + 1);
    if (!r) r = gameProgram(b, l + 1);
    if (!r) r = proofProgram(b, l + 1);
    if (!r) r = consumeToken(b, V_LINE_COMMENT);
    return r;
  }

  /* ********************************************************** */
  // F_GAME V_IDENT S_PAREN_L paramList? S_PAREN_R S_BRACE_L gameBody S_BRACE_R
  public static boolean game(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "game")) return false;
    if (!nextTokenIs(b, F_GAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, F_GAME, V_IDENT, S_PAREN_L);
    r = r && game_3(b, l + 1);
    r = r && consumeTokens(b, 0, S_PAREN_R, S_BRACE_L);
    r = r && gameBody(b, l + 1);
    r = r && consumeToken(b, S_BRACE_R);
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
  // parameterizedGame P_PERIOD F_ADVERSARY
  public static boolean gameAdversary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameAdversary")) return false;
    if (!nextTokenIs(b, V_IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameterizedGame(b, l + 1);
    r = r && consumeTokens(b, 0, P_PERIOD, F_ADVERSARY);
    exit_section_(b, m, GAME_ADVERSARY, r);
    return r;
  }

  /* ********************************************************** */
  // (field P_SEMIC)* method+ |
  //     (field P_SEMIC)* method* gamePhase+
  public static boolean gameBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GAME_BODY, "<game body>");
    r = gameBody_0(b, l + 1);
    if (!r) r = gameBody_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (field P_SEMIC)* method+
  private static boolean gameBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gameBody_0_0(b, l + 1);
    r = r && gameBody_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (field P_SEMIC)*
  private static boolean gameBody_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!gameBody_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gameBody_0_0", c)) break;
    }
    return true;
  }

  // field P_SEMIC
  private static boolean gameBody_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
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

  // (field P_SEMIC)* method* gamePhase+
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

  // (field P_SEMIC)*
  private static boolean gameBody_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!gameBody_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gameBody_1_0", c)) break;
    }
    return true;
  }

  // field P_SEMIC
  private static boolean gameBody_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameBody_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
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
  // K_EXPORT K_AS V_IDENT P_SEMIC
  public static boolean gameExport(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameExport")) return false;
    if (!nextTokenIs(b, K_EXPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_EXPORT, K_AS, V_IDENT, P_SEMIC);
    exit_section_(b, m, GAME_EXPORT, r);
    return r;
  }

  /* ********************************************************** */
  // gameStep P_SEMIC (gameStep P_SEMIC | induction | stepAssumption)*
  public static boolean gameList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameList")) return false;
    if (!nextTokenIs(b, V_IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gameStep(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
    r = r && gameList_2(b, l + 1);
    exit_section_(b, m, GAME_LIST, r);
    return r;
  }

  // (gameStep P_SEMIC | induction | stepAssumption)*
  private static boolean gameList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameList_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!gameList_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gameList_2", c)) break;
    }
    return true;
  }

  // gameStep P_SEMIC | induction | stepAssumption
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

  // gameStep P_SEMIC
  private static boolean gameList_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameList_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gameStep(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // F_PHASE S_BRACE_L (method)+ K_ORACLES P_COLON
  //     S_BRACKET_L id (P_COMMA id)* S_BRACKET_R P_SEMIC S_BRACE_R
  public static boolean gamePhase(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gamePhase")) return false;
    if (!nextTokenIs(b, F_PHASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, F_PHASE, S_BRACE_L);
    r = r && gamePhase_2(b, l + 1);
    r = r && consumeTokens(b, 0, K_ORACLES, P_COLON, S_BRACKET_L);
    r = r && id(b, l + 1);
    r = r && gamePhase_7(b, l + 1);
    r = r && consumeTokens(b, 0, S_BRACKET_R, P_SEMIC, S_BRACE_R);
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

  // (P_COMMA id)*
  private static boolean gamePhase_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gamePhase_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!gamePhase_7_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "gamePhase_7", c)) break;
    }
    return true;
  }

  // P_COMMA id
  private static boolean gamePhase_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gamePhase_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, P_COMMA);
    r = r && id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // moduleImport* game game gameExport
  public static boolean gameProgram(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameProgram")) return false;
    if (!nextTokenIs(b, "<game program>", F_GAME, K_IMPORT)) return false;
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
  // concreteGame K_COMPOSE parameterizedGame K_AGAINST gameAdversary |  // reductionStep
  // 	(concreteGame | parameterizedGame) K_AGAINST gameAdversary
  public static boolean gameStep(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameStep")) return false;
    if (!nextTokenIs(b, V_IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gameStep_0(b, l + 1);
    if (!r) r = gameStep_1(b, l + 1);
    exit_section_(b, m, GAME_STEP, r);
    return r;
  }

  // concreteGame K_COMPOSE parameterizedGame K_AGAINST gameAdversary
  private static boolean gameStep_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameStep_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = concreteGame(b, l + 1);
    r = r && consumeToken(b, K_COMPOSE);
    r = r && parameterizedGame(b, l + 1);
    r = r && consumeToken(b, K_AGAINST);
    r = r && gameAdversary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (concreteGame | parameterizedGame) K_AGAINST gameAdversary
  private static boolean gameStep_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gameStep_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = gameStep_1_0(b, l + 1);
    r = r && consumeToken(b, K_AGAINST);
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
  // V_IDENT | K_IN
  public static boolean id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id")) return false;
    if (!nextTokenIs(b, "<id>", K_IN, V_IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ID, "<id>");
    r = consumeToken(b, V_IDENT);
    if (!r) r = consumeToken(b, K_IN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // K_INDUCTION S_PAREN_L V_IDENT K_FROM integerExpression K_TO
  //     integerExpression S_PAREN_R S_BRACE_L gameList S_BRACE_R
  public static boolean induction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "induction")) return false;
    if (!nextTokenIs(b, K_INDUCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_INDUCTION, S_PAREN_L, V_IDENT, K_FROM);
    r = r && integerExpression(b, l + 1);
    r = r && consumeToken(b, K_TO);
    r = r && integerExpression(b, l + 1);
    r = r && consumeTokens(b, 0, S_PAREN_R, S_BRACE_L);
    r = r && gameList(b, l + 1);
    r = r && consumeToken(b, S_BRACE_R);
    exit_section_(b, m, INDUCTION, r);
    return r;
  }

  /* ********************************************************** */
  // variable O_ASGN expression
  public static boolean initializedField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "initializedField")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INITIALIZED_FIELD, "<initialized field>");
    r = variable(b, l + 1);
    r = r && consumeToken(b, O_ASGN);
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
  // (field P_SEMIC)*
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

  // field P_SEMIC
  private static boolean lets_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lets_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (id | parameterizedGame) (P_PERIOD id | S_BRACKET_L expression S_BRACKET_R)*
  public static boolean lvalue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue")) return false;
    if (!nextTokenIs(b, "<lvalue>", K_IN, V_IDENT)) return false;
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

  // (P_PERIOD id | S_BRACKET_L expression S_BRACKET_R)*
  private static boolean lvalue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!lvalue_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lvalue_1", c)) break;
    }
    return true;
  }

  // P_PERIOD id | S_BRACKET_L expression S_BRACKET_R
  private static boolean lvalue_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lvalue_1_0_0(b, l + 1);
    if (!r) r = lvalue_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // P_PERIOD id
  private static boolean lvalue_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, P_PERIOD);
    r = r && id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // S_BRACKET_L expression S_BRACKET_R
  private static boolean lvalue_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, S_BRACKET_L);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, S_BRACKET_R);
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
  // type id S_PAREN_L paramList? S_PAREN_R
  public static boolean methodSignature(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodSignature")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_SIGNATURE, "<method signature>");
    r = type(b, l + 1);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, S_PAREN_L);
    r = r && methodSignature_3(b, l + 1);
    r = r && consumeToken(b, S_PAREN_R);
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
  // K_IMPORT V_FILESTRING (K_AS V_IDENT)? P_SEMIC
  public static boolean moduleImport(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleImport")) return false;
    if (!nextTokenIs(b, K_IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_IMPORT, V_FILESTRING);
    r = r && moduleImport_2(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
    exit_section_(b, m, MODULE_IMPORT, r);
    return r;
  }

  // (K_AS V_IDENT)?
  private static boolean moduleImport_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleImport_2")) return false;
    moduleImport_2_0(b, l + 1);
    return true;
  }

  // K_AS V_IDENT
  private static boolean moduleImport_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleImport_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_AS, V_IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // primaryIntegerExpression
  //     ( (O_MULT | O_DIV) primaryIntegerExpression )*
  public static boolean multiplicativeIntegerExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeIntegerExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLICATIVE_INTEGER_EXPRESSION, "<multiplicative integer expression>");
    r = primaryIntegerExpression(b, l + 1);
    r = r && multiplicativeIntegerExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( (O_MULT | O_DIV) primaryIntegerExpression )*
  private static boolean multiplicativeIntegerExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeIntegerExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiplicativeIntegerExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplicativeIntegerExpression_1", c)) break;
    }
    return true;
  }

  // (O_MULT | O_DIV) primaryIntegerExpression
  private static boolean multiplicativeIntegerExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeIntegerExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplicativeIntegerExpression_1_0_0(b, l + 1);
    r = r && primaryIntegerExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // O_MULT | O_DIV
  private static boolean multiplicativeIntegerExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeIntegerExpression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, O_MULT);
    if (!r) r = consumeToken(b, O_DIV);
    return r;
  }

  /* ********************************************************** */
  // unaryExpression ( (O_MULT | O_DIV) unaryExpression )*
  public static boolean multiplyExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLY_EXPRESSION, "<multiply expression>");
    r = unaryExpression(b, l + 1);
    r = r && multiplyExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( (O_MULT | O_DIV) unaryExpression )*
  private static boolean multiplyExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiplyExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplyExpression_1", c)) break;
    }
    return true;
  }

  // (O_MULT | O_DIV) unaryExpression
  private static boolean multiplyExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplyExpression_1_0_0(b, l + 1);
    r = r && unaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // O_MULT | O_DIV
  private static boolean multiplyExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplyExpression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, O_MULT);
    if (!r) r = consumeToken(b, O_DIV);
    return r;
  }

  /* ********************************************************** */
  // andExpression (O_OR andExpression)*
  public static boolean orExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OR_EXPRESSION, "<or expression>");
    r = andExpression(b, l + 1);
    r = r && orExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (O_OR andExpression)*
  private static boolean orExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!orExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "orExpression_1", c)) break;
    }
    return true;
  }

  // O_OR andExpression
  private static boolean orExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, O_OR);
    r = r && andExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // variable (P_COMMA variable)*
  public static boolean paramList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM_LIST, "<param list>");
    r = variable(b, l + 1);
    r = r && paramList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (P_COMMA variable)*
  private static boolean paramList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!paramList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "paramList_1", c)) break;
    }
    return true;
  }

  // P_COMMA variable
  private static boolean paramList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, P_COMMA);
    r = r && variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // V_IDENT S_PAREN_L argList? S_PAREN_R
  public static boolean parameterizedGame(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameterizedGame")) return false;
    if (!nextTokenIs(b, V_IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, V_IDENT, S_PAREN_L);
    r = r && parameterizedGame_2(b, l + 1);
    r = r && consumeToken(b, S_PAREN_R);
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
  // S_PAREN_L argList? S_PAREN_R
  //     | S_BRACKET_L integerExpression P_COLON integerExpression S_BRACKET_R
  public static boolean postfixOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixOperation")) return false;
    if (!nextTokenIs(b, "<postfix operation>", S_BRACKET_L, S_PAREN_L)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSTFIX_OPERATION, "<postfix operation>");
    r = postfixOperation_0(b, l + 1);
    if (!r) r = postfixOperation_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // S_PAREN_L argList? S_PAREN_R
  private static boolean postfixOperation_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixOperation_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, S_PAREN_L);
    r = r && postfixOperation_0_1(b, l + 1);
    r = r && consumeToken(b, S_PAREN_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // argList?
  private static boolean postfixOperation_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixOperation_0_1")) return false;
    argList(b, l + 1);
    return true;
  }

  // S_BRACKET_L integerExpression P_COLON integerExpression S_BRACKET_R
  private static boolean postfixOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixOperation_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, S_BRACKET_L);
    r = r && integerExpression(b, l + 1);
    r = r && consumeToken(b, P_COLON);
    r = r && integerExpression(b, l + 1);
    r = r && consumeToken(b, S_BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // lvalue
  //     | S_BRACKET_L (expression (P_COMMA expression)*)? S_BRACKET_R
  //     | S_BRACE_L  (expression (P_COMMA expression)*)? S_BRACE_R
  //     | type
  //     | V_BINARYNUM
  //     | T_INT
  //     | V_BOOL
  //     | K_NONE
  //     | S_PAREN_L expression S_PAREN_R
  public static boolean primaryElement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_ELEMENT, "<primary element>");
    r = lvalue(b, l + 1);
    if (!r) r = primaryElement_1(b, l + 1);
    if (!r) r = primaryElement_2(b, l + 1);
    if (!r) r = type(b, l + 1);
    if (!r) r = consumeToken(b, V_BINARYNUM);
    if (!r) r = consumeToken(b, T_INT);
    if (!r) r = consumeToken(b, V_BOOL);
    if (!r) r = consumeToken(b, K_NONE);
    if (!r) r = primaryElement_8(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // S_BRACKET_L (expression (P_COMMA expression)*)? S_BRACKET_R
  private static boolean primaryElement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, S_BRACKET_L);
    r = r && primaryElement_1_1(b, l + 1);
    r = r && consumeToken(b, S_BRACKET_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (expression (P_COMMA expression)*)?
  private static boolean primaryElement_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_1_1")) return false;
    primaryElement_1_1_0(b, l + 1);
    return true;
  }

  // expression (P_COMMA expression)*
  private static boolean primaryElement_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && primaryElement_1_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (P_COMMA expression)*
  private static boolean primaryElement_1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_1_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!primaryElement_1_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primaryElement_1_1_0_1", c)) break;
    }
    return true;
  }

  // P_COMMA expression
  private static boolean primaryElement_1_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_1_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, P_COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // S_BRACE_L  (expression (P_COMMA expression)*)? S_BRACE_R
  private static boolean primaryElement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, S_BRACE_L);
    r = r && primaryElement_2_1(b, l + 1);
    r = r && consumeToken(b, S_BRACE_R);
    exit_section_(b, m, null, r);
    return r;
  }

  // (expression (P_COMMA expression)*)?
  private static boolean primaryElement_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_2_1")) return false;
    primaryElement_2_1_0(b, l + 1);
    return true;
  }

  // expression (P_COMMA expression)*
  private static boolean primaryElement_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && primaryElement_2_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (P_COMMA expression)*
  private static boolean primaryElement_2_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_2_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!primaryElement_2_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primaryElement_2_1_0_1", c)) break;
    }
    return true;
  }

  // P_COMMA expression
  private static boolean primaryElement_2_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_2_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, P_COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // S_PAREN_L expression S_PAREN_R
  private static boolean primaryElement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryElement_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, S_PAREN_L);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, S_PAREN_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // primaryElement (postfixOperation)*
  public static boolean primaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_EXPRESSION, "<primary expression>");
    r = primaryElement(b, l + 1);
    r = r && primaryExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (postfixOperation)*
  private static boolean primaryExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!primaryExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primaryExpression_1", c)) break;
    }
    return true;
  }

  // (postfixOperation)
  private static boolean primaryExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = postfixOperation(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // lvalue
  //     | V_INT
  //     | V_BINARYNUM
  //     | S_PAREN_L integerExpression S_PAREN_R
  public static boolean primaryIntegerExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryIntegerExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_INTEGER_EXPRESSION, "<primary integer expression>");
    r = lvalue(b, l + 1);
    if (!r) r = consumeToken(b, V_INT);
    if (!r) r = consumeToken(b, V_BINARYNUM);
    if (!r) r = primaryIntegerExpression_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // S_PAREN_L integerExpression S_PAREN_R
  private static boolean primaryIntegerExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryIntegerExpression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, S_PAREN_L);
    r = r && integerExpression(b, l + 1);
    r = r && consumeToken(b, S_PAREN_R);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ((initializedField | methodSignature) P_SEMIC)*
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

  // (initializedField | methodSignature) P_SEMIC
  private static boolean primitiveBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitiveBody_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primitiveBody_0_0(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
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
  // F_PRIMITIVE V_IDENT S_PAREN_L paramList? S_PAREN_R
  //     S_BRACE_L primitiveBody S_BRACE_R
  public static boolean primitiveProgram(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitiveProgram")) return false;
    if (!nextTokenIs(b, F_PRIMITIVE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, F_PRIMITIVE, V_IDENT, S_PAREN_L);
    r = r && primitiveProgram_3(b, l + 1);
    r = r && consumeTokens(b, 0, S_PAREN_R, S_BRACE_L);
    r = r && primitiveBody(b, l + 1);
    r = r && consumeToken(b, S_BRACE_R);
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
  // K_PROOF P_COLON
  //     (K_LET P_COLON lets)?
  //     (K_ASSUME P_COLON assumptions)?
  //     K_THEOREM P_COLON theorem
  //     K_GAMES P_COLON gameList
  public static boolean proof(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proof")) return false;
    if (!nextTokenIs(b, K_PROOF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_PROOF, P_COLON);
    r = r && proof_2(b, l + 1);
    r = r && proof_3(b, l + 1);
    r = r && consumeTokens(b, 0, K_THEOREM, P_COLON);
    r = r && theorem(b, l + 1);
    r = r && consumeTokens(b, 0, K_GAMES, P_COLON);
    r = r && gameList(b, l + 1);
    exit_section_(b, m, PROOF, r);
    return r;
  }

  // (K_LET P_COLON lets)?
  private static boolean proof_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proof_2")) return false;
    proof_2_0(b, l + 1);
    return true;
  }

  // K_LET P_COLON lets
  private static boolean proof_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proof_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_LET, P_COLON);
    r = r && lets(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (K_ASSUME P_COLON assumptions)?
  private static boolean proof_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proof_3")) return false;
    proof_3_0(b, l + 1);
    return true;
  }

  // K_ASSUME P_COLON assumptions
  private static boolean proof_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proof_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_ASSUME, P_COLON);
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
  // F_REDUCTION V_IDENT S_PAREN_L paramList? S_PAREN_R
  //     K_COMPOSE parameterizedGame K_AGAINST gameAdversary
  //     S_BRACE_L gameBody S_BRACE_R
  public static boolean reduction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reduction")) return false;
    if (!nextTokenIs(b, F_REDUCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, F_REDUCTION, V_IDENT, S_PAREN_L);
    r = r && reduction_3(b, l + 1);
    r = r && consumeTokens(b, 0, S_PAREN_R, K_COMPOSE);
    r = r && parameterizedGame(b, l + 1);
    r = r && consumeToken(b, K_AGAINST);
    r = r && gameAdversary(b, l + 1);
    r = r && consumeToken(b, S_BRACE_L);
    r = r && gameBody(b, l + 1);
    r = r && consumeToken(b, S_BRACE_R);
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
  // F_SCHEME V_IDENT S_PAREN_L paramList? S_PAREN_R
  //     K_EXTENDS V_IDENT S_BRACE_L schemeBody S_BRACE_R
  public static boolean scheme(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scheme")) return false;
    if (!nextTokenIs(b, F_SCHEME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, F_SCHEME, V_IDENT, S_PAREN_L);
    r = r && scheme_3(b, l + 1);
    r = r && consumeTokens(b, 0, S_PAREN_R, K_EXTENDS, V_IDENT, S_BRACE_L);
    r = r && schemeBody(b, l + 1);
    r = r && consumeToken(b, S_BRACE_R);
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
  // (K_REQUIRES expression P_SEMIC)*
  //     (field P_SEMIC | method)+
  public static boolean schemeBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeBody")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCHEME_BODY, "<scheme body>");
    r = schemeBody_0(b, l + 1);
    r = r && schemeBody_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (K_REQUIRES expression P_SEMIC)*
  private static boolean schemeBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeBody_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!schemeBody_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "schemeBody_0", c)) break;
    }
    return true;
  }

  // K_REQUIRES expression P_SEMIC
  private static boolean schemeBody_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeBody_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_REQUIRES);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
    exit_section_(b, m, null, r);
    return r;
  }

  // (field P_SEMIC | method)+
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

  // field P_SEMIC | method
  private static boolean schemeBody_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeBody_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = schemeBody_1_0_0(b, l + 1);
    if (!r) r = method(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // field P_SEMIC
  private static boolean schemeBody_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeBody_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // moduleImport* scheme
  public static boolean schemeProgram(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schemeProgram")) return false;
    if (!nextTokenIs(b, "<scheme program>", F_SCHEME, K_IMPORT)) return false;
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
  // unionExpression (O_BSLASH unionExpression)*
  public static boolean setMinusExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setMinusExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SET_MINUS_EXPRESSION, "<set minus expression>");
    r = unionExpression(b, l + 1);
    r = r && setMinusExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (O_BSLASH unionExpression)*
  private static boolean setMinusExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setMinusExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!setMinusExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "setMinusExpression_1", c)) break;
    }
    return true;
  }

  // O_BSLASH unionExpression
  private static boolean setMinusExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "setMinusExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, O_BSLASH);
    r = r && unionExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type id P_SEMIC                                             // varDeclStatement
  // 	| type lvalue O_ASGN expression P_SEMIC                       // varDeclWithValueStatement
  // 	| type lvalue O_SMPL expression P_SEMIC                       // varDeclWithSampleStatement
  // 	| lvalue O_ASGN expression P_SEMIC                            // assignmentStatement
  // 	| lvalue O_SMPL expression P_SEMIC                            // sampleStatement
  // 	| expression S_PAREN_L argList? S_PAREN_R P_SEMIC             // functionCallStatement
  // 	| K_RETURN expression P_SEMIC                                 // returnStatement
  // 	| K_IF S_PAREN_L expression S_PAREN_R block (K_ELSE K_IF S_PAREN_L expression S_PAREN_R block )* (K_ELSE block )?  // ifStatement
  // 	| K_FOR S_PAREN_L T_INT id O_ASGN expression K_TO expression S_PAREN_R block  // numericForStatement
  // 	| K_FOR S_PAREN_L type id K_IN expression S_PAREN_R block
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

  // type id P_SEMIC
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
    exit_section_(b, m, null, r);
    return r;
  }

  // type lvalue O_ASGN expression P_SEMIC
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && lvalue(b, l + 1);
    r = r && consumeToken(b, O_ASGN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
    exit_section_(b, m, null, r);
    return r;
  }

  // type lvalue O_SMPL expression P_SEMIC
  private static boolean statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && lvalue(b, l + 1);
    r = r && consumeToken(b, O_SMPL);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
    exit_section_(b, m, null, r);
    return r;
  }

  // lvalue O_ASGN expression P_SEMIC
  private static boolean statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lvalue(b, l + 1);
    r = r && consumeToken(b, O_ASGN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
    exit_section_(b, m, null, r);
    return r;
  }

  // lvalue O_SMPL expression P_SEMIC
  private static boolean statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lvalue(b, l + 1);
    r = r && consumeToken(b, O_SMPL);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression S_PAREN_L argList? S_PAREN_R P_SEMIC
  private static boolean statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, S_PAREN_L);
    r = r && statement_5_2(b, l + 1);
    r = r && consumeTokens(b, 0, S_PAREN_R, P_SEMIC);
    exit_section_(b, m, null, r);
    return r;
  }

  // argList?
  private static boolean statement_5_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_5_2")) return false;
    argList(b, l + 1);
    return true;
  }

  // K_RETURN expression P_SEMIC
  private static boolean statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_RETURN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
    exit_section_(b, m, null, r);
    return r;
  }

  // K_IF S_PAREN_L expression S_PAREN_R block (K_ELSE K_IF S_PAREN_L expression S_PAREN_R block )* (K_ELSE block )?
  private static boolean statement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_IF, S_PAREN_L);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, S_PAREN_R);
    r = r && block(b, l + 1);
    r = r && statement_7_5(b, l + 1);
    r = r && statement_7_6(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (K_ELSE K_IF S_PAREN_L expression S_PAREN_R block )*
  private static boolean statement_7_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_7_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement_7_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement_7_5", c)) break;
    }
    return true;
  }

  // K_ELSE K_IF S_PAREN_L expression S_PAREN_R block
  private static boolean statement_7_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_7_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_ELSE, K_IF, S_PAREN_L);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, S_PAREN_R);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (K_ELSE block )?
  private static boolean statement_7_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_7_6")) return false;
    statement_7_6_0(b, l + 1);
    return true;
  }

  // K_ELSE block
  private static boolean statement_7_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_7_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_ELSE);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // K_FOR S_PAREN_L T_INT id O_ASGN expression K_TO expression S_PAREN_R block
  private static boolean statement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_FOR, S_PAREN_L, T_INT);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, O_ASGN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, K_TO);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, S_PAREN_R);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // K_FOR S_PAREN_L type id K_IN expression S_PAREN_R block
  private static boolean statement_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_FOR, S_PAREN_L);
    r = r && type(b, l + 1);
    r = r && id(b, l + 1);
    r = r && consumeToken(b, K_IN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, S_PAREN_R);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // K_ASSUME expression P_SEMIC
  public static boolean stepAssumption(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stepAssumption")) return false;
    if (!nextTokenIs(b, K_ASSUME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_ASSUME);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
    exit_section_(b, m, STEP_ASSUMPTION, r);
    return r;
  }

  /* ********************************************************** */
  // parameterizedGame P_SEMIC
  public static boolean theorem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "theorem")) return false;
    if (!nextTokenIs(b, V_IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameterizedGame(b, l + 1);
    r = r && consumeToken(b, P_SEMIC);
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
  // atomicType O_OPT*
  public static boolean typePostfix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typePostfix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_POSTFIX, "<type postfix>");
    r = atomicType(b, l + 1);
    r = r && typePostfix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // O_OPT*
  private static boolean typePostfix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typePostfix_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, O_OPT)) break;
      if (!empty_element_parsed_guard_(b, "typePostfix_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // typePostfix (O_MULT typePostfix)*
  public static boolean typeProduct(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeProduct")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_PRODUCT, "<type product>");
    r = typePostfix(b, l + 1);
    r = r && typeProduct_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (O_MULT typePostfix)*
  private static boolean typeProduct_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeProduct_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeProduct_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeProduct_1", c)) break;
    }
    return true;
  }

  // O_MULT typePostfix
  private static boolean typeProduct_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeProduct_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, O_MULT);
    r = r && typePostfix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // O_NOT unaryExpression
  //     | O_VBAR unaryExpression O_VBAR
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

  // O_NOT unaryExpression
  private static boolean unaryExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, O_NOT);
    r = r && unaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // O_VBAR unaryExpression O_VBAR
  private static boolean unaryExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, O_VBAR);
    r = r && unaryExpression(b, l + 1);
    r = r && consumeToken(b, O_VBAR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // orExpression (K_UNION orExpression)*
  public static boolean unionExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unionExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNION_EXPRESSION, "<union expression>");
    r = orExpression(b, l + 1);
    r = r && unionExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (K_UNION orExpression)*
  private static boolean unionExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unionExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unionExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unionExpression_1", c)) break;
    }
    return true;
  }

  // K_UNION orExpression
  private static boolean unionExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unionExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, K_UNION);
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
