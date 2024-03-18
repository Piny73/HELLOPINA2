/* somma di tutti i numeri da 0 ad n
*   INIZIO
 *      leggo N;
 *      num = -1;
 *      som= 0;
 *      while (cont<=num);
 *          cont = cont+1;
 *          som = som + num; *         
 *      end while
 *      stampa somma; 
 * FINE
 */

package esercizi;

import java.util.Scanner;

public class SommoNnumeri {
    public static void main(String[] args) {
        System.out.println("SOMMO TUTTI I NUMERI da 0 ad n");
        int num = 0;
        int som = 0;
        int cont = 0;
        Scanner readnumber = new Scanner(System.in);
        System.out.println("Inserisci il numero n:");
        num = readnumber.nextInt();
        while (cont < num) {
            cont = cont + 1;
            som = som + cont;
        }
        String riga = "";
        riga = "IL RISULTATO E': " + som;
        System.out.println(riga);
    }
}
