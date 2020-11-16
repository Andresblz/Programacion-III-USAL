package partidosarray;

import java.util.Scanner;

public class PartidosArray{
    public static void main(String[] args){
        int[] goles = new int[10];
        float average = 0.0f;

        Scanner sc = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("      GOAL AVERAGE CALCULATOR (ARRAY)      ");
        System.out.println("===========================================");

        for(int partidos = 0; partidos < goles.length; partidos++){
            System.out.printf("Goles del partido "+(partidos+1)+": ");
            goles[partidos] = Integer.parseInt(sc.nextLine());
        }

        /* Calculos */
        for(int partidos = 0; partidos < goles.length; partidos++){
            average += goles[partidos];
        }

        average /= goles.length;

        /* Resultado */
        System.out.println("La media por partido es de "+average+" goles");
    }
}