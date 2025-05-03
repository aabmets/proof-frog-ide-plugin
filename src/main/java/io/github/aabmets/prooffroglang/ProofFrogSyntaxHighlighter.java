package io.github.aabmets.prooffroglang;

import io.github.aabmets.prooffroglang.psi.ProofFrogTypes;
import io.github.aabmets.prooffroglang.psi.ProofFrogTokenSets;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class ProofFrogSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey KEYWORD =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_KEYWORD",
            DefaultLanguageHighlighterColors.KEYWORD
        );

    public static final TextAttributesKey STRING =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_STRING",
            DefaultLanguageHighlighterColors.STRING
        );

    public static final TextAttributesKey COMMENT =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT
        );

    public static final TextAttributesKey SEMICOLON =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_SEMICOLON",
            DefaultLanguageHighlighterColors.SEMICOLON
        );

    public static final TextAttributesKey BAD_CHARACTER =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_BAD_CHARACTER",
            HighlighterColors.BAD_CHARACTER
        );

    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] SEMICOLON_KEYS = new TextAttributesKey[]{SEMICOLON};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new ProofFrogLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (ProofFrogTokenSets.KEYWORDS.contains(tokenType)) {
            return KEYWORD_KEYS;
        } else if (tokenType.equals(ProofFrogTypes.FILESTRING)) {
            return STRING_KEYS;
        } else if (tokenType.equals(ProofFrogTypes.LINE_COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(ProofFrogTypes.SEMI)) {
            return SEMICOLON_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
