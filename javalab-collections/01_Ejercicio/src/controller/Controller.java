package controller;

import model.Model;

public class Controller {
	private final Model m = new Model();
	
	public void darValores() {
		m.giveRandomValuesToList();
	}
	
	public String[] obtenerListado() {
		if(m.getLista().isEmpty()) {
			return null;
		}
		
		String[] temp = new String[this.getNumFacturas()];
		
		for(int i = 0; i < temp.length; i++) {
			temp[i] = m.getLista().get(i).exportStateAsColumns();
		}
		return temp;
	}
	
	public int getNumFacturas() {
		return m.getLista().size();
	}
}
