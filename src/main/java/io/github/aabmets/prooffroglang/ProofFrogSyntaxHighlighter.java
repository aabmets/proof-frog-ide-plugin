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

    public static final TextAttributesKey PUNCTUATION =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_PUNCTUATION",
            DefaultLanguageHighlighterColors.SEMICOLON
        );

    public static final TextAttributesKey STRUCTURE =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_STRUCTURE",
            DefaultLanguageHighlighterColors.BRACES
        );

    public static final TextAttributesKey OPERATOR =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_OPERATOR",
            DefaultLanguageHighlighterColors.OPERATION_SIGN
        );

    public static final TextAttributesKey KEYWORD =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_KEYWORD",
            DefaultLanguageHighlighterColors.KEYWORD
        );

    public static final TextAttributesKey LABEL =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_LABEL",
            DefaultLanguageHighlighterColors.LABEL
        );

    public static final TextAttributesKey CLASS_DECLARATOR =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_CLASS_DECLARATOR",
            DefaultLanguageHighlighterColors.KEYWORD
        );

    public static final TextAttributesKey PROPERTY =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_PROPERTY",
            DefaultLanguageHighlighterColors.INSTANCE_FIELD
        );

    public static final TextAttributesKey NAMED_BLOCK =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_NAMED_BLOCK",
            DefaultLanguageHighlighterColors.INTERFACE_NAME
        );

    public static final TextAttributesKey DATATYPE =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_DATATYPE",
            DefaultLanguageHighlighterColors.CLASS_NAME
        );

    public static final TextAttributesKey BOOLEAN =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_BOOLEAN",
            DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL
        );

    public static final TextAttributesKey NUMBER =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_NUMBER",
            DefaultLanguageHighlighterColors.NUMBER
        );

    public static final TextAttributesKey COMMENT =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT
        );

    public static final TextAttributesKey STRING =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_STRING",
            DefaultLanguageHighlighterColors.STRING
        );

    public static final TextAttributesKey IDENTIFIER =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_IDENTIFIER",
            DefaultLanguageHighlighterColors.IDENTIFIER
        );

    public static final TextAttributesKey BAD_CHARACTER =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_BAD_CHARACTER",
            HighlighterColors.BAD_CHARACTER
        );

    private static final TextAttributesKey[] PUNCTUATION_KEYS = new TextAttributesKey[]{PUNCTUATION};
    private static final TextAttributesKey[] STRUCTURE_KEYS = new TextAttributesKey[]{STRUCTURE};
    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] LABEL_KEYS  = new TextAttributesKey[]{LABEL};
    private static final TextAttributesKey[] CLASS_DECLARATOR_KEYS  = new TextAttributesKey[]{CLASS_DECLARATOR};
    private static final TextAttributesKey[] PROPERTY_KEYS  = new TextAttributesKey[]{PROPERTY};
    private static final TextAttributesKey[] NAMED_BLOCK_KEYS  = new TextAttributesKey[]{NAMED_BLOCK};
    private static final TextAttributesKey[] DATATYPE_KEYS = new TextAttributesKey[]{DATATYPE};
    private static final TextAttributesKey[] BOOLEAN_KEYS = new TextAttributesKey[]{BOOLEAN};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new ProofFrogLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (ProofFrogTokenSets.PUNCTUATION.contains(tokenType)) {
            return PUNCTUATION_KEYS;
        } else if (ProofFrogTokenSets.STRUCTURE.contains(tokenType)) {
            return STRUCTURE_KEYS;
        } else if (ProofFrogTokenSets.OPERATORS.contains(tokenType)) {
            return OPERATOR_KEYS;
        } else if (ProofFrogTokenSets.KEYWORDS.contains(tokenType)) {
            return KEYWORD_KEYS;
        } else if (ProofFrogTokenSets.LABELS.contains(tokenType)) {
            return LABEL_KEYS;
        } else if (ProofFrogTokenSets.CLASS_DECLARATORS.contains(tokenType)) {
            return CLASS_DECLARATOR_KEYS;
        } else if (ProofFrogTokenSets.PROPERTIES.contains(tokenType)) {
            return PROPERTY_KEYS;
        } else if (ProofFrogTokenSets.NAMED_BLOCKS.contains(tokenType)) {
            return NAMED_BLOCK_KEYS;
        } else if (ProofFrogTokenSets.DATATYPES.contains(tokenType)) {
            return DATATYPE_KEYS;
        } else if (tokenType.equals(ProofFrogTypes.VL_BOOL)) {
            return BOOLEAN_KEYS;
        } else if (tokenType.equals(ProofFrogTypes.VL_INT)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(ProofFrogTypes.VL_BINARYNUM)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(ProofFrogTypes.VL_LINE_COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(ProofFrogTypes.VL_FILE_PATH)) {
            return STRING_KEYS;
        } else if (tokenType.equals(ProofFrogTypes.VL_IDENTIFIER)) {
            return IDENTIFIER_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
