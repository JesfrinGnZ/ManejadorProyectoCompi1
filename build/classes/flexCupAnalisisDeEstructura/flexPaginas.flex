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

//********************************************************Simbolos************************************
    "\""    {return symbol(COMILLA,yytext());}

    "/"    {return symbol(DIAGONAL,yytext());}

   "<"    {return symbol(MENOR_QUE,yytext());}

   ">"    {return symbol(MAYOR_QUE,yytext());}

   "="    {return symbol(IGUAL,yytext());}

//******************************************************SitiWeb**********************************************

    "sitioWeb" {return symbol(SITIO_WEB,yytext());}

    "parametrosSitioWeb" {return symbol(PARAMETROS_SITIO_WEB,yytext());}

    "parametroSitioWeb" {return symbol(PARAMETRO_SITIO_WEB,yytext());}

    "nombre"	{return symbol(NOMBRE,yytext());}

    "paginasSitioWeb" {return symbol(PAGINAS_SITIO_WEB,yytext());}	


//********************************************************PaginaWeb*****************************************************
    "pagina" {return symbol(PAGINA,yytext());}		
     
    "parametrosDePagina" {return symbol(PARAMETROS_DE_PAGINA,yytext());}

    "parametroDePagina"  {return symbol(PARAMETRO_DE_PAGINA,yytext());}

    "componentes" {return symbol(COMPONENTES,yytext());}

    "etiquetas" {return symbol(ETIQUETAS,yytext());}

//******************************************************Componentes*****************************************

    "componente"  {return symbol(COMPONENTE,yytext());}

    "atributos"  {return symbol(ATRIBUTOS,yytext());}
    
    "atributo"  {return symbol(ATRIBUTO,yytext());}

    

 
//*************************************************************************PARAMETROS***************************************
	
    "ID" {return symbol(ID,yytext());}	

    "DIRECCION" {return symbol(DIRECCION,yytext());}

    "USUARIO_CREACION"  {return symbol(USUARIO_CREACION,yytext());}

    "FECHA_CREACION"    {return symbol(FECHA_CREACION,yytext());}

    "FECHA_MODIFICACION"    {return symbol(FECHA_MODIFICACION,yytext());}

    "USUARIO_MODIFICACION"  {return symbol(USUARIO_MODIFICACION,yytext());}

    "TITULO" {return symbol(TITULO,yytext());}		

    "SITIO" {return symbol(SITIO,yytext());}		

    "PADRE" {return symbol(PADRE,yytext());}		


//************************************************************************ATRIBUTOS*******************************************

    "TEXTO" {return symbol(TEXTO,yytext());}

    "ALINEACION" {return symbol(ALINEACION,yytext());}

    "COLOR" {return symbol(COLOR,yytext());}

    "ORIGEN" {return symbol(ORIGEN,yytext());}

    "ALTURA" {return symbol(ALTURA,yytext());}
    
    "ANCHO" {return symbol(ANCHO,yytext());}

//*************************************************************************TIPOS DE COMPONENTES*******************************
    "PARRAFO" {return symbol(PARRAFO,yytext());}
    
    "IMAGEN" {return symbol(IMAGEN,yytext());}
    
    "VIDEO" {return symbol(VIDEO,yytext());}
    
    "MENU" {return symbol(MENU,yytext());}
    
    "ETIQUETAS" {return symbol(ETIQUETAS_MENU,yytext());}


//**************************************************************************Etiquetas*******************************************
    
    "etiqueta" {return symbol(ETIQUETA,yytext());}


    "["~"]" {return symbol(ORACION,yytext());}

{Espacio} 	{/*IGNORAMOS*/}
}

//<<EOF>>                 { return symbol(EOF);

[^]     {/*Ignoramos*/System.out.println("Error:"+yytext());}



