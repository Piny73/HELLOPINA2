/* Stampa i numeri primi tra 1 ed N
 * 
 * INIZIO
 *  leggo N;
 *  cont=1;
 *      while (cont<=N) do
 *          if (cont è primo) then
 *          stampa cont;
 *          end if
 *      cont=cont+1;
 *      end while
 * FINE 
 */

package esercizi;

import riutilizzo.Funzioni;

public class StampoPrimi {
    public static void main(String[] args){
        System.out.println("***STAMPO L'INTERVALLO DEI NUMERI PRIMI DI n***");
        int n = Funzioni.leggiNumero();
        int cont = 1;
        while (cont <= n) {
            if (Funzioni.numPrimo(cont)){
                System.out.println(cont);   
            }
            cont+= 1;
        }
    }

}
