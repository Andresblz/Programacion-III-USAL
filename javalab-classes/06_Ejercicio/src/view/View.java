package view;

import static com.coti.tools.Esdia.readString;
import static com.coti.tools.Esdia.yesOrNo;
import static com.coti.tools.OpMat.printToScreen;
import controller.Controller;
import static java.lang.System.err;

public class View {
    Controller c = new Controller();
    
    public void runMenu(String menu){
        boolean salir = false;
        String option;
        String[] avaibleOptions = {"1", "2", "3", "4", "q"};
        do{
        	/*
        	 * biblioteca.jar
        	 * readString​(java.lang.String prompt, java.lang.String[] options)
        	 * Este método devuelve una de las opciones pasadas en el segundo 
        	 * argumento después de haber incitado con el primero
        	 */
            option = readString(menu, avaibleOptions).toLowerCase();
            switch (option) {
                case "1":
                    this.crearLista();
                    break;
                case "2":
                    this.mostrarTabla();
                    break;
                case "3":
                    this.exportarDatosPersonales();
                    break;
                case "4":
                    this.exportarDirecciones();
                    break;
                case "q":
                	/*
                	 * biblioteca.jar
                	 * yesOrNo​(java.lang.String prompt)
                	 * Este método solicita un booleano, permitiendo 
                	 * sólo "y" o "n" como entrada.
                	 */
                    salir = yesOrNo("Desea realmente salir de la aplicación");
                    break;
                default:
                    System.out.printf("%n%nOpcion Incorrecta%n%n");
                    break;
            }
        }while (!salir);
    }
    
    private void crearLista(){
        c.crearLista();
    }
    
    private void mostrarTabla(){
        String[][] tmp = c.tablaGeneralDeDatos();
        System.out.printf("%nTabla de Datos%n");
        try{
        	/*
        	 * biblioteca.jar
        	 * printToScreen​(java.lang.String[][] matrix)
        	 * Este método imprime por pantalla una matriz
        	 * con anchos de columna fijos (20)
        	 */
            printToScreen(tmp);
        } catch (Exception ex) {
            err.println("ERROR: se ha intentado imprimir una tabla vacía.");
        }
    }
    
    private void exportarDatosPersonales(){
        try{
            c.exportarDatosPersonales();
        } catch (Exception ex) {
            err.println("ERROR: no fue posible exportar datos personales.");
        }
    }
    
    private void exportarDirecciones(){
        try{
            c.exportarDirecciones();
        } catch (Exception ex) {
            err.println("ERROR: no fue posible exportar direcciones.");
        }
    }
    
}