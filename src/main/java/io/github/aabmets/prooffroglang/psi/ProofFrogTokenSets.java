package io.github.aabmets.prooffroglang.psi;

import com.intellij.psi.tree.TokenSet;

public interface ProofFrogTokenSets {

    // Punctuation
    TokenSet PUNCTUATION = TokenSet.create(
        ProofFrogTypes.PN_SEMI,
        ProofFrogTypes.PN_COLON,
        ProofFrogTypes.PN_COMMA,
        ProofFrogTypes.PN_PERIOD
    );

    // Structure
    TokenSet STRUCTURE = TokenSet.create(
        ProofFrogTypes.ST_BRACE_L,
        ProofFrogTypes.ST_BRACE_R,
        ProofFrogTypes.ST_BRACKET_L,
        ProofFrogTypes.ST_BRACKET_R,
        ProofFrogTypes.ST_PAREN_L,
        ProofFrogTypes.ST_PAREN_R
    );

    // Operators
    TokenSet OPERATORS = TokenSet.create(
        ProofFrogTypes.OP_SAMPLE,
        ProofFrogTypes.OP_ASSIGN,
        ProofFrogTypes.OP_MULT,
        ProofFrogTypes.OP_ADD,
        ProofFrogTypes.OP_SUB,
        ProofFrogTypes.OP_DIV,
        ProofFrogTypes.OP_EQ,
        ProofFrogTypes.OP_OPT,
        ProofFrogTypes.OP_NOT,
        ProofFrogTypes.OP_NEQ,
        ProofFrogTypes.OP_GT,
        ProofFrogTypes.OP_GEQ,
        ProofFrogTypes.OP_LEQ,
        ProofFrogTypes.OP_LT,
        ProofFrogTypes.OP_OR,
        ProofFrogTypes.OP_AND,
        ProofFrogTypes.OP_VBAR,
        ProofFrogTypes.OP_BSLASH
    );

    // Keywords
    TokenSet KEYWORDS = TokenSet.create(
        ProofFrogTypes.KW_IMPORT,
        ProofFrogTypes.KW_EXPORT,
        ProofFrogTypes.KW_RETURN,
        ProofFrogTypes.KW_SUBSETS,
        ProofFrogTypes.KW_ORACLES,
        ProofFrogTypes.KW_AGAINST,
        ProofFrogTypes.KW_COMPOSE,
        ProofFrogTypes.KW_THEOREM,
        ProofFrogTypes.KW_EXTENDS,
        ProofFrogTypes.KW_REQUIRES,
        ProofFrogTypes.KW_INDUCTION,
        ProofFrogTypes.KW_ASSUME,
        ProofFrogTypes.KW_PROOF,
        ProofFrogTypes.KW_GAMES,
        ProofFrogTypes.KW_UNION,
        ProofFrogTypes.KW_CALLS,
        ProofFrogTypes.KW_FROM,
        ProofFrogTypes.KW_ELSE,
        ProofFrogTypes.KW_LET,
        ProofFrogTypes.KW_FOR,
        ProofFrogTypes.KW_IF,
        ProofFrogTypes.KW_TO,
        ProofFrogTypes.KW_IN,
        ProofFrogTypes.KW_AS,
        ProofFrogTypes.KW_NONE
    );

    // Functions
    TokenSet FUNCTIONS = TokenSet.create(
        ProofFrogTypes.FN_ADVERSARY,
        ProofFrogTypes.FN_PRIMITIVE,
        ProofFrogTypes.FN_REDUCTION,
        ProofFrogTypes.FN_SCHEME,
        ProofFrogTypes.FN_PHASE,
        ProofFrogTypes.FN_GAME
    );

    // Datatypes
    TokenSet DATATYPES = TokenSet.create(
        ProofFrogTypes.DT_SET,
        ProofFrogTypes.DT_BOOL,
        ProofFrogTypes.DT_VOID,
        ProofFrogTypes.DT_INT,
        ProofFrogTypes.DT_MAP,
        ProofFrogTypes.DT_ARRAY,
        ProofFrogTypes.DT_BITSTRING
    );

    // Comments
    TokenSet COMMENTS = TokenSet.create(
        ProofFrogTypes.VL_LINE_COMMENT
    );

}
