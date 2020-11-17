package apartado_b;

import java.util.Scanner;

public class Lector {

    Scanner sc = new Scanner(System.in);

    public int leerEntero(String frase) {
        String temp;
        int salida = 0;
        Boolean control = false;

        while (control == false) {
            do {
                System.out.println(frase);
                temp = sc.nextLine();
            } while (temp.isEmpty());

            try {
                salida = Integer.parseInt(temp);
                control = true;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un valor entero");
                control = false;
            }
        }

        return salida;
    }

    public float leerReal(String frase) {
        String temp;
        float salida = 0;
        Boolean control = false;

        while (control == false) {
            do {
                System.out.println(frase);
                temp = sc.nextLine();
            } while (temp.isEmpty());

            try {
                salida = Float.parseFloat(temp);
                control = true;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un valor real");
                control = false;
            }
        }

        return salida;
    }

    public double leerDouble(String frase) {
        String temp;
        double salida = 0;
        Boolean control = false;

        while (control == false) {
            do {
                System.out.println(frase);
                temp = sc.nextLine();
            } while (temp.isEmpty());

            try {
                salida = Double.parseDouble(temp);
                control = true;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un valor doble");
                control = false;
            }
        }

        return salida;
    }
}
