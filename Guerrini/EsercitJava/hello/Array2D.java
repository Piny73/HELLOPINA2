package hello;

import java.util.Scanner;

public class Array2D {
    static int tabella[][];
    static int dim;

    public static void main(String[] args) {
        System.out.println("Quanto è grande la tabella?: ");
        Scanner input = new Scanner(System.in);
        dim = input.nextInt(); // dichiarato nella classe
        tabella = new int[dim][dim];
        printTab();
        System.out.println();
        setDiagonale(11); // inserire in diagonale tutti 11
        System.out.println();        
        printTab();
    }

    public static void printTab(){
        for (int r=0; r<dim; r++){// ciclo righe
            for (int c=0; c<dim; c++){
                System.out.print(tabella[r][c] + "  ");
            }
                System.out.println();
        }
    }
    
    public static void setDiagonale(int valore) {
        for (int i = 0; i < dim; ++i) {
            tabella[i][i] = valore;
        }
    }
}
