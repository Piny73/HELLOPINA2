package esercizi;

import java.util.Arrays;

public class StampaArrayPari {

    public static void main(String[] args) {
        int stArr[] = { 1, 2, 3, 5, 7, 11, 13 };
        int i = 0;
        while (i < stArr.length) {
            if (stArr[i] % 2 == 0) {
                System.out.println(stArr[i] + " ");
            }
            i++;
        }
    }
}
