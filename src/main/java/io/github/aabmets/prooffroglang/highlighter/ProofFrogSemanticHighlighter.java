package io.github.aabmets.prooffroglang.highlighter;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

public class ProofFrogSemanticHighlighter {

    public static final TextAttributesKey CLASS_NAME =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_CLASS_NAME",
            DefaultLanguageHighlighterColors.CLASS_NAME
        );

    public static final TextAttributesKey CLASS_INSTANTIATION =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_CLASS_INSTANTIATION",
            DefaultLanguageHighlighterColors.FUNCTION_CALL
        );

    public static final TextAttributesKey CLASS_FIELD =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_CLASS_FIELD",
            DefaultLanguageHighlighterColors.STATIC_FIELD
        );

    public static final TextAttributesKey LOCAL_VARIABLE =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_LOCAL_VARIABLE",
            DefaultLanguageHighlighterColors.LOCAL_VARIABLE
        );

    public static final TextAttributesKey PARAMETER =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_PARAMETER",
            DefaultLanguageHighlighterColors.PARAMETER
        );

    public static final TextAttributesKey METHOD_CALL =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_METHOD_CALL",
            DefaultLanguageHighlighterColors.FUNCTION_CALL
        );

    public static final TextAttributesKey METHOD_NAME =
        TextAttributesKey.createTextAttributesKey(
            "PROOFFROG_METHOD_NAME",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
        );

}
