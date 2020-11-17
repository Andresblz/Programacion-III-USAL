package apartado_b;

import java.util.Scanner;

public class Parse {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        
        Lector l1 = new Lector();
        Persona pers1= new Persona();
        
        System.out.println("Introduce el nombre: ");
        pers1.setNombre(sc.nextLine());
        
        pers1.setEdad(l1.leerEntero("Introduce la edad: "));
        pers1.setTalla(l1.leerReal("Introduce la talla: "));
        
        System.out.println("El nombre introducido es: "+ pers1.getNombre());
        System.out.println("La edad introducida es: "+ pers1.getEdad());
        System.out.println("La talla introducida es: "+ pers1.getTalla());
        
    }
    
}
