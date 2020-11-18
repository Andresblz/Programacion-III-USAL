package company;

import view.View;

public class Company{
    public static void main(String[] args){
        View v = new View();
        v.runMenu("\n1.- Leer tabla de ventas"
                 +"\n2.- Leer tabla de precios"
                 +"\n3.- Calcular beneficios"
                 +"\n4.- Mostrar resultados"
                 +"\nq.- Salir");
    }
}
