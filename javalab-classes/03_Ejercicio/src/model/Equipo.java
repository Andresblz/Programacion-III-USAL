package model;

public class Equipo {
	private String nombre;
	private int marcador;
	
	Equipo(String nombre, int marcador){
		this.nombre = nombre;
		this.marcador = marcador;
	}
	
	Equipo() {
		this.nombre = "desconocido";
		this.marcador = 0;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getMarcador() {
		return this.marcador;
	}
	
	public void setMarcador(int marcador) {
		this.marcador = marcador;
	}
}
