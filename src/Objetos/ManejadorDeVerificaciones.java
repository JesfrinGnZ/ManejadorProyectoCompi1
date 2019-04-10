/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import elementos.Run;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeVerificaciones {

    public static boolean verificarSiExisteSitioWeb(String idSitioWeb) {
        for (SitioWeb sitio : Run.listaDeSitiosWeb) {
            if (sitio.getId().equals(idSitioWeb)) {
                ManejadorDeMensajes.agregarMensaje("ERROR el SITIO_WEB con id:" + idSitioWeb + " ya existe.");
                return true;
            }
        }
        return false;
    }

    public static boolean verificarSiExisteElSitioWebParaPagina(String idSitioWeb) {
        for (SitioWeb sitio : Run.listaDeSitiosWeb) {
            if (sitio.getId().equals(idSitioWeb)) {
                return true;
            }
        }
        ManejadorDeMensajes.agregarMensaje("ERROR el SITIO_WEB con id:" + idSitioWeb + " no existe.");
        return false;
    }

    public static boolean verificarSiExisteLaPagina(String identifiacdorDePagina) {
        for (PaginaWeb paginaWeb : Run.listaDePaginasWeb) {
            if (paginaWeb.getId().equals(identifiacdorDePagina)) {
                ManejadorDeMensajes.agregarMensaje("ERROR la PAGINA_WEB con id:" + identifiacdorDePagina + " ya existe.");
                return true;
            }
        }
        return false;
    }

    public static boolean verificarSiExistePadreParaPagina(String padreDePagina) {
        for (PaginaWeb paginaWeb : Run.listaDePaginasWeb) {
            if (paginaWeb.getId().equals(padreDePagina)) {
                return true;
            }
        }
        for (SitioWeb sitioWeb : Run.listaDeSitiosWeb) {
            if(sitioWeb.getId().equals(padreDePagina)){
                return true;
            }
        }
        
        ManejadorDeMensajes.agregarMensaje("ERROR la PAGINA_WEB(o sitio si no especifico) con id:" + padreDePagina + " no existe.");
        return false;
    }


    /*public static boolean verificarSiExisteComponenteDePagina(String identificadorDeComponente, String identificadorDePagina) {
        for (Componente componente : Run.listaDeComponentes) {
            if (componente.getId().equals(identificadorDeComponente) && componente.getPagina().equals(identificadorDePagina)) {
                ManejadorDeMensajes.agregarMensaje("ERROR el Componente con id:" + identificadorDeComponente + " para la pagina" + identificadorDePagina + " ya existe");
                return true;
            }
        }
        return false;
    }*/
    public static boolean verificarSiExisteElUsuario(String idUsuario) {
        for (Usuario usuario : Run.listaDeUsuarios) {
            System.out.println("--------------------->ID USUARIO:" + idUsuario + " NOMBRE:" + usuario.getNombre());
            if (usuario.getNombre().equals(idUsuario)) {
                return true;
            }
        }
        ManejadorDeMensajes.agregarMensaje("ERROR el USUARIO con id:" + idUsuario + " no existe.");
        return false;
    }

}
