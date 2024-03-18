package hello;

import java.util.Scanner;

public class PensioneJava {
    static int camere[];
    static int arr[];
    static String voci[] = { "maschio", "femmina", "bambino", "bambina", };

    public static void main(String[] args) {
        System.out.println("Inserisci il numero di camere della pensione: ");
        Scanner input = new Scanner(System.in);
        int numcamere = input.nextInt();
        camere = new int[numcamere];
        while (true) {
        int numpax = 0;
        System.out.println("In quanti siete? [0 per liberare camera] ");
        numpax = input.nextInt(); // es.: 3
        System.out.println("Che camera volete? ");
        int numroom = -1;
        numroom = input.nextInt(); // es.: 2
        if (numpax == 0) {// libero una stanza
            camere[numcamere - 1] = numpax;
        } else {
            if (camere[numroom - 1] == 0) {
                camere[numroom - 1] = numpax;
            } else {
                System.out.println("Camera " + numroom + " OCCUPATA!");
                int numstz = getNumberFreeRoom();
                if (numstz >=0){
                    camere[numstz] = numpax;
                    System.out.println("Assegnata camera " + numpax);
                } 
                else {
                    System.out.println("Spiacente, la pensione è piena!");
                }           }
            for (int i = 0; i < camere.length; i++) {
                System.out.print((i + 1) + " ");
            }
            System.out.println();
            for (int i = 0; i < numcamere; i++) {
                System.out.print((camere[i] + " "));
            }
        }
    }

    }

    public static int getNumberFreeRoom() { // scorro tutti gli elementi di camere finchè non trovo uno zero
        int camfree = -1;
        for (int i = 0; i < camere.length; i++) { //oppure: for(int i = camere.length-1; i>=0; i--;) così parte dalla fine dell'array
            if (camere[i] == 0) { // la camera è libera
                camfree = i;
                break;
            }
        }
        return camfree;
    }
}
