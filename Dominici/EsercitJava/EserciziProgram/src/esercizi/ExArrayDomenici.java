package esercizi;

import java.util.Arrays;
import java.util.Scanner;
//System.out.println (arNum1[i]);
//i++; 

public class ExArrayDomenici {

    public static void main(String[] args) {
        Scanner scNum = new Scanner(System.in);
        int arNum1[] = { 2, 8, 4, 28 };
        int arNum2[] = { 2, 8, 4, 28 };
        int ind = 0;
        boolean risultato = true;
        System.out.println(Arrays.toString(arNum1));
        System.out.println(Arrays.toString(arNum2));
        // System.out.println(Arrays.equals(arNum1,arNum2)); confronta il contenuto
        if (arNum1.length != arNum2.length);
        {
            risultato = false;
        }
        while (ind < arNum1.length && risultato) {
            if (arNum1[ind] != arNum2[ind]) {
                risultato = false;
            }
        }
        System.out.println("I due array sono uguali!");
    }
}
