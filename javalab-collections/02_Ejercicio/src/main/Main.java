package main;

import view.View;

public class Main {

    public static void main(String[] args) {
        View v = new View();
        v.runMenu("%n%nDISCOS DUROS"
                + "%n1.- Dar valores"
                + "%n2.- Importar"
                + "%n3.- Ordenar"
                + "%n4.- Ver listado"
                + "%n5.- Exportar"
                + "%n6.- Guardar"
                + "%n7.- Leer"
                + "%nq.- Salir");
    }
} /* End of Main */
