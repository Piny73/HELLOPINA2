package EsercitazioniBase;

import java.util.Scanner;

public class Ex3_ConditionalStatement {
    public static void main(String[] args) {
        System.out.println("Program that takes three numbers from the user and prints the greatest number");
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("Insert first number: ");
        int n1 = input.nextInt();
        System.out.print("Insert second number: ");
        int n2 = input.nextInt();
        System.out.print("Insert third number: ");
        int n3 = input.nextInt();
        System.out.println();
        if (n1 > n2 && n1 > n3) {

            System.out.println("The greatest is first number: " + n1);
            
        } else if (n2 > n1 && n2 > n3) {

            System.out.println("The greatest is second number: " + n2);

        } else if (n3 > n1 && n3 > n2) {

            System.out.println("The greatest is third: " + n3);

        }

    }
}
