package io.github.aabmets.prooffroglang;

import io.github.aabmets.prooffroglang.psi.ProofFrogTypes;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

%%

%class ProofFrogLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

WHITE_SPACE=[ \t\r\n]+
LINE_COMMENT="//".*
ID=[a-zA-Z_$][a-zA-Z_0-9$]*
FILESTRING=\'([-0-9a-zA-Z_$/.=>< ]+)\'
SEMI=";"
IMPORT="import"
EXPORT="export"
AS="as"

SET="Set"
BOOL="Bool"
VOID="Void"
INT="Int"
MAP="Map"
BITSTRING="BitString"
ARRAY="Array"

%%

// --------- Whitespaces and comments ---------
{WHITE_SPACE}    { return TokenType.WHITE_SPACE; }
{LINE_COMMENT}   { return ProofFrogTypes.LINE_COMMENT; }

// --------- Keywords ---------
{IMPORT}         { return ProofFrogTypes.IMPORT; }
{EXPORT}         { return ProofFrogTypes.EXPORT; }
{AS}             { return ProofFrogTypes.AS; }

// --------- Datatypes ---------
{SET}            { return ProofFrogTypes.SET; }
{BOOL}           { return ProofFrogTypes.BOOL; }
{VOID}           { return ProofFrogTypes.VOID; }
{INT}            { return ProofFrogTypes.INT; }
{MAP}            { return ProofFrogTypes.MAP; }
{BITSTRING}      { return ProofFrogTypes.BITSTRING; }
{ARRAY}          { return ProofFrogTypes.ARRAY; }

// --------- FILESTRING ---------
{FILESTRING}     { return ProofFrogTypes.FILESTRING; }

// --------- Identifiers ---------
{ID}             { return ProofFrogTypes.ID; }

// --------- Punctuation ---------
{SEMI}           { return ProofFrogTypes.SEMI; }

// --------- Fallback ---------
[^]              { return TokenType.BAD_CHARACTER; }