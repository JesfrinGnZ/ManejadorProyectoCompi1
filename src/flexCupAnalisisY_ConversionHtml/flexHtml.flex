//------------------>1era area<--------------------------    

package analizadoresConvertidoresHtml;
import java_cup.runtime.*;
import static analizadoresConvertidoresHtml.sym.*;

%% //------------------>2da area<--------------------------    

%public
%class AnalizadorLexicoTextoCliente
%cup
%cupdebug
%unicode
%line
%column

Salto = \r|\n|\r\n
Espacio = {Salto} | [ \t\f]
//L = [a-zA-Z]
Digitos = 0|[1-9][0-9]*
//DigitosNaturales=[1-9][0-9]*
FormatoFecha=[0-9][0-9][0-9][0-9]["-"][0-9][0-9]["-"][0-9][0-9]
Id =  ( [_] | [-] | [$] )([:jletterdigit:] | [-] | [_] | [$] )+
//Url =https?:\/\/(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&//=]*)

%{
  StringBuilder string = new StringBuilder();
  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }


  private void error(String message) {
    System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
  }

%}

%% //------------------>3er area<--------------------------    
        
<YYINITIAL>     [a|A][c|C][c|C][i|I][o|O][n|N][e|E][s|S]	{ return symbol(ACCIONES,yytext());}				

<YYINITIAL>     [a|A][c|C][c|C][i|I][o|O][n|N]	{return symbol(ACCION,yytext());}				
	
<YYINITIAL>     [p|P][a|A][r|R][a|A][m|M][e|E][t|T][r|R][o|O][s|S] {return symbol(PARAMETROS,yytext());}

<YYINITIAL>     [p|P][a|A][r|R][a|A][m|M][e|E][t|T][r|R][o|O] {return symbol(PARAMETRO,yytext());}

<YYINITIAL>     [a|A][t|T][r|R][i|I][b|B][u|U][t|T][o|O][s|S] {return symbol(ATRIBUTOS,yytext());}

<YYINITIAL>     [a|A][t|T][r|R][i|I][b|B][u|U][t|T][o|O] {return symbol(ATRIBUTO,yytext());}

<YYINITIAL>     [n|N][o|O][m|M][b|B][r|R][e|E]    {return symbol(NOMBRE,yytext());}

<YYINITIAL>     [e|E][t|T][i|I][q|Q][u|U][e|E][t|T][a|A][s|S]    {return symbol(ETIQUETAS,yytext());}

<YYINITIAL>     [e|E][t|T][i|I][q|Q][u|U][e|E][t|T][a|A]    {return symbol(ETIQUETA,yytext());}

<YYINITIAL>     [v|V][a|A][l|L][o|O][r|R] {return symbol(VALOR,yytext());}

<YYINITIAL>     "/"    {return symbol(DIAGONAL,yytext());}

<YYINITIAL>     "<"    {return symbol(MENOR_QUE,yytext());}

<YYINITIAL>     ">"    {return symbol(MAYOR_QUE,yytext());}

//<YYINITIAL>     "["    {return symbol(CORCHETE_ABIERTO,yytext());}

//<YYINITIAL>     "]"    {return symbol(CORCHETE_CERRADO,yytext());}

<YYINITIAL>     "="    {return symbol(IGUAL,yytext());}

<YYINITIAL>     "\""   {return symbol(COMILLA,yytext());}

//<YYINITIAL>     "|"    {return symbol(DIAGONAL_RECTA,yytext());}

<YYINITIAL>     "NUEVO_SITIO_WEB"   {return symbol(NUEVO_SITIO_WEB,yytext());}

<YYINITIAL>     "ID"    {return symbol(ID,yytext());}

<YYINITIAL>     "USUARIO_CREACION"  {return symbol(USUARIO_CREACION,yytext());}

<YYINITIAL>     "FECHA_CREACION"    {return symbol(FECHA_CREACION,yytext());}

<YYINITIAL>     "FECHA_MODIFICACION"    {return symbol(FECHA_MODIFICACION,yytext());}

<YYINITIAL>     "USUARIO_MODIFICACION"  {return symbol(USUARIO_MODIFICACION,yytext());}

<YYINITIAL>     "BORRAR_SITIO_WEB"      {return symbol(BORRAR_SITIO_WEB,yytext());}

<YYINITIAL>     "NUEVA_PAGINA"      {return symbol(NUEVA_PAGINA,yytext());}

<YYINITIAL>     "TITULO"      {return symbol(TITULO,yytext());}

<YYINITIAL>     "SITIO"     {return symbol(SITIO,yytext());}

<YYINITIAL>     "PADRE"     {return symbol(PADRE,yytext());}

//<YYINITIAL>     "ETIQUETAS"    {return symbol(ETIQUETAS_TEXTO_MENU,yytext());}

<YYINITIAL>     "BORRAR_PAGINA"   {return symbol(BORRAR_PAGINA,yytext());}

<YYINITIAL>     "MODIFICAR_PAGINA"  {return symbol(MODIFICAR_PAGINA,yytext());}

<YYINITIAL>     "AGREGAR_COMPONENTE"    {return symbol(AGREGAR_COMPONENTE,yytext());}

<YYINITIAL>     "PAGINA"   {return symbol(PAGINA,yytext());}

<YYINITIAL>     "CLASE"     {return symbol(CLASE,yytext());}

<YYINITIAL>     "BORRAR_COMPONENTE"    {return symbol(BORRAR_COMPONENTE,yytext());}

<YYINITIAL>     "MODIFICAR_COMPONENTE"  {return symbol(MODIFICAR_COMPONENTE,yytext());} 

<YYINITIAL>     "[TITULO]"       {return symbol(TITULO,yytext());}       

<YYINITIAL>     "[PARRAFO]"       {return symbol(PARRAFO,yytext());}       

<YYINITIAL>     "[IMAGEN]"       {return symbol(IMAGEN,yytext());}       

<YYINITIAL>     "[VIDEO]"       {return symbol(VIDEO,yytext());}       

<YYINITIAL>     "[MENU]"       {return symbol(MENU,yytext());}

<YYINITIAL>     "TEXTO"     {return symbol(TEXTO,yytext());}
       
<YYINITIAL>     "ALINEACION"       {return symbol(ALINEACION,yytext());}

<YYINITIAL>     "[CENTRAR]"       {return symbol(CENTRAR,yytext());}

<YYINITIAL>     "[IZQUIERDA]"       {return symbol(IZQUIERDA,yytext());}

<YYINITIAL>     "[DERECHA]"       {return symbol(DERECHA,yytext());}

<YYINITIAL>     "[JUSTIFICAR]"       {return symbol(JUSTIFICAR,yytext());}

<YYINITIAL>     "COLOR"       {return symbol(COLOR,yytext());}

<YYINITIAL>     "ORIGEN"      {return symbol(ORIGEN,yytext());}

<YYINITIAL>     "ALTURA"     {return symbol(ALTURA,yytext());}

<YYINITIAL>     "ANCHO"       {return symbol(ANCHO,yytext());}

<YYINITIAL>     "["{FormatoFecha}"]"  {return symbol(FORMATO_FECHA,yytext());}

<YYINITIAL>     "["{Digitos}"]"     {return symbol(NUMERO,yytext());}

<YYINITIAL> "["(({Id}"|")+) {Id}"]"  {System.out.println("ConjuntoDeEtiquetas:"+yytext());return symbol(CONJUNTO_DE_ETIQUETAS,yytext());}  

<YYINITIAL>     "["{Id}"]" {return symbol(IDENTIFICADOR,yytext());}   

<YYINITIAL>     "\""{Id}"\"" {return symbol(IDENTIFICADOR_COMILLA,yytext());}

<YYINITIAL> "[#"([a-fA-F]|[0-9]){6}"]"      {System.out.println("Codigo color:"+yytext());return symbol(CODIGO_COLOR,yytext());}  

//<YYINITIAL> "\""~"\""     {System.out.println("Oracion:"+yytext());return symbol(ORACION_ETIQUETA,yytext());}  

<YYINITIAL> "["https?:\/\/[\w\-]+(\.[\w\-]+)+[/#?]?.*"]" {System.out.println("URL"+yytext());return symbol(URL,yytext());}

<YYINITIAL> "["~"]"     {System.out.println("Oracion:"+yytext());return symbol(ORACION,yytext());}  

//<YYINITIAL>  ~"|"     {System.out.println("ETIQUETA_MENU:"+yytext());return symbol(ETIQUETA_MENU,yytext());}

//<YYINITIAL>  ~"]"     {System.out.println("ETIQUETA_MENU_FIN:"+yytext());return symbol(ETIQUETA_MENU_FIN,yytext());}  
  

{Espacio} 	{/*IGNORAMOS*/}

[^]     {System.out.println("ERRORES LEXICOS:"+yytext());}


