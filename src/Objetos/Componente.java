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
public class Componente {

    private String id, clase;//Parametros
    private String texto, alineacion, color, origen, altura, ancho, padre, etiquetas;//Atributos segun clase

    public Componente() {
    }

    public void darValoresCreacion(ArrayList<Token> listaDeTokens) {
        for (Token token : listaDeTokens) {
            String valor = token.getLexema().substring(1, token.getLexema().length() - 1);
            switch (token.getTipo()) {
                case "ID":
                    this.id = valor;
                    break;
                case "CLASE":
                    this.clase = valor;
                    break;
                case "TEXTO":
                    this.texto = valor;
                    break;
                case "ALINEACION":
                    this.alineacion = valor;
                    break;
                case "COLOR":
                    this.color = valor;
                    break;
                case "ORIGEN":
                    this.origen = valor;
                    break;
                case "ALTURA":
                    this.altura = valor;
                    break;
                case "ANCHO":
                    this.ancho = valor;
                    break;
                case "PADRE":
                    this.padre = valor;
                    break;
                case "ETIQUETAS":
                    this.etiquetas = valor;
                    break;
            }
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.substring(1,id.length()-1);
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase.substring(1,clase.length()-1);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto.substring(1,texto.length()-1);
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion.substring(0,alineacion.length()-1);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color.substring(1,color.length()-1);
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen.substring(1,origen.length()-1);
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura.substring(1,altura.length()-1);
    }

    public String getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho.substring(1,ancho.length()-1);
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre.substring(1,padre.length()-1);
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas.substring(1,etiquetas.length()-1);
    }

}
