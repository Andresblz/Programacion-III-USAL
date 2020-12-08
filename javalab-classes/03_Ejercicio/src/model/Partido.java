package model;

public class Partido {
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private String resultado;
	
	Partido(String[] data) {
		this.equipoLocal = new Equipo(data[0], 0);
		this.equipoVisitante = new Equipo(data[1], 0);
		this.resultado = "desconocido";
	}
	
	Partido() {
		this.equipoLocal = new Equipo();
		this.equipoVisitante = new Equipo();
		this.resultado = "desconocido";
	}
	
	public void calcularResultados() {
		int marcadorLocal = this.equipoLocal.getMarcador();
		int marcadorVisitante = this.equipoVisitante.getMarcador();
		if(marcadorLocal > marcadorVisitante) {
			this.resultado = "1  ";
		} else if (marcadorVisitante > marcadorLocal) {
			this.resultado = "  2";
		} else {
			this.resultado = " X ";
		}
	}
	
	public void setMarcadoresDelPartido(int[] marcadores) {
		this.equipoLocal.setMarcador(marcadores[0]);
		this.equipoVisitante.setMarcador(marcadores[1]);
	}
	
	public void setNombresDeEquiposDelPartido(String[] nombresDeEquipos) {
		this.equipoLocal.setNombre(nombresDeEquipos[0]);
		this.equipoVisitante.setNombre(nombresDeEquipos[1]);
	}
	
	public Equipo getEquipoLocal() {
		return this.equipoLocal;
	}
	
	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	
	public Equipo getEquipoVisitante() {
		return this.equipoVisitante;
	}
	
	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	
	public String getResultado() {
		return this.resultado;
	}
}
