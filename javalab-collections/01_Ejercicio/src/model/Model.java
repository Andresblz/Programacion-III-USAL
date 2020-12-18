package model;

import java.util.ArrayList;

public class Model {
	final int NUM_FACTURAS = 10;
	private final ArrayList<Factura> lista = new ArrayList<>();
	
	public ArrayList<Factura> getLista() {
		return lista;
	}
	
	public void giveRandomValuesToList() {
		lista.clear();
		for(int i = 0; i < NUM_FACTURAS; i++) {
			lista.add(Factura.instanceWithRandomAttributes());
		}
	}
}
