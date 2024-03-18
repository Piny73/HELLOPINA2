/* Calcolare la moltiplicazione tra due numeri N e M letti in input
* p.s.: USARE SOLO L'OPERATORE SOMMA)
 * 
 * INIZIO
 *  inserisco i due numeri da moltiplicare
 *  Leggo n1;
 *  Leggo n2;
 *  som = 0;
 *  cont = 0;
 *      while (cont < n2) do
 *          cont = cont +1;
 *          som = som + n1;
 *      end while
 *      stampa som; 
 * FINE
 */
package esercizi;

import java.util.Scanner;

public class Moltiplicazione {

    public static void main(String[] args) {
        System.out.println("CALCOLO LA MOLTIPLICAZIONE DI DUE NUMERI");
        int Pnumero = 0;
        int Snumero = 0;
        int som = 0;
        int cont = 0;
        Scanner readnumber = new Scanner(System.in);
        System.out.println("Inserisci il primo numero da moltiplicare:");
        Pnumero = readnumber.nextInt();
        System.out.println("Inserisci il secondo numero da moltiplicare:");
        Snumero = readnumber.nextInt();
        while (cont < Snumero) {
            cont = cont + 1;
            som = som + Pnumero;
        }
        String riga = "";
        riga = "IL RISULTATO E': " + som;
        System.out.println(riga);
    }
}
