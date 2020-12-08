package controller;

import model.Model;

import java.io.*;

public class Controller {
	Model m = new Model();
	
	public void importarDatosDe(File nombreArchivo) {
		m.importarDatosDe(nombreArchivo);
	}
	
	public int getNumeroTotalDeFacturas() {
		return m.getNumeroTotalDeFacturas();
	}
	
	public void guardarImporteMinimoEnModelo(float tmp) {
		m.setImporteMinimo(tmp);
	}
	
	public float getImporteMinimo() {
		return m.getImporteMinimo();
	}
	
	public void calcularMorosos() {
		m.calcularListadoMorosos();
	}
	
	public String[][] getDatosMorosos() {
		return m.getDatosMorosos();
	}
	
	public void crearHTMLFacturasAdeudadas() throws FileNotFoundException {
		m.crearHTMLFacturasAdeudadas();
	}
	
	public String getNombreArchivoHTML() {
		return m.getNombreArchivoHTML();
	}
}
