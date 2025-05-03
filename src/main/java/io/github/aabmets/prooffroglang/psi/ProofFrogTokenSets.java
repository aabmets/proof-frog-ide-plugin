package io.github.aabmets.prooffroglang.psi;

import com.intellij.psi.tree.TokenSet;

public interface ProofFrogTokenSets {

    // Punctuation
    TokenSet PUNCTUATION = TokenSet.create(
        ProofFrogTypes.P_SEMIC,
        ProofFrogTypes.P_COLON,
        ProofFrogTypes.P_COMMA,
        ProofFrogTypes.P_PERIOD
    );

    // Structure
    TokenSet STRUCTURE = TokenSet.create(
        ProofFrogTypes.S_BRACE_L,
        ProofFrogTypes.S_BRACE_R,
        ProofFrogTypes.S_BRACKET_L,
        ProofFrogTypes.S_BRACKET_R,
        ProofFrogTypes.S_PAREN_L,
        ProofFrogTypes.S_PAREN_R
    );

    // Operators
    TokenSet OPERATORS = TokenSet.create(
        ProofFrogTypes.O_SMPL,
        ProofFrogTypes.O_ASGN,
        ProofFrogTypes.O_MULT,
        ProofFrogTypes.O_ADD,
        ProofFrogTypes.O_SUB,
        ProofFrogTypes.O_DIV,
        ProofFrogTypes.O_EQ,
        ProofFrogTypes.O_OPT,
        ProofFrogTypes.O_NOT,
        ProofFrogTypes.O_NEQ,
        ProofFrogTypes.O_GT,
        ProofFrogTypes.O_GEQ,
        ProofFrogTypes.O_LEQ,
        ProofFrogTypes.O_LT,
        ProofFrogTypes.O_OR,
        ProofFrogTypes.O_AND,
        ProofFrogTypes.O_VBAR,
        ProofFrogTypes.O_BSLASH
    );

    // Keywords
    TokenSet KEYWORDS = TokenSet.create(
        ProofFrogTypes.K_IMPORT,
        ProofFrogTypes.K_EXPORT,
        ProofFrogTypes.K_RETURN,
        ProofFrogTypes.K_SUBSETS,
        ProofFrogTypes.K_ORACLES,
        ProofFrogTypes.K_AGAINST,
        ProofFrogTypes.K_COMPOSE,
        ProofFrogTypes.K_THEOREM,
        ProofFrogTypes.K_EXTENDS,
        ProofFrogTypes.K_REQUIRES,
        ProofFrogTypes.K_INDUCTION,
        ProofFrogTypes.K_ASSUME,
        ProofFrogTypes.K_PROOF,
        ProofFrogTypes.K_GAMES,
        ProofFrogTypes.K_UNION,
        ProofFrogTypes.K_CALLS,
        ProofFrogTypes.K_FROM,
        ProofFrogTypes.K_ELSE,
        ProofFrogTypes.K_LET,
        ProofFrogTypes.K_FOR,
        ProofFrogTypes.K_IF,
        ProofFrogTypes.K_TO,
        ProofFrogTypes.K_IN,
        ProofFrogTypes.K_AS,
        ProofFrogTypes.K_NONE
    );

    // Functions
    TokenSet FUNCTIONS = TokenSet.create(
        ProofFrogTypes.F_ADVERSARY,
        ProofFrogTypes.F_PRIMITIVE,
        ProofFrogTypes.F_REDUCTION,
        ProofFrogTypes.F_SCHEME,
        ProofFrogTypes.F_PHASE,
        ProofFrogTypes.F_GAME
    );

    // Datatypes
    TokenSet DATATYPES = TokenSet.create(
        ProofFrogTypes.T_SET,
        ProofFrogTypes.T_BOOL,
        ProofFrogTypes.T_VOID,
        ProofFrogTypes.T_INT,
        ProofFrogTypes.T_MAP,
        ProofFrogTypes.T_ARRAY,
        ProofFrogTypes.T_BITSTRING
    );

    // Comments
    TokenSet COMMENTS = TokenSet.create(
        ProofFrogTypes.V_LINE_COMMENT
    );

}
