package esercizi;

import java.util.Arrays;

public class LoopVari {

    public static void main(String[] args) {
        
        int [] numeri ={33,6,4,7,67,45,2,123,4};
        int idx = 0;

        /////////////////////////////// while
        while (idx < numeri.length;) { 
            System.out.println(numeri[idx]);
            idx++;
        }

        /////////////////////////////// while eseguito almeno una volta!
        idx=0;
        do { 
            System.out.println(numeri[idx]); 
            idx++;
        } while (idx<=numeri.length);

        /////////////////////////////////// for stile c
        for (int i = 0; i<numeri.length; i++){ // for stile c
            System.out.println(numeri[i]);
        }

        ///////////////////////////////////// foreach
        for(int numero : numeri){ //foreach
            System.out.println(numero);
        }

        ///////////////////////////////////// stream, method reference
        Arrays.asList(1,4,6,85,56,78,93)
                .forEach(System.out::println);
                
        stampaNumeri(2,4,6);
    }

        ///////////////////////////////////// altro tipo di array
    private static void stampaNumeri(int... nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }
        ///////////////////////////////////java ha 8 tipi primitivi (contenuti delle variabili)
        
    

}
