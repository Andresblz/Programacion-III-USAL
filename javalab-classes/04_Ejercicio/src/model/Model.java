package model;

import static com.coti.tools.OpMat.*;
import com.coti.tools.Rutas;

import java.io.*;
import java.util.*;

public class Model {
	private List<Factura> facturasImportadas = null;
	private List<Factura> listadoMorosos = null;
	private float importeMinimo;
	private final String nombreArchivoHTML = "archivo.html";
	
	public Model() {
		this.facturasImportadas = new ArrayList<>();
		this.listadoMorosos = new ArrayList<>();
	}
	
	public void calcularListadoMorosos() {
		for (Factura f : facturasImportadas) {
			if (f.valorDeFactura() > this.importeMinimo) {
				listadoMorosos.add(f);
			}
		}
	}
	
	public String[][] getDatosMorosos() {
		int numeroMorosos = this.listadoMorosos.size();
		String[][] tdm = new String[numeroMorosos][];
		for(int n = 0; n < numeroMorosos; n++) {
			tdm[n] = listadoMorosos.get(n).datosDeFactura();
		}
		return tdm;
	}
	
	public void importarDatosDe(File f) {
		if(!f.exists()) {
			System.err.printf("%nERROR: %s no existe en el escritorio. Saliendo...%n", f.toString());
			System.err.printf("%nCopie 'datos.txt' en el escritorio%n");
		}
		String[][] tmp;
		try {
			/*
			 * biblioteca.jar
			 * importFromDisk​(java.io.File f, java.lang.String delimiter)
			 * Este metodo importa de disco un String[][] separado con un delimitador
			 */
			tmp = importFromDisk(f, "\t");
		} catch (Exception ex) {
			System.err.printf("%nNo fue posible importar el archivo%n");
			return;
		}
		for(String[] s : tmp) {
			Factura fac = Factura.factory(s);
			if(null != fac) {
				this.facturasImportadas.add(fac);
			}
		}
	}
	
	public void crearHTMLFacturasAdeudadas() {
		/*
		 * biblioteca.jar
		 * pathToFileOnDesktop​(java.lang.String nameOfFile)
		 * Este metodo devuelve la ruta a un fichero en el escritorio
		 */
		File f = Rutas.pathToFileOnDesktop(nombreArchivoHTML).toFile();
		try {
			PrintWriter pw = new PrintWriter(f);
			pw.printf("<!DOCTYPE html>%n"
					 +"<HTML>%n"
					 +"<HEAD>%n"
					 +"<meta charset=\"UTF-8\">%n"
					 +"<H1>Listado de facturas superiores a %6.2f€</H1>%n"
					 +"</HEAD>%n"
					 +"</BODY>%n", this.importeMinimo);
			pw.printf("<TABLE BORDER=1>%n");
			
			for(Factura fac : listadoMorosos) {
				pw.printf("%s%n", fac.comoFilaDeUnaTablaEnHTML());
			}
			pw.printf("</TABLE>%n</BODY>%n</HTML>%n");
			pw.close();
		} catch (FileNotFoundException ex) {
			System.err.printf("ERROR: no se ha creado %s%n", f.toString());
			return;
		}
		System.out.printf("%nSe ha creado una tabla con %d registros%n", this.listadoMorosos.size());
		System.out.printf("Ruta del archivo: " + f.toString());
	}
	
	public String getNombreArchivoHTML() {
		return this.nombreArchivoHTML;
	}
	
	public int getNumeroTotalDeFacturas() {
		return this.facturasImportadas.size();
	}
	
	public float getImporteMinimo() {
		return this.importeMinimo;
	}
	
	public void setImporteMinimo(float tmp) {
		this.importeMinimo = tmp;
	}
	
}
