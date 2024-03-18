package EsercitazioniBase;

import java.util.Scanner;

public class Ex5_scann {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Insert first number: ");
        int fnum = input.nextInt();
        System.out.print("Insert second number: ");
        int snum = input.nextInt();
        int molt = fnum * snum;
        System.out.print("Il risultato è: " + molt);
    }
}
