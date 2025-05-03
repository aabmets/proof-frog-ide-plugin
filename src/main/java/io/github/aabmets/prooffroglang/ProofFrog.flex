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
P_SEMIC=";"
P_COLON=":"
P_COMMA=","
P_PERIOD="."

// --------- Structure ---------
S_BRACE_L="{"
S_BRACE_R="}"
S_BRACKET_L="["
S_BRACKET_R="]"
S_PAREN_L="("
S_PAREN_R=")"

// --------- Operators ---------
O_SMPL="<-"
O_ASGN="="
O_MULT="*"
O_ADD="+"
O_SUB="-"
O_DIV="/"
O_EQ="=="
O_OPT="?"
O_NOT="!"
O_NEQ="!="
O_GT=">"
O_GEQ=">="
O_LEQ="<="
O_LT="<"
O_OR="||"
O_AND="&&"
O_VBAR="|"
O_BSLASH="\\"

// --------- Keywords ---------
K_IMPORT="import"
K_EXPORT="export"
K_RETURN="return"
K_SUBSETS="subsets"
K_ORACLES="oracles"
K_AGAINST="against"
K_COMPOSE="compose"
K_THEOREM="theorem"
K_EXTENDS="extends"
K_REQUIRES="requires"
K_INDUCTION="induction"
K_ASSUME="assume"
K_PROOF="proof"
K_GAMES="games"
K_UNION="union"
K_CALLS="calls"
K_FROM="from"
K_ELSE="else"
K_LET="let"
K_FOR="for"
K_IF="if"
K_TO="to"
K_IN="in"
K_AS="as"
K_NONE="None"

// --------- Functions ---------
F_ADVERSARY="Adversary"
F_PRIMITIVE="Primitive"
F_REDUCTION="Reduction"
F_SCHEME="Scheme"
F_PHASE="Phase"
F_GAME="Game"

// --------- Datatypes ---------
T_SET="Set"
T_BOOL="Bool"
T_VOID="Void"
T_INT="Int"
T_MAP="Map"
T_ARRAY="Array"
T_BITSTRING="BitString"

// --------- Values ---------
V_BOOL=true|false
V_INT=[0-9]+
V_BINARYNUM="0b"[01]+
V_LINE_COMMENT="//".*
V_FILESTRING=\'([-0-9a-zA-Z_$/.=>< ]+)\'
V_IDENT=[a-zA-Z_$][a-zA-Z_0-9$]*
V_WHITE_SPACE=[ \t\r\n]+

%%

// --------- Punctuation ---------
{P_SEMIC}          { return ProofFrogTypes.P_SEMIC; }
{P_COLON}          { return ProofFrogTypes.P_COLON; }
{P_COMMA}          { return ProofFrogTypes.P_COMMA; }
{P_PERIOD}         { return ProofFrogTypes.P_PERIOD; }

// --------- Structure ---------
{S_BRACE_L}        { return ProofFrogTypes.S_BRACE_L; }
{S_BRACE_R}        { return ProofFrogTypes.S_BRACE_R; }
{S_BRACKET_L}      { return ProofFrogTypes.S_BRACKET_L; }
{S_BRACKET_R}      { return ProofFrogTypes.S_BRACKET_R; }
{S_PAREN_L}        { return ProofFrogTypes.S_PAREN_L; }
{S_PAREN_R}        { return ProofFrogTypes.S_PAREN_R; }

// --------- Operators ---------
{O_SMPL}           { return ProofFrogTypes.O_SMPL; }
{O_ASGN}           { return ProofFrogTypes.O_ASGN; }
{O_MULT}           { return ProofFrogTypes.O_MULT; }
{O_ADD}            { return ProofFrogTypes.O_ADD; }
{O_SUB}            { return ProofFrogTypes.O_SUB; }
{O_DIV}            { return ProofFrogTypes.O_DIV; }
{O_EQ}             { return ProofFrogTypes.O_EQ; }
{O_OPT}            { return ProofFrogTypes.O_OPT; }
{O_NOT}            { return ProofFrogTypes.O_NOT; }
{O_NEQ}            { return ProofFrogTypes.O_NEQ; }
{O_GT}             { return ProofFrogTypes.O_GT; }
{O_GEQ}            { return ProofFrogTypes.O_GEQ; }
{O_LEQ}            { return ProofFrogTypes.O_LEQ; }
{O_LT}             { return ProofFrogTypes.O_LT; }
{O_OR}             { return ProofFrogTypes.O_OR; }
{O_AND}            { return ProofFrogTypes.O_AND; }
{O_VBAR}           { return ProofFrogTypes.O_VBAR; }
{O_BSLASH}         { return ProofFrogTypes.O_BSLASH; }

// --------- Keywords ---------
{K_IMPORT}         { return ProofFrogTypes.K_IMPORT; }
{K_EXPORT}         { return ProofFrogTypes.K_EXPORT; }
{K_RETURN}         { return ProofFrogTypes.K_RETURN; }
{K_SUBSETS}        { return ProofFrogTypes.K_SUBSETS; }
{K_ORACLES}        { return ProofFrogTypes.K_ORACLES; }
{K_AGAINST}        { return ProofFrogTypes.K_AGAINST; }
{K_COMPOSE}        { return ProofFrogTypes.K_COMPOSE; }
{K_THEOREM}        { return ProofFrogTypes.K_THEOREM; }
{K_EXTENDS}        { return ProofFrogTypes.K_EXTENDS; }
{K_REQUIRES}       { return ProofFrogTypes.K_REQUIRES; }
{K_INDUCTION}      { return ProofFrogTypes.K_INDUCTION; }
{K_ASSUME}         { return ProofFrogTypes.K_ASSUME; }
{K_PROOF}          { return ProofFrogTypes.K_PROOF; }
{K_GAMES}          { return ProofFrogTypes.K_GAMES; }
{K_UNION}          { return ProofFrogTypes.K_UNION; }
{K_CALLS}          { return ProofFrogTypes.K_CALLS; }
{K_FROM}           { return ProofFrogTypes.K_FROM; }
{K_ELSE}           { return ProofFrogTypes.K_ELSE; }
{K_LET}            { return ProofFrogTypes.K_LET; }
{K_FOR}            { return ProofFrogTypes.K_FOR; }
{K_IF}             { return ProofFrogTypes.K_IF; }
{K_TO}             { return ProofFrogTypes.K_TO; }
{K_IN}             { return ProofFrogTypes.K_IN; }
{K_AS}             { return ProofFrogTypes.K_AS; }
{K_NONE}           { return ProofFrogTypes.K_NONE; }

// --------- Functions ---------
{F_ADVERSARY}      { return ProofFrogTypes.F_ADVERSARY; }
{F_PRIMITIVE}      { return ProofFrogTypes.F_PRIMITIVE; }
{F_REDUCTION}      { return ProofFrogTypes.F_REDUCTION; }
{F_SCHEME}         { return ProofFrogTypes.F_SCHEME; }
{F_PHASE}          { return ProofFrogTypes.F_PHASE; }
{F_GAME}           { return ProofFrogTypes.F_GAME; }

// --------- Data types ---------
{T_SET}            { return ProofFrogTypes.T_SET; }
{T_BOOL}           { return ProofFrogTypes.T_BOOL; }
{T_VOID}           { return ProofFrogTypes.T_VOID; }
{T_INT}            { return ProofFrogTypes.T_INT; }
{T_MAP}            { return ProofFrogTypes.T_MAP; }
{T_ARRAY}          { return ProofFrogTypes.T_ARRAY; }
{T_BITSTRING}      { return ProofFrogTypes.T_BITSTRING; }

// --------- Values ---------
{V_BOOL}           { return ProofFrogTypes.V_BOOL; }
{V_INT}            { return ProofFrogTypes.V_INT; }
{V_BINARYNUM}      { return ProofFrogTypes.V_BINARYNUM; }
{V_LINE_COMMENT}   { return ProofFrogTypes.V_LINE_COMMENT; }
{V_FILESTRING}     { return ProofFrogTypes.V_FILESTRING; }
{V_IDENT}          { return ProofFrogTypes.V_IDENT; }
{V_WHITE_SPACE}    { return TokenType.WHITE_SPACE; }

// --------- Fallback ---------
[^]                { return TokenType.BAD_CHARACTER; }