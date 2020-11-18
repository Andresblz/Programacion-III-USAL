package view;

import com.coti.tools.Esdia;
import controller.Controller;

public class View {
    
    Controller c = new Controller();
    boolean flag = false;
    boolean flag1 = false;
    
    public void runMenu(String menu){
        boolean salir = false;
        String opc;
    
        do{
        	/*
        	 * biblioteca.jar
        	 * readString​(java.lang.String prompt)
        	 * Este método devuelve una cadena después
        	 * de la indicación.
        	 */
            opc = Esdia.readString(menu);
            switch(opc){
                case"1":
                	this.leerNumeros();
                    break;
                case"2":
                	this.calcularSuma();
                    break;
                case"3":
                	this.visualizarResultado();
                    break;
                case"q":
                	/*
                	 * biblioteca.jar
                	 * yesOrNo​(java.lang.String prompt)
                	 * Este método solicita un booleano, permitiendo 
                	 * sólo "y" o "n" como entrada.
                	 */
                    salir = Esdia.yesOrNo("¿Quieres abandonar la aplicacion ");
                    break;
            }
        }while(!salir);
    }
    
    private void leerNumeros(){
    	flag = false;
        int n1, n2;
        /*
         * biblioteca.jar
         * readInt​(java.lang.String prompt)
         * El método devuelve un int.
         */
        n1 = Esdia.readInt("introduce numero 1: ");
        n2 = Esdia.readInt("introduce numero 2: ");
        c.guardarNumeros(n1,n2);
        flag1 = true;
    }

    private void calcularSuma() {
    	if(!flag1) {
    		System.out.printf("%nAntes de calcular el resultado seleccione la opcion '1.- Leer Numeros'");
    	} else {
    		c.calcularSuma();   
            flag = true;
    	}
    }

    private void visualizarResultado() {
    	if(!flag) {
    		System.out.printf("%nAntes de ver el resultado seleccione la opcion '2.- Sumar Numeros'.");
    	} else {
            System.out.printf("La suma: "+c.getN1()+" + "+c.getN2()+" = "+c.getResul()+"");
    	}
    }
}
