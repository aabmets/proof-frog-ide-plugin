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
        new AttributesDescriptor("Punctuation", ProofFrogSyntaxHighlighter.PUNCTUATION),
        new AttributesDescriptor("Structure", ProofFrogSyntaxHighlighter.STRUCTURE),
        new AttributesDescriptor("Operators", ProofFrogSyntaxHighlighter.OPERATORS),
        new AttributesDescriptor("Keywords", ProofFrogSyntaxHighlighter.KEYWORD),
        new AttributesDescriptor("Functions", ProofFrogSyntaxHighlighter.FUNCTION),
        new AttributesDescriptor("Data types", ProofFrogSyntaxHighlighter.DATATYPE),
        new AttributesDescriptor("Boolean literal", ProofFrogSyntaxHighlighter.BOOLEAN),
        new AttributesDescriptor("Number literal", ProofFrogSyntaxHighlighter.NUMBER),
        new AttributesDescriptor("String literal", ProofFrogSyntaxHighlighter.STRING),
        new AttributesDescriptor("Identifiers", ProofFrogSyntaxHighlighter.IDENTIFIER),
        new AttributesDescriptor("Line comment", ProofFrogSyntaxHighlighter.COMMENT),
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
            import 'examples/Primitives/SecretSharing.primitive';
            
            Scheme OTP(Int l) extends SecretSharing {
                Set Message = BitString<l>;
                Set Shares = BitString<l>;
                Int shareCount = 2;
                Int threshold = 2;
            
                Array<Shares, shareCount> Share(Message m) {
                    BitString<l> s0 <- BitString<l>;
                    BitString<l> s1 = s1 + m;
                    return [s0, s1];
                }
            
                Message Reconstruct(Array<Shares, shareCount> s) {
                    return s[0] + s[1];
                }
            }
            """;
    }

}
