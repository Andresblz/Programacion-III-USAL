package datosarray;

import java.util.Scanner;

public class DatosArray {
    public static void main(String[] args){
        String[] nombres = new String[3];           // Similar en C a poner: 'char nombres[3];'
        int[] edades = new int[3];                  // Similar en C a poner: 'int edades[3]'
        float[] tallas = new float[3];              // Similar en C a poner: 'float tallas[3]'

        Scanner sc = new Scanner(System.in);

        /*
         * 'println' se encarga de introducir automáticamente
         * un salto de linea al final del mensaje que sale
         * por pantalla.
         */
        System.out.println("=========================================");
        System.out.println("        TABLA DE DATOS CON ARRAYS        ");
        System.out.println("=========================================");

        System.out.println("Introduzca los datos: ");
        for(int i = 0; i < nombres.length; i++){
            System.out.printf("Introduce el nombre: ");
            nombres[i] = sc.nextLine();
            System.out.printf("Introduce la edad: ");
            edades[i] = Integer.parseInt(sc.nextLine());
            System.out.printf("Introduce la talla: ");
            tallas[i] = Float.parseFloat(sc.nextLine());
            sc.nextLine();              // Eliminamos el retorno de carro | Similar en C a poner: 'fflush(stdin);' | Tenemos que pulsar la tecla 'intro'
            System.out.println();
        }

        /* Resultados */
        System.out.printf("|%15s|%8s|%8s|\n", "NOMBRE", "EDAD", "TALLA");
        for(int i = 0; i < nombres.length; i++){
            System.out.printf("%|15s|%8d|%8.2f|%n", nombres[i], edades[i], tallas[i]);
        }
    }
}
