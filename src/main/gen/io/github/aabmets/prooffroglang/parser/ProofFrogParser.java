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
  // SET|BOOL|VOID|INT|MAP|BITSTRING|ARRAY
  public static boolean datatype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "datatype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATATYPE, "<datatype>");
    r = consumeToken(b, SET);
    if (!r) r = consumeToken(b, BOOL);
    if (!r) r = consumeToken(b, VOID);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, MAP);
    if (!r) r = consumeToken(b, BITSTRING);
    if (!r) r = consumeToken(b, ARRAY);
    exit_section_(b, l, m, r, false, null);
    return r;
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
  //     datatype |
  //     LINE_COMMENT
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = module_import(b, l + 1);
    if (!r) r = module_export(b, l + 1);
    if (!r) r = datatype(b, l + 1);
    if (!r) r = consumeToken(b, LINE_COMMENT);
    return r;
  }

  /* ********************************************************** */
  // EXPORT AS ID SEMI
  public static boolean module_export(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_export")) return false;
    if (!nextTokenIs(b, EXPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EXPORT, AS, ID, SEMI);
    exit_section_(b, m, MODULE_EXPORT, r);
    return r;
  }

  /* ********************************************************** */
  // IMPORT FILESTRING (AS ID)? SEMI
  public static boolean module_import(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_import")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IMPORT, FILESTRING);
    r = r && module_import_2(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, MODULE_IMPORT, r);
    return r;
  }

  // (AS ID)?
  private static boolean module_import_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_import_2")) return false;
    module_import_2_0(b, l + 1);
    return true;
  }

  // AS ID
  private static boolean module_import_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_import_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AS, ID);
    exit_section_(b, m, null, r);
    return r;
  }

}
