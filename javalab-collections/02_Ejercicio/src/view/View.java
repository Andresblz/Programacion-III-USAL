package view;

import static com.coti.tools.Esdia.*;
import controller.Controller;
import java.io.IOException;
import java.util.List;

public class View {

    private final Controller c = new Controller();

    public void runMenu(String menu) {
        String option;
        boolean salir = false;
        String[] avaibleOptions = {"0", "1", "2", "3", "4", "5", "6", "7", "q"};
        do {
            option = readString(menu, avaibleOptions);
            switch (option) {
                case "1":
                    this.darValores();
                    break;
                case "2":
                    this.importar();
                    break;
                case "3":
                    this.mostrarListadoOrdenado();
                    break;
                case "4":
                    this.verListado();
                    break;
                case "5":
                    this.exportar();
                    break;
                case "6":
                    this.guardar();
                    break;
                case "7":
                    this.leer();
                    break;
                case "q":
                case "Q":
                    salir = yesOrNo("Desea realmente salir de la aplicacion? ");
                    break;
                default:
                    System.out.printf("%nERROR: Seleccione una opcion valida (1, 2, 3, 4, 5, 6, 7, q).%n");
                    break;
            }
        } while (!salir);
    }

    public void darValores() {
        c.darValores();
        System.out.printf("%nSe ha construido una lista de %d elementos%n", c.getNumeroDeDiscosDuros());
    }

    public void importar() {
        try {
            c.importar();
        } catch (IOException ex) {
            System.err.printf("%nERROR: no ha sido posible importar los datos");
            System.err.printf("%nERROR: %s%n", ex.toString());
            return;
        }

        System.out.printf("%nSe ha importado una lista de %d elementos%n", c.getNumeroDeDiscosDuros());
    }

    public void exportar() {
        try {
            c.exportar();
        } catch (IOException ex) {
            System.err.printf("%nERROR: no ha sido posaible exportar los datos");
            System.err.printf("%nERROR: %s%n", ex.toString());
        }

        System.out.printf("%nSe ha exportado una lista de %d elementos%n", c.getNumeroDeDiscosDuros());
    }

    public void verListado() {
        List<String> listado = c.obtenerListado();

        if (listado == null) {
            System.err.printf("%nERROR: Lista vacia, por favor de valores a la lista%n");
            return;
        }

        System.out.printf("%nListado de discos duros%n");

        for (String s : listado) {
            System.out.println(s);
        }

        System.out.println();
    }

    private void mostrarListadoOrdenado() {
        boolean salir = false;
        String option;
        String menu = "%nORDENAR POR:"
                + "%n1.- Fabricante        2.- Megabytes			 3.- Modelo"
                + "%n4.- Numero de serie   5.- Tasa de transmision   6.- Tecnologia"
                + "%n7.- Tipo de Interface 8.- Velocidad de rotacion"
                + "%nq.- Salir de ordenar";
        String[] avaibleOptions = {"1", "2", "3", "4", "5", "6", "7", "8", "q"};
        do {
            option = readString(menu, avaibleOptions);
            switch (option) {
                case "1", "2", "3", "4", "5", "6", "7", "8":
                    c.ordenarPor(option);
                    this.verListado();
                    break;
                case "q", "Q":
                    salir = yesOrNo("Desea volver al menu principal? ");
                    break;
                default:
                    System.out.printf("%nERROR: Seleccione una opcion valida (1, 2, 3, 4, 5, 6, 7, 8, q).%n");
                    break;
            }
        } while (!salir);
    }

    private void guardar() {
        c.guardar();
        System.out.printf("%nSe ha guardado la informacion en formato binario.%n");
    }

    private void leer() {
        c.leer();
        System.out.printf("%nSe ha leido la informacion con formato binario.%n");
    }
} /* End of View */
