/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import ManejadoresDeTexto.LectorDeDatos;
import Objetos.Componente;
import Objetos.Etiqueta;
import Objetos.ManejadorDeMensajes;
import Objetos.PaginaWeb;
import Objetos.SitioWeb;
import Objetos.Usuario;
import analizadorParaLogin.AnalizadorLexicoUsuarios;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import recuperacionPaginas.AnalizadorLexicoPaginas;
import recuperacionPaginas.parser;

/**
 *
 * @author jesfrin
 */
public class Run {

    public static ArrayList<SitioWeb> listaDeSitiosWeb = new ArrayList<>();
    public static ArrayList<PaginaWeb> listaDePaginasWeb = new ArrayList<>();
    public static ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();

    public static void main(String[] args) {
        //Leyendo lo creado en cesiones anteriores
        cargaDeElementosAnteriores();
        //Leyendo los usuarios existenetes
        cargaDeUsuarios();

        //ManejadorDeMensajes.escribirSitioWeb();
        //Creando servidor para recibir texto 
        ManejadorDeServidor nuevoServidor = new ManejadorDeServidor();
        nuevoServidor.iniciarServidor(6000);//Conexion para RECIBIR TEXTO

    }

    public static void cargaDeElementosAnteriores() {
        String elementos = LectorDeDatos.leerDatos("/home/jesfrin/Documentos/ArchivosP1Compi1/paginas.txt");
        if (elementos != null && !elementos.isEmpty()) {
            AnalizadorLexicoPaginas lex = new AnalizadorLexicoPaginas(new BufferedReader(new StringReader(elementos)));
            parser sintactico = new parser(lex);
            try {
                sintactico.parse();
            } catch (Exception ex) {
                Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void cargaDeUsuarios() {
        String instruccion = LectorDeDatos.leerDatos("/home/jesfrin/Documentos/ArchivosP1Compi1/Usuarios.txt");
        AnalizadorLexicoUsuarios lexico = new AnalizadorLexicoUsuarios(new BufferedReader(new StringReader(instruccion)));
        analizadorParaLogin.parser sintactico = new analizadorParaLogin.parser(lexico, listaDeUsuarios);
        try {
            sintactico.parse();
        } catch (Exception ex) {
            // Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("OCURRIO UN ERROR EN EL SINTACTICO");
        }
    }

}
