package binariosconpunto;
import java_cup.runtime.Symbol;


%%

%{
%}

%cup
%class scanner
%public
%line
%char
%column
%full

numeroBinario=[0-1]
punto ="."

/*Espacios*/
Espacios   = [\ \r\t\f]
Enter   = [\ \n]

%%



<YYINITIAL> {numeroBinario}     
{ 
        return new Symbol(sym.numeroBinario, yyline, yycolumn,yytext());
}
<YYINITIAL> {punto}     
{ 
        return new Symbol(sym.punto, yyline, yycolumn,yytext());
}

<YYINITIAL> {Espacios}      {}
<YYINITIAL> {Enter}         {}

<YYINITIAL> [^] 
{
        String errLex = " Error léxico, caracter irreconocible: '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+yycolumn;
}
