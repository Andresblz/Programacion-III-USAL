package model;

import java.text.*;
import java.util.*;

public class Factura {
	private float descuento;
	private float importe;
	private float tipoDeIVA;
	private String concepto;
	private String fecha;
	private String NIF;
	private String nombre;
	private String direccion;
	
	public Factura(float descuento, float importe, float tipo_de_IVA, 
			       String concepto, String fecha, String NIF, String nombre, 
			       String razon_social) {
		this.descuento = descuento;
		this.importe = importe;
		this.tipoDeIVA = tipo_de_IVA;
		this.concepto = concepto;
		this.fecha = fecha;
		this.NIF = NIF;
		this.nombre = nombre;
		this.direccion = razon_social;
	}
	
	public Factura() {
		this.descuento = 0.0F;
		this.importe = 0.0F;
		this.tipoDeIVA = 0.0F;
		this.concepto = "DESCONOCIDO";
		this.fecha = "DESCONOCIDO";
		this.NIF = "DESCONOCIDO";
		this.nombre = "DESCONOCIDO";
		this.direccion = "DESCONOCIDO";
	}
	
	public String[] datosDeFactura() {
		String tmp_descuento = String.format("%2.2f", this.descuento);
		String tmp_valor_factura = String.format("%2.2f", this.valorDeFactura());
		String tmp_tipo_de_iva = String.format("%2.2f", this.tipoDeIVA);
		String[] rd = {
				 	this.concepto,
					tmp_descuento,
					this.fecha,
					tmp_valor_factura,
					this.NIF,
					this.nombre, 
					this.direccion,
					tmp_tipo_de_iva
				 };
		return rd;
	}
	
	public String comoFilaDeUnaTablaEnHTML() {
		String resultado;
		resultado = String.format("<TR>"
				+ "<TD>%s</TD>"		// Concepto
				+ "<TD>%f</TD>"		// Descuento
				+ "<TD>%s</TD>"		// Fecha
				+ "<TD>%f</TD>"		// Importe
				+ "<TD>%s</TD>"		// NIF
				+ "<TD>%s</TD>"		// Nombre
				+ "<TD>%s</TD>"		// Razón social
				+ "<TD>%f</TD>"		// Tipo de IVA
				+ "</TR>",
				this.concepto, this.descuento, this.fecha, this.importe, this.NIF, this.nombre, this.direccion, this.tipoDeIVA);
		return resultado;
	}
	
	/*
	 * METODO DE FACTORÍA
	 * Admite como argumento una lista de cadenas, produce como resultado una factura o un null.
	 * El método de factoría crea objetos sin necesidad de especificar la clase exacta
	 * del objeto que se va a crear.
	 */
	public static Factura factory(String[] tokens) {
		
		if(8 != tokens.length) {
			return null;
		}
		
		Factura fac = new Factura();
		Locale spanish = new Locale("es", "ES");
		NumberFormat nf = NumberFormat.getInstance(spanish);
		
		/*
		 * Como locale (España) espera comas, y recibe puntos, cambiamos estos.
		 */
		tokens[1] = tokens[1].replace(".", ",");
		tokens[3] = tokens[3].replace(".", ",");
		tokens[7] = tokens[7].replace(".", ",");
		
		/*
		 * Crea la factura.
		 */
		try {
			fac.concepto = tokens[0];
			fac.descuento = nf.parse(tokens[1]).floatValue();
			fac.fecha = tokens[2];
			fac.importe = nf.parse(tokens[3]).floatValue();
			fac.NIF = tokens[4];
			fac.nombre = tokens[5];
			fac.direccion = tokens[6];
			fac.tipoDeIVA = nf.parse(tokens[7]).floatValue();
			return fac;
		} catch (ParseException ex) {
			return null;
		}
	}
	
	public static Factura factory(String linea) {
		return Factura.factory(linea.split("\t"));
	}
	
	float valorDeFactura() {
		return this.importe * (1.0f - this.descuento / 100.0f)* (1.0f + this.tipoDeIVA);
	}

	/*
	 * GETTERS Y SETTERS
	 */
	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public float getTipoDeIVA() {
		return tipoDeIVA;
	}

	public void setTipoDeIVA(float tipoDeIVA) {
		this.tipoDeIVA = tipoDeIVA;
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

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String NIF) {
		this.NIF = NIF;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	  
}
