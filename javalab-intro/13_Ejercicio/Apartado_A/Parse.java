package apartado_a;

import java.util.Scanner;
import apartado_a.Lector;

public class Parse{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        Lector l1 = new Lector();
        int num1;
        float num2;
        double num3;

        l1.leerEntero("Introduce un número entero: ");
        num1 = sc.nextInt();
        l1.leerReal("Introduce un número real: ");
        num2 = sc.nextFloat();
        l1.leerDouble("Introduce un número doble: ");
        num3 = sc.nextDouble();
    }

}