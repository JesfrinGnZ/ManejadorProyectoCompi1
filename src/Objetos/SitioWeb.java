/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import ManejadoresDeTexto.EscritorDeDatos;
import elementos.Run;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class SitioWeb {

    private String id, usuarioCreacion, fechaCreacion, fechaModificacion, usuarioModificacion;

    public SitioWeb() {
    }

    public void darValoresCreacionyVerificacion(ArrayList<Token> listaDeTokens) {
        int contador = 0;
        for (Token token : listaDeTokens) {
            String lexema = token.getLexema().substring(1, token.getLexema().length() - 1);
            switch (token.getTipo()) {
                case "ID":
                    this.id = lexema;
                    ManejadorDeMensajes.agregarMensaje("-------------CREACION SITIO WEB ID:" + this.id + "----------------");
                    if (ManejadorDeVerificaciones.verificarSiExisteSitioWeb(this.id)) {
                        contador++;
                    }
                    break;
                case "USUARIO_CREACION":
                    this.usuarioCreacion = lexema;
                    if (!ManejadorDeVerificaciones.verificarSiExisteElUsuario(this.usuarioCreacion)) {
                        contador++;
                    }
                    break;
                case "FECHA_CREACION":
                    this.fechaCreacion = lexema;
                    break;
                case "FECHA_MODIFICACION":
                    this.fechaModificacion = lexema;
                    break;
                case "USUARIO_MODIFICACION":
                    this.usuarioModificacion = lexema;
                    if (!ManejadorDeVerificaciones.verificarSiExisteElUsuario(this.usuarioModificacion)) {
                        contador++;
                    }
                    break;
            }
        }
        if (contador == 0) {
            ManejadorDeMensajes.agregarMensaje("El sitio web con id:" + this.id + " se ha CREADO EXITOSAMENTE");
            //Se agrega els itio web a la lista
            Run.listaDeSitiosWeb.add(this);//Le mandamos el sitio web que estamos creando y analizando
            //Se escribe el sitio web y index
            PaginaWeb index1 = new PaginaWeb("index" + this.id, "/home/jesfrin/Documentos/DocumentosHtml/index" + this.id + ".html", "index" + this.id, this.id, this.id, this.usuarioCreacion, this.fechaCreacion, this.fechaModificacion, this.usuarioModificacion);
            //Se agrega la pagina a la lista
            Run.listaDePaginasWeb.add(index1);
            //Crear el html de la pagina web
            String html = index1.crearHtmlDePaginaWeb();
            EscritorDeDatos.escribirHtml(html, "/home/jesfrin/Documentos/DocumentosHtml/index" + this.id + ".html");
            //Se escribio la pagina html
            EscritorDeDatos.agregarDatosABaseDeDatos(escribirSitioWeb(this, index1), "/home/jesfrin/Documentos/ArchivosP1Compi1/paginas.txt");

        }
    }

    public static void borrarSitioWeb(ArrayList<Token> listaDeTokens) {
        String idDeSitioWeb = listaDeTokens.get(0).getLexema();
        SitioWeb sitioWebAEliminar = null;
        ManejadorDeMensajes.agregarMensaje("-------------ELIMINACION SITIO WEB ID:" + idDeSitioWeb + "----------------");
        for (SitioWeb sitioWeb : Run.listaDeSitiosWeb) {
            if (sitioWeb.getId().equals(idDeSitioWeb)) {
                sitioWebAEliminar = sitioWeb;
            }
        }
        if (sitioWebAEliminar == null) {
            //Mandar mensaje de que no se encontro el sitio web con el Id buscado
            ManejadorDeMensajes.agregarMensaje("Error no se encontro el sitio web con id:" + idDeSitioWeb);
        } else {
            ManejadorDeEliminaciones.eliminarSitioYPaginas(sitioWebAEliminar);
            //Reescribir el archivo
            EscritorDeDatos.reescribirBaseDeDatos(ManejadorDeMensajes.escribirSitiosWeb(), "/home/jesfrin/Documentos/ArchivosP1Compi1/paginas.txt");
            ManejadorDeMensajes.textoBaseDeDatos = "";
            //Mandar mensaje que el sitio web y sus paginas se han eliminado
            ManejadorDeMensajes.agregarMensaje("Se ha eliminado el sitio web con id:" + idDeSitioWeb + " asi como sus paginas");
        }
    }

    public static void crearPagina() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.substring(1, id.length() - 1);
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion.substring(1, usuarioCreacion.length() - 1);
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion.substring(1, fechaCreacion.length() - 1);
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion.substring(1, fechaModificacion.length() - 1);
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion.substring(1, usuarioModificacion.length() - 1);
    }

    public static String escribirSitioWeb(SitioWeb sitioWeb, PaginaWeb paginaWeb) {
        return "<sitioWeb>\n"
                + "\t<parametrosSitioWeb>\n"
                + "\t\t<parametroSitioWeb nombre = \"ID\">\n"
                + "\t\t\t[" + sitioWeb.getId() + "]" + " \n"
                + "\t\t</parametroSitioWeb>\n"
                + "\t\t<parametroSitioWeb nombre = \"USUARIO_CREACION\">\n"
                + "\t\t\t[" + sitioWeb.getUsuarioCreacion() + "]" + " \n"
                + "\t\t</parametroSitioWeb>\n"
                + "\t\t<parametroSitioWeb nombre = \"FECHA_CREACION\">\n"
                + "\t\t\t[" + sitioWeb.getFechaCreacion() + "]" + " \n"
                + "\t\t</parametroSitioWeb>\n"
                + "\t\t<parametroSitioWeb nombre = \"FECHA_MODIFICACION\">\n"
                + "\t\t\t[" + sitioWeb.getFechaModificacion() + "]" + " \n"
                + "\t\t</parametroSitioWeb>\n"
                + "\t\t<parametroSitioWeb nombre = \"USUARIO_MODIFICACION\">\n"
                + "\t\t\t[" + sitioWeb.getUsuarioModificacion() + "]" + " \n"
                + " \t\t</parametroSitioWeb>\n"
                + "\t</parametrosSitioWeb>\n"
                + "\t<paginasSitioWeb>\n"
                + "\t\t<pagina>\n"
                + "\t\t\t<parametrosDePagina>\n"
                + "\t\t\t<parametroDePagina nombre = \"ID\">\n"
                + "\t\t\t\t[" + paginaWeb.getId() + "]" + " \n"
                + "\t\t\t</parametroDePagina>\n"
                + "\t\t\t<parametroDePagina nombre = \"DIRECCION\">\n"
                + "\t\t\t\t[" + paginaWeb.getDireccion() + "]" + " \n"
                + "\t\t\t</parametroDePagina>                \n"
                + "\t\t\t<parametroDePagina nombre = \"TITULO\">\n"
                + "\t\t\t\t[" + paginaWeb.getTitulo() + "]" + " \n"
                + "\t\t\t</parametroDePagina>\n"
                + "\t\t\t<parametroDePagina nombre = \"SITIO\">\n"
                + "\t\t\t\t[" + paginaWeb.getSitio() + "]" + " \n"
                + "\t\t\t</parametroDePagina>\n"
                + "\t\t\t<parametroDePagina nombre = \"PADRE\">\n"
                + "\t\t\t\t[" + paginaWeb.getPadre() + "]" + " \n"
                + "\t\t\t</parametroDePagina>\n"
                + "\t\t\t<parametroDePagina nombre = \"USUARIO_CREACION\">\n"
                + "\t\t\t\t[" + paginaWeb.getUsuarioCreacion() + "]" + " \n"
                + "\t\t\t</parametroDePagina>\n"
                + " \t\t\t<parametroDePagina nombre = \"FECHA_CREACION\">\n"
                + "\t\t\t\t[" + paginaWeb.getFechaDeCreacion() + "]" + " \n"
                + "\t\t\t</parametroDePagina>\n"
                + "\t\t\t<parametroDePagina nombre = \"FECHA_MODIFICACION\">\n"
                + "\t\t\t\t[" + paginaWeb.getFechaModificacion() + "]" + " \n"
                + "\t\t\t</parametroDePagina>\n"
                + "\t\t\t<parametroDePagina nombre = \"USUARIO_MODIFICACION\">\n"
                + "\t\t\t\t[" + paginaWeb.getUsuarioModificacion() + "]" + " \n"
                + "\t\t\t</parametroDePagina>\n"
                + "\t\t\t</parametrosDePagina>\n"
                + "\t\t</pagina>\n"
                + "\t</paginasSitioWeb>\n"
                + "</sitioWeb>\n";
    }

}
