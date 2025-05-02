package io.github.aabmets.prooffroglang;

import com.intellij.lang.Language;

public class ProofFrogLanguage extends Language {

    public static final ProofFrogLanguage INSTANCE = new ProofFrogLanguage();

    private ProofFrogLanguage() {
        super("ProofFrog");
    }

}
