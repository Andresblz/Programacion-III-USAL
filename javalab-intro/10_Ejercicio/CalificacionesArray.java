package calificacionesarray;

import java.util.Scanner;

public class CalificacionesArray{
    public static void main(String[] args){
        /*
         * 'final' hace que el valor no pueda
         * modificarse, algunos usos de esto pueden ser:
         * 
         * final int LIMITE=5;
         * final int LIMITE;
         * static final double PI = 3.1415926;
         */
        final int ALUMNOS = 4;
        final int PARCIALES = 3;
        float[][] notas = new float[ALUMNOS][PARCIALES];
        float[] medias = new float[ALUMNOS];

        float sum;

        Scanner sc = new Scanner(System.in);

        /*
         * 'println' se encarga de introducir automáticamente
         * un salto de linea al final del mensaje que sale
         * por pantalla.
         */
        System.out.println("=======================================");
        System.out.println("        NOTAS MEDIAS CON ARRAYS        ");
        System.out.println("=======================================");

        for(int alum = 0; alum < ALUMNOS; alum++){
            System.out.printf("%nAlumno [%d]: %n",alum+1);
            for(int parc = 0; parc < PARCIALES; parc++){
                System.out.printf("Nota del parcial [%d]: ",parc+1);
                notas[alum][parc] = Float.parseFloat(sc.nextLine());
            }
        }

        for(int alum = 0; alum < ALUMNOS; alum++){
            sum = 0.0f;
            for(int parc = 0; parc < PARCIALES; parc++){
                sum += notas[alum][parc];
            }
            medias[alum] = sum / PARCIALES;
        }

        System.out.printf("|%20s|%6s|%n", "NOTAS", "MEDIA");
        for(int alum = 0; alum < ALUMNOS; alum++){
            for(int parc = 0; parc < PARCIALES; parc++){
                System.out.printf("|%6.2f", notas[alum][parc]);
            }
            System.out.printf("|%6.2f|%n", medias[alum]);
        }
    }
}