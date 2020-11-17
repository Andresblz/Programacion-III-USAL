package model;

import java.util.Random;

public class DatosPersonales {
    String nombre;
    String apellidos;
    int edad;
    String DNI;
    private static final Random RR = new Random();
    
    public DatosPersonales (String nombre, String apellidos, int edad, String DNI){
        this.nombre =nombre;
        this.apellidos=apellidos;
        this.edad=edad;
        this.DNI=DNI;
    }
                
    private static String randomDNI() {
        char[] numbers = "0123456789".toCharArray();
        char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXY".toCharArray();
        String resultado ="";
        for (int i =0; i<8; i++){
            resultado +=numbers[RR.nextInt(numbers.length)]+"";
            
        }
        resultado += letters[RR.nextInt(letters.length)] + "";
        return resultado;
    }
    
    public static DatosPersonales randomDatosPersonales(){
        String[] nombres = {"Juan", "Ana", "María", "Pedro"};
        String[] apellidos = {"Pérez", "García", "López", "González"};
        String n = nombres[RR.nextInt(nombres.length)];
        String ap = apellidos[RR.nextInt(apellidos.length)];
        int ed = RR.nextInt(100) + 1;
        String id = randomDNI();
        DatosPersonales dp = new DatosPersonales(n, ap, ed, id);
        return dp;
    }
}