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
        new AttributesDescriptor("Identifiers//Method name", ProofFrogSemanticHighlighter.METHOD_NAME),
        new AttributesDescriptor("Identifiers//Method call", ProofFrogSemanticHighlighter.METHOD_CALL),
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
            "var", ProofFrogSemanticHighlighter.LOCAL_VARIABLE,
            "param", ProofFrogSemanticHighlighter.PARAMETER,
            "call", ProofFrogSemanticHighlighter.METHOD_CALL
        );
    }

    @NotNull
    @Override
    public String getDemoText() {
        return """
            // Scheme file
            import 'examples/Primitives/SymEnc.primitive';
            import 'examples/Primitives/PRF.primitive';
            
            Scheme <class>OFB</class>(Int <param>lambda</param>, Int <param>blocks</param>, PRF <param>F</param>) extends SymEnc {
                requires F.lambda == lambda && F.input == lambda && F.out == lambda;
            
                Set Key = BitString<lambda>;
                Set Message = Array<BitString<lambda>, blocks>;
                Set Ciphertext = Array<BitString<lambda>, blocks + 1>;
            
                Ciphertext Enc(Key k, Message m) {
                    Ciphertext c;
                    BitString<lambda> r <- BitString<lambda>;
            
                    c[0] = r;
                    for (Int i = 1 to blocks) {
                        r = F.<call>evaluate</call>(k, r);
                        c[i] = r + m[i-1];
                    }
                    return c;
                }
            }
            
            // Proof file
            import 'examples/Primitives/SymEnc.primitive';
            import 'examples/Games/SymEnc/CPA.game';
            import 'examples/Games/SymEnc/CPA$.game';
            
            Reduction <class>R1</class>(SymEnc <param>E</param>) compose CPA$(E) against CPA(E).Adversary {
                E.Ciphertext Eavesdrop(E.Message <param>mL</param>, E.Message <param>mR</param>) {
                    return challenger.<call>CTXT</call>(<param>mL</param>);
                }
            }

            proof:
                let:
                    Set MessageSpace;
                    Set CiphertextSpace;
                    Set KeySpace;
                    SymEnc E = <call>SymEnc</call>(MessageSpace, CiphertextSpace, KeySpace);
                assume:
                    CPA$(E);
                theorem:
                    CPA(E);
                games:
                    CPA(E).Left against CPA(E).Adversary;
                    CPA$(E).Real compose R1(E) against CPA(E).Adversary;
                    CPA$(E).Random compose R1(E) against CPA(E).Adversary;
                    CPA(E).Right against CPA(E).Adversary;
            """;
    }

}
