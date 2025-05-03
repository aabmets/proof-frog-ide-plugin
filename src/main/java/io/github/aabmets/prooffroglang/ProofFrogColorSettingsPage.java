package io.github.aabmets.prooffroglang;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Map;

public class ProofFrogColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[] {
        new AttributesDescriptor("Keywords", ProofFrogSyntaxHighlighter.KEYWORD),
        new AttributesDescriptor("String literal", ProofFrogSyntaxHighlighter.STRING),
        new AttributesDescriptor("Line comment", ProofFrogSyntaxHighlighter.COMMENT),
        new AttributesDescriptor("Semicolon", ProofFrogSyntaxHighlighter.SEMICOLON),
        new AttributesDescriptor("Bad character", ProofFrogSyntaxHighlighter.BAD_CHARACTER),
    };

    @NotNull
    @Override
    public String getDisplayName() {
        return "ProofFrog";
    }

    @Override
    public Icon getIcon() {
        return ProofFrogIcons.FILE;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new ProofFrogSyntaxHighlighter();
    }

    @NotNull
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return Map.of();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return """
            // Example ProofFrog code
            import 'EncDec.primitive' as Cipher;
            
            export as Security;
            """;
    }

}
