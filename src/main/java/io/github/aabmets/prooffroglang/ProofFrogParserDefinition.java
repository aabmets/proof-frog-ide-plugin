package io.github.aabmets.prooffroglang;

import io.github.aabmets.prooffroglang.parser.ProofFrogParser;
import io.github.aabmets.prooffroglang.psi.ProofFrogFile;
import io.github.aabmets.prooffroglang.psi.ProofFrogTokenSets;
import io.github.aabmets.prooffroglang.psi.ProofFrogTypes;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

final class ProofFrogParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(ProofFrogLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new ProofFrogLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return ProofFrogTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new ProofFrogParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new ProofFrogFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return ProofFrogTypes.Factory.createElement(node);
    }

}
