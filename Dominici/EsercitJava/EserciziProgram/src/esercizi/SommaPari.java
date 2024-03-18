/* Stampa la somma dei numeri pari tra 0 ed N
 * 
 * INIZIO
 *  Leggo N
 *  cont=0;
 *  som=0;
 *      while (cont < N) do
 *          cont=cont+2;
 *          som=som+cont;
 *      end while
 *      stampa som;
 * FINE
 * 
 */

package esercizi;

import java.util.Scanner;

public class SommaPari {
    public static void main(String[] args) {
        System.out.println("SOMMO I NUMERI PARI da 0 ad n");
        int num = 0;        
        int som = 0;
        int cont = 0;
        Scanner readnumber = new Scanner(System.in);
        System.out.println("Inserisci il numero n:");
        num = readnumber.nextInt();
        while (cont < num) {
            cont = cont + 2;
            som = som + cont;
        }
        String riga = "";
        riga = "IL RISULTATO E': " + som;
        System.out.println(riga);
    }

}
