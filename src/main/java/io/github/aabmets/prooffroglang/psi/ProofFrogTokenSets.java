package io.github.aabmets.prooffroglang.psi;

import com.intellij.psi.tree.TokenSet;

public interface ProofFrogTokenSets {

    // Keywords
    TokenSet KEYWORDS = TokenSet.create(
        ProofFrogTypes.IMPORT,
        ProofFrogTypes.EXPORT,
        ProofFrogTypes.AS
    );

    // Data types
    TokenSet DATATYPES = TokenSet.create(
        ProofFrogTypes.SET,
        ProofFrogTypes.BOOL,
        ProofFrogTypes.VOID,
        ProofFrogTypes.INT,
        ProofFrogTypes.MAP,
        ProofFrogTypes.BITSTRING,
        ProofFrogTypes.ARRAY
    );

    // Identifiers
    TokenSet IDENTIFIERS = TokenSet.create(
        ProofFrogTypes.ID
    );

    // Comments
    TokenSet COMMENTS = TokenSet.create(
        ProofFrogTypes.LINE_COMMENT
    );

    // String literals
    TokenSet STRINGS = TokenSet.create(
        ProofFrogTypes.FILESTRING
    );

    // Whitespaces
    TokenSet WHITESPACES = TokenSet.create(
        com.intellij.psi.TokenType.WHITE_SPACE
    );

}
