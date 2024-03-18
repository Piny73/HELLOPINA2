package oO_Excercises;

import java.time.LocalDate;

public class TipiOggetto {
    public static void main(String[] args) {
        String message = new String("ciao");
        String messageUpperCase = message.toUpperCase();

        System.out.println(message); // stampa ciao
        System.out.println(messageUpperCase); // stampa CIAO

        message.equals(messageUpperCase); // per verificare se sono uguali (vero o falso)

        LocalDate oggi = LocalDate.now();

        LocalDate dopodomani = oggi.plusDays(2); // metodo di istanza o dinamico

        oggi.plusDays(1);

        Math.toIntExact(10);

        String message1 = "hello";

        int x = 10;

        message.length(); // 4

        message1.length(); // 5
    }
}

