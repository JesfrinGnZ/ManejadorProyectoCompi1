/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import ManejadoresDeTexto.EscritorDeDatos;
import elementos.Run;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeEliminaciones {

    public static void eliminarPaginasEHijas(PaginaWeb pagina) {
        File archivoDePagina;
        //Borrando todas las paginas hijas
        ArrayList<PaginaWeb> paginasAEliminar = new ArrayList<>();
        for (PaginaWeb paginaWeb : Run.listaDePaginasWeb) {
            if (paginaWeb.getPadre().equals(pagina.getId())) {
                archivoDePagina = new File(paginaWeb.getDireccion());
                if (archivoDePagina.exists()) {
                    archivoDePagina.delete();//Borrando archivo
                }
                paginasAEliminar.add(paginaWeb);
            }
        }
        if (!paginasAEliminar.isEmpty()) {
            for (PaginaWeb pag : paginasAEliminar) {
                Run.listaDePaginasWeb.remove(pag);
            }
        }
        //Borrando a la pagina
        archivoDePagina = new File(pagina.getDireccion());
        archivoDePagina.delete();
        //Eliminando pagina principal
        Run.listaDePaginasWeb.remove(pagina);
    }

    public static void eliminarSitioYPaginas(SitioWeb sitioWeb) {
        File archivoDePagina;
        //Borrando todas las paginas del sitio web
        ArrayList<PaginaWeb> paginasAEliminar = new ArrayList<>();
        for (PaginaWeb paginaWeb : Run.listaDePaginasWeb) {
            if (paginaWeb.getSitio().equals(sitioWeb.getId())) {
                archivoDePagina = new File(paginaWeb.getDireccion());
                if (archivoDePagina.exists()) {
                    archivoDePagina.delete();
                }
                paginasAEliminar.add(paginaWeb);
            }
        }
        if(!paginasAEliminar.isEmpty()){
            for (PaginaWeb paginaWeb : paginasAEliminar) {
                Run.listaDePaginasWeb.remove(paginaWeb);
            }
        }
       File archivo = new File(sitioWeb.getDireccion());
       archivo.delete();
        Run.listaDeSitiosWeb.remove(sitioWeb);//Borrando sitio web
    }

}
