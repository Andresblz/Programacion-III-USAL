package facturas;

import view.View;
import static com.coti.tools.DiaUtil.*;

public class Facturas {
	public static void main(String[] args) throws Exception {
		View v = new View();
		v.runMenu("\n1.- Importar facturas de disco"
				 +"\n2.- Leer importe mínimo"
				 +"\n3.- Calcular listados de morosos"
				 +"\n4.- Imprimir facturas adeudadas"
				 +"\n5.- Crear HTML de facturas adeudadas"
				 +"\nq.- Salir");
		showFinalTime();
		System.out.printf("%nTerminación normal del programa%n");
	}
}
