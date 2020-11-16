package partidos;

import java.io.Console;

public class Partidos{
    public static void main(String[] args){
        float g1, g2, g3, g4, g5, g6, g7, g8, g9, g10;
        float average;

        Console c = System.console();

        c.printf("===================================%n");
        c.printf("      GOAL AVERAGE CALCULATOR      %n");
        c.printf("===================================%n");

        /*
         * Probar a hacerlo más adelante mediante un bucle
         * 'for' y un array de elementos.
         */
        c.printf("Goles anotados en el primer partido: "); 
        g1 = Float.parseFloat(c.readLine());                    // Juntamos los metodos 'readLine' y 'parse' en una misma linea

        c.printf("Goles anotados en el segundo partido: ");
        g2 = Float.parseFloat(c.readLine());

        c.printf("Goles anotados en el tercer partido: ");
        g3 = Float.parseFloat(c.readLine());

        c.printf("Goles anotados en el cuarto partido: ");
        g4 = Float.parseFloat(c.readLine());

        c.printf("Goles anotados en el quinto partido: ");
        g5 = Float.parseFloat(c.readLine());

        c.printf("Goles anotados en el sexto partido: ");
        g6 = Float.parseFloat(c.readLine());

        c.printf("Goles anotados en el septimo partido: ");
        g7 = Float.parseFloat(c.readLine());

        c.printf("Goles anotados en el octavo partido: ");
        g8 = Float.parseFloat(c.readLine());

        c.printf("Goles anotados en el noveno partido: ");
        g9 = Float.parseFloat(c.readLine());

        c.printf("Goles anotados en el decimo partido: ");
        g10 = Float.parseFloat(c.readLine());

        /* Calculos */
        average = (g1+g2+g3+g4+g5+g6+g7+g8+g9+g10) / 10.0f;

        /* Resultados */
        c.printf("El equipo cuenta con un Goal Average de: %6.2f%n", average);
    }
}