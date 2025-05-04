package io.github.aabmets.prooffroglang.highlighter;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.tree.IElementType;
import io.github.aabmets.prooffroglang.psi.ProofFrogTokenSets;
import org.jetbrains.annotations.Nullable;

public class ProofFrogVariousHighlighter implements ProofFrogTokenHighlighter {

    public static final TextAttributesKey CLASS_KEYWORDS =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_CLASS_KEYWORDS",
            DefaultLanguageHighlighterColors.KEYWORD
        );

    public static final TextAttributesKey NAMED_BLOCK =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_NAMED_BLOCK",
            DefaultLanguageHighlighterColors.INTERFACE_NAME
        );

    public static final TextAttributesKey PROPERTY =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_PROPERTY",
            DefaultLanguageHighlighterColors.INSTANCE_FIELD
        );

    private static final TextAttributesKey[] CLASS_KEYWORD_KEYS = new TextAttributesKey[]{CLASS_KEYWORDS};
    private static final TextAttributesKey[] NAMED_BLOCK_KEYS = new TextAttributesKey[]{NAMED_BLOCK};
    private static final TextAttributesKey[] PROPERTY_KEYS = new TextAttributesKey[]{PROPERTY};

    @Override
    @Nullable
    public TextAttributesKey[] getKeys(IElementType elementType) {
        if (ProofFrogTokenSets.CLASS_KEYWORDS.contains(elementType)) {
            return CLASS_KEYWORD_KEYS;
        } else if (ProofFrogTokenSets.NAMED_BLOCKS.contains(elementType)) {
            return NAMED_BLOCK_KEYS;
        } else if (ProofFrogTokenSets.PROPERTIES.contains(elementType)) {
            return PROPERTY_KEYS;
        }
        return null;
    }

}
