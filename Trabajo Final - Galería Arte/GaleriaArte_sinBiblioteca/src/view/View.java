package view;

import java.io.*;
import java.util.*;
import controller.Controller;
import model.*;

public class View {
    private Controller c = new Controller();
    private Scanner input = new Scanner(System.in);

    public void importBinaryFile() {
        clearConsole();
        printTitle();
        String info = c.importDataFromBinaryFile();
        System.out.println(info);
        pressEnterToContinue();
    }

    /*
     * Main menu
     */
    public void runMenu(String[] menu) {
        String option;
        Boolean exit = false;

        do {
            clearConsole();
            printTitle();
            
            System.out.print(menu[0]);
            do {
                option = input.nextLine();
            } while(option.isEmpty());

            switch(option) {
                case "1": // Files menu
                    this.filesMenu(menu[1]);
                    break;

                case "2": // Gallery management menu
                    this.galleryManagementMenu(menu[2]);
                    break;

                case "3": // List menu
                    this.listMenu(menu[3]);
                    break;

                case "4": // Exit
                    exit = exitOption("salir del programa");
                    break;

                default: // Any other option
                    System.out.println("ERROR: Seleccione una opción válida [1, 2, 3, 4].");
                    pressEnterToContinue();
                    break;
            }
        } while (!exit);

        c.exportToBinaryFile();
        System.out.println("\nSaliendo...\n");
    }


    /*
     * Files Menu
     */
    private void filesMenu(String menu) {
        String option;
        Boolean exitMenu = false;

        do {
            clearConsole();
            printTitle();

            System.out.print(menu);
            do {
                option = input.nextLine().toLowerCase();
            } while(option.isEmpty());

            switch(option) {
                case "a": // Import CSV
                    this.importCSV();
                    break;

                case "b": // Export CSV
                    this.exportCSV();
                    break;

                case "c": // Export HTML
                    this.exportHTML();
                    break;

                case "q": // Back to main menu
                    exitMenu = exitOption("volver al menú principal");
                    break;

                default: // Any other option
                    System.out.println("ERROR: Seleccione una opción válida [a, b, c, q].");
                    pressEnterToContinue();
                    break;
            }
        } while (!exitMenu);
    }

    private void importCSV() {
        try {
            String info = c.importCSV();
            System.out.println(info);
            pressEnterToContinue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void exportCSV() {
        try {
            c.exportCSV();
            System.out.println("INFO: Se ha exportado correctamente a CSV.");
            pressEnterToContinue();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    private void exportHTML() {
        try {
            c.exportHTML();
            System.out.println("INFO: Se ha exportado correctamente a HTML.");
            pressEnterToContinue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    /*
     * Gallery Management
     */
    private void galleryManagementMenu(String menu) {
        String option;
        Boolean exitMenu = false;

        do {
            clearConsole();
            printTitle();
            
            System.out.print(menu);
            do {
                option = input.nextLine().toLowerCase();
            } while(option.isEmpty());

            switch(option) {
                case "a": // Add figure to inventory
                    this.addFigureToInventory();
                    break;

                case "b": // Query data of a figure
                    this.queryDataOfAFigure();
                    break;

                case "c": // Modify figure data
                    this.modifyFigureData();
                    break;

                case "d": // Remove figure from inventory
                    this.removeFigureFromInventory();
                    break;

                case "q": // Back to main menu
                    exitMenu = exitOption("volver al menú principal");
                    break;

                default: // Any other option
                    System.out.println("ERROR: Seleccione una opción válida [a, b, c, d, q].");
                    pressEnterToContinue();
                    break;
            }
        } while (!exitMenu);
    }

    private void addFigureToInventory() {
        System.out.println("\nAGREGAR UNA NUEVA FIGURA AL INVENTARIO:");
        System.out.printf("\nIntroduce el identificador >> ");
        String identifier = input.nextLine();
        System.out.printf("Introduce la altura (m o cm) >> ");
        Float height = Float.parseFloat(input.nextLine());
        System.out.printf("Introduce el material >> ");
        String material = input.nextLine();
        System.out.printf("Introduce la cantidad >> ");
        Integer quantity = Integer.parseInt(input.nextLine());
        System.out.printf("Introduce el año >> ");
        Integer year = Integer.parseInt(input.nextLine());
        System.out.printf("Introduce la foto (extensión .png) >> ");
        String photo = input.nextLine();
        System.out.printf("Introduce el fabricante >> ");
        String manufacturer = input.nextLine();
        String info = c.addFigureToInventory(identifier, height, material, quantity, year, photo, manufacturer);
        System.out.println(info);
        pressEnterToContinue();
    }

    private void queryDataOfAFigure() {
        System.out.println("\nCONSULTAR DATOS DE UNA FIGURA:");
        System.out.printf("\nIntroduce el identificador de la figura a consultar >> ");
        String identifier = input.nextLine();
        String info = c.queryDataOfAFigure(identifier);
        System.out.println(info);
        pressEnterToContinue();
    }

    private void modifyFigureData() {
        Boolean exitModify = false;
        String optionModify;
        String modifyMenu = "SELECCIONE UNA OPCIÓN PARA MODIFICAR: "
                          + "\n\ta. Modificar altura"
                          + "\n\tb. Modificar material"
                          + "\n\tc. Modificar cantidad"
                          + "\n\td. Modificar año"
                          + "\n\te. Modificar foto"
                          + "\n\tf. Modificar fabricante"
                          + "\n\tg. Modificar datos de otra figura"
                          + "\n\tq. Salir de la opcion modificar";

        clearConsole();
        printTitle();
        System.out.println("\nMODIFICA DATOS DE UNA FIGURA:");
        System.out.printf("\nIntroduce el identificador de la figura a modificar >> ");
        String identifier = input.nextLine();
        
        do {
            clearConsole();
            printTitle();

            String info = c.queryDataOfAFigure(identifier);
            System.out.println("\n\nINFORMACIÓN");
            System.out.println(info);

            if (info.startsWith("ERROR:")) {
                exitModify = exitOption("probar con otro identificador");
                if (exitModify) {
                    pressEnterToContinue();
                    this.modifyFigureData();
                }
                break;
            }

            System.out.println("\n\n" + modifyMenu);
            System.out.printf("\nSeleccione una opción >> ");
            do {
                optionModify = input.nextLine();
            } while (optionModify.isEmpty());

            switch (optionModify) {
                case "a": // Height
                    System.out.printf("\nIntroduce el valor de la nueva altura >> ");
                    String height = input.nextLine();
                    info = c.modifyFigureData(height, identifier, 1);
                    System.out.println(info);
                    pressEnterToContinue();
                    break;

                case "b": // Material
                    System.out.printf("\nIntroduce el valor del nuevo material >> ");
                    String material = input.nextLine();
                    info = c.modifyFigureData(material, identifier, 2);
                    System.out.println(info);
                    pressEnterToContinue();
                    break;

                case "c": // Quantity
                    System.out.printf("\nIntroduce el valor de la nueva cantidad >> ");
                    String quantity = input.nextLine();
                    info = c.modifyFigureData(quantity, identifier, 3);
                    System.out.println(info);
                    pressEnterToContinue();
                    break;

                case "d": // Year
                    System.out.printf("\nIntroduce el valor del nuevo año >> ");
                    String year = input.nextLine();
                    info = c.modifyFigureData(year, identifier, 4);
                    System.out.println(info);
                    pressEnterToContinue();
                    break;

                case "e": // Photo
                    System.out.printf("\nIntroduce el valor de la nueva fotografía >> ");
                    String photo = input.nextLine();
                    info = c.modifyFigureData(photo, identifier, 5);
                    System.out.println(info);
                    pressEnterToContinue();
                    break;

                case "f": // Manufacturer
                    System.out.printf("\nIntroduce el valor del nuevo fabricante >> ");
                    String manufacturer = input.nextLine();
                    info = c.modifyFigureData(manufacturer, identifier, 6);
                    System.out.println(info);
                    pressEnterToContinue();
                    break;
                
                case "g": // Modify other figure
                    this.modifyFigureData();
                    break;

                case "q": // Exit
                    exitModify = exitOption("salir del menú de modificación");
                    break;

                default: // Any other option
                    System.out.println("ERROR: Seleccione una opción válida [a, b, c, d, e, f, q].");
                    pressEnterToContinue();
                    break;
            }
        } while (!exitModify);
    }

    private void removeFigureFromInventory() {
        System.out.println("\nELIMINAR UNA FIGURA DEL INVENTARIO:");  
        System.out.printf("\nIntroduce el identificador de la figura a eliminar >> ");
        String identifier = input.nextLine();
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
    private void listMenu(String menu) {
        String option;
        Boolean exitMenu = false;

        do {
            clearConsole();
            printTitle();

            System.out.print(menu);
            do {
                option = input.nextLine();
            } while(option.isEmpty());

            switch(option) {
                case "a": // Listing by identifier
                    this.listByIdentifier();
                    break;

                case "b": // Listing by year and identifier
                    this.listByYearAndIdentifier();
                    break;

                case "c": // Listed by manufacturer and year
                    this.listByManufacturerAndYear();
                    break;

                case "q": // Back to main menu
                    exitMenu = exitOption("volver al menú principal");
                    break;

                default: // Any other option
                    System.out.println("ERROR: Seleccione una opción válida [a, b, c, q].");
                    pressEnterToContinue();
                    break;
            }
        } while (!exitMenu);
    }


    private void listByIdentifier() {
        ArrayList<Figure> sortedFigures = c.listByIdentifier();

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-10s | %-15s | %-8s | %-6s | %-10s | %-15s |\n", "IDENTIFICADOR", "ALTURA", "MATERIAL", "CANTIDAD", "AÑO", "FOTOGRAFÍA", "FABRICANTE");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        
        for (Figure figure : sortedFigures) {
            System.out.println(figure.toColumn(figure));
        }

        pressEnterToContinue();
    }

    private void listByYearAndIdentifier() {
        ArrayList<Figure> sortedFigures = c.listByYearAndIdentifier();

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-10s | %-15s | %-8s | %-6s | %-10s | %-15s |\n", "IDENTIFICADOR", "ALTURA", "MATERIAL", "CANTIDAD", "AÑO", "FOTOGRAFÍA", "FABRICANTE");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        for (Figure figure : sortedFigures) {
            System.out.println(figure.toColumn(figure));
        }

        pressEnterToContinue();
    }

    private void listByManufacturerAndYear() {
        ArrayList<Figure> sortedFigures = c.listByManufacturerAndYear();

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-10s | %-15s | %-8s | %-6s | %-10s | %-15s |\n", "IDENTIFICADOR", "ALTURA", "MATERIAL", "CANTIDAD", "AÑO", "FOTOGRAFÍA", "FABRICANTE");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        
        for (Figure figure : sortedFigures) {
            System.out.println(figure.toColumn(figure));
        }
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

    public void clearConsole() {
        try {
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public void pressEnterToContinue() {
        System.out.println("\nPulse INTRO para continuar...\n");
        input.nextLine();
    }

    public Boolean exitOption(String option) {
        String yesOrNo;

        do {
            System.out.print("\n¿Estás seguro de que desea " + option + "? (s/n) > ");
            do {
                yesOrNo = input.nextLine().toLowerCase();
            } while (yesOrNo.isEmpty());

            return (yesOrNo.equals("s")) ? true : false;
        } while (!yesOrNo.equals("s") || !yesOrNo.equals("n"));
    }
}