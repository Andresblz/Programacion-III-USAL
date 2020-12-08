package view;

import controller.Controller;

import static com.coti.tools.Esdia.*;
import static com.coti.tools.OpMat.*;

public class View {
	Controller c = new Controller();
	
	public void runMenu(String menu) throws Exception {
		boolean salir = false;
		String option;
		String[] avaibleOptions = {"1", "2", "3", "4", "5", "q"};
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
				this.leerEquiposPorTeclado();
				break;
			case "2":
				this.leerMarcadoresPorTeclado();
				break;
			case "3":
				this.calcularResultados();
				break;
			case "4":
				this.mostrarResultados();
				break;
			case "5":
				this.importarEquiposDeDisco();
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
				System.out.printf("ERROR: Introduzca una opción válida (1, 2, 3, 4, 5, q).");
				break;
			}
		} while(!salir);
	}
	
	
	/*
	 * OPCIÓN 1 - LEER EQUIPOS POR TECLADO
	 */
	private void leerEquiposPorTeclado() {
		final int NUMERO_DE_PARTIDOS = c.getNumeroDePartidos();
		final int NUMERO_DE_EQUIPOS = 2;
		String[][] tmp = new String[NUMERO_DE_PARTIDOS][NUMERO_DE_EQUIPOS];
		for (int np = 0; np < NUMERO_DE_PARTIDOS; np++) {
			System.out.printf("%nPartido nº %2d:%n", np+1);
			/*
        	 * biblioteca.jar
        	 * readString​(java.lang.String prompt, java.lang.String[] options)
        	 * Este método devuelve una de las opciones pasadas en el segundo 
        	 * argumento después de haber incitado con el primero
        	 */
			tmp[np][0] = readString("Equipo local    : ");
			tmp[np][1] = readString("Equipo vistante : ");
		}
		c.guardarEnModelo(tmp);
	}
	
	
	/*
	 * OPCIÓN 2 - LEER MARCADOR POR TECLADO
	 */
	private void leerMarcadoresPorTeclado() {
		final int NUM_PARTIDOS = c.getNumeroDePartidos();
		final int NUM_EQUIPOS = 2;
		int[][] tmp = new int[NUM_PARTIDOS][NUM_EQUIPOS];
		String[][] equipos = c.getNombresDeEquipos();
		System.out.printf("%n%nGOLES%n%n");
		for(int np = 0; np < NUM_PARTIDOS; np++) {
			System.out.printf("%nPartido nº %2d (%s)%n", np+1, equipos[np][0] + "-" + equipos[np][1]);
			/*
        	 * biblioteca.jar
        	 * readInt​(java.lang.String prompt)
        	 * Este método devuelve un int
        	 */
			tmp[np][0] = readInt("Goles equipo local     : ");
			tmp[np][1] = readInt("Goles equipo visitante : ");
		}
		c.guardarEnModelo(tmp);
	}
	
	
	/*
	 * OPCIÓN 3 - CALCULAR RESULTADOS
	 */
	private void calcularResultados() {
		c.calcularResultados();
		System.out.printf("%nSe han calculado los resultados de los partidos correctamente%n");
	}
	
	
	/*
	 * OPCIÓN 4 - MOSTRAR LOS RESULTADOS
	 */
	private void mostrarResultados() throws Exception {
		String[][] nombresDeLosEquipos = c.getNombresDeEquipos();
		String[] resultadosDeLosPartidos = c.getResultadosDeLosPartidos();
		System.out.printf("%nRESULTADOS DE LOS PARTIDOS%n");
		/*
		 * biblioteca.jar
		 * printToScreen3(java.lang.String[][] matrix)
		 * Este método muestra en pantalla un String[][] con un mínimo
		 * y posiblemente diferentes anchos para cada columna
		 * 
		 * join(java.lang.String[][] a, java.lang.String[][] b)
		 * Este método devuelve la unión de dos String[][]
		 */
		printToScreen3(join(nombresDeLosEquipos, resultadosDeLosPartidos));
	}
	
	
	/*
	 * OPCIÓN 5 - IMPORTAR EQUIPOS DE .TXT
	 */
	private void importarEquiposDeDisco() throws Exception {
		c.importarEquiposDeDisco();
		this.mostrarListaDeEquiposPorPartidos();
	}
	
	private void mostrarListaDeEquiposPorPartidos() throws Exception {
		String[][] equipos = c.getNombresDeEquipos();
		System.out.printf("%nLISTA DE PARTIDOS%n");
		/*
		 * biblioteca.jar
		 * printToScreen3(java.lang.String[][] matrix)
		 * Este metodo muestra en pantalla un String[][] con un mínimo
		 * y posiblemente diferentes anchos para cada columna
		 */
		printToScreen3(equipos);
	}
}
