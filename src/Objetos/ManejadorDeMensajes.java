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
public class ManejadorDeMensajes {
    
    public static String mensaje;
    
    public static void agregarMensaje(String texto){
        String inicioMensaje = "<mensaje>\n";
        String finMensaje ="</mensaje>\n";
        mensaje = inicioMensaje +"["+texto+"]\n"+finMensaje;
    }
    
    public static void prepararMensajesParaEnvio(){
        String inicioMensajes = "<mensajes>\n";
        String  finMensajes="</mensajes>";
        mensaje=inicioMensajes+mensaje+finMensajes;
    }
    
}
