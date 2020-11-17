package model;

import java.util.Random;

public class DatosDireccion {
    private final static Random RR = new Random();
    String calle;
    int numero;
    String letra;
    String DNI;
    
    public DatosDireccion(String calle, int numero, String letra) {
        this.calle = calle;
        this.numero = numero;
        this.letra = letra;
        this.DNI="";
    }
    
    public static DatosDireccion randomDatosDireccion(){
        String [] calles = {"Calle del Pez","Rue du Percebe", "Baker Street"};
        char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String c = calles[RR.nextInt(calles.length)];
        int n = RR.nextInt(100) + 1;
        String l = letters[RR.nextInt(letters.length)]+"";
        DatosDireccion d = new DatosDireccion(c, n, l);
        return d;
    }
}