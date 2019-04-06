//------------------>1era area<--------------------------    

package recuperacionPaginas;
import java_cup.runtime.*;
import static recuperacionPaginas.sym.*;

%% //------------------>2da area<--------------------------    

%public
%class AnalizadorLexicoPaginas
%cup
%cupdebug
%unicode
%line
%column

Salto = \r|\n|\r\n
Espacio = {Salto} | [ \t\f]
Digitos = 0|[1-9][0-9]*
FormatoFecha=[0-9][0-9][0-9][0-9]["-"][0-9][0-9]["-"][0-9][0-9]
Id =( [_] | [-] | [$] )([:jletterdigit:] | [-] | [_] | [$] )+


%{
  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }

%}

%% //------------------>3er area<--------------------------    
  <YYINITIAL>  {

    "elemento" {return symbol(ELEMENTO,yytext());}

    "nombre"	{return symbol(NOMBRE,yytext());}				
	
    "parametros" {return symbol(PARAMETROS,yytext());}

    "parametro" {return symbol(PARAMETRO,yytext());}

    "etiqueta" {return symbol(ETIQUETA,yytext());}

    "valor" {return symbol(VALOR,yytext());}

    "etiquetas" {return symbol(PARAM_ETIQUETAS,yytext());}

    "SITIO_WEB" {return symbol(SITIO_WEB,yytext());}

    "ID" {return symbol(ID,yytext());}

    "PAGINA_WEB" {return symbol(PAGINA_WEB,yytext());}
    
    "TITULO" {return symbol(TITULO_PARAMETRO,yytext());}

    "[TITULO]" {return symbol(TITULO,yytext());}

    "[PARRAFO]" {return symbol(PARRAFO,yytext());}

    "[IMAGEN]" {return symbol(IMAGEN,yytext());}

    "[VIDEO]" {return symbol(VIDEO,yytext());}

    "[MENU]" {return symbol(MENU,yytext());}

    "SITIO" {return symbol(SITIO,yytext());}

    "PADRE" {return symbol(PADRE,yytext());}

    "ETIQUETAS_DE_PAGINA" {return symbol(ETIQUETAS_DE_PAGINA,yytext());}

    "COMPONENTE" {return symbol(COMPONENTE,yytext());}

    "PAGINA" {return symbol(PAGINA,yytext());}

    "CLASE" {return symbol(CLASE,yytext());}

    "TEXTO" {return symbol(TEXTO,yytext());}

    "ALINEACION" {return symbol(ALINEACION,yytext());}

    "COLOR" {return symbol(COLOR,yytext());}

    "ORIGEN" {return symbol(ORIGEN,yytext());}

    "ALTURA" {return symbol(ALTURA,yytext());}
    
    "ANCHO" {return symbol(ANCHO,yytext());}

    "ETIQUETAS" {return symbol(ETIQUETAS,yytext());}

    "CENTRAR" {return symbol(CENTRAR,yytext());}

    "IZQUIERDA" {return symbol(IZQUIERDA,yytext());}

    "DERECHA" {return symbol(DERECHA,yytext());}

    "JUSTIFICAR" {return symbol(JUSTIFICAR,yytext());}

    "USUARIO_CREACION"  {return symbol(USUARIO_CREACION,yytext());}

     "FECHA_CREACION"    {return symbol(FECHA_CREACION,yytext());}

     "FECHA_MODIFICACION"    {return symbol(FECHA_MODIFICACION,yytext());}

     "USUARIO_MODIFICACION"  {return symbol(USUARIO_MODIFICACION,yytext());}

      "atributo"  {return symbol(ATRIBUTO,yytext());}

      "atributos"  {return symbol(ATRIBUTOS,yytext());}

    "\""    {return symbol(COMILLA,yytext());}

    "/"    {return symbol(DIAGONAL,yytext());}

   "<"    {return symbol(MENOR_QUE,yytext());}

   ">"    {return symbol(MAYOR_QUE,yytext());}

   "="    {return symbol(IGUAL,yytext());}

    "["{Id}"]"   {System.out.println("Id"+yytext());return symbol(IDENTIFICADOR,yytext());}

//    "[#"([a-fA-F]|[0-9]){6}"]" {System.out.println("CODIGO_COLOR:"+yytext());}

    "["{FormatoFecha}"]"  {return symbol(FORMATO_FECHA,yytext());}

    "["{Digitos}"]"     {return symbol(NUMERO,yytext());}

    "["(({Id}"|")+) {Id}"]"  {System.out.println("ConjuntoDeEtiquetas:"+yytext());return symbol(CONJUNTO_DE_ETIQUETAS,yytext());}  

    "["https?:\/\/[\w\-]+(\.[\w\-]+)+[/#?]?.*"]" {System.out.println("URL"+yytext());return symbol(URL,yytext());}

    "["~"]" {return symbol(ORACION,yytext());}

{Espacio} 	{/*IGNORAMOS*/}
}

//<<EOF>>                 { return symbol(EOF);

[^]     {/*Ignoramos*/System.out.println("Error:"+yytext());}



