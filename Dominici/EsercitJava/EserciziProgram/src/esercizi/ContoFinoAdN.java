
/*stampo i numeri da 0 ad n
* inizio
*   leggo n; 
*   ris=0;
*   while (ris<=n)
*       ris= ris+1;
*       stampo ris;
*   end while
*Fine
*/

package esercizi;


import riutilizzo.Funzioni;

public class ContoFinoAdN {
    public static void main(String[] args) {
        int n = Funzioni.leggiNumero("Inserisci il numero: ");
        int ris = 0;
        while (ris <= n) {
            System.out.println(ris);
            ris = ris + 1;
        }
    }

    
}
