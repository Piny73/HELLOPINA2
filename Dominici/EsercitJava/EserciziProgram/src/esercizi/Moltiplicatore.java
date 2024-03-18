package esercizi;

import java.util.Scanner;

import riutilizzo.Funzioni;

public class Moltiplicatore {

    public static void main(String[] args) {
        System.out.println("***CALCOLO LA MOLTIPLICAZIONE DI DUE NUMERI***");
        int Snumero = Funzioni.leggiNumero("Inserisci il primo numero: ");
        int Pnumero = Funzioni.leggiNumero("Inserisci il secondo numero: ");
        int som = 0;
        int cont = 0;
        Scanner readnumber = new Scanner(System.in);
       while (cont < Snumero) {
            cont = cont + 1;
            som = som + Pnumero;
        }
        String riga = "";
        riga = "IL RISULTATO E': " + som;
        System.out.println(riga);
    }
}
