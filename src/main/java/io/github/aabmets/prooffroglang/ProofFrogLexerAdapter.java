package io.github.aabmets.prooffroglang;

import com.intellij.lexer.FlexAdapter;

public class ProofFrogLexerAdapter extends FlexAdapter {

    public ProofFrogLexerAdapter() {
        super(new ProofFrogLexer(null));
    }

}
