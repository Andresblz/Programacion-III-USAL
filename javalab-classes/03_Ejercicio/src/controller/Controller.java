package controller;

import model.Model;

import static com.coti.tools.OpMat.*;
import com.coti.tools.Rutas;
import java.io.File;

public class Controller {
	
	Model m = new Model();
	
	public int getNumeroDePartidos() {
		return m.getNUMERO_DE_PARTIDOS();
	}
	
	public void calcularResultados() {
		m.calcularResultados();
	}
	
	public String[][] getNombresDeEquipos() {
		return m.getTablaDeNombresDeEquipos();
	}
	
	public String[] getResultadosDeLosPartidos() {
		return m.getTablaDeResultadosDeLosPartidos();
	}
	
	public void importarEquiposDeDisco() throws Exception {
		String archivo = m.getNOMBRE_ARCHIVO_PARTIDOS();
		String carpeta = m.getNOMBRE_CARPETA_PARTIDOS();
		 /*
         * biblioteca.jar
         * pathToFileOnDesktop​(java.lang.String nameOfFile)
         * Este método devuelve la ruta a un archivo en el 
         * Escritorio.
         */
		File rutaArchivo = Rutas.pathToFileInFolderOnDesktop(carpeta, archivo).toFile();
		System.out.println("-------->" + rutaArchivo.toString());
		if (!rutaArchivo.exists()) {
			System.err.printf("%n%nNo existe ~Desktop/%s%s%n%n", carpeta, archivo);
			System.err.printf("%nCopie la carpeta %s en el escritorio%n", carpeta);
			return;
		}
		
		/*
		 * biblioteca.jar
		 * importFromDisk​(java.io.File f, java.lang.String delimiter)
		 * Este método importa del disco un String[][] escrito con formato
		 * delimitador
		 */
		String [][] tablaDeNombresDeEquipos = importFromDisk(rutaArchivo, "-");
		
		if(tablaDeNombresDeEquipos.length != m.getNUMERO_DE_PARTIDOS()) {
			System.err.printf("%nERROR: el número de parejas de equipos (%d) no coincide con el numero de partidos (%d)%n", 
							  tablaDeNombresDeEquipos.length, m.getNUMERO_DE_PARTIDOS());
			return;
		}
		this.guardarEnModelo(tablaDeNombresDeEquipos);
	}
	
	public void guardarEnModelo(String[][] tablaDeNombresDeEquipos) {
		m.guardarEnModelo(tablaDeNombresDeEquipos);
	}
	
	public void guardarEnModelo(int[][] marcadoresDeEquipos) {
		m.guardarEnModelo(marcadoresDeEquipos);
	}

}
