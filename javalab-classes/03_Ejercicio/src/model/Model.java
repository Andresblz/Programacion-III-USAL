package model;

public class Model {
	private final int NUMERO_DE_PARTIDOS = 15;
	private Partido[] partidos;
	private final String NOMBRE_ARCHIVO_PARTIDOS = "equipos.txt";
	private final String NOMBRE_CARPETA_PARTIDOS = "datos";
	
	public Model() {
		partidos = new Partido[NUMERO_DE_PARTIDOS];
		for (int i = 0; i < NUMERO_DE_PARTIDOS; i++) {
			this.partidos[i] = new Partido();
		}
	}
	 
	public void setEquipoLocal(int jornada, Equipo equipoLocal) {
		this.partidos[jornada].setEquipoLocal(equipoLocal);
	}
	
	public void setEquipoVisitante(int jornada, Equipo equipoVisitante) {
		this.partidos[jornada].setEquipoVisitante(equipoVisitante);
	}
	
	public void calcularResultados() {
		for(Partido partido : this.partidos) {
			partido.calcularResultados();
		}
	}
	
	public String[][] getTablaDeNombresDeEquipos() {
		String[][] tmp = new String[this.NUMERO_DE_PARTIDOS][2];
		for(int i = 0; i < this.NUMERO_DE_PARTIDOS; i++) {
			tmp[i][0] = this.partidos[i].getEquipoLocal().getNombre();
			tmp[i][1] = this.partidos[i].getEquipoVisitante().getNombre();
		}
		return tmp;
	}
	
	public String[] getTablaDeResultadosDeLosPartidos() {
		String[] tmp = new String[this.NUMERO_DE_PARTIDOS];
		for(int i = 0; i < this.NUMERO_DE_PARTIDOS; i++) {
			tmp[i] = partidos[i].getResultado();
		}
		return tmp;
	}
	
	public String getNOMBRE_ARCHIVO_PARTIDOS() {
		return this.NOMBRE_ARCHIVO_PARTIDOS;
	}
	
	public String getNOMBRE_CARPETA_PARTIDOS() {
		return this.NOMBRE_CARPETA_PARTIDOS;
	}
	
	public void guardarEnModelo(String[][] data) {
		for(int jornada = 0; jornada < data.length; jornada++) {
			Partido m = new Partido(data[jornada]);
			partidos[jornada] = m;
		}
	}
	
	public void guardarEnModelo(int[][] marcadores) {
		for(int m = 0; m < this.partidos.length; m++) {
			this.partidos[m].setMarcadoresDelPartido(marcadores[m]);
		}
	}
	
	public int getNUMERO_DE_PARTIDOS() {
		return this.NUMERO_DE_PARTIDOS;
	}
	
	public Partido[] getPartidos() {
		return this.partidos;
	}
	
	public void setPartidos(Partido[] partidos) {
		this.partidos = partidos;
	}
}
