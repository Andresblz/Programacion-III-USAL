package ivaarray;

import java.util.Scanner;

public class IVAArray{
    public static void main(String[] args){
        /*
         * 'final' hace que el valor no pueda
         * modificarse, algunos usos de esto pueden ser:
         * 
         * final int LIMITE=5;
         * final int LIMITE;
         * static final double PI = 3.1415926;
         */
        final float IVA = 0.04f;
        String[] frutas = {"manzanas", "peras"};
        float[] numKilos = new float[frutas.length];
        float[] precioKilo = new float[frutas.length];
        float sinIVA = 0.0f, valorIVA, conIVA;

        Scanner sc = new Scanner(System.in);

        /*
         * 'println' se encarga de introducir automáticamente
         * un salto de linea al final del mensaje que sale
         * por pantalla.
         */
        System.out.println("============================");
        System.out.println("        CALCULAR IVA        ");
        System.out.println("============================");

        for(int i = 0; i < frutas.length; i++){
            System.out.printf("Nº de kilos de "+frutas[i]+": ");
            numKilos[i] = Float.parseFloat(sc.nextLine());
            System.out.printf("Precio de "+frutas[i]+": ");
            precioKilo[i] = Float.parseFloat(sc.nextLine());
            System.out.println();
        }

        /* Calculos */
        for(int i = 0; i < frutas.length; i++){
            sinIVA += numKilos[i] * precioKilo[i];
        }

        valorIVA = sinIVA * IVA;
        conIVA = sinIVA + valorIVA;

        /* Resultados */
        System.out.println("PRECIO FINAL");
        System.out.println("============");
        System.out.printf("Precio sin IVA: %5.2f%n", sinIVA);
        System.out.printf("Importe del IVA: %2.2f%n", valorIVA);
        System.out.printf("Precio total: %7.2f%n", conIVA);
    }
}