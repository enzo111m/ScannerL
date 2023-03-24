package analex;
import static analex.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z]+
N=[0,1]+
S=[ ,\t,\r,\n]+
%{
    public String lexema;
%}
%%
{S} {/*Ignore*/}

"{" {return LLAVE_APERTURA;}
"}" {return LLAVE_CIERRE;}
"(" {return PARENTESIS_ABRIR;}
")" {return PARENTESIS_CIERRE;}
"[" {return CORCHETE_APERTURA;}
"]" {return CORCHETE_CIERRE;}

"=" {return IGUAL;}
"|" {return OR;}
"&" {return AND;}
"!" {return NOT;}
";" {return SEPARADOR;}
{L}({L}|{N})* {lexema=yytext(); return IDENTIFICADOR;}
("(-"{N}+")")|{N}+ {lexema=yytext(); return NUMERO;}
 . {return NO_DEFINIDO;}
