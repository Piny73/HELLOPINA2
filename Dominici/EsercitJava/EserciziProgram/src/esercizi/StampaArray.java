package esercizi;

import java.util.Arrays;

public class StampaArray {

    public static void main(String[] args) {
        int stArr[] = { 1, 2, 3, 5, 7, 11, 13 };
        System.out.println(Arrays.toString(stArr)); // stampo in orizzontale
        int i = 0;
        while (i<stArr.length){
        System.out.println(stArr[i] + " "); // stampo in verticale
        i++;
    }
    }

}
