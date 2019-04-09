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
                //SitioWeb.analisisDeEliminacionSitioWeb(tipo, listaDeTokens, clienteFrame);
                break;
            case "NUEVA_PAGINA":
                PaginaWeb nuevaPagina = new PaginaWeb();
                nuevaPagina.darValoresCreacionYModificacion(listaDeTokens,null);
                //PaginaWeb.analisisDeCreacionDePaginaWeb(tipo, listaDeTokens, clienteFrame, null);
                break;
            case "BORRAR_PAGINA":
                //PaginaWeb.analisisDeEliminacionDePaginaWeb(tipo, listaDeTokens, clienteFrame);
                break;
            case "MODIFICAR_PAGINA":
                //PaginaWeb.analisisDeModificacionDePagina(tipo, listaDeTokens, clienteFrame, null);
                break;
            case "AGREGAR_COMPONENTE":
                //clienteFrame.mostrarErrorSintactico("Error SINTACTICO falta de atributos para accion en Linea:" + tipo.getLinea() + " " + "Columna:" + tipo.getColumna());
                break;
            case "BORRAR_COMPONENTE":
                //Componente.analisisDeEliminacionDeComponente(tipo, listaDeTokens, clienteFrame);
                break;
            case "MODIFICAR_COMPONENTE":
                //clienteFrame.mostrarErrorSintactico("Error SINTACTICO falta de atributos para accion en Linea:" + tipo.getLinea() + " " + "Columna:" + tipo.getColumna());
                break;
        }
    }

    public static void manejarExpresionConEtiquetas(Token tipo, ArrayList<Token> listaDeTokens,ArrayList<Token> listaDeEtiquetas) {
        switch (tipo.getTipo()) {//Segun accion encontrada
            case "NUEVO_SITIO_WEB":
                //clienteFrame.mostrarErrorSintactico("Error SINTACTICO accion no puede contener etiquetas Linea:" + tipo.getLinea() + " " + "Columna:" + tipo.getColumna());
                break;
            case "BORRAR_SITIO_WEB":
                //clienteFrame.mostrarErrorSintactico("Error SINTACTICO accion no puede contener etiquetas Linea:" + tipo.getLinea() + " " + "Columna:" + tipo.getColumna());
                break;
            case "NUEVA_PAGINA":
                //PaginaWeb.analisisDeCreacionDePaginaWeb(tipo, listaDeTokens, clienteFrame, listaDeEtiquetas);
                break;
            case "BORRAR_PAGINA":
                //clienteFrame.mostrarErrorSintactico("Error SINTACTICO accion no puede contener etiquetas Linea:" + tipo.getLinea() + " " + "Columna:" + tipo.getColumna());
                break;
            case "MODIFICAR_PAGINA":
                //PaginaWeb.analisisDeModificacionDePagina(tipo, listaDeTokens, clienteFrame, listaDeEtiquetas);
                break;
            case "AGREGAR_COMPONENTE":
                //clienteFrame.mostrarErrorSintactico("Error SINTACTICO accion no puede contener etiquetas Linea:" + tipo.getLinea() + " " + "Columna:" + tipo.getColumna());
                break;
            case "BORRAR_COMPONENTE":
                //clienteFrame.mostrarErrorSintactico("Error SINTACTICO accion no puede contener etiquetas Linea:" + tipo.getLinea() + " " + "Columna:" + tipo.getColumna());
                break;
            case "MODIFICAR_COMPONENTE":
                //clienteFrame.mostrarErrorSintactico("Error SINTACTICO accion no puede contener etiquetas Linea:" + tipo.getLinea() + " " + "Columna:" + tipo.getColumna());
                break;
            default:
                System.out.println("TIPO NO VIENE BIEN"+tipo.getTipo());
                break;
        }
    }

    public static void manejarExpresionConAtributos(Token tipo, ArrayList<Token> listaDeTokens,ArrayList<Token> listaDeAtributos) {
        switch (tipo.getTipo()) {//Segun accion encontrada
            case "NUEVO_SITIO_WEB":
                //clienteFrame.mostrarErrorSintactico("Error SINTACTICO accion no puede contener atributos Linea:" + tipo.getLinea() + " " + "Columna:" + tipo.getColumna());
                break;
            case "BORRAR_SITIO_WEB":
                //clienteFrame.mostrarErrorSintactico("Error SINTACTICO accion no puede contener atributos Linea:" + tipo.getLinea() + " " + "Columna:" + tipo.getColumna());
                break;
            case "NUEVA_PAGINA":
                //clienteFrame.mostrarErrorSintactico("Error SINTACTICO accion no puede contener atributos Linea:" + tipo.getLinea() + " " + "Columna:" + tipo.getColumna());
                break;
            case "BORRAR_PAGINA":
                //clienteFrame.mostrarErrorSintactico("Error SINTACTICO accion no puede contener etiquetas Linea:" + tipo.getLinea() + " " + "Columna:" + tipo.getColumna());
                break;
            case "MODIFICAR_PAGINA":
               // clienteFrame.mostrarErrorSintactico("Error SINTACTICO accion no puede contener atributos Linea:" + tipo.getLinea() + " " + "Columna:" + tipo.getColumna());
                break;
            case "AGREGAR_COMPONENTE":
                //Componente.analisisDeCreacion_ModificacionDeComponente(tipo, listaDeTokens, clienteFrame, listaDeAtributos,"creacion");
                break;
            case "BORRAR_COMPONENTE":
                //clienteFrame.mostrarErrorSintactico("Error SINTACTICO falta de atributos para accion en Linea:" + tipo.getLinea() + " " + "Columna:" + tipo.getColumna());
                break;
            case "MODIFICAR_COMPONENTE":
               // Componente.analisisDeCreacion_ModificacionDeComponente(tipo, listaDeTokens, clienteFrame, listaDeAtributos,"modificacion");
                break;
        }
    }

}
