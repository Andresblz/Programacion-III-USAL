package nombres;

import java.util.Scanner;

public class Nombres{
    public static void main(String[] args){
        String nombre;
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