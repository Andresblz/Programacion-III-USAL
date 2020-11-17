package nombres;

import java.util.Scanner;

public class Nombres{
    public static void main(String[] args){
        String nombre;
        /*
         * 'final' hace que el valor no pueda
         * modificarse, algunos usos de esto pueden ser:
         * 
         * final int LIMITE=5;
         * final int LIMITE;
         * static final double PI = 3.1415926;
         */
        final int TOTAL = 2;

        Scanner sc = new Scanner(System.in);

        System.out.printf("==================================%n");
        System.out.printf("         ALINEACIÓN TEXTO         %n");
        System.out.printf("==================================%n");

        System.out.printf("%nIntroduce tu nombre: ");
        nombre = sc.nextLine();

        System.out.printf("|%-20s|%20s|%n", "IZQUIERDA", "DERECHA");
        for(int i = 0; i < TOTAL; i++){
            System.out.printf("|%-20s|%20s|%n", nombre, nombre);
        }
    }
}
