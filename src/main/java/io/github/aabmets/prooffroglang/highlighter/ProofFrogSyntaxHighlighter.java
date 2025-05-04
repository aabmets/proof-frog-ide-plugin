package io.github.aabmets.prooffroglang.highlighter;

import io.github.aabmets.prooffroglang.ProofFrogLexerAdapter;

import java.util.List;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class ProofFrogSyntaxHighlighter extends SyntaxHighlighterBase {

    private final List<ProofFrogTokenHighlighter> highlighters = List.of(
        new ProofFrogDatatypeHighlighter(),
        new ProofFrogDelimiterHighlighter(),
        new ProofFrogKeywordHighlighter(),
        new ProofFrogLabelHighlighter(),
        new ProofFrogOperatorHighlighter(),
        new ProofFrogStructureHighlighter(),
        new ProofFrogVariousHighlighter(),
        new ProofFrogValueHighlighter()
    );

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new ProofFrogLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        for (ProofFrogTokenHighlighter h : highlighters) {
            TextAttributesKey[] keys = h.getKeys(tokenType);
            if (keys != null) {
                return keys;
            }
        }
        return EMPTY_KEYS;
    }
}
