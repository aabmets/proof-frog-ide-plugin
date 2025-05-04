package io.github.aabmets.prooffroglang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.source.resolve.FileContextUtil;
import com.intellij.openapi.util.io.FileUtilRt;
import org.jetbrains.annotations.NotNull;

public class ProofFrogParserUtil extends GeneratedParserUtilBase {
    private static @NotNull String getExtension(@NotNull PsiBuilder builder) {
        PsiFile file = builder.getUserData(FileContextUtil.CONTAINING_FILE_KEY);
        if (file == null) {
            return "";
        }
        String name = file.getVirtualFile() != null
                ? file.getVirtualFile().getName()
                : file.getName();
        return FileUtilRt.getExtension(name);
    }

    public static boolean isPrimitiveFile(PsiBuilder builder, int level) {
        return "primitive".equals(getExtension(builder));
    }

    public static boolean isSchemeFile(PsiBuilder builder, int level) {
        return "scheme".equals(getExtension(builder));
    }

    public static boolean isGameFile(PsiBuilder builder, int level) {
        return "game".equals(getExtension(builder));
    }

    public static boolean isProofFile(PsiBuilder builder, int level) {
        return "proof".equals(getExtension(builder));
    }

}
