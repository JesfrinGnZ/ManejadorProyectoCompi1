/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import elementos.Run;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeMensajes {

    //Mensaje que se le mandar a la aplicacion cliente
    public static String mensajeParaCliente = "";

    public static String textoBaseDeDatos = "";

    public static void agregarMensaje(String texto) {
        String inicioMensaje = "<mensaje>\n";
        String finMensaje = "</mensaje>\n";
        mensajeParaCliente += inicioMensaje + "[" + texto + "]\n" + finMensaje;
    }

    public static void prepararMensajesParaEnvio() {
        String inicioMensajes = "<mensajes>\n";
        String finMensajes = "</mensajes>";
        mensajeParaCliente = inicioMensajes + mensajeParaCliente + finMensajes;
    }

    private static String escribirSitioWeb(SitioWeb sitioWeb) {
        return "<sitioWeb>\n"
                + "    <parametrosSitioWeb>\n"
                + "        <parametroSitioWeb nombre = \"ID\">\n"
                + "            [" + sitioWeb.getId() + "]                   \n"
                + "        </parametroSitioWeb>\n"
                + "        <parametroSitioWeb nombre =\"DIRECCION\">\n"
                + "            ["+sitioWeb.getDireccion()+"]\n"
                + "        </parametroSitioWeb>\n"
                + "        <parametroSitioWeb nombre = \"USUARIO_CREACION\">\n"
                + "            [" + sitioWeb.getUsuarioCreacion() + "]                   \n"
                + "        </parametroSitioWeb>\n"
                + "        <parametroSitioWeb nombre = \"FECHA_CREACION\">\n"
                + "            [" + sitioWeb.getFechaCreacion() + "]                   \n"
                + "        </parametroSitioWeb>\n"
                + "        <parametroSitioWeb nombre = \"FECHA_MODIFICACION\">\n"
                + "            [" + sitioWeb.getFechaModificacion() + "]                   \n"
                + "        </parametroSitioWeb>\n"
                + "        <parametroSitioWeb nombre = \"USUARIO_MODIFICACION\">\n"
                + "            [" + sitioWeb.getUsuarioModificacion() + "]                   \n"
                + "        </parametroSitioWeb>\n"
                + "    </parametrosSitioWeb>\n"
                + "    <paginasSitioWeb>\n";

    }

    private static String escribirParametrosPaginaWeb(PaginaWeb paginaWeb) {
        return "<pagina>\n"
                + "            <parametrosDePagina>\n"
                + "                <parametroDePagina nombre = \"ID\">\n"
                + "                    [" + paginaWeb.getId() + "]                   \n"
                + "                </parametroDePagina>\n"
                + "                <parametroDePagina nombre = \"DIRECCION\">\n"
                + "                    [" + paginaWeb.getDireccion() + "]                   \n"
                + "                </parametroDePagina>                \n"
                + "                <parametroDePagina nombre = \"TITULO\">\n"
                + "                    [" + paginaWeb.getTitulo() + "]                   \n"
                + "                </parametroDePagina>\n"
                + "                <parametroDePagina nombre = \"SITIO\">\n"
                + "                    [" + paginaWeb.getSitio() + "]                   \n"
                + "                </parametroDePagina>\n"
                + "                <parametroDePagina nombre = \"PADRE\">\n"
                + "                    [" + paginaWeb.getPadre() + "]                   \n"
                + "                </parametroDePagina>\n"
                + "                <parametroDePagina nombre = \"USUARIO_CREACION\">\n"
                + "                    [" + paginaWeb.getUsuarioCreacion() + "]                   \n"
                + "                </parametroDePagina>\n"
                + "                <parametroDePagina nombre = \"FECHA_CREACION\">\n"
                + "                    [" + paginaWeb.getFechaDeCreacion() + "]                   \n"
                + "                </parametroDePagina>\n"
                + "                <parametroDePagina nombre = \"FECHA_MODIFICACION\">\n"
                + "                    [" + paginaWeb.getFechaModificacion() + "]                   \n"
                + "                </parametroDePagina>\n"
                + "                <parametroDePagina nombre = \"USUARIO_MODIFICACION\">\n"
                + "                    [" + paginaWeb.getUsuarioModificacion() + "]                   \n"
                + "                </parametroDePagina>          \n"
                + "            </parametrosDePagina>\n";
    }

    private static String escribirComponentes(PaginaWeb paginaWeb) {
        String textoDeComponentes = "";
        if (paginaWeb.getListaDeComponentes() != null && !paginaWeb.getListaDeComponentes().isEmpty()) {
            textoDeComponentes += "<componentes>\n";
            for (Componente componente : paginaWeb.getListaDeComponentes()) {
                textoDeComponentes += "                <componente nombre = \"" + componente.getClase() + "\">\n"
                        + "                    <atributos>\n"
                        + "                        <atributo nombre =\"ID\">\n"
                        + "                            [" + componente.getId() + "]\n"
                        + "                         </atributo>\n";

                if (componente.getTexto() != null) {
                    textoDeComponentes += "                        <atributo nombre =\"TEXTO\">\n"
                            + "                            [" + componente.getTexto() + "]\n"
                            + "                        </atributo>\n";
                }
                if (componente.getAlineacion() != null) {
                    textoDeComponentes += "                        <atributo nombre =\"ALINEACION\">\n"
                            + "                            [" + componente.getAlineacion() + "]\n"
                            + "                        </atributo>\n";
                }
                if (componente.getColor() != null) {
                    textoDeComponentes += "                        <atributo nombre =\"COLOR\">\n"
                            + "                            [" + componente.getColor() + "]\n"
                            + "                        </atributo>\n";
                }

                if (componente.getOrigen() != null) {
                    textoDeComponentes += "                        <atributo nombre =\"ORIGEN\">\n"
                            + "                            [" + componente.getOrigen() + "]\n"
                            + "                        </atributo>\n";
                }

                if (componente.getAltura() != null) {
                    textoDeComponentes += "                        <atributo nombre =\"ALTURA\">\n"
                            + "                            [" + componente.getAltura() + "]\n"
                            + "                        </atributo>\n";
                }

                if (componente.getAncho() != null) {
                    textoDeComponentes += "                        <atributo nombre =\"ANCHO\">\n"
                            + "                            [" + componente.getAncho() + "]\n"
                            + "                        </atributo>\n";
                }

                if (componente.getPadre() != null) {
                    textoDeComponentes += "                        <atributo nombre =\"PADRE\">\n"
                            + "                            [" + componente.getPadre() + "]\n"
                            + "                        </atributo>\n";
                }

                if (componente.getEtiquetas() != null) {
                    textoDeComponentes += "                        <atributo nombre =\"ETIQUETAS\">\n"
                            + "                            [" + componente.getEtiquetas() + "]\n"
                            + "                        </atributo>\n";
                }
                textoDeComponentes += "                    </atributos>\n";
                textoDeComponentes += "</componente>\n";
            }
            textoDeComponentes += "</componentes>\n";
        }

        return textoDeComponentes;
    }

    private static String escribirEtiquetas(PaginaWeb paginaWeb) {
        String etiquetas = "";
        if (paginaWeb.getListaDeEtiquetas() != null && !paginaWeb.getListaDeEtiquetas().isEmpty()) {
            etiquetas += "\t<etiquetas>\n";
            for (Etiqueta etiqueta : paginaWeb.getListaDeEtiquetas()) {
                etiquetas += "\t\t<etiqueta nombre =[" + etiqueta.getEtiqueta() + "]/>\n";
            }
            etiquetas += "\t</etiquetas>\n";
        }
        return etiquetas;
    }

    public static void buscarPaginasHijas(String idSitio) {
        for (PaginaWeb paginaWeb : Run.listaDePaginasWeb) {
            if (paginaWeb.getSitio().equals(idSitio)) {
                textoBaseDeDatos += escribirParametrosPaginaWeb(paginaWeb);
                textoBaseDeDatos += escribirComponentes(paginaWeb);
                textoBaseDeDatos += escribirEtiquetas(paginaWeb);
                textoBaseDeDatos += "</pagina>\n";
            }
        }
        //Que cierre la pagina;
    }

    public static String escribirSitiosWeb() {
        for (SitioWeb sitioWeb : Run.listaDeSitiosWeb) {
            textoBaseDeDatos += escribirSitioWeb(sitioWeb);
            buscarPaginasHijas(sitioWeb.getId());
            textoBaseDeDatos += "</paginasSitioWeb>\n";
            textoBaseDeDatos += "</sitioWeb>";
            System.out.println(",.,.,.,.,<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(textoBaseDeDatos);
            System.out.println(",.,.,.,.,<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        }

        return textoBaseDeDatos;

    }
}
