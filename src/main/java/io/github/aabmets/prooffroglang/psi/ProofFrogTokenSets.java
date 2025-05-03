package io.github.aabmets.prooffroglang.psi;

import com.intellij.psi.tree.TokenSet;

public interface ProofFrogTokenSets {

    // Keywords
    TokenSet KEYWORDS = TokenSet.create(
        ProofFrogTypes.IMPORT,
        ProofFrogTypes.EXPORT,
        ProofFrogTypes.AS
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
