package io.github.aabmets.prooffroglang.highlighter;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import io.github.aabmets.prooffroglang.psi.ProofFrogTypes;
import org.jetbrains.annotations.Nullable;

public class ProofFrogValueHighlighter implements ProofFrogTokenHighlighter {

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

    public static final TextAttributesKey BAD_CHARACTER =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_BAD_CHARACTER",
            HighlighterColors.BAD_CHARACTER
        );

    private static final TextAttributesKey[] BOOLEAN_KEYS = new TextAttributesKey[]{BOOLEAN};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] BAD_CHARACTER_KEYS = new TextAttributesKey[]{BAD_CHARACTER};

    @Override
    @Nullable
    public TextAttributesKey[] getKeys(IElementType elementType) {
        if (elementType == ProofFrogTypes.VL_BOOL) {
            return BOOLEAN_KEYS;
        } else if (elementType == ProofFrogTypes.VL_INT) {
            return NUMBER_KEYS;
        } else if (elementType == ProofFrogTypes.VL_BINARYNUM) {
            return NUMBER_KEYS;
        } else if (elementType == ProofFrogTypes.VL_LINE_COMMENT) {
            return COMMENT_KEYS;
        } else if (elementType == ProofFrogTypes.VL_FILE_PATH) {
            return STRING_KEYS;
        } else if (elementType == TokenType.BAD_CHARACTER) {
            return BAD_CHARACTER_KEYS;
        }
        return null;
    }

}
