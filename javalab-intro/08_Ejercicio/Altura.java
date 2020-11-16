package altura;

import java.util.Scanner;

public class Altura{
    public static void main(String[] args){
        /*
         * 'final' hace que el valor no pueda
         * modificarse, algunos usos de esto pueden ser:
         * 
         * final int LIMITE=5;
         * final int LIMITE;
         * static final double PI = 3.1415926;
         */
        final String[] nombres = {"Tom", "Dick", "Harry"};
        float[] pesos = new float[nombres.length];              // Similar en C a poner: 'float pesos[3];'
        double[] tallas = new double[nombres.length];           // Similar en C a poner  'double tallas[3];'
        int pesoMaxIni, tallaMaxIni;
        float pesoMax;
        double tallaMax;

        Scanner sc = new Scanner(System.in);

        System.out.printf("=============================%n");
        System.out.printf("         ARRAYS JAVA         %n");
        System.out.printf("=============================%n");

        for(int i = 0; i < pesos.length; i++){
            /*
             * 'println' se encarga de introducir automáticamente
             * un salto de linea al final del mensaje que sale
             * por pantalla.
             */
            System.out.println("\nEscribe los datos de "+nombres[i]+": ");
            System.out.printf("Peso: ");
            pesos[i] = Float.parseFloat(sc.nextLine());
            System.out.printf("Talla: ");
            tallas[i] = Double.parseDouble(sc.nextLine());
        }

        /* Calculos */
        pesoMax = pesos[0];
        tallaMax = tallas[0];
        pesoMaxIni = 0;
        tallaMaxIni = 0;

        for(int i = 0; i < pesos.length; i++){
            if(pesoMax < pesos[i]){
                pesoMaxIni = i;
                pesoMax = pesos[i];
            }
            if(tallaMax < tallas[i]){
                tallaMaxIni = i;
                tallaMax = tallas[i];
            }
        }

        /* Resultados */
        System.out.println("El que más pesa es "+nombres[pesoMaxIni]+", con un peso de "+pesoMax+" kilos");
        System.out.println("El más alto es "+nombres[tallaMaxIni]+", con una altura de "+tallaMax+" metros");
    }
}