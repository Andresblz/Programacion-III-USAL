package controller;

import com.coti.tools.Rutas;
import com.coti.tools.OpMat;
import model.Model;
import model.Persona;
import java.io.*;
import java.util.*;


public class Controller {
	Model m = new Model();
	
	public void importarArchivo() {
		String nombreDelArchivo = m.getNombreDelArchivo();
		String nombreDeCarpeta = m.getNombreDeCarpeta();
		List<Persona> personasImportadas;
		
		/*
		 * biblioteca.jar
		 * pathToFileInFolderOnDesktop​(java.lang.String nameOfFolder, java.lang.String nameOfFile)
		 * Este método devuelve la ruta de un fichero que está dentro de una carpeta
		 * en el escritorio.
		 */
		File f = Rutas.pathToFileInFolderOnDesktop(nombreDeCarpeta, nombreDelArchivo).toFile();
		
		if (!f.exists()) {
			System.err.printf("%nERROR: no se puede encontrar %s en la carpeta %s del escritorio.", nombreDelArchivo, nombreDeCarpeta);
			System.err.printf("%nCopie los datos en el escritorio%n");
			return;
		}
		
		String[][] tmp;
		try {
			/*
			 * biblioteca.jar
			 * importFromDisk​(java.io.File f, java.lang.String delimiter)
			 * Este metodo importa de disco un String[][] separado con un delimitador
			 */
			tmp = OpMat.importFromDisk(f, "\t");
		} catch (Exception ex) {
			System.out.printf("ERROR: %s/%s no existe, cópiela en el escritorio.", nombreDeCarpeta, nombreDelArchivo);
			return;
		}
		
		personasImportadas = new ArrayList<>();
		Persona x;
		for(String[] fila : tmp) {
			x = Persona.factory(fila);
			if(null != x) {
				personasImportadas.add(x);
			}
		}
		
		m.setPersonasImportadas(personasImportadas);
	}
	
	public String[][] getPersonasImportadasComoTabla() {
		final int numPersonas = m.getPersonasImportadas().size();
		String[][] tabla = new String[numPersonas][];
		for (int n = 0; n < numPersonas; n++) {
			tabla[n] = m.getPersonasImportadas().get(n).stateAsStringList();
		}
		return tabla;
	}
	
	public int getNumPersonas() {
		return m.getPersonasImportadas().size();
	}
	
}
