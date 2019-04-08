/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;


/**
 *
 * @author jesfrin
 */
public class Etiqueta {

    private String etiqueta;

    public Etiqueta(String etiqueta) {
        this.etiqueta=etiqueta.substring(1,etiqueta.length()-1);
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    
}