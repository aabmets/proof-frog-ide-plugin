package io.github.aabmets.prooffroglang.psi;

import com.intellij.psi.tree.TokenSet;

public interface ProofFrogTokenSets {

    TokenSet DELIMITERS = TokenSet.create(
        ProofFrogTypes.PN_SEMI,
        ProofFrogTypes.PN_COLON,
        ProofFrogTypes.PN_COMMA,
        ProofFrogTypes.PN_PERIOD
    );

    TokenSet STRUCTURE = TokenSet.create(
        ProofFrogTypes.ST_BRACE_L,
        ProofFrogTypes.ST_BRACE_R,
        ProofFrogTypes.ST_BRACKET_L,
        ProofFrogTypes.ST_BRACKET_R,
        ProofFrogTypes.ST_PAREN_L,
        ProofFrogTypes.ST_PAREN_R
    );

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

    TokenSet KEYWORDS = TokenSet.create(
        ProofFrogTypes.KW_IMPORT,
        ProofFrogTypes.KW_EXPORT,
        ProofFrogTypes.KW_RETURN,
        ProofFrogTypes.KW_SUBSETS,
        ProofFrogTypes.KW_ORACLES,
        ProofFrogTypes.KW_AGAINST,
        ProofFrogTypes.KW_COMPOSE,
        ProofFrogTypes.KW_EXTENDS,
        ProofFrogTypes.KW_REQUIRES,
        ProofFrogTypes.KW_INDUCTION,
        ProofFrogTypes.KW_UNION,
        ProofFrogTypes.KW_CALLS,
        ProofFrogTypes.KW_FROM,
        ProofFrogTypes.KW_ELSE,
        ProofFrogTypes.KW_FOR,
        ProofFrogTypes.KW_IF,
        ProofFrogTypes.KW_TO,
        ProofFrogTypes.KW_IN,
        ProofFrogTypes.KW_AS,
        ProofFrogTypes.KW_NONE
    );

    TokenSet LABELS = TokenSet.create(
        ProofFrogTypes.LB_PROOF,
        ProofFrogTypes.LB_LET,
        ProofFrogTypes.LB_ASSUME,
        ProofFrogTypes.LB_THEOREM,
        ProofFrogTypes.LB_GAMES
    );

    TokenSet CLASS_KEYWORDS = TokenSet.create(
        ProofFrogTypes.CL_PRIMITIVE,
        ProofFrogTypes.CL_REDUCTION,
        ProofFrogTypes.CL_SCHEME,
        ProofFrogTypes.CL_GAME
    );

    TokenSet NAMED_BLOCKS = TokenSet.create(
        ProofFrogTypes.NB_PHASE
    );

    TokenSet PROPERTIES = TokenSet.create(
        ProofFrogTypes.PR_ADVERSARY
    );

    TokenSet DATATYPES = TokenSet.create(
        ProofFrogTypes.DT_SET,
        ProofFrogTypes.DT_BOOL,
        ProofFrogTypes.DT_VOID,
        ProofFrogTypes.DT_INT,
        ProofFrogTypes.DT_MAP,
        ProofFrogTypes.DT_ARRAY,
        ProofFrogTypes.DT_BITSTRING
    );

    TokenSet COMMENTS = TokenSet.create(
        ProofFrogTypes.VL_LINE_COMMENT
    );

    TokenSet VARIABLES = TokenSet.create(
        ProofFrogTypes.VARIABLE,
        ProofFrogTypes.VAR_DECL_ASSIGN_STMT,
        ProofFrogTypes.VAR_DECL_SAMPLE_STMT,
        ProofFrogTypes.VAR_DECL_STMT,
        ProofFrogTypes.ASSIGN_STMT,
        ProofFrogTypes.SAMPLE_STMT
    );

    TokenSet CLASS_SIGNATURES = TokenSet.create(
        ProofFrogTypes.PRIMITIVE_SIGNATURE,
        ProofFrogTypes.REDUCTION_SIGNATURE,
        ProofFrogTypes.SCHEME_SIGNATURE,
        ProofFrogTypes.GAME_SIGNATURE
    );

}
