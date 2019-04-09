/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import ManejadoresDeTexto.EscritorDeDatos;
import elementos.Run;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class Componente {

    private String id, pagina, clase;//Parametros
    private String texto, alineacion, color, origen, altura, ancho, padre, etiquetas;//Atributos segun clase

    public Componente() {
    }

    public void darValoresCreacion(ArrayList<Token> listaDeTokens, ArrayList<Token> listaDeAtributos) {
        int contador = 0;
        PaginaWeb paginaWeb = null;
        for (Token token : listaDeTokens) {
            String valor = token.getLexema();
            switch (token.getTipo()) {
                case "ID":
                    ManejadorDeMensajes.agregarMensaje("-------------COMPONENTE ID:" + this.id + "----------------");
                    this.id = valor;
                    break;
                case "PAGINA":
                    this.pagina = valor;
                    for (PaginaWeb pag : Run.listaDePaginasWeb) {
                        if (pag.getId().equals(this.pagina)) {
                            paginaWeb = pag;
                            break;
                        }
                    }
                    if (paginaWeb != null) {
                        if (paginaWeb.getListaDeComponentes() != null) {
                            for (Componente componente : paginaWeb.getListaDeComponentes()) {
                                if (componente.getId().equals(this.id)) {
                                    ManejadorDeMensajes.agregarMensaje("ERROR el componente con id:" + this.id + " ya existe en la pagina con id:" + this.pagina);
                                    contador++;
                                    break;
                                }
                            }
                        }

                    } else {
                        ManejadorDeMensajes.agregarMensaje("ERROR la PAGINA_WEB con id:" + this.pagina + " no existe.");
                        contador++;
                    }

                case "CLASE":
                    this.clase = valor;
                    break;
            }
        }

        for (Token atributo : listaDeAtributos) {
            String valor = atributo.getLexema();
            switch (atributo.getTipo()) {
                case "texto":
                    this.texto = valor;
                    break;
                case "alineacion":
                    this.alineacion = valor;
                    break;
                case "color":
                    this.color = valor;
                    break;
                case "origen":
                    this.origen = valor;
                    break;
                case "altura":
                    this.altura = valor;
                    break;
                case "ancho":
                    this.ancho = valor;
                    break;
                case "padre":
                    this.padre = valor;
                    break;
                case "etiquetas":
                    this.etiquetas = valor;
                    break;
            }
        }

        if (contador == 0) {
            //Se anade de una el compoennte a la pagina
            if (paginaWeb.getListaDeComponentes() == null) {
                ArrayList<Componente> listaComponente = new ArrayList<>();
                listaComponente.add(this);
                paginaWeb.setListaDeComponentes(listaComponente);
            } else {
                paginaWeb.getListaDeComponentes().add(this);
            }
            //Se reescribe el html de la pagina
            String html = armarHtmlParaPagina(paginaWeb);
            EscritorDeDatos.escribirHtml(html, paginaWeb.getDireccion());
            ManejadorDeMensajes.agregarMensaje("Se ha creado el componente:" + this.id);
            //Se escriben los datos de la base de nuevo
            EscritorDeDatos.reescribirBaseDeDatos(ManejadorDeMensajes.escribirSitiosWeb(), "/home/jesfrin/Documentos/ArchivosP1Compi1/paginas.txt");
            ManejadorDeMensajes.textoBaseDeDatos = "";
        }
    }

    public void darValoresModificacion(ArrayList<Token> listaDeTokens, ArrayList<Token> listaDeAtributos) {
        int contador = 0;
        PaginaWeb paginaWeb = null;
        Componente componenteAModificar = null;
        for (Token token : listaDeTokens) {
            String valor = token.getLexema();
            switch (token.getTipo()) {
                case "ID":
                    ManejadorDeMensajes.agregarMensaje("-------------COMPONENTE ID:" + this.id + "----------------");
                    this.id = valor;
                    break;
                case "PAGINA":
                    this.pagina = valor;
                    for (PaginaWeb pag : Run.listaDePaginasWeb) {
                        if (pag.getId().equals(this.pagina)) {
                            paginaWeb = pag;
                            break;
                        }
                    }
                    if (paginaWeb != null) {
                        if (paginaWeb.getListaDeComponentes() != null) {
                            for (Componente componente : paginaWeb.getListaDeComponentes()) {
                                if (componente.getId().equals(this.id)) {
                                    componenteAModificar = componente;
                                    //ManejadorDeMensajes.agregarMensaje("ERROR el componente con id:" + this.id + " ya existe en la pagina con id:" + this.pagina);
                                    //contador++;
                                    break;
                                }
                            }
                        }
                        if (componenteAModificar == null) {
                            ManejadorDeMensajes.agregarMensaje("ERROR El componente con id:" + this.id + " no existe.");
                            contador++;
                        }
                    } else {
                        ManejadorDeMensajes.agregarMensaje("ERROR la PAGINA_WEB con id:" + this.pagina + " no existe.");
                        contador++;
                    }

                case "CLASE":
                    this.clase = valor;
                    break;
            }
        }

        for (Token atributo : listaDeAtributos) {
            String valor = atributo.getLexema();
            switch (atributo.getTipo()) {
                case "texto":
                    this.texto = valor;
                    break;
                case "alineacion":
                    this.alineacion = valor;
                    break;
                case "color":
                    this.color = valor;
                    break;
                case "origen":
                    this.origen = valor;
                    break;
                case "altura":
                    this.altura = valor;
                    break;
                case "ancho":
                    this.ancho = valor;
                    break;
                case "padre":
                    this.padre = valor;
                    break;
                case "etiquetas":
                    this.etiquetas = valor;
                    break;
            }
        }

        if (contador == 0) {
            //Se anade de una el compoennte a la pagina
            for (Componente comp : paginaWeb.getListaDeComponentes()) {
                if(comp.getId().equals(this.id)){
                    comp=this;//Comp ahora toma el valor del componente que ingreso
                }
            }
            //Se reescribe el html de la pagina
            String html = armarHtmlParaPagina(paginaWeb);
            EscritorDeDatos.escribirHtml(html, paginaWeb.getDireccion());
            ManejadorDeMensajes.agregarMensaje("Se ha creado el componente:" + this.id);
            //Se escriben los datos de la base de nuevo
            EscritorDeDatos.reescribirBaseDeDatos(ManejadorDeMensajes.escribirSitiosWeb(), "/home/jesfrin/Documentos/ArchivosP1Compi1/paginas.txt");
            ManejadorDeMensajes.textoBaseDeDatos = "";
        }
    }

    public static void borrarComponente(ArrayList<Token> listaDeTokens) {
        String idComponente = listaDeTokens.get(0).getLexema();
        String idPagina = listaDeTokens.get(1).getLexema();
        ManejadorDeMensajes.agregarMensaje("-------------ELIMINAR COMPONENTE ID:" + idComponente + "----------------");
        PaginaWeb paginaWeb = null;
        Componente componente = null;
        for (PaginaWeb pag : Run.listaDePaginasWeb) {//Se busca la pagina web
            if (pag.getId().equals(idPagina)) {
                paginaWeb = pag;
                break;
            }
        }
        if (paginaWeb != null) {//Se busca el componente ya con la pagina
            for (Componente comp : paginaWeb.getListaDeComponentes()) {
                if (comp.getId().equals(idPagina)) {
                    componente = comp;
                    break;
                }
            }
            if (componente != null) {//El compoennte existe
                paginaWeb.getListaDeComponentes().remove(componente);
                //Se reescribe el html de la pagina
                String html = armarHtmlParaPagina(paginaWeb);
                EscritorDeDatos.escribirHtml(html, paginaWeb.getDireccion());
                ManejadorDeMensajes.agregarMensaje("Se ha eliminado el componente:" + idComponente);
                //Se escriben los datos de la base de nuevo
                EscritorDeDatos.reescribirBaseDeDatos(ManejadorDeMensajes.escribirSitiosWeb(), "/home/jesfrin/Documentos/ArchivosP1Compi1/paginas.txt");
                ManejadorDeMensajes.textoBaseDeDatos = "";
            } else {
                ManejadorDeMensajes.agregarMensaje("El componente con id:" + idComponente + " " + "no existe");
            }
        } else {//la pagina no existe
            ManejadorDeMensajes.agregarMensaje("La pagina web con id:" + idPagina + " " + "no existe");

        }
    }

    public static String armarHtmlParaPagina(PaginaWeb paginaWeb) {
        String textoComponentes = "";
        for (Componente comp : paginaWeb.getListaDeComponentes()) {
            textoComponentes += comp.generarTextoHtmParaComponente();
        }
        return "<HTML>\n"
                + "<HEAD>\n"
                + "<title>" + paginaWeb.getTitulo() + "</title></HEAD>\n"
                + "<BODY>\n" + textoComponentes
                + "</BODY>\n"
                + "</HTML>";
    }

    public String generarTextoHtmParaComponente() {
        String textoHtml = "";
        switch (this.clase) {
            case "TITULO":
                textoHtml = " <h1 align=\"" + devolverAlineacion() + "\" style=\"color:" + this.color + "\";>" + this.texto + "</h1>\n";
                break;
            case "PARRAFO":
                textoHtml = "<p align=\"" + devolverAlineacion() + "\" style=\"color:" + this.color + "\";>" + this.texto + "</p>\n";
                break;
            case "IMAGEN":
                textoHtml = "    <" + devolverAlineacion() + ">\n"
                        + "    <img src=\"" + this.origen + "\" width=\"" + this.ancho + "\" height=\"" + this.altura + "\">   \n"
                        + "    </" + devolverAlineacion() + ">";
                break;
            case "VIDEO":
                textoHtml = "    <" + devolverAlineacion() + ">    \n"
                        + "    <video src=\"" + this.origen + "\" width=\"" + this.ancho + "\" height=\"" + this.altura + "\" controls autoplay preload></video>\n"
                        + "    </" + devolverAlineacion() + ">";
                break;
            case "MENU":
                System.out.println("ES MENU LOL");
                break;

        }
        return texto;
    }

    public String devolverAlineacion() {
        switch (this.alineacion) {
            case "CENTRAR":
                return "center";
            case "IZQUIERDA":
                return "left";
            case "DERECHA":
                return "right";
            case "JUSTIFICAR":
                return "justify";
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.substring(1, id.length() - 1);
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase.substring(1, clase.length() - 1);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto.substring(1, texto.length() - 1);
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion.substring(0, alineacion.length() - 1);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color.substring(1, color.length() - 1);
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen.substring(1, origen.length() - 1);
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura.substring(1, altura.length() - 1);
    }

    public String getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho.substring(1, ancho.length() - 1);
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre.substring(1, padre.length() - 1);
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas.substring(1, etiquetas.length() - 1);
    }

}
