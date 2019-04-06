/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import ManejadoresDeTexto.LectorDeDatos;
import Objetos.Componente;
import Objetos.Etiqueta;
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

    public static ArrayList<Componente> listaDeComponentes = new ArrayList<>();
    public static ArrayList<Etiqueta> listaDeEtiquetas = new ArrayList<>();
    public static ArrayList<PaginaWeb> listaDePaginasWeb = new ArrayList<>();
    public static ArrayList<SitioWeb> listaDeSitiosWeb = new ArrayList<>();
    public static ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();

    public static void main(String[] args) {
        //Leyendo lo creado en cesiones anteriores
        cargaDeElementosAnteriores();
        //Leyendo los usuarios existenetes
        cargaDeUsuarios();
        for (Usuario usuario : listaDeUsuarios) {
            System.out.println("USUARIO:"+usuario.getNombre());
        }
        //Creando servidor para recibir texto 

        /*
       ManejadorDeServidor  nuevoServidor = new ManejadorDeServidor();
       nuevoServidor.iniciarServidor(45000);//Conexion para RECIBIR TEXTO
       
         */
 /*
        if (listaDeSitiosWeb.isEmpty()) {
            System.out.println("ES VACIA LA LISTA");
        }
        System.out.println("------------------------------------------------------------------------------------------------");

        //------------------------------SITIO WEB-----------------------------------------
        for (SitioWeb sitioWeb : listaDeSitiosWeb) {
            System.out.println("SITIO WEB:" + sitioWeb.getId());
            System.out.println(sitioWeb.getUsuarioCreacion());
            System.out.println(sitioWeb.getFechaCreacion());
            System.out.println(sitioWeb.getFechaModificacion());
            System.out.println(sitioWeb.getUsuarioModificacion());
        }
        System.out.println("------------------------------------------------------------------------------------------------");
        //------------------------------PAGINA WEB------------------------------------------

        for (PaginaWeb paginaWeb : listaDePaginasWeb) {
            System.out.println("PAGINA WEB:" + paginaWeb.getId());
            System.out.println(paginaWeb.getTitulo());
            System.out.println(paginaWeb.getSitio());
            System.out.println(paginaWeb.getPadre());
            System.out.println(paginaWeb.getUsuarioCreacion());
            System.out.println(paginaWeb.getFechaDeCreacion());
            System.out.println(paginaWeb.getFechaModificacion());
            System.out.println(paginaWeb.getUsuarioModificacion());
        }
        System.out.println("------------------------------------------------------------------------------------------------");

        //------------------------------ETIQUETAS-----------------------------------------
        for (Etiqueta etiqueta : listaDeEtiquetas) {
            System.out.println(etiqueta.getIdDePagina());
            for (String eti : etiqueta.getEtiquetas()) {
                System.out.println(eti);
            }
        }

        //------------------------------COMPONENTES-----------------------------------------

        System.out.println("------------------------------------------------------------------------------------------------");
        for (Componente componente : listaDeComponentes) {
            System.out.println("id " + componente.getId());
            System.out.println("pagina " + componente.getPagina());
            System.out.println("clase " + componente.getClase());
            System.out.println("color " + componente.getColor());
        }
         */
    }

    public static void cargaDeElementosAnteriores() {
        String elementos = LectorDeDatos.leerDatos("/home/jesfrin/Documentos/ArchivosP1Compi1/paginas.txt");
        AnalizadorLexicoPaginas lex = new AnalizadorLexicoPaginas(new BufferedReader(new StringReader(elementos)));
        parser sintactico = new parser(lex);
        try {
            sintactico.parse();
        } catch (Exception ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
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
            System.out.println("OCURRIO UN ERROR EN EL SINTACTICO");
        }
    }

}
