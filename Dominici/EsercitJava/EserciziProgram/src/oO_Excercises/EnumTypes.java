package oO_Excercises;

import java.util.EnumSet;
import java.util.Scanner;

public class EnumTypes {

    public static enum Giorni {
        LUNEDI, MARTEDI, MERCOLEDI, GIOVEDI, VENERDI, SABATO, DOMENICA
    }

    public static void main(String[] args) {

        Giorni g = Giorni.LUNEDI;

        if (g == Giorni.DOMENICA) {
            System.out.println(g);
        }

        Scanner s = new Scanner (System.in);
        System.out.println("scrivi un giorno della settimana");
        String giorno = s.nextLine();        
        Giorni ggInserito = Giorni.valueOf(giorno.toUpperCase());  
        System.out.println(ggInserito);
        Giorni.values(); // tutti i valori contenuti in Giorni
    }


}
