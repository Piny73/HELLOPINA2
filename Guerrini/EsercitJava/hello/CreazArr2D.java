package hello;

import java.util.Scanner;

public class CreazArr2D {
    static int tab[][];
    static int Lc, Lr;
    public static void main(String[] args) {
    
    System.out.println("Inserisci numero righe: ");
    Scanner input = new Scanner(System.in);
    Lr=input.nextInt(); // dichiarato nella classe
    System.out.println("Inserisci numero colonne: ");
    Lc=input.nextInt();tab=new int[Lr][Lc];
    printTab();
    }

    public static void printTab(){ // creazione array bidimensionale r - righe e c - colonne
        for (int r=0; r<Lr; r++){// ciclo righe
            for (int c=0; c<Lc; c++){
                System.out.print(tab[r][c] + "  ");
            }
                System.out.println();
        }
    }

}
