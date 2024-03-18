/* INIZIO
* boolean inNumeroPrimo
INIZIO
*   if (num==0) then
*   return false
*   end if
*   conta=2;
*   while (conta<num) do
*       if (num%conta==0) then
*       return false
*       end if 
*   end while
*   return true
 * FINE
 * 
 * ALTRO MODO
 * INIZIO
*   risultato =? true;*   
*   if (num==0) then
*   risultato false
*   end if
*   conta=2;
*   while (conta<num and risultato) do
*       if (num%conta==0) then
*       risultato = false
*       end if 
*   end while
*   return risultato
 * FINE
 * 
 * 
 */

package riutilizzo;

import java.util.Scanner;

public class Funzioni {
    
    public static int leggiNumero() {
        return leggiNumero("Inserisci un numero");
    }

    public static int leggiNumero(String msg) {
        System.out.println(msg);
        final Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        return n;

    }

    public static boolean numPrimo(int num) {
        boolean ris = true;
        if (num < 2) {
            ris = false;
        }
        int cont = 2;
        while (cont < num && ris) {
            if (num % cont == 0) {
                ris = false;
            }
            cont += 1;
        }
        return ris;
    }
}
