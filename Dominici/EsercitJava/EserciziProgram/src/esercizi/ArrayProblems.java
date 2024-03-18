package esercizi;

import java.util.Scanner;

public class ArrayProblems {

    public static void main (String[] args){
        Scanner scnumeri = new Scanner(System.in);
        System.out.println("Inserisci il numero di elementi: ");
        int lung = scnumeri.nextInt();
        int[] numeri = new int [lung];
         
        //ArrayTools.linearSequence(numeri, 10, 3);
        ArrayTools.avarage(numeri);
        

        }
}
