package view;

import com.coti.tools.Esdia;
import com.coti.tools.OpMat;
import controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;

public class View {
    
    Controller c = new Controller();
    
    public void runmenu(String menu){
        
        boolean salir = false;
        String opc;
        String [] options={"1", "2", "3", "q", "Q"};
    
        do{
        	/*
        	 * biblioteca.jar
        	 * readString​(java.lang.String prompt, java.lang.String[] options)
        	 * Este método devuelve una de las opciones pasadas en el segundo 
        	 * argumento después de haber incitado con el primero.
        	 */
            opc = Esdia.readString(menu, options);
            switch(opc){
                case"1":
                	this.pedirDatos();
                    break;
                case"2":
                	this.calcularBeneficios();
                    break;
                case"3":
                	this.visualizarResultado();
                    break;
                case"q":
                case"Q":
                	/*
                	 * biblioteca.jar
                	 * yesOrNo​(java.lang.String prompt)
                	 * Este método solicita un booleano, permitiendo 
                	 * sólo "y" o "n" como entrada.
                	 */
                    salir = Esdia.yesOrNo("¿quieres Salir?");
                    break;
                default:
                	System.out.printf("%nIntroduce una opcion valida%n");
                	break;
            }
        }while(!salir);
    
    }

    private void pedirDatos() {
        int cant [][] = null;
        float precios [][] = null;
        /*
         * 'try' permite definir un bloque de código para ser probado en busca
         * de errores mientras se está ejecutando.
         * 
         * 'catch' permite definir un bloque de código para ser ejecutado, si
         * se produce un error en el bloque 'try'
         */
        try {
            try {
            	System.out.printf("%n%nCANTIDADES%n");
                cant = new int[5][2];
                /*
                 * biblioteca.jar
                 * inputMat​(int[][] matrix)
                 * Este metodo lee de teclado una matriz int[][].
                 */
                OpMat.inputMat(cant);
            } catch (Exception ex) {
            	/*
            	 * public static Logger getLogger(String name)
            	 * Este método se utiliza para encontrar o crear un registrador con
            	 * el nombre pasado como parámetro. Creará un nuevo registrador si
            	 * no existe uno con el nombre.
            	 * 
            	 * (Tambien podemos reemplazar por 'return -1')
            	 */
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.printf("%n%nPRECIOS%n");
            precios = new float[5][2];
            /*
             * biblioteca.jar
             * inputMat​(float[][] matrix)
             * Este metodo lee de teclado una matriz float[][].
             */
            OpMat.inputMat(precios);
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        c.guardar(cant, precios);
    }

    private void calcularBeneficios() {
        c.realizarCalculos();      
    }

    private void visualizarResultado() {
        System.out.println("%nLa matriz de ventas es: ");
        try {
        	/*
        	 * biblioteca.jar
        	 * printToScreen​(java.lang.String[][] matrix)
        	 * Este método imprime por pantalla una matriz
        	 * con anchos de columna fijos (20)
        	 */
            OpMat.printToScreen(c.getMatVentas());
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("%nLa matriz de precios es: ");
        try {
            OpMat.printToScreen(c.getMatPrecios());
        } catch (Exception ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.printf("%nEl beneficio es: %.2f%n", c.getBeneficio());
    }
}