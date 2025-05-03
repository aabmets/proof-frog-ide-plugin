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
  // item_*
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // module_import |
  //     module_export |
  //     (P_SEMIC|P_COLON|P_COMMA|P_PERIOD) |  // Punctuation
  //     (S_BRACE_L|S_BRACE_R|S_BRACKET_L|S_BRACKET_R|S_PAREN_L|S_PAREN_R) |  // Structure
  //     (
  //         O_SMPL|O_ASGN|O_MULT|O_ADD|O_SUB|O_DIV|O_EQ|O_OPT|O_NOT|
  //         O_NEQ|O_GT|O_GEQ|O_LEQ|O_LT|O_OR|O_AND|O_VBAR|O_BSLASH
  //     ) |  // Operators
  //     (
  //         K_IMPORT|K_EXPORT|K_RETURN|K_SUBSETS|K_ORACLES|K_AGAINST|
  //         K_COMPOSE|K_THEOREM|K_EXTENDS|K_REQUIRES|K_INDUCTION|K_ASSUME|
  //         K_PROOF|K_GAMES|K_UNION|K_CALLS|K_FROM|K_ELSE|K_LET|K_FOR|
  //         K_IF|K_TO|K_IN|K_AS|K_NONE
  //     ) |  // Keywords
  //     (F_ADVERSARY|F_PRIMITIVE|F_REDUCTION|F_SCHEME|F_PHASE|F_GAME) |  // Functions
  //     (T_SET|T_BOOL|T_VOID|T_INT|T_MAP|T_ARRAY|T_BITSTRING) |  // Datatypes
  //     (V_BOOL|V_INT|V_BINARYNUM|V_LINE_COMMENT|V_FILESTRING|V_IDENT)
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_import(b, l + 1);
    if (!r) r = module_export(b, l + 1);
    if (!r) r = item__2(b, l + 1);
    if (!r) r = item__3(b, l + 1);
    if (!r) r = item__4(b, l + 1);
    if (!r) r = item__5(b, l + 1);
    if (!r) r = item__6(b, l + 1);
    if (!r) r = item__7(b, l + 1);
    if (!r) r = item__8(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // P_SEMIC|P_COLON|P_COMMA|P_PERIOD
  private static boolean item__2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__2")) return false;
    boolean r;
    r = consumeToken(b, P_SEMIC);
    if (!r) r = consumeToken(b, P_COLON);
    if (!r) r = consumeToken(b, P_COMMA);
    if (!r) r = consumeToken(b, P_PERIOD);
    return r;
  }

  // S_BRACE_L|S_BRACE_R|S_BRACKET_L|S_BRACKET_R|S_PAREN_L|S_PAREN_R
  private static boolean item__3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__3")) return false;
    boolean r;
    r = consumeToken(b, S_BRACE_L);
    if (!r) r = consumeToken(b, S_BRACE_R);
    if (!r) r = consumeToken(b, S_BRACKET_L);
    if (!r) r = consumeToken(b, S_BRACKET_R);
    if (!r) r = consumeToken(b, S_PAREN_L);
    if (!r) r = consumeToken(b, S_PAREN_R);
    return r;
  }

  // O_SMPL|O_ASGN|O_MULT|O_ADD|O_SUB|O_DIV|O_EQ|O_OPT|O_NOT|
  //         O_NEQ|O_GT|O_GEQ|O_LEQ|O_LT|O_OR|O_AND|O_VBAR|O_BSLASH
  private static boolean item__4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__4")) return false;
    boolean r;
    r = consumeToken(b, O_SMPL);
    if (!r) r = consumeToken(b, O_ASGN);
    if (!r) r = consumeToken(b, O_MULT);
    if (!r) r = consumeToken(b, O_ADD);
    if (!r) r = consumeToken(b, O_SUB);
    if (!r) r = consumeToken(b, O_DIV);
    if (!r) r = consumeToken(b, O_EQ);
    if (!r) r = consumeToken(b, O_OPT);
    if (!r) r = consumeToken(b, O_NOT);
    if (!r) r = consumeToken(b, O_NEQ);
    if (!r) r = consumeToken(b, O_GT);
    if (!r) r = consumeToken(b, O_GEQ);
    if (!r) r = consumeToken(b, O_LEQ);
    if (!r) r = consumeToken(b, O_LT);
    if (!r) r = consumeToken(b, O_OR);
    if (!r) r = consumeToken(b, O_AND);
    if (!r) r = consumeToken(b, O_VBAR);
    if (!r) r = consumeToken(b, O_BSLASH);
    return r;
  }

  // K_IMPORT|K_EXPORT|K_RETURN|K_SUBSETS|K_ORACLES|K_AGAINST|
  //         K_COMPOSE|K_THEOREM|K_EXTENDS|K_REQUIRES|K_INDUCTION|K_ASSUME|
  //         K_PROOF|K_GAMES|K_UNION|K_CALLS|K_FROM|K_ELSE|K_LET|K_FOR|
  //         K_IF|K_TO|K_IN|K_AS|K_NONE
  private static boolean item__5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__5")) return false;
    boolean r;
    r = consumeToken(b, K_IMPORT);
    if (!r) r = consumeToken(b, K_EXPORT);
    if (!r) r = consumeToken(b, K_RETURN);
    if (!r) r = consumeToken(b, K_SUBSETS);
    if (!r) r = consumeToken(b, K_ORACLES);
    if (!r) r = consumeToken(b, K_AGAINST);
    if (!r) r = consumeToken(b, K_COMPOSE);
    if (!r) r = consumeToken(b, K_THEOREM);
    if (!r) r = consumeToken(b, K_EXTENDS);
    if (!r) r = consumeToken(b, K_REQUIRES);
    if (!r) r = consumeToken(b, K_INDUCTION);
    if (!r) r = consumeToken(b, K_ASSUME);
    if (!r) r = consumeToken(b, K_PROOF);
    if (!r) r = consumeToken(b, K_GAMES);
    if (!r) r = consumeToken(b, K_UNION);
    if (!r) r = consumeToken(b, K_CALLS);
    if (!r) r = consumeToken(b, K_FROM);
    if (!r) r = consumeToken(b, K_ELSE);
    if (!r) r = consumeToken(b, K_LET);
    if (!r) r = consumeToken(b, K_FOR);
    if (!r) r = consumeToken(b, K_IF);
    if (!r) r = consumeToken(b, K_TO);
    if (!r) r = consumeToken(b, K_IN);
    if (!r) r = consumeToken(b, K_AS);
    if (!r) r = consumeToken(b, K_NONE);
    return r;
  }

  // F_ADVERSARY|F_PRIMITIVE|F_REDUCTION|F_SCHEME|F_PHASE|F_GAME
  private static boolean item__6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__6")) return false;
    boolean r;
    r = consumeToken(b, F_ADVERSARY);
    if (!r) r = consumeToken(b, F_PRIMITIVE);
    if (!r) r = consumeToken(b, F_REDUCTION);
    if (!r) r = consumeToken(b, F_SCHEME);
    if (!r) r = consumeToken(b, F_PHASE);
    if (!r) r = consumeToken(b, F_GAME);
    return r;
  }

  // T_SET|T_BOOL|T_VOID|T_INT|T_MAP|T_ARRAY|T_BITSTRING
  private static boolean item__7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__7")) return false;
    boolean r;
    r = consumeToken(b, T_SET);
    if (!r) r = consumeToken(b, T_BOOL);
    if (!r) r = consumeToken(b, T_VOID);
    if (!r) r = consumeToken(b, T_INT);
    if (!r) r = consumeToken(b, T_MAP);
    if (!r) r = consumeToken(b, T_ARRAY);
    if (!r) r = consumeToken(b, T_BITSTRING);
    return r;
  }

  // V_BOOL|V_INT|V_BINARYNUM|V_LINE_COMMENT|V_FILESTRING|V_IDENT
  private static boolean item__8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item__8")) return false;
    boolean r;
    r = consumeToken(b, V_BOOL);
    if (!r) r = consumeToken(b, V_INT);
    if (!r) r = consumeToken(b, V_BINARYNUM);
    if (!r) r = consumeToken(b, V_LINE_COMMENT);
    if (!r) r = consumeToken(b, V_FILESTRING);
    if (!r) r = consumeToken(b, V_IDENT);
    return r;
  }

  /* ********************************************************** */
  // K_EXPORT K_AS V_IDENT P_SEMI
  public static boolean module_export(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_export")) return false;
    if (!nextTokenIs(b, K_EXPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_EXPORT, K_AS, V_IDENT, P_SEMI);
    exit_section_(b, m, MODULE_EXPORT, r);
    return r;
  }

  /* ********************************************************** */
  // K_IMPORT V_FILESTRING (K_AS V_IDENT)? P_SEMI
  public static boolean module_import(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_import")) return false;
    if (!nextTokenIs(b, K_IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_IMPORT, V_FILESTRING);
    r = r && module_import_2(b, l + 1);
    r = r && consumeToken(b, P_SEMI);
    exit_section_(b, m, MODULE_IMPORT, r);
    return r;
  }

  // (K_AS V_IDENT)?
  private static boolean module_import_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_import_2")) return false;
    module_import_2_0(b, l + 1);
    return true;
  }

  // K_AS V_IDENT
  private static boolean module_import_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_import_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, K_AS, V_IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

}
