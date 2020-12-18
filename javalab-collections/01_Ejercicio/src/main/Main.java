package main;

import view.View;

public class Main {
	public static void main(String[] args) {
		System.out.printf("Facturas");
		View v = new View();
		v.runMenu("\n1.- Dar valroes"
				 +"\n2.- Mostrar lista"
				 +"\nq.- Salir");
	}
}