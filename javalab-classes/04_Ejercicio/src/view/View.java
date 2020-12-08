package view;

import controller.Controller;
import static com.coti.tools.Esdia.*;
import static com.coti.tools.OpMat.*;
import com.coti.tools.Rutas;
import java.io.File;

public class View {
	Controller c = new Controller();
	
	public void runMenu(String menu) throws Exception {
		boolean salir = false;
		String option;
		String[] avaibleOptions = {"1","2","3","4","5","q"};
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
					this.importarFacturasDisco();
					break;
				case "2":
					this.leerImporteMinimo();
					break;
				case "3":
					this.calcularListadoMorosos();
					break;
				case "4":
					this.imprimirFacturasAdeudadas();
					break;
				case "5":
					this.crearHTMLFacturasAdeudadas();
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
					System.out.printf("%nERROR: Introduzca una opción válida (1, 2, 3, 4, 5, q).");
					break;
			}
		} while(!salir);
	}
	
	
	private void importarFacturasDisco() {
		System.out.printf("%nLectura de datos (archivo en el Escritorio)%n");
		/*
		 * biblioteca.jar
		 * readString_ne​(java.lang.String prompt)
		 * Este metodo devuelve un String no-nulo.
		 */
		String archivo = readString_ne("Nombre de archivo: ");
		File rutaArchivo = Rutas.pathToFileOnDesktop(archivo).toFile();
		c.importarDatosDe(rutaArchivo);
		System.out.printf("%nSe han importado los datos correctamente%n");
	}
	
	private void leerImporteMinimo() {
		/*
    	 * biblioteca.jar
    	 * readFloat​(java.lang.String prompt)
    	 * Este método devuelve un float.
    	 */
		float tmp = readFloat("%nImporte mínimo de las facturas deseadas: ");
		c.guardarImporteMinimoEnModelo(tmp);
		System.out.printf("%nImporte mínimo = %8.2f€%n", c.getImporteMinimo());
	}
	
	private void calcularListadoMorosos() {
		c.calcularMorosos();
		System.out.printf("%nListado de facturas adeudadas correctamente calculado%n");
	}
	
	private void imprimirFacturasAdeudadas() throws Exception {
		System.out.printf("%nListado de morosos%n");
		/*
		 * biblioteca.jar
		 * printToScreen3(java.lang.String[][] matrix)
		 * Este metodo muestra en pantalla un String[][] con un mínimo
		 * y posiblemente diferentes anchos para cada columna
		 */
		printToScreen3(c.getDatosMorosos());
	}
	
	private void crearHTMLFacturasAdeudadas() throws Exception {
		c.crearHTMLFacturasAdeudadas();
		System.out.printf("%nCreado correctamente %s%n", c.getNombreArchivoHTML());
	}
}
