package model;

import java.util.List;

public class Model {
	private final String nombreDelArchivo = "personas.txt";
	private final String nombreDeCarpeta = "datos";
	private List<Persona> personasImportadas;
	
	public List<Persona> getPersonasImportadas() {
		return personasImportadas;
	}
	
	public void setPersonasImportadas(List<Persona> importadas) {
		this.personasImportadas = importadas;
	}
	
	public String getNombreDelArchivo() {
		return nombreDelArchivo;
	}
	
	public String getNombreDeCarpeta() {
		return nombreDeCarpeta;
	}
	
}