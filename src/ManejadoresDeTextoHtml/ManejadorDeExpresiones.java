/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejadoresDeTextoHtml;

import Objetos.*;
import Objetos.Token;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeExpresiones {

    public static void manejarExpresionSinEtiquetasNiAtributos(Token tipo, ArrayList<Token> listaDeTokens) {
        switch (tipo.getTipo()) {//Segun accion encontrada
            case "NUEVO_SITIO_WEB":
                SitioWeb sitioWeb = new SitioWeb();
                sitioWeb.darValoresCreacionyVerificacion(listaDeTokens);
                break;
            case "BORRAR_SITIO_WEB":
                SitioWeb.borrarSitioWeb(listaDeTokens);
                break;
            case "NUEVA_PAGINA":
                PaginaWeb nuevaPagina = new PaginaWeb();
                nuevaPagina.darValoresCreacion(listaDeTokens, null);
                break;
            case "BORRAR_PAGINA":
                PaginaWeb.borrarPaginaWeb(listaDeTokens);
                break;
            case "MODIFICAR_PAGINA":
                PaginaWeb.modificarPagina(listaDeTokens, null);
                break;
            case "BORRAR_COMPONENTE":
                Componente.borrarComponente(listaDeTokens);
                break;

        }
    }

    public static void manejarExpresionConEtiquetas(Token tipo, ArrayList<Token> listaDeTokens, ArrayList<Token> listaDeEtiquetas) {
        switch (tipo.getTipo()) {//Segun accion encontrada
            case "NUEVA_PAGINA":
                PaginaWeb nuevaPagina = new PaginaWeb();
                nuevaPagina.darValoresCreacion(listaDeTokens, listaDeEtiquetas);
                break;
            case "MODIFICAR_PAGINA":
                PaginaWeb.modificarPagina(listaDeTokens, listaDeEtiquetas);
                break;
        }
    }

    public static void manejarExpresionConAtributos(Token tipo, ArrayList<Token> listaDeTokens, ArrayList<Token> listaDeAtributos) {
        switch (tipo.getTipo()) {//Segun accion encontrada
            case "AGREGAR_COMPONENTE":
                Componente componente = new Componente();
                componente.darValoresCreacion(listaDeTokens, listaDeAtributos);
                break;
            case "MODIFICAR_COMPONENTE":
                Componente componente1 = new Componente();
                componente1.darValoresModificacion(listaDeTokens, listaDeAtributos);
                break;
        }
    }

}
