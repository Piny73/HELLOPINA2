package esercizi;

import java.util.Scanner;

public class ArrayTools {

    public static void linearSequence(int[] data, int a, int b) {
        int i = 0;
        while (i < data.length) {
            data[i] = a * i + b;
            i++;
        }
        System.out.println("La sequenza è: ");
        stampa(data);
    }

    public static void stampa(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            System.out.println(arr[i] + " ");
            i++;
        }
    }

    public static void avarage(int[] media) {
        Scanner scMedia = new Scanner(System.in);
        int sum = 0;
        int i = 0;
        while (i < media.length) {
            System.out.print("Numero " + (i + 1) + ": ");
            int num = scMedia.nextInt();
            media[i] += media[i]; 
            i++;
           
        }
        sum = media[i] / media.length;
        System.out.println("La media è: " + sum);
    }
}
