package hello;

import java.util.Scanner;

public class Array2D_Ex2 {
    static int tabella[][];
    static int dimC, dimR;

    public static void main(String[] args) {
        System.out.println("Inserisci numero righe: ");
        Scanner input = new Scanner(System.in);
        dimR = input.nextInt(); // dichiarato nella classe
        System.out.println("Inserisci numero colonne: ");
        dimC = input.nextInt();
        tabella = new int[dimR][dimC];
        printTab();
        System.out.println();
        setDiagonale(5); // inserire in diagonale tutti 11
        System.out.println();        
        printTab();
        setRigaValore(2,5);
        setColonnaValore (1,12);
    }

    public static void setRigaValore(int riga, int valore) {
       if (riga<=dimR && riga>0) {
        for (int c=0; c<dimC; c++){
            tabella [riga-1][c]= valore;
        }
        
       }
    }

    public static void setColonnaValore(int colonna, int valore) {
        if (colonna<=dimR && colonna>0) {
            for (int r=0; r<dimR; r++){
                tabella [r][colonna-1]= valore;  
    }
}
    }

    public static void printTab(){ // creazione array bidimensionale r - righe e c - colonne
        for (int r=0; r<dimR; r++){// ciclo righe
            for (int c=0; c<dimC; c++){
                System.out.print(tabella[r][c] + "  ");
            }
                System.out.println();
        }
    }

    
    public static void setDiagonale(int valore) {

        if (dimR<dimC){
        for (int i = 0; i < dimR; ++i) {
            tabella[i][i] = valore;
        }
    }
    else{
        for (int i = 0; i < dimC; ++i) {
            tabella[i][i] = valore;
    }
}
    }
    
}