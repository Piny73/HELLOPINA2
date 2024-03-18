package EsercitazioniBase;

import java.util.Scanner;

public class Ex1_scann {
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        System.out.print("Insert firstname: ");
        String firstname = input.nextLine();
        System.out.print("Insert Lastname: ");
        String lastname = input.nextLine();
        String testo = "Hello " + firstname + " " + lastname;
        System.out.print(testo);
}
}