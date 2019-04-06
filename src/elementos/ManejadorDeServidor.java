/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeServidor implements Observer {

    public void iniciarServidor(int puerto) {
        try {
            Servidor nuevoServidor = new Servidor(puerto);
            nuevoServidor.addObserver(this);
            Thread t = new Thread(nuevoServidor);
            t.start();
        } catch (IOException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        String mensaje = (String) arg;
        System.out.println("DESDE SERVIDOR");
        System.out.println(mensaje);
    }

}
