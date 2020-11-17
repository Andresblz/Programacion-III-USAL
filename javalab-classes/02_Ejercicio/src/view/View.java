package view;

import controller.Controller;
import java.util.Scanner;

public class View{
    Scanner sc = new Scanner(System.in);
    Controller c = new Controller();

    public void runMenu(String menu){
        boolean salir = false;
        do{
            System.out.printf("%s", menu);
            System.out.printf("%nOpcion? ");
            String opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    this.leerTablaVentas();
                    break;
                case "2":
                    this.leerTablaPrecios();
                    break;
                case "3":
                    this.calcularIngresos();
                    break;
                case "4":
                    this.mostrarResultados();
                    break;
                case "q":
                    salir = this.preguntaSalir();
                    break;
                default:
                    System.out.printf("%nIntroduzca una opcion valida%n");
                    break;
            }
        }while(!salir);
    }

    /*
     * 'private' es un modificador de acceso que se utiliza tanto para 
     * atributos, métodos y constructores, hace que solo sean accesibles
     * dentro de la clase declarada.
     */
    private boolean preguntaSalir(){
        String opcion;
        do{
            System.out.printf("%nDesea salir de la aplicacion? [s/N]: ");
            opcion = sc.nextLine();
        }while(!"sSnN".contains(opcion));
        System.out.println();
        return(!opcion.isEmpty() && "sS".contains(opcion));
    }

    private void leerTablaVentas(){
    	int ALMACENES = c.getNumAlmacenes();
    	int PRODUCTOS = c.getNumProductos();
    	float[][] ventas = new float[ALMACENES][PRODUCTOS];
        
        System.out.printf("%nVENTAS%n");
    	for(int alm = 0; alm < ALMACENES; alm++) {
    		for(int prod = 0; prod < PRODUCTOS; prod++) {
                System.out.printf("Almacen[%d], Producto[%d]: ", alm+1, prod+1);
                ventas[alm][prod] = Float.parseFloat(sc.nextLine());
    		}
        }
        c.guardarEnModelVentas(ventas);
        sc.nextLine();
    }

    private void leerTablaPrecios(){
        int ALMACENES = c.getNumAlmacenes();
        int PRODUCTOS = c.getNumProductos();
        float[][] precios = new float[ALMACENES][PRODUCTOS];

        System.out.printf("%nPRECIOS%n");
        for(int alm = 0; alm < ALMACENES; alm++) {
    		for(int prod = 0; prod < PRODUCTOS; prod++) {
                System.out.printf("Almacen[%d], Producto[%d]: ", alm+1, prod+1);
                precios[alm][prod] = Float.parseFloat(sc.nextLine());
            }
        }
        c.guardarEnModelPrecios(precios);
        sc.nextLine();
    }

    private void calcularIngresos(){
        c.calcularResultado();
        System.out.printf("%nIngresos calculados correctamente%n");
    }

    private void mostrarResultados(){
        int ALMACENES = c.getNumAlmacenes();
        int PRODUCTOS = c.getNumProductos();
        float[][] precios = c.getTablaPrecios();
        float[][] ventas = c.getTablaVentas();
        float resultado = c.getResultados();

        System.out.printf("|%12s|%12s|%8s|%8s|%n","ALMACENES","PRODUCTOS","PRECIOS","VENTAS");
        for(int alm = 0; alm < ALMACENES; alm++){
            for(int prod = 0; prod < PRODUCTOS; prod++){
                System.out.printf("|%12d|%12d|%8.2f|%8.2f|%n", alm+1, prod+1, precios[alm][prod], ventas[alm][prod]);
            }
        }
        System.out.printf("%nBeneficio total: %.2f€%n", resultado);
    }
}