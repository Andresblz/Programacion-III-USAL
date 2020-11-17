package View;

import Controller.Controller;
import java.util.Scanner;

public class View {

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
                    this.leerNumeros();
                    break;
                case "2":
                    this.hacerSuma();
                    break;
                case "3":
                    this.mostrarResultado();
                    break;
                case "q":
                    salir = this.preguntaSalir();
                    break;
                default:
                    System.out.printf("%n%nIntroduzca una opcion valida%n%n");
            }
        }while(!salir);
    }
    
    private boolean preguntaSalir(){
        String opcion;
        do{
            System.out.printf("%nDesea salir de la aplicacion? [s/N]: ");
            opcion = sc.nextLine();
        }while(!"sSnN".contains(opcion));
        System.out.println();
        return(!opcion.isEmpty() && "sS".contains(opcion));
    }

    private void leerNumeros(){
        int num1, num2;

        System.out.printf("%nEscribe el primer numero: ");
        num1 = sc.nextInt();
        System.out.printf("%nEscribe el segundo numero: ");
        num2 = sc.nextInt();

        c.storeIntoModel(num1, num2);
        sc.nextLine();
    }

    private void hacerSuma(){
        System.out.printf("%nSe ha realizado la suma con éxito%n");
        c.getSuma();
    }

    private void mostrarResultado(){
        int num1 = c.getInfo_num1();
        int num2 = c.getInfo_num2();
        int resultado = c.getInfo_Resultado();
        System.out.printf("%n"+num1+" + "+num2+" = "+resultado);
    }

}
