/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import Objetos.ManejadorDeMensajes;
import analizadoresConvertidoresHtml.AnalizadorLexicoTextoCliente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
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
        //Se analiza el mensaje de la app cliente
        AnalizadorLexicoTextoCliente lex = new AnalizadorLexicoTextoCliente(new BufferedReader(new StringReader(mensaje)));
        analizadoresConvertidoresHtml.parser sintactico = new analizadoresConvertidoresHtml.parser(lex);
        try {
            sintactico.parse();
        } catch (Exception ex) {
            Logger.getLogger(ManejadorDeServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Se manda las acciones que se completaron o las acciones que no se pudieron cumplir
        Cliente c = new Cliente(9000,ManejadorDeMensajes.mensajeParaCliente);
        Thread t = new Thread(c);
        t.start();
        ManejadorDeMensajes.mensajeParaCliente="";
    }

}
