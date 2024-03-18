package hello;

import java.util.Scanner;

public class Contocorrente {
    static float movimenti[] = new float[100];

    public static void printMenu() {
        System.out.println("             ---MENU BANCA---");
        System.out.println("[S] - saldo attuale   --- [L] - lista movimenti");
        System.out.println("[V] - versamenti      --- [P] - prelievo");
        System.out.println("[E] - termina esci");
    }

    public static void main(String[] args) {
        Scanner readMenu = new Scanner(System.in);

        while (true) {
            printMenu();
            String choise = readMenu.nextLine();
            choise = choise.toLowerCase();
            // caso saldo attuale
            if (choise.equals("s"))
                getSaldo();
            if (choise.equals("l"))
                getListaMovimenti();
            if (choise.equals("v"))
                getVersamento();
            if (choise.equals("p"))
                getPrelievo();
            if (choise.equals("e"))
                break;
        }
        readMenu.close();
    }

    private static void getPrelievo() {
        Scanner getFloat = new Scanner(System.in);
        System.out.println("Ins importo da prelevare [es.:88.99]:");
        float prelievo = getFloat.nextFloat();
        if (prelievo<0){
            System.out.println("importo non valido!");
            return;
        }
        
        if (prelievo > getSaldoValue()) {
            System.out.println("credito insufficente o importo non valido!");
        } else {
            for (int i = 0; i < movimenti.length; i++) {
                if (movimenti[i] == 0) {
                    movimenti[i] = -prelievo;
                    break;
                }
            } // fine ciclo for
            System.out.println("prelievo effettuato. Grazie.");
        }
    }

    private static void getVersamento() {
        Scanner getFloat = new Scanner(System.in);
        System.out.println("Ins importo da versare [es.:88.99]:");
        float versamento = getFloat.nextFloat();
        if (versamento < 0) {
            System.out.println("importo non valido!");
        } else {
            for (int i = 0; i < movimenti.length; i++) {
                if (movimenti[i] == 0) {
                    movimenti[i] = versamento;
                    break;
                }
            } // fine ciclo for
            System.out.println("versamento effettuato. Grazie.");
        }
    }

    private static void getListaMovimenti() {
        System.out.println("La tua lista movimenti è:");
        for (int i = 0; i < movimenti.length; i++) {
            if (movimenti[i] == 0)
                break;
            String riga = (i + 1) + ")" + movimenti[i];
            System.out.println(riga);
        }

    }

    private static void getSaldo() {
        System.out.println("Il tuo salto corrente è €" + getSaldoValue());
    }

    private static float getSaldoValue() {
        // fare ciclo for che sommi tutti i movimenti contenuti nell'array
        float saldo = 0;
        // scorro tutto movimenti e aggiungo uno per uno i valori
        for (int i = 0; i < 100; i++) {
            saldo = saldo + movimenti[i];
        }
        return saldo;
    }
}