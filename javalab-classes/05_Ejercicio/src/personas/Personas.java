package personas;

import view.View;

public class Personas {
	public static void main(String[] args) throws Exception {
		View v = new View();
		v.runMenu("\n1.- Importar archivo de personas"
				 +"\n2.- Mostrar datos"
				 +"\nq.- Salir");
	}
}