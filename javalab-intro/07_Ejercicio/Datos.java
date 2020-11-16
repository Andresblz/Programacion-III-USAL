package datos;

import java.io.Console;

public class Datos{
    public static void main(String[] args){
        String nombre1, nombre2, nombre3;
        int edad1, edad2, edad3;
        float talla1, talla2, talla3;

        Console c = System.console();

        c.printf("==================================%n");
        c.printf("          TABLA DE DATOS          %n");
        c.printf("==================================%n");

        c.printf("Introduce el primer nombre: ");
        nombre1 = c.readLine();
        c.printf("Introduce el segundo nombre: ");
        nombre2 = c.readLine();
        c.printf("Introduce el tercer nombre: ");
        nombre3 = c.readLine();

        c.printf("Introduce la edad de %s: ", nombre1);
        edad1 = Integer.parseInt(c.readLine());
        c.printf("Introduce la edad de %s: ", nombre2);
        edad2 = Integer.parseInt(c.readLine());
        c.printf("Introduce la edad de %s: ", nombre3);
        edad3 = Integer.parseInt(c.readLine());

        c.printf("Introduce la talla de %s: ", nombre1);
        talla1 = Float.parseFloat(c.readLine());
        c.printf("Introduce la talla de %s: ", nombre2);
        talla2 = Float.parseFloat(c.readLine());
        c.printf("Introduce la talla de %s: ", nombre3);
        talla3 = Float.parseFloat(c.readLine());

        /* Resultados en una tabla */
        c.printf("%n|%15s|%6s|%7s|%n", "NOMBRE", "EDAD", "TALLA");
        c.printf("|%15s|%6d|%7.2f|%n", nombre1, edad1, talla1);
        c.printf("|%15s|%6d|%7.2f|%n", nombre2, edad2, talla2);
        c.printf("|%15s|%6d|%7.2f|%n", nombre3, edad3, talla3);
    }
}