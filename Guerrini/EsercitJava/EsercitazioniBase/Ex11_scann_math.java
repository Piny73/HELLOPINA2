package EsercitazioniBase;

import java.util.Scanner;

public class Ex11_scann_math {
    public static void main(String[] args) {
        System.out.println("---Program to print the area and perimeter of a circle---");
        Scanner input = new Scanner(System.in);
        System.out.print("Insert radius: ");
        float rad = input.nextFloat();
        System.out.println();
        double circle = 2 * Math.PI * rad;
        System.out.print("Perimeter is: " + circle);
        double area = Math.PI * rad * rad;
        System.out.print("\nArea is: " + circle);
    }
}
