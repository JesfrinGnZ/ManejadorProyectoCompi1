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
public class SitioWeb {

    private String id, usuarioCreacion, fechaCreacion, fechaModificacion, usuarioModificacion;

    public SitioWeb() {
    }

    public void darValoresCreacion(ArrayList<Token> listaDeTokens) {

        for (Token token : listaDeTokens) {
            String lexema = token.getLexema().substring(1, token.getLexema().length() - 1);
            switch (token.getTipo()) {
                case "ID":
                    this.id = lexema;
                    break;
                case "USUARIO_CREACION":
                    this.usuarioCreacion = lexema;
                    break;
                case "FECHA_CREACION":
                    this.fechaCreacion = lexema;
                    break;
                case "FECHA_MODIFICACION":
                    this.fechaModificacion = lexema;
                    break;
                case "USUARIO_MODIFICACION":
                    this.usuarioModificacion = lexema;
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

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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
