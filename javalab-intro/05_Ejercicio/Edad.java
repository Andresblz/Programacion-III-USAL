package edad;

import java.io.Console;

public class Edad{
    public static void main(String[] args){
        String temp;
        int anyoActual;
        int anyoNacimiento;
        int edad;

        Console c = System.console();

        c.printf("=========================%n");
        c.printf("      CALCULAR EDAD      %n");
        c.printf("=========================%n");

        c.printf("Introduce el año actual: ");
        temp = c.readLine();
        anyoActual = Integer.parseInt(temp);    // Convertimos 'String temp' a 'int anyoActual' mediante parse

        c.printf("Introduce tu año de nacimiento: ");
        temp = c.readLine();
        anyoNacimiento = Integer.parseInt(temp);

        /* Calculos */
        edad = anyoActual - anyoNacimiento;

        /* Resultados */
        c.printf("Tu edad es de %d años%n", edad);
    }
}