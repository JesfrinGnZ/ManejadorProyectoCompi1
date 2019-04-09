/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import elementos.Run;
import java.io.File;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeEliminaciones {
    
    public static void eliminarPaginasEHijas(PaginaWeb pagina){
        File archivoDePagina;
        //Borrando todas las paginas hijas
        for (PaginaWeb paginaWeb : Run.listaDePaginasWeb) {
            if(paginaWeb.getPadre().equals(pagina.getId())){
                archivoDePagina = new File(paginaWeb.getDireccion());
                archivoDePagina.delete();//Borrando archivo
                Run.listaDePaginasWeb.remove(paginaWeb);//Borrando de lista
            }
        }
        //Borrando a la pagina
        archivoDePagina = new File(pagina.getDireccion());
        archivoDePagina.delete();
        Run.listaDePaginasWeb.remove(pagina);//Eliminando pagina principal
    }
    
    public static void eliminarSitioYPaginas(SitioWeb sitioWeb){
        File archivoDePagina;
        //Borrando todas las paginas del sitio web
        for (PaginaWeb paginaWeb : Run.listaDePaginasWeb) {
            if(paginaWeb.getSitio().equals(sitioWeb.getId())){
                archivoDePagina = new File(paginaWeb.getDireccion());
                archivoDePagina.delete();
                Run.listaDePaginasWeb.remove(paginaWeb);
            }
        }
        Run.listaDeSitiosWeb.remove(sitioWeb);//Borrando sitio web
    }
    
}
