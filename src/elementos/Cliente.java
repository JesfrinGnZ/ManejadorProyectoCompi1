/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesfrin
 */
public class Cliente implements Runnable{

    final String HOST = "127.0.0.1";
    private int puerto;
    private String mensaje;
    private DataOutputStream out;

    public Cliente(int puerto,String mensaje){
        this.puerto=puerto;
        this.mensaje=mensaje;
    }
    
    private void iniciarConexion() throws IOException {
        Socket sc = new Socket(HOST, puerto);
        out = new DataOutputStream(sc.getOutputStream());//Para escritura de mensajes
        out.writeUTF(this.mensaje);
        //Cierra la conexion
        sc.close();
    }

    @Override
    public void run() {
        try {
            iniciarConexion();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}