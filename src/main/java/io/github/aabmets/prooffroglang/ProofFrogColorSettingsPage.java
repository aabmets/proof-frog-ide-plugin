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
        new AttributesDescriptor("Identifiers//Class name", ProofFrogSemanticHighlighter.CLASS_NAME),
        new AttributesDescriptor("Identifiers//Class instantiation", ProofFrogSemanticHighlighter.CLASS_INSTANTIATION),
        new AttributesDescriptor("Identifiers//Class field", ProofFrogSemanticHighlighter.CLASS_FIELD),
        new AttributesDescriptor("Identifiers//Method name", ProofFrogSemanticHighlighter.METHOD_NAME),
        new AttributesDescriptor("Identifiers//Method call", ProofFrogSemanticHighlighter.METHOD_CALL),
        new AttributesDescriptor("Identifiers//Parameter", ProofFrogSemanticHighlighter.PARAMETER),
        new AttributesDescriptor("Identifiers//Local variable", ProofFrogSemanticHighlighter.LOCAL_VARIABLE),

        // Literals and Values
        new AttributesDescriptor("Literals//File import path", ProofFrogLiteralHighlighter.STRING),
        new AttributesDescriptor("Literals//Number", ProofFrogLiteralHighlighter.NUMBER),
        new AttributesDescriptor("Literals//Boolean", ProofFrogLiteralHighlighter.BOOLEAN),

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
        new AttributesDescriptor("Documentation//Comments", ProofFrogLiteralHighlighter.COMMENT),

        // Errors
        new AttributesDescriptor("Errors//Bad characters", ProofFrogLiteralHighlighter.BAD_CHARACTER),
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
            "call", ProofFrogSemanticHighlighter.METHOD_CALL,
            "type", ProofFrogDatatypeHighlighter.KEY,
            "prop", ProofFrogVariousHighlighter.PROPERTY
        );
    }

    @NotNull
    @Override
    public String getDemoText() {
        return """
            // Scheme file
            import 'examples/Primitives/SymEnc.primitive';
            import 'examples/Primitives/PRF.primitive';
            
            Scheme <class>OFB</class>(Int lambda, Int blocks, PRF F) extends SymEnc {
                requires F.lambda == lambda && F.input == lambda && F.out == lambda;
            
                Set Key = BitString<lambda>;
                Set Message = Array<BitString<lambda>, blocks>;
                Set Ciphertext = Array<BitString<lambda>, blocks + 1>;
            
                <type>Ciphertext</type> <call>Enc</call>(<type>Key</type> <param>k</param>, <type>Message</type> <param>m</param>) {
                    <type>Ciphertext</type> c;
                    BitString<lambda> r <- BitString<lambda>;
            
                    c[0] = r;
                    for (Int i = 1 to blocks) {
                        r = F.<call>evaluate</call>(<param>k</param>, r);
                        c[i] = r + <param>m</param>[i-1];
                    }
                    return c;
                }
            }
            
            // Proof file
            import 'examples/Primitives/SymEnc.primitive';
            import 'examples/Games/SymEnc/CPA.game';
            import 'examples/Games/SymEnc/CPA$.game';
            
            Reduction <class>R1</class>(<type>SymEnc</type> E) compose <call>CPA$</call>(E) against <call>CPA</call>(E).Adversary {
                <type>E</type>.<type>Ciphertext</type> <call>Eavesdrop</call>(<type>E</type>.<type>Message</type> <param>mL</param>, <type>E</type>.<type>Message</type> <param>mR</param>) {
                    return <prop>challenger</prop>.<call>CTXT</call>(<param>mL</param>);
                }
            }

            proof:
                let:
                    Set MessageSpace;
                    Set CiphertextSpace;
                    Set KeySpace;
                    <type>SymEnc</type> E = <call>SymEnc</call>(MessageSpace, CiphertextSpace, KeySpace);
                assume:
                    <call>CPA$</call>(E);
                theorem:
                    <call>CPA</call>(E);
                games:
                    <call>CPA</call>(E).Left against <call>CPA</call>(E).Adversary;
                    <call>CPA$</call>(E).Real compose <call>R1</call>(E) against <call>CPA</call>(E).Adversary;
                    <call>CPA$</call>(E).Random compose <call>R1</call>(E) against <call>CPA</call>(E).Adversary;
                    <call>CPA</call>(E).Right against <call>CPA</call>(E).Adversary;
            """;
    }

}
