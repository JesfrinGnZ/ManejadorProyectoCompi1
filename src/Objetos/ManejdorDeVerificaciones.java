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
public class ManejdorDeVerificaciones {

    public static boolean verificarSiYaExisteElCliente(String identifiacdorDeSitio) {
        identifiacdorDeSitio = identifiacdorDeSitio.substring(1, identifiacdorDeSitio.length() - 1);
        for (SitioWeb sitio : Run.listaDeSitiosWeb) {
            if (sitio.getId().equals(identifiacdorDeSitio)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean verificarSiExisteLaPagina(String identifiacdorDePagina){
        for (PaginaWeb paginaWeb : Run.listaDePaginasWeb) {
            if(paginaWeb.getId().equals(identifiacdorDePagina)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean verificarSiExisteComponenteDePagina(String identificadorDeComponente,String identificadorDePagina){
        for (Componente componente : Run.listaDeComponentes) {
            if(componente.getId().equals(identificadorDeComponente) && componente.getPagina().equals(identificadorDePagina)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean verificarSiExisteElUsuario(String idUsuario){
        for (Usuario usuario : Run.listaDeUsuarios) {
            if(usuario.getNombre().equals(idUsuario)){
                return true;
            }
        }
        return false;
    }
    
    
}
