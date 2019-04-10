/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import ManejadoresDeTexto.EscritorDeDatos;
import static Objetos.SitioWeb.escribirSitioWeb;
import elementos.Run;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class PaginaWeb {

    String id, direccion, titulo, sitio, padre, usuarioCreacion, fechaDeCreacion, fechaModificacion, usuarioModificacion;
    ArrayList<Componente> listaDeComponentes;
    ArrayList<Etiqueta> listaDeEtiquetas;

    public PaginaWeb() {
        this.listaDeComponentes = new ArrayList<>();
        this.listaDeEtiquetas = new ArrayList<>();
    }

    public PaginaWeb(String id, String direccion, String titulo, String sitio, String padre, String usuarioCreacion, String fechaDeCreacion, String fechaModificacion, String usuarioModificacion) {
        this.id = id;
        this.direccion = direccion;
        this.titulo = titulo;
        this.sitio = sitio;
        this.padre = padre;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
    }

    public void darValoresCreacion(ArrayList<Token> listaDeTokens, ArrayList<Token> etiquetas) {
        int contador = 0;
        for (Token token : listaDeTokens) {
            String valor = token.getLexema().substring(1, token.getLexema().length() - 1);
            switch (token.getTipo()) {
                case "ID":
                    this.id = valor;
                    ManejadorDeMensajes.agregarMensaje("-------------PAGINA WEB ID:" + this.id + "----------------");
                    if (ManejadorDeVerificaciones.verificarSiExisteLaPagina(this.id)) {//Pagina repetida
                        contador++;
                    }
                    break;
                case "TITULO":
                    this.titulo = valor;
                    break;
                case "SITIO":
                    this.sitio = valor;
                    if (!ManejadorDeVerificaciones.verificarSiExisteElSitioWebParaPagina(this.sitio)) {
                        contador++;
                    }
                    break;
                case "PADRE":
                    this.padre = valor;
                    if (!ManejadorDeVerificaciones.verificarSiExistePadreParaPagina(this.padre)) {
                        contador++;
                    }
                    break;
                case "USUARIO_CREACION":
                    this.usuarioCreacion = valor;
                    if (!ManejadorDeVerificaciones.verificarSiExisteElUsuario(this.usuarioCreacion)) {
                        contador++;
                    }
                    break;
                case "FECHA_CREACION":
                    this.fechaDeCreacion = valor;
                    break;
                case "FECHA_MODIFICACION":
                    this.fechaModificacion = valor;
                    break;
                case "USUARIO_MODIFICACION":
                    this.usuarioModificacion = valor;
                    if (!ManejadorDeVerificaciones.verificarSiExisteElUsuario(this.usuarioModificacion)) {
                        contador++;
                    }
                    break;
            }
        }

        if (contador == 0) {
            if (etiquetas != null) {//Se deben agregar etiquetas
                for (Token etiqueta : etiquetas) {
                    listaDeEtiquetas.add(new Etiqueta(etiqueta.getLexema()));
                }
            }

            ManejadorDeMensajes.agregarMensaje("La pagina web con id:" + this.id + " se ha CREADO EXITOSAMENTE");
            //Se agrega els itio web a la lista
            Run.listaDePaginasWeb.add(this);//Le mandamos la pagina web que estamos creando y analizando
            //Se agrega la direccion de la pagina
            this.direccion = "/home/jesfrin/Documentos/DocumentosHtml/" + this.id + ".html";
            //Crear el html de la pagina web
            String html = this.crearHtmlDePaginaWeb();
            EscritorDeDatos.escribirHtml(html, "/home/jesfrin/Documentos/DocumentosHtml/" + this.id + ".html");
            ManejadorDeMensajes.escribirSitiosWeb();
            EscritorDeDatos.reescribirBaseDeDatos(ManejadorDeMensajes.textoBaseDeDatos, "/home/jesfrin/Documentos/ArchivosP1Compi1/paginas.txt");
            ManejadorDeMensajes.textoBaseDeDatos = "";
//Se escribio la pagina html
            //EscritorDeDatos.agregarDatosABaseDeDatos(escribirSitioWeb(this, index1), "/home/jesfrin/Documentos/ArchivosP1Compi1/paginas.txt");

        }
    }

    public static void borrarPaginaWeb(ArrayList<Token> listaDeTokens) {
        String idDePagina = listaDeTokens.get(0).getLexema();
        PaginaWeb paginaWebAEliminar = null;
        ManejadorDeMensajes.agregarMensaje("-------------ELIMINACION PAGINA WEB ID:" + idDePagina + "----------------");
        for (PaginaWeb paginWeb : Run.listaDePaginasWeb) {//Buscar la pagina a eliminar
            if (paginWeb.getId().equals(idDePagina)) {
                paginaWebAEliminar = paginWeb;
            }
        }
        if (paginaWebAEliminar == null) {
            //Mandar mensaje de que no se encontro el sitio web con el Id buscado
            ManejadorDeMensajes.agregarMensaje("Error no se encontro la pagina web con id:" + idDePagina);
        } else {
            ManejadorDeEliminaciones.eliminarPaginasEHijas(paginaWebAEliminar);
            //Reescribir el archivo
            EscritorDeDatos.reescribirBaseDeDatos(ManejadorDeMensajes.escribirSitiosWeb(), "/home/jesfrin/Documentos/ArchivosP1Compi1/paginas.txt");
            ManejadorDeMensajes.textoBaseDeDatos = "";
            //Mandar mensaje que el sitio web y sus paginas se han eliminado
            ManejadorDeMensajes.agregarMensaje("Se ha eliminado la pagina web con id:" + idDePagina + " asi como sus paginas hijas");
        }
    }

    public static void modificarPagina(ArrayList<Token> listaDeTokens, ArrayList<Token> listaDeEtiquetas) {
        String idPaginaWeb = listaDeTokens.get(0).getLexema().substring(1, listaDeTokens.get(0).getLexema().length() - 1);
        ManejadorDeMensajes.agregarMensaje("-------------MODIFICACION PAGINA WEB ID:" + idPaginaWeb + "----------------");
        PaginaWeb paginaWebAModificar = null;
        for (PaginaWeb paginaWeb : Run.listaDePaginasWeb) {//Se busca la pagina web que se quiere modificar
            if (paginaWeb.getId().equals(idPaginaWeb)) {
                paginaWebAModificar = paginaWeb;
            }
        }
        if (paginaWebAModificar != null) {//Se encontro la pagina web
            if (listaDeTokens.size() == 2) {//Trae ID Y TITULO, por lo que se modifica titulo
                paginaWebAModificar.setTitulo(listaDeTokens.get(1).getLexema());
            }
            if (listaDeEtiquetas != null) {//Existen etiquetas para modificar
                ArrayList<Etiqueta> nuevaListaDeEtiquetas = new ArrayList<>();//Se crea una nueva lista de etiquetas
                for (Token etiqueta : listaDeEtiquetas) {//Se llena la lista nueva de etiquetas con la que trae las actuales
                    nuevaListaDeEtiquetas.add(new Etiqueta(etiqueta.getLexema()));
                }
                //Se modifica la lista de etiquetas
                paginaWebAModificar.setListaDeEtiquetas(nuevaListaDeEtiquetas);
            }
            //Escribir html
            String html = paginaWebAModificar.crearHtmlDePaginaWeb();
            EscritorDeDatos.escribirHtml(html, "/home/jesfrin/Documentos/DocumentosHtml/" + paginaWebAModificar.getId() + ".html");
            //Mensaje y reescribir base de datos
            ManejadorDeMensajes.agregarMensaje("Se ha modificado la pagina web:" + idPaginaWeb);
            EscritorDeDatos.reescribirBaseDeDatos(ManejadorDeMensajes.escribirSitiosWeb(), "/home/jesfrin/Documentos/ArchivosP1Compi1/paginas.txt");
            ManejadorDeMensajes.textoBaseDeDatos = "";
        } else {//Se manda que no se encontro la pagina web
            ManejadorDeMensajes.agregarMensaje("Error no se encontro la pagina web con id:" + idPaginaWeb);
        }

//Buscar la pagina
    }

    public String crearHtmlDePaginaWeb() {
        return "<HTML>\n"
                + "<HEAD>\n"
                + "<title>" + this.titulo + "</title>"
                + "</HEAD>\n"
                + "<BODY>\n"
                + "</BODY>\n"
                + "</HTML>";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.substring(1, id.length() - 1);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion.substring(1, direccion.length() - 1);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo.substring(1, titulo.length() - 1);
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio.substring(1, sitio.length() - 1);
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre.substring(1, padre.length() - 1);
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion.substring(1, usuarioCreacion.length() - 1);
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion.substring(1, fechaDeCreacion.length() - 1);
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

    public ArrayList<Componente> getListaDeComponentes() {
        return listaDeComponentes;
    }

    public void setListaDeComponentes(ArrayList<Componente> listaDeComponentes) {
        this.listaDeComponentes = listaDeComponentes;
    }

    public ArrayList<Etiqueta> getListaDeEtiquetas() {
        return listaDeEtiquetas;
    }

    public void setListaDeEtiquetas(ArrayList<Etiqueta> listaDeEtiquetas) {
        this.listaDeEtiquetas = listaDeEtiquetas;
    }

}
