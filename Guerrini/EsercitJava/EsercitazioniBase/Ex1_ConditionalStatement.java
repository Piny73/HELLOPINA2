package EsercitazioniBase;

import java.util.Scanner;

public class Ex1_ConditionalStatement {
    public static void main(String[] args) {
        System.out.println("program to get a number from the user and print whether it is positive or negative");
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("Insert number: ");
        int num = input.nextInt();
        if (num>0) {
            System.out.println("Number is positive");
         }else if  (num<0){
        System.out.println("Number is negative");
         } else {
            System.out.println("Number is 0");
         }
    }
}
