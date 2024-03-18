package EsercitazioniBase;

import java.util.Scanner;

public class Ex6_scann {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Insert first number: ");
        int fnum = input.nextInt();
        System.out.print("Insert second number: ");
        int snum = input.nextInt();
        System.out.println();
        int sum = fnum + snum;
        System.out.print("Il risultato della somma è: " + sum);
        int sub = fnum - snum;
        System.out.print("\nIl risultato della sottrazione è: " + sub);
        int molt = fnum * snum;
        System.out.print("\nIl risultato della moltiplicazione è: " + molt);
        int div = fnum / snum;
        System.out.print("\nIl risultato della divisione è: " + div);
        int mod = fnum % snum;
        System.out.print("\nIl resto della divisione è: " + mod);
}
}
