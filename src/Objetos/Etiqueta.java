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
public class Etiqueta {

    private String idDePagina;
    private ArrayList<String> etiquetas;

    public Etiqueta(String idDePagina, ArrayList<String> etiquetas) {
        this.idDePagina = idDePagina;
        this.etiquetas = etiquetas;
    }

    public String getIdDePagina() {
        return idDePagina;
    }

    public void setIdDePagina(String idDePagina) {
        this.idDePagina = idDePagina;
    }

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(ArrayList<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

}
