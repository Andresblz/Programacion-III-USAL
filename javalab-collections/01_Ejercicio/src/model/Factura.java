package model;

import java.util.*;

public class Factura {
	private String NIF;
	private String concepto;
	private String fecha;
	private float importe;
	private String nombre;
	private String razon_social;
	private float tipo_de_IVA;
	
	/* VALORES ALEATORIOS */
	private static final String[] NIFS = {
			"12345678A",
			"23456789B",
			"34567890C"
	};
	
	private static final String[] CONCEPTOS = {
			"Recambios",
			"Fungibles",
			"Adquisiciones"
	};
	
	private static final String[] DIRECCIONES = {
			"Calle del pez, 13",
			"Calle Pastor, 19",
			"Calle Honda, 9",
			"Calle la luz, 24",
			"Calle de la madera, 38"
	};
	
	private static final String[] FECHAS = {
			"23/Nov/1989",
			"12/Oct/1492",
			"20/Feb/2005"
	};
	
	private static final String[] NOMBRES = {
			"John Doe",
			"Richard Roe",
			"Hans Wurst",
			"Juan Palomo"
	};
	
	private static final float IVAS[] = {
			10f, 22f, 6f
	};
	
	
	/* CONSTRUCTORES */
	public Factura() {
		this.NIF = "12345689X";
		this.concepto = "Reparación";
		this.fecha = "1-Septiembre-1939";
		this.importe = 123.456f;
		this.nombre = "Nombre Apellidos";
		this.razon_social = "Compañía ACME";
		this.tipo_de_IVA = 21;
	}

	public Factura(String _NIF, String concepto, String fecha, float importe, 
			String nombre, String razon_social, float tipo_de_IVA) {
		this.NIF = _NIF;
		this.concepto = concepto;
		this.fecha = fecha;
		this.importe = importe;
		this.nombre = nombre;
		this.razon_social = razon_social;
		this.tipo_de_IVA = tipo_de_IVA;
	}
	
	
	public static Factura instanceWithRandomAttributes() {
		Random r = new Random();
		
		Factura f = new Factura(
				NIFS[r.nextInt(NIFS.length)],
				CONCEPTOS[r.nextInt(CONCEPTOS.length)],
				FECHAS[r.nextInt(FECHAS.length)],
				1.0f + 1000.0f * r.nextFloat(),
				NOMBRES[r.nextInt(NOMBRES.length)],
				DIRECCIONES[r.nextInt(DIRECCIONES.length)],
				IVAS[r.nextInt(IVAS.length)]);
		
		return f;
	}
	
	public String exportStateAsColumns() {
		return String.format("| %9s | %-15s | %11s | %7.2f | %-15s | %-25s | %8.2f |",
				this.NIF, this.concepto, this.fecha, this.importe, this.nombre, this.razon_social, this.tipo_de_IVA);
	}


	
	/* GETTERS Y SETTERS */
	public String getNIF() {
		return NIF;
	}


	public void setNIF(String nIF) {
		NIF = nIF;
	}


	public String getConcepto() {
		return concepto;
	}


	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public float getImporte() {
		return importe;
	}


	public void setImporte(float importe) {
		this.importe = importe;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRazon_social() {
		return razon_social;
	}


	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}


	public float getTipo_de_IVA() {
		return tipo_de_IVA;
	}


	public void setTipo_de_IVA(float tipo_de_IVA) {
		this.tipo_de_IVA = tipo_de_IVA;
	}

	
	

}
