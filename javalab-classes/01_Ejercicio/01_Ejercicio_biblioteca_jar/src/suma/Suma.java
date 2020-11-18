package suma;

import view.View;

public class Suma{
	public static void main(String[] args) {
		View v = new View();
		v.runMenu("\n1.- Leer numeros"
				 +"\n2.- Sumar numeros"
				 +"\n3.- Mostrar resultado"
				 +"\nq.- Salir"
				 +"\nIntroduce una opcion: ");
	}
}
