package apellidos;

import java.io.Console;

public class apellidos {
        public static void main(String[] args){
        String nombre;
        String apellido1;
        String apellido2;

        /* Asignamos System.console() a 'c' */
        Console c = System.console();

        /* Titulo de programa */
        c.printf("=============================%n");
        c.printf("      NOMBRE Y LONGITUD      %n");
        c.printf("=============================%n");

        /* Pedimos los datos */
        c.printf("Escribe tu nombre: ");
        nombre = c.readLine();
        c.printf("Escribe tu primer apellido: ");
        apellido1 = c.readLine();
        c.printf("Escribe tu segundo apellido: ");
        apellido2 = c.readLine();

        /* Presentamos resultados por pantalla */
        c.printf("%nTu nombre completo es: %s %s %s%n", nombre, apellido1, apellido2);
        c.printf("%s tiene una longitud de: %d%n", apellido1, apellido1.length());
        c.printf("%s tiene una longitud de: %d%n", apellido2, apellido2.length());
    }
}