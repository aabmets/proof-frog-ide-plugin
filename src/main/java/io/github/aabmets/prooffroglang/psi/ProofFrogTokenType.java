package io.github.aabmets.prooffroglang.psi;

import io.github.aabmets.prooffroglang.ProofFrogLanguage;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ProofFrogTokenType extends IElementType {

    public ProofFrogTokenType(@NotNull @NonNls String debugName) {
        super(debugName, ProofFrogLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return PRESENTATION.getOrDefault(super.toString(), super.toString());
    }

    private static final Map<String,String> PRESENTATION = Map.<String, String>ofEntries(
        Map.entry("PN_SEMI",    ";"),
        Map.entry("PN_COLON",  ":"),
        Map.entry("PN_COMMA",    ","),
        Map.entry("PN_PERIOD",  "."),

        Map.entry("ST_BRACE_L",    "{"),
        Map.entry("ST_BRACE_R",  "}"),
        Map.entry("ST_BRACKET_L",    "["),
        Map.entry("ST_BRACKET_R",  "]"),
        Map.entry("ST_PAREN_L",    "("),
        Map.entry("ST_PAREN_R",  ")"),

        Map.entry("OP_SAMPLE",    "<-"),
        Map.entry("OP_ASSIGN",  "="),
        Map.entry("OP_MULT",    "*"),
        Map.entry("OP_ADD",  "+"),
        Map.entry("OP_SUB",    "-"),
        Map.entry("OP_DIV",  "/"),
        Map.entry("OP_EQ",    "=="),
        Map.entry("OP_OPT",  "?"),
        Map.entry("OP_NOT",    "!"),
        Map.entry("OP_NEQ",  "!="),
        Map.entry("OP_GT",    ">"),
        Map.entry("OP_GEQ",  ">="),
        Map.entry("OP_LEQ",  "<="),
        Map.entry("OP_LT",    "<"),
        Map.entry("OP_OR",  "||"),
        Map.entry("OP_AND",    "&&"),
        Map.entry("OP_VBAR",  "|"),
        Map.entry("OP_BSLASH",  "\\"),

        Map.entry("KW_IMPORT",    "import"),
        Map.entry("KW_EXPORT",  "export"),
        Map.entry("KW_RETURN",    "return"),
        Map.entry("KW_SUBSETS",  "subsets"),
        Map.entry("KW_ORACLES",    "oracles"),
        Map.entry("KW_AGAINST",  "against"),
        Map.entry("KW_COMPOSE",    "compose"),
        Map.entry("KW_EXTENDS",  "extends"),
        Map.entry("KW_REQUIRES",    "requires"),
        Map.entry("KW_INDUCTION",  "induction"),
        Map.entry("KW_UNION",    "union"),
        Map.entry("KW_CALLS",  "calls"),
        Map.entry("KW_FROM",  "from"),
        Map.entry("KW_ELSE",    "else"),
        Map.entry("KW_FOR",  "for"),
        Map.entry("KW_IF",    "if"),
        Map.entry("KW_TO",  "to"),
        Map.entry("KW_IN",  "in"),
        Map.entry("KW_AS",  "as"),
        Map.entry("KW_NONE",  "None"),

        Map.entry("LB_PROOF",    "proof"),
        Map.entry("LB_LET",  "let"),
        Map.entry("LB_ASSUME",    "assume"),
        Map.entry("LB_THEOREM",  "theorem"),
        Map.entry("LB_GAMES",    "games"),

        Map.entry("CL_PRIMITIVE",  "Primitive"),
        Map.entry("CL_REDUCTION",    "Reduction"),
        Map.entry("CL_SCHEME",  "Scheme"),
        Map.entry("CL_GAME",    "Game"),

        Map.entry("PR_ADVERSARY",  "Adversary"),

        Map.entry("NB_PHASE",    "Phase"),

        Map.entry("DT_SET",  "Set"),
        Map.entry("DT_BOOL",  "Bool"),
        Map.entry("DT_VOID",    "Void"),
        Map.entry("DT_INT",  "Int"),
        Map.entry("DT_MAP",    "Map"),
        Map.entry("DT_ARRAY",  "Array"),
        Map.entry("DT_BITSTRING",  "BitString"),

        Map.entry("VL_BOOL",  "boolean"),
        Map.entry("VL_INT",  "integer"),
        Map.entry("VL_BINARYNUM",  "binary integer"),
        Map.entry("VL_LINE_COMMENT",  "line comment"),
        Map.entry("VL_FILE_PATH",  "file path"),
        Map.entry("VL_IDENTIFIER",  "identifier"),
        Map.entry("VL_WHITE_SPACE",  "white space")
    );

}
