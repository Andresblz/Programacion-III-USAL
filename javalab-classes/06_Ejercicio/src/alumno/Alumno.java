package alumno;

import view.View;

public class Alumno {
    public static void main(String[] args) {
        View v = new View();
        v.runMenu("\n1.- Crear lista de alumnos"
                 +"\n2.- Mostrar tabla de alumnos"
                 +"\n3.- Exportar datos personales"
                 +"\n4.- Exportar direcciones"
                 +"\nq.- Salir"
                 +"\n");
    }
}