package esercizi;

import java.util.Arrays;

public class StampaArrayInverso {

    public static void main(String[] args) {
        int stArr[] = { 1, 2, 3, 5, 7, 11, 13 };
        int i = stArr.length;
        while (i > 0) {
            i--;
            System.out.println(stArr[i] + " ");
        }
    }
}
