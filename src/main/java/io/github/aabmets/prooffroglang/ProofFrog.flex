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

// --------- Punctuation ---------
PN_SEMI=";"
PN_COLON=":"
PN_COMMA=","
PN_PERIOD="."

// --------- Structure ---------
ST_BRACE_L="{"
ST_BRACE_R="}"
ST_BRACKET_L="["
ST_BRACKET_R="]"
ST_PAREN_L="("
ST_PAREN_R=")"

// --------- Operators ---------
OP_SAMPLE="<-"
OP_ASSIGN="="
OP_MULT="*"
OP_ADD="+"
OP_SUB="-"
OP_DIV="/"
OP_EQ="=="
OP_OPT="?"
OP_NOT="!"
OP_NEQ="!="
OP_GT=">"
OP_GEQ=">="
OP_LEQ="<="
OP_LT="<"
OP_OR="||"
OP_AND="&&"
OP_VBAR="|"
OP_BSLASH="\\"

// --------- Keywords ---------
KW_IMPORT="import"
KW_EXPORT="export"
KW_RETURN="return"
KW_SUBSETS="subsets"
KW_ORACLES="oracles"
KW_AGAINST="against"
KW_COMPOSE="compose"
KW_EXTENDS="extends"
KW_REQUIRES="requires"
KW_INDUCTION="induction"
KW_UNION="union"
KW_CALLS="calls"
KW_FROM="from"
KW_ELSE="else"
KW_FOR="for"
KW_IF="if"
KW_TO="to"
KW_IN="in"
KW_AS="as"
KW_NONE="None"

// --------- Labels ---------
LB_PROOF="proof"
LB_LET="let"
LB_ASSUME="assume"
LB_THEOREM="theorem"
LB_GAMES="games"

// --------- Class declarators ---------
CL_PRIMITIVE="Primitive"
CL_REDUCTION="Reduction"
CL_SCHEME="Scheme"
CL_GAME="Game"

// --------- Properties ---------
PR_ADVERSARY="Adversary"

// --------- Named blocks ---------
NB_PHASE="Phase"

// --------- Datatypes ---------
DT_SET="Set"
DT_BOOL="Bool"
DT_VOID="Void"
DT_INT="Int"
DT_MAP="Map"
DT_ARRAY="Array"
DT_BITSTRING="BitString"

// --------- Values ---------
VL_BOOL=true|false
VL_INT=[0-9]+
VL_BINARYNUM="0b"[01]+
VL_LINE_COMMENT="//".*
VL_FILESTRING=\'([-0-9a-zA-Z_$/.=>< ]+)\'
VL_IDENT=[a-zA-Z_$][a-zA-Z_0-9$]*
VL_WHITE_SPACE=[ \t\r\n]+

%%

// --------- Punctuation ---------
{PN_SEMI}           { return ProofFrogTypes.PN_SEMI; }
{PN_COLON}          { return ProofFrogTypes.PN_COLON; }
{PN_COMMA}          { return ProofFrogTypes.PN_COMMA; }
{PN_PERIOD}         { return ProofFrogTypes.PN_PERIOD; }

// --------- Structure ---------
{ST_BRACE_L}        { return ProofFrogTypes.ST_BRACE_L; }
{ST_BRACE_R}        { return ProofFrogTypes.ST_BRACE_R; }
{ST_BRACKET_L}      { return ProofFrogTypes.ST_BRACKET_L; }
{ST_BRACKET_R}      { return ProofFrogTypes.ST_BRACKET_R; }
{ST_PAREN_L}        { return ProofFrogTypes.ST_PAREN_L; }
{ST_PAREN_R}        { return ProofFrogTypes.ST_PAREN_R; }

// --------- Operators ---------
{OP_SAMPLE}         { return ProofFrogTypes.OP_SAMPLE; }
{OP_ASSIGN}         { return ProofFrogTypes.OP_ASSIGN; }
{OP_MULT}           { return ProofFrogTypes.OP_MULT; }
{OP_ADD}            { return ProofFrogTypes.OP_ADD; }
{OP_SUB}            { return ProofFrogTypes.OP_SUB; }
{OP_DIV}            { return ProofFrogTypes.OP_DIV; }
{OP_EQ}             { return ProofFrogTypes.OP_EQ; }
{OP_OPT}            { return ProofFrogTypes.OP_OPT; }
{OP_NOT}            { return ProofFrogTypes.OP_NOT; }
{OP_NEQ}            { return ProofFrogTypes.OP_NEQ; }
{OP_GT}             { return ProofFrogTypes.OP_GT; }
{OP_GEQ}            { return ProofFrogTypes.OP_GEQ; }
{OP_LEQ}            { return ProofFrogTypes.OP_LEQ; }
{OP_LT}             { return ProofFrogTypes.OP_LT; }
{OP_OR}             { return ProofFrogTypes.OP_OR; }
{OP_AND}            { return ProofFrogTypes.OP_AND; }
{OP_VBAR}           { return ProofFrogTypes.OP_VBAR; }
{OP_BSLASH}         { return ProofFrogTypes.OP_BSLASH; }

// --------- Keywords ---------
{KW_IMPORT}         { return ProofFrogTypes.KW_IMPORT; }
{KW_EXPORT}         { return ProofFrogTypes.KW_EXPORT; }
{KW_RETURN}         { return ProofFrogTypes.KW_RETURN; }
{KW_SUBSETS}        { return ProofFrogTypes.KW_SUBSETS; }
{KW_ORACLES}        { return ProofFrogTypes.KW_ORACLES; }
{KW_AGAINST}        { return ProofFrogTypes.KW_AGAINST; }
{KW_COMPOSE}        { return ProofFrogTypes.KW_COMPOSE; }
{KW_EXTENDS}        { return ProofFrogTypes.KW_EXTENDS; }
{KW_REQUIRES}       { return ProofFrogTypes.KW_REQUIRES; }
{KW_INDUCTION}      { return ProofFrogTypes.KW_INDUCTION; }
{KW_UNION}          { return ProofFrogTypes.KW_UNION; }
{KW_CALLS}          { return ProofFrogTypes.KW_CALLS; }
{KW_FROM}           { return ProofFrogTypes.KW_FROM; }
{KW_ELSE}           { return ProofFrogTypes.KW_ELSE; }
{KW_FOR}            { return ProofFrogTypes.KW_FOR; }
{KW_IF}             { return ProofFrogTypes.KW_IF; }
{KW_TO}             { return ProofFrogTypes.KW_TO; }
{KW_IN}             { return ProofFrogTypes.KW_IN; }
{KW_AS}             { return ProofFrogTypes.KW_AS; }
{KW_NONE}           { return ProofFrogTypes.KW_NONE; }

// --------- Labels ---------
{LB_PROOF}          { return ProofFrogTypes.LB_PROOF; }
{LB_LET}            { return ProofFrogTypes.LB_LET; }
{LB_ASSUME}         { return ProofFrogTypes.LB_ASSUME; }
{LB_THEOREM}        { return ProofFrogTypes.LB_THEOREM; }
{LB_GAMES}          { return ProofFrogTypes.LB_GAMES; }

// --------- Class declarators ---------
{CL_PRIMITIVE}      { return ProofFrogTypes.CL_PRIMITIVE; }
{CL_REDUCTION}      { return ProofFrogTypes.CL_REDUCTION; }
{CL_SCHEME}         { return ProofFrogTypes.CL_SCHEME; }
{CL_GAME}           { return ProofFrogTypes.CL_GAME; }

// --------- Properties ---------
{PR_ADVERSARY}      { return ProofFrogTypes.PR_ADVERSARY; }

// --------- Named blocks ---------
{NB_PHASE}          { return ProofFrogTypes.NB_PHASE; }

// --------- Data types ---------
{DT_SET}            { return ProofFrogTypes.DT_SET; }
{DT_BOOL}           { return ProofFrogTypes.DT_BOOL; }
{DT_VOID}           { return ProofFrogTypes.DT_VOID; }
{DT_INT}            { return ProofFrogTypes.DT_INT; }
{DT_MAP}            { return ProofFrogTypes.DT_MAP; }
{DT_ARRAY}          { return ProofFrogTypes.DT_ARRAY; }
{DT_BITSTRING}      { return ProofFrogTypes.DT_BITSTRING; }

// --------- Values ---------
{VL_BOOL}           { return ProofFrogTypes.VL_BOOL; }
{VL_INT}            { return ProofFrogTypes.VL_INT; }
{VL_BINARYNUM}      { return ProofFrogTypes.VL_BINARYNUM; }
{VL_LINE_COMMENT}   { return ProofFrogTypes.VL_LINE_COMMENT; }
{VL_FILESTRING}     { return ProofFrogTypes.VL_FILESTRING; }
{VL_IDENT}          { return ProofFrogTypes.VL_IDENT; }
{VL_WHITE_SPACE}    { return TokenType.WHITE_SPACE; }

// --------- Fallback ---------
[^]                 { return TokenType.BAD_CHARACTER; }