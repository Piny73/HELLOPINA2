package EsercitazioniBase;

import java.util.Arrays;

public class Ex10_array {
    //static int max;
    static int min;

    public static void main(String[] args) {
        int[] pinarr = {3, 5, 7, 11, 13, 17, 19};
        System.out.println("Original Array: " + Arrays.toString(pinarr));
        //max = pinarr[0];
        min = pinarr[0];
        int posmax = 0;
        for (int i = 1; i < pinarr.length; i++) {
            if (pinarr[i]>pinarr[posmax]) {
                posmax = i;
            }      
        }
        System.out.println("Max value= " + pinarr[posmax]);
        int posmin = 0;
        for (int i = 1; i < pinarr.length; i++) {
            if (min<pinarr[posmin]){
                posmin = min;
            }
        }
        System.out.println("Min value = " + min);
    }
}
