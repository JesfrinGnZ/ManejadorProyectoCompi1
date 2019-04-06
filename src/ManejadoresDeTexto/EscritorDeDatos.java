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
    
        public static void escribirDatos(String texto) {
        File direccionDeUsuarios = new File("/home/jesfrin/Documentos/ArchivosP1Compi1/Usuarios.txt");
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(direccionDeUsuarios, true));
            bf.append(texto);
            bf.close();
        } catch (Exception ex) {
            Logger.getLogger(LectorDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
