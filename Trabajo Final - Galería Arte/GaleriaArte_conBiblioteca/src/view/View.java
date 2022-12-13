package view;

import java.io.*;
import controller.*;
import model.*;

import static com.coti.tools.Esdia.*;
import static com.coti.tools.DiaUtil.*;
import static com.coti.tools.OpMat.*;

public class View {
    private final Controller c = new Controller();

    public void importBinaryFile() {
        clear();
        printTitle();
        String info = c.importDataFromBinaryFile();
        System.out.println(info);
        pressEnterToContinue();
    }

    /*
     * Main menu
     */
    public void runMenu(String[] menu) throws Exception {
        Boolean exit = false;
        String[] availableOptions = {"1", "2", "3", "4"};

        do {
            clear();
            printTitle();
            
            String option = readString(menu[0], availableOptions);
            switch(option) {
                case "1" -> this.filesMenu(menu[1]);                                        
                case "2" -> this.galleryManagementMenu(menu[2]);                            
                case "3" -> this.listMenu(menu[3]);                                         
                case "4" -> exit = siOno("¿Desea realmente salir de la aplicación? "); 
                default -> {                                                                
                    System.out.println("ERROR: Seleccione una opción válida [1, 2, 3, 4].");
                    pressEnterToContinue();
                }
            }
        } while (!exit);

        c.exportToBinaryFile();
        System.out.println("\nSaliendo...\n");
    }


    /*
     * Files Menu
     */
    private void filesMenu(String menu) {
        Boolean exitMenu = false;
        String[] availableOptions = {"a", "b", "c", "q"};

        do {
            clear();
            printTitle();

            String option = readString(menu, availableOptions).toLowerCase();
            switch(option) {
                case "a" -> this.importCSV();                                               
                case "b" -> this.exportCSV();
                case "c" -> this.exportHTML();
                case "q" -> exitMenu = siOno("¿Desea volver al menú principal? ");
                default -> {
                    System.out.println("ERROR: Seleccione una opción válida [a, b, c, q].");
                    pressEnterToContinue();
                }
            }
        } while (!exitMenu);
    }

    private void importCSV() {
        try {
            String info = c.importCSV();
            System.out.println(info);
            pressEnterToContinue();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
    
    private void exportCSV() {
        try {
            c.exportCSV();
            System.out.println("INFO: Se ha exportado correctamente a CSV.");
            pressEnterToContinue();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        
    }

    private void exportHTML() {
        try {
            c.exportHTML();
            System.out.println("INFO: Se ha exportado correctamente a HTML.");
            pressEnterToContinue();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
    

    /*
     * Gallery Management
     */
    private void galleryManagementMenu(String menu) {
        Boolean exitMenu = false;
        String[] availableOptions = {"a", "b", "c", "d", "q"};

        do {
            clear();
            printTitle();
            
            String option = readString(menu, availableOptions).toLowerCase();
            switch (option) {
                case "a" -> this.addFigureToInventory();
                case "b" -> this.queryDataOfAFigure();
                case "c" -> this.modifyFigureData();
                case "d" -> this.removeFigureFromInventory();
                case "q" -> exitMenu = siOno("¿Desea volver al menú principal? ");
                default -> {
                    System.out.println("ERROR: Seleccione una opción válida [a, b, c, d, q].");
                    pressEnterToContinue();
                }
            }
        } while (!exitMenu);
    }

    private void addFigureToInventory() {
        System.out.println("\nAGREGAR UNA NUEVA FIGURA AL INVENTARIO:");
        String identifier = readString("\nIntroduce el identificador >> ");
        Float height = readFloat("Introduce la altura (m o cm) >> ");
        String material = readString("Introduce el material >> ");
        Integer quantity = readInt("Introduce la cantidad >> ");
        Integer year = readInt("Introduce el año >> ");
        String photo = readString("Introduce la foto (extensión .png) >> ");
        String manufacturer = readString("Introduce el fabricante >> ");
        String info = c.addFigureToInventory(identifier, height, material, quantity, year, photo, manufacturer);
        System.out.println(info);
        pressEnterToContinue();
    }

    private void queryDataOfAFigure() {
        System.out.println("\nCONSULTAR DATOS DE UNA FIGURA:");
        String identifier = readString("\nIntroduce el identificador de la figura a consultar >> ");
        String info = c.queryDataOfAFigure(identifier);
        System.out.println(info);
        pressEnterToContinue();
    }

    private void modifyFigureData() {
        Boolean exitModify = false;
        String modifyMenu = "\n\nSELECCIONE UNA OPCIÓN PARA MODIFICAR: "
                          + "\n\ta. Modificar altura"
                          + "\n\tb. Modificar material"
                          + "\n\tc. Modificar cantidad"
                          + "\n\td. Modificar año"
                          + "\n\te. Modificar foto"
                          + "\n\tf. Modificar fabricante"
                          + "\n\tg. Modificar datos de otra figura"
                          + "\n\tq. Salir de la opcion modificar\n";
        String[] availableOptions = {"a", "b", "c", "d", "e", "f", "g", "q"};
        

        clear();
        printTitle();
        System.out.println("\nMODIFICA DATOS DE UNA FIGURA:");
        String identifier = readString("\nIntroduce el identificador de la figura a modificar >> ");
        
        do {
            clear();
            printTitle();

            String info = c.queryDataOfAFigure(identifier);
            System.out.println("\n\nINFORMACIÓN");
            System.out.println(info);

            if (info.startsWith("ERROR:")) {
                exitModify = siOno("¿Desea probar con otro identificador?");
                if (exitModify) {
                    pressEnterToContinue();
                    this.modifyFigureData();
                }
                break;
            }


            String optionModify = readString(modifyMenu, availableOptions).toLowerCase();

            switch (optionModify) {
                case "a" -> { // Height
                    String height = readString("\nIntroduce el valor de la nueva altura >> ");
                    info = c.modifyFigureData(height, identifier, 1);
                    System.out.println(info);
                    pressEnterToContinue();
                }

                case "b" -> { // Material
                    String material = readString("\nIntroduce el valor del nuevo material >> ");
                    info = c.modifyFigureData(material, identifier, 2);
                    System.out.println(info);
                    pressEnterToContinue();
                }

                case "c" -> { // Quantity
                    String quantity = readString("\nIntroduce el valor de la nueva cantidad >> ");
                    info = c.modifyFigureData(quantity, identifier, 3);
                    System.out.println(info);
                    pressEnterToContinue();
                }

                case "d" -> { // Year
                    String year = readString("\nIntroduce el valor del nuevo año >> ");
                    info = c.modifyFigureData(year, identifier, 4);
                    System.out.println(info);
                    pressEnterToContinue();
                }

                case "e" -> { // Photo
                    String photo = readString("\nIntroduce el valor de la nueva fotografía >> ");
                    info = c.modifyFigureData(photo, identifier, 5);
                    System.out.println(info);
                    pressEnterToContinue();
                }

                case "f" -> { // Manufacturer
                    String manufacturer = readString("\nIntroduce el valor del nuevo fabricante >> ");
                    info = c.modifyFigureData(manufacturer, identifier, 6);
                    System.out.println(info);
                    pressEnterToContinue();
                }
                
                case "g" -> this.modifyFigureData();// Modify other figure
                case "q" -> exitModify = siOno("¿Desea dejar de modificar figuras? "); // Exit
                default -> {
                    System.out.println("ERROR: Seleccione una opción válida [a, b, c, d, e, f, q].");
                    pressEnterToContinue();
                }
            }
        } while (!exitModify);
    }

    private void removeFigureFromInventory() {
        System.out.println("\nELIMINAR UNA FIGURA DEL INVENTARIO:");  
        String identifier = readString("\nIntroduce el identificador de la figura a eliminar >> ");
        Figure info = c.removeFigureFromInventory(identifier);

        if (info == null) {
            System.out.println("ERROR: El identificador introducido no existe.");
            pressEnterToContinue();
        } else {
            System.out.println("\nElemento eliminado: ");
            System.out.println(info);
            pressEnterToContinue();
        }
    }


    /*
     * Listing Menu
     */
    private void listMenu(String menu) throws Exception {
        Boolean exitMenu = false;
        String[] availableOptions = {"a", "b", "c", "q"};

        do {
            clear();
            printTitle();

            String option = readString(menu, availableOptions).toLowerCase();
            switch(option) {
                case "a" -> this.listByIdentifier();
                case "b" -> this.listByYearAndIdentifier();
                case "c" -> this.listByManufacturerAndYear();
                case "q" -> exitMenu = siOno("¿Desea realmente volver al menú principal? ");
                default -> {
                    System.out.println("ERROR: Seleccione una opción válida [a, b, c, q].");
                    pressEnterToContinue();
                }
            }
        } while (!exitMenu);
    }


    private void listByIdentifier() throws Exception {
        String[][] sortedFigures = c.listByIdentifier();
        System.out.println("LISTADO ORDENADO POR IDENTIFICADOR");
        System.out.println("==================================");
        printToScreen2(sortedFigures);
        pressEnterToContinue();
    }

    private void listByYearAndIdentifier() throws Exception {
        String[][] sortedFigures = c.listByYearAndIdentifier();
        System.out.println("LISTADO ORDENADO POR AÑO DESCENDENTE E IDENTIFICADOR ASCENDENTE");
        System.out.println("===============================================================");
        printToScreen2(sortedFigures);
        pressEnterToContinue();
    }

    private void listByManufacturerAndYear() throws Exception {
        String[][] sortedFigures = c.listByManufacturerAndYear();
        System.out.println("LISTADO ORDENADO POR FABRICANTE Y AÑO");
        System.out.println("=====================================");
        printToScreen2(sortedFigures);
        pressEnterToContinue();
    }


    /*
     * Extra functions
     */
    public void printTitle() {
        System.out.println(" ██████   █████  ██      ███████ ██████  ██  █████       █████  ██████  ████████ ███████");
        System.out.println("██       ██   ██ ██      ██      ██   ██ ██ ██   ██     ██   ██ ██   ██    ██    ██     ");
        System.out.println("██   ███ ███████ ██      █████   ██████  ██ ███████     ███████ ██████     ██    █████  ");
        System.out.println("██    ██ ██   ██ ██      ██      ██   ██ ██ ██   ██     ██   ██ ██   ██    ██    ██     ");
        System.out.println(" ██████  ██   ██ ███████ ███████ ██   ██ ██ ██   ██     ██   ██ ██   ██    ██    ███████");
    }

    public void pressEnterToContinue() {
        readString("\nPulse INTRO para continuar...\n");
    }
}