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

    private String id, pagina, clase;//Parametros
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
                case "PAGINA":
                    this.pagina = valor;
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
        this.id = id;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

}
