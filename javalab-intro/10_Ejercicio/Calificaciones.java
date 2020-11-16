package calificaciones;

import java.util.Scanner;

public class Calificaciones{
    public static void main(String[] args){
        float p1Nota1, p1Nota2, p1Nota3;
        float p2Nota1, p2Nota2, p2Nota3;
        float p3Nota1, p3Nota2, p3Nota3;
        float media1, media2, media3;

        Scanner sc = new Scanner(System.in);

        System.out.printf("==============================%n");
        System.out.printf("         NOTAS MEDIAS         %n");
        System.out.printf("==============================%n");

        /* Primer parcial */
        System.out.printf("Parcial[%d] Nota del primer alumno: ", 1);
        p1Nota1 = Float.parseFloat(sc.nextLine());
        System.out.printf("Parcial[%d] Nota del segundo alumno: ", 1);
        p1Nota2 = Float.parseFloat(sc.nextLine());
        System.out.printf("Parcial[%d] Nota del tercer alumno: ", 1);
        p1Nota3 = Float.parseFloat(sc.nextLine());

        /* Segundo parcial */
        System.out.printf("%nParcial[%d] Nota del primer alumno: ", 2);
        p2Nota1 = Float.parseFloat(sc.nextLine());
        System.out.printf("Parcial[%d] Nota del segundo alumno: ", 2);
        p2Nota2 = Float.parseFloat(sc.nextLine());
        System.out.printf("Parcial[%d] Nota del tercer alumno: ", 2);
        p2Nota3 = Float.parseFloat(sc.nextLine());

        /* Tercer parcial */
        System.out.printf("%nParcial[%d] Nota del primer alumno: ", 3);
        p3Nota1 = Float.parseFloat(sc.nextLine());
        System.out.printf("Parcial[%d] Nota del segundo alumno: ", 3);
        p3Nota2 = Float.parseFloat(sc.nextLine());
        System.out.printf("Parcial[%d] Nota del tercer alumno: ", 3);
        p3Nota3 = Float.parseFloat(sc.nextLine());

        /* Calculos */
        media1 = (p1Nota1 + p2Nota1 + p3Nota1) / 3;
        media2 = (p1Nota2 + p2Nota2 + p3Nota2) / 3;
        media3 = (p1Nota3 + p2Nota3 + p3Nota3) / 3;

        System.out.printf("%n|%8s|%8s|%8s|%n", "ALUMNO 1", "ALUMNO 2", "ALUMNO 3");
        System.out.printf("|%8.2f|%8.2f|%8.2f|%n", p1Nota1, p1Nota2, p1Nota3);
        System.out.printf("|%8.2f|%8.2f|%8.2f|%n", p2Nota1, p2Nota2, p2Nota3);
        System.out.printf("|%8.2f|%8.2f|%8.2f|%n", p3Nota1, p3Nota2, p3Nota3);

        System.out.printf("%n|%8s|%8s|%8s|%n", "MEDIA 1", "MEDIA 2", "MEDIA 3");
        System.out.printf("|%8.2f|%8.2f|%8.2f|%n", media1, media2, media3);
    }
}