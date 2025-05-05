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
        new AttributesDescriptor("General//Delimiters", ProofFrogDelimiterHighlighter.KEY),
        new AttributesDescriptor("General//Structure", ProofFrogStructureHighlighter.KEY),
        new AttributesDescriptor("General//Operators", ProofFrogOperatorHighlighter.KEY),
        new AttributesDescriptor("General//Keywords", ProofFrogKeywordHighlighter.KEY),
        new AttributesDescriptor("General//Data types", ProofFrogDatatypeHighlighter.KEY),
        new AttributesDescriptor("General//Labels", ProofFrogLabelHighlighter.KEY),
        new AttributesDescriptor("General//Method calls", ProofFrogSemanticHighlighter.METHOD_CALL),
        new AttributesDescriptor("Various//Class keywords", ProofFrogVariousHighlighter.CLASS_KEYWORDS),
        new AttributesDescriptor("Various//Properties", ProofFrogVariousHighlighter.PROPERTY),
        new AttributesDescriptor("Various//Named blocks", ProofFrogVariousHighlighter.NAMED_BLOCK),
        new AttributesDescriptor("Various//Bad characters", ProofFrogValueHighlighter.BAD_CHARACTER),
        new AttributesDescriptor("Literals//Booleans", ProofFrogValueHighlighter.BOOLEAN),
        new AttributesDescriptor("Literals//Numbers", ProofFrogValueHighlighter.NUMBER),
        new AttributesDescriptor("Literals//Strings", ProofFrogValueHighlighter.STRING),
        new AttributesDescriptor("Literals//Comments", ProofFrogValueHighlighter.COMMENT),
        new AttributesDescriptor("Identifiers//Class names", ProofFrogSemanticHighlighter.CLASS_NAME),
        new AttributesDescriptor("Identifiers//Local variables", ProofFrogSemanticHighlighter.LOCAL_VARIABLE),
        new AttributesDescriptor("Identifiers//Method parameters", ProofFrogSemanticHighlighter.PARAMETER),
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
