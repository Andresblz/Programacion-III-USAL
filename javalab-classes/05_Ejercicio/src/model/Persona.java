package model;

import java.util.Arrays;
import java.lang.NumberFormatException;

public class Persona {
	private String nombre;
	private int telefono;
	private float peso;
	
	public Persona(String nombre, int telefono, float peso) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.peso = peso;
	}
	
	private static void reject(String[] tokens, String reason) {
		System.out.printf("%nREJECTED: %s, REASON: %s", Arrays.toString(tokens), reason);
	}
	
	public static Persona factory(String[] tokens) {
		if (3 != tokens.length) {
			reject(tokens, "Wrong number of tokens.");
			return null;
		}
		
		String n = tokens[0];
		if (n.isEmpty()) {
			reject(tokens, "Name is empty.");
			return null;
		}
		
		Persona tmp;
		try {
			int t = Integer.parseInt(tokens[1]);
			float p = Float.parseFloat(tokens[2]);
			tmp = new Persona(n, t, p);
		} catch (NumberFormatException e) {
			reject(tokens, "Number format exception.");
			tmp = null;
		}
		
		return tmp;
	}
	
	public static Persona factory(String s) {
		String[] fragmentos = s.split("\t");
		return Persona.factory(fragmentos);
	}
	
	public String[] stateAsStringList() {
		String[] lista = {this.nombre, String.valueOf(this.telefono), this.peso + ""};
		return lista;
	}
}