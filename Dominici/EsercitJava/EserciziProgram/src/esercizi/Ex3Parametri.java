package esercizi;

import java.util.Arrays;

public class Ex3Parametri {
    public static void main (String[]args){
        int numero = 123;
        pTipoPrimitivo(numero);
        System.out.println("numero vale: " + numero);

        int[] numeri = {3,6,9};
        pTipoArray(numeri);
        System.out.println("l'array originale è: " + Arrays.toString(numeri));
    }
   
    private static void pTipoArray (int[] arr) {
        System.out.println("il parametro vale: " + Arrays.toString(arr));
        int i=0;
        while (1<arr.length) {
            arr[i] = arr[1]*10;
            i++;
        }
    }
    
            private static void pTipoPrimitivo (int a) {
        System.out.println("il parametro vale: " + a);
        a = a*10;
        System.out.println("Ho modificato a:" + a);
    }

   
        }
    

