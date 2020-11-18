package company;

import view.View;

public class Company {
    public static void main(String[] args) {        
        View v = new View();
        v.runmenu("\n\n1.- Pedir datos "  
                 +"\n2.- Calcular beneficio "  
                 +"\n3.- Mostrar resultado "  
                 +"\nq.- Salir " 
                 +"\nIntroduce una opcion: ");
    }  
}