/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class PaginaWeb {

    String id, titulo, sitio, padre, usuarioCreacion, fechaDeCreacion, fechaModificacion, usuarioModificacion;

    public PaginaWeb() {
    }

    public void darValoresCreacion(ArrayList<Token> listaDeTokens) {
        for (Token token : listaDeTokens) {
            String valor = token.getLexema().substring(1, token.getLexema().length() - 1);
            switch (token.getTipo()) {
                case "ID":
                    this.id = valor;
                    break;
                case "TITULO":
                    this.titulo = valor;
                    break;
                case "SITIO":
                    this.sitio = valor;
                    break;
                case "PADRE":
                    this.padre = valor;
                    break;
                case "USUARIO_CREACION":
                    this.usuarioCreacion = valor;
                    break;
                case "FECHA_CREACION":
                    this.fechaDeCreacion = valor;
                    break;
                case "FECHA_MODIFICACION":
                    this.fechaModificacion = valor;
                    break;
                case "USUARIO_MODIFICACION":
                    this.usuarioModificacion = valor;
                    break;
            }
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

}
