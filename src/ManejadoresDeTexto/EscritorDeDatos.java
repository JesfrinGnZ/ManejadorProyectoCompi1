/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejadoresDeTexto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesfrin
 */
public class EscritorDeDatos {

    public static void agregarDatosABaseDeDatos(String texto, String direccion) {
        File direccionDeUsuarios = new File(direccion);
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(direccionDeUsuarios, true));
            bf.append(texto);
            bf.close();
        } catch (Exception ex) {
            Logger.getLogger(LectorDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void reescribirBaseDeDatos(String texto, String direccion) {
        File direccionDeUsuarios = new File(direccion);
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(direccionDeUsuarios));
            bf.write(texto);
            bf.close();
        } catch (Exception ex) {
            Logger.getLogger(LectorDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void escribirHtml(String texto, String direccion) {
        File direccionDeUsuarios = new File(direccion);
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(direccionDeUsuarios));
            bf.write(texto);
            bf.close();
        } catch (Exception ex) {
            Logger.getLogger(LectorDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void crearCarpetaParaSitioWeb(String direccion) {
        File direccionDeUsuarios = new File(direccion);
        direccionDeUsuarios.mkdir();
    }
    
    public static void borrarSitioWeb(String direccion) {
        File direccionDeUsuarios = new File(direccion);
        direccionDeUsuarios.deleteOnExit();
    }
    
    

}
