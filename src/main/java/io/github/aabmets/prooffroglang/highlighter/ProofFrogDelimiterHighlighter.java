package io.github.aabmets.prooffroglang.highlighter;

import io.github.aabmets.prooffroglang.psi.ProofFrogTokenSets;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.Nullable;

public class ProofFrogDelimiterHighlighter implements ProofFrogTokenHighlighter {

    public static final TextAttributesKey KEY =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_DELIMITER",
            DefaultLanguageHighlighterColors.SEMICOLON
        );

    private static final TextAttributesKey[] KEYS = new TextAttributesKey[]{KEY};

    @Override
    @Nullable
    public TextAttributesKey[] getKeys(IElementType elementType) {
        if (ProofFrogTokenSets.DELIMITERS.contains(elementType)) {
            return KEYS;
        }
        return null;
    }

}
