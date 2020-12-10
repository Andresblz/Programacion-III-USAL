package view;

import static com.coti.tools.Esdia.*;
import static com.coti.tools.OpMat.*;
import controller.Controller;

public class View {
	Controller c = new Controller();
	
	public void runMenu(String menu) throws Exception {
		boolean salir = false;
		String option;
		String[] avaibleOptions = {"1", "2", "q"};
		do {	
			/*
        	 * biblioteca.jar
        	 * readString​(java.lang.String prompt, java.lang.String[] options)
        	 * Este método devuelve una de las opciones pasadas en el segundo 
        	 * argumento después de haber incitado con el primero
        	 */
			option = readString(menu, avaibleOptions);
			switch(option) {
				case "1":
					this.importarArchivo();
					break;
				case "2":
					this.mostrarDatos();
					break;
				case "q":
				case "Q":
					/*
	            	 * biblioteca.jar
	            	 * yesOrNo​(java.lang.String prompt)
	            	 * Este método solicita un booleano, permitiendo 
	            	 * sólo "y" o "n" como entrada.
	            	 */
					salir = yesOrNo("¿Desea realmente salir de la aplicación? ");
					break;
				default:
					System.out.printf("ERROR: Seleccione una opcion válida (1, 2, q).");
					break;
			}
		} while(!salir);
	}
	
	private void importarArchivo() {
		c.importarArchivo();
		int numPersonas = c.getNumPersonas();
		System.out.printf("%nSe han encontrado %d personas%n", numPersonas);
	}
	
	private void mostrarDatos() throws Exception {
		String[][] tmp = c.getPersonasImportadasComoTabla();
		System.out.printf("%nLista de personas importadas%n");
		/*
		 * biblioteca.jar
		 * printToScreen3(java.lang.String[][] matrix)
		 * Este metodo muestra en pantalla un String[][] con un mínimo
		 * y posiblemente diferentes anchos para cada columna
		 */
		printToScreen3(tmp);
	}
}
