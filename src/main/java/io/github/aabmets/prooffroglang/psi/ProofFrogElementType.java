package io.github.aabmets.prooffroglang.psi;

import io.github.aabmets.prooffroglang.ProofFrogLanguage;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ProofFrogElementType extends IElementType {

    public ProofFrogElementType(@NotNull @NonNls String debugName) {
        super(debugName, ProofFrogLanguage.INSTANCE);
    }

}
