package controller;

import static com.coti.tools.OpMat.exportToDisk;
import static com.coti.tools.Rutas.pathToFileOnDesktop;
import java.io.File;
import model.Model;

public class Controller {
    Model m = new Model();
    
    public void crearLista(){
        m.crearLista();
    }
    
    public void exportarDatosPersonales() throws Exception {
        String[][] tmp = m.tablaDatosPersonales();
        /*
         * biblioteca.jar
         * pathToFileOnDesktop​(java.lang.String nameOfFile)
         * Este método devuelve la ruta a un archivo en el 
         * Escritorio.
         */
        File f = pathToFileOnDesktop("datos_personales.txt").toFile();
        /*
         * biblioteca.jar
         * exportToDisk​(java.lang.String[][] matrix, java.io.File f, java.lang.String delimiter)
         * Este método exporta un String[][] con formato delimitado y puede lanzar una excepción.
         */
        exportToDisk(tmp, f, "\t");
    }
    
    public void exportarDirecciones() throws Exception {
        String[][] tmp = m.tablaDeDirecciones();
        File f = pathToFileOnDesktop("datos_de_direcciones.txt").toFile();
        exportToDisk(tmp, f, "\t");
    }
    
    public String[][] tablaGeneralDeDatos(){
        return m.tablaGeneralDeDatos();
    }
}