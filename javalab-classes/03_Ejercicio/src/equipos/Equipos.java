package equipos;

import view.View;

public class Equipos {
	public static void main(String[] args) throws Exception {
		View v = new View();
		v.runMenu("\n1.- Leer equipos"
				 +"\n2.- Leer goles de cada equipo"
				 +"\n3.- Calcular resultados"
				 +"\n4.- Mostrar resultados"
				 +"\n5.- Importar equipos (disco)"
				 +"\nq.- Salir");
	}
}
