package EsercitazioniBase;

import java.util.Arrays;

public class Ex_arraySort_Int {

    static int[] carte = { 2, 11, 6, 4, 10, 3 };
    static int[] scarte = new int[carte.length];

    public static void main(String[] args) {

        System.out.println("Original Array: " + Arrays.toString(carte)); // stampo l'Array originale
        
        for (int j = 0; j < scarte.length; j++) {
        int posmin = 0;
        int newmin = carte[0];
            for (int i = 1; i < carte.length; i++) {
                if (carte[i] < newmin) {
                    newmin = carte[i];
                    posmin = i;
                }
            }
            scarte[j] = carte[posmin];
            carte[posmin] = 9999999;
        }
        System.out.print("Sorted Array: [ ");
        for (int carta : scarte) {
            System.out.print(carta + " ");
           }
           System.out.println("]");
           
    }
}
