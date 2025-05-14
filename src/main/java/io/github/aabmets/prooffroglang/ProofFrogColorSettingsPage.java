package io.github.aabmets.prooffroglang;

import io.github.aabmets.prooffroglang.highlighter.*;

import javax.swing.*;
import java.util.Map;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;

public class ProofFrogColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[] {
        // Keywords and Identifiers
        new AttributesDescriptor("Keywords//General", ProofFrogKeywordHighlighter.KEY),
        new AttributesDescriptor("Keywords//Class", ProofFrogVariousHighlighter.CLASS_KEYWORDS),
        new AttributesDescriptor("Identifiers//Class", ProofFrogSemanticHighlighter.CLASS_NAME),
        new AttributesDescriptor("Identifiers//Method", ProofFrogSemanticHighlighter.METHOD_CALL),
        new AttributesDescriptor("Identifiers//Parameter", ProofFrogSemanticHighlighter.PARAMETER),
        new AttributesDescriptor("Identifiers//Local variable", ProofFrogSemanticHighlighter.LOCAL_VARIABLE),

        // Literals and Values
        new AttributesDescriptor("Literals//File import path", ProofFrogValueHighlighter.STRING),
        new AttributesDescriptor("Literals//Number", ProofFrogValueHighlighter.NUMBER),
        new AttributesDescriptor("Literals//Boolean", ProofFrogValueHighlighter.BOOLEAN),

        // Operators and Delimiters
        new AttributesDescriptor("Operators//Operator", ProofFrogOperatorHighlighter.KEY),
        new AttributesDescriptor("Operators//Delimiter", ProofFrogDelimiterHighlighter.KEY),

        // Language Elements
        new AttributesDescriptor("Language//Data types", ProofFrogDatatypeHighlighter.KEY),
        new AttributesDescriptor("Language//Structure", ProofFrogStructureHighlighter.KEY),
        new AttributesDescriptor("Language//Property", ProofFrogVariousHighlighter.PROPERTY),
        new AttributesDescriptor("Language//Label", ProofFrogLabelHighlighter.KEY),
        new AttributesDescriptor("Language//Named block", ProofFrogVariousHighlighter.NAMED_BLOCK),

        // Documentation
        new AttributesDescriptor("Documentation//Comments", ProofFrogValueHighlighter.COMMENT),

        // Errors
        new AttributesDescriptor("Errors//Bad characters", ProofFrogValueHighlighter.BAD_CHARACTER),
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
        return Map.of(
            "class", ProofFrogSemanticHighlighter.CLASS_NAME,
            "param", ProofFrogSemanticHighlighter.PARAMETER,
            "var", ProofFrogSemanticHighlighter.LOCAL_VARIABLE
        );
    }

    @NotNull
    @Override
    public String getDemoText() {
        return """
            // Example ProofFrog code
            import 'examples/Primitives/SecretSharing.primitive';
            
            Scheme <class>OTP</class>(Int length) extends SecretSharing {
                Set Message = BitString<length>;
                Set Shares = BitString<length>;
                Int shareCount = 2;
                Int threshold = 2;
            
                Array<Shares, shareCount> Share(Message <param>m</param>) {
                    BitString<length> <var>s0</var> <- BitString<l>;
                    BitString<length> <var>s1</var> = s1 + m;
                    return [s0, s1];
                }
            
                Message Reconstruct(Array<Shares, shareCount> <param>s</param>) {
                    return s[0] + s[1];
                }
            }
            """;
    }

}
