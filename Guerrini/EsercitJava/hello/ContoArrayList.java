package hello;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ContoArrayList {
    static ArrayList<Float> movimenti = new ArrayList<Float>();
    static String contoCorrente = "";

    public static void main(String[] args) {
        printMenu();
        Scanner readMenu = new Scanner(System.in);
        setContoCorrente();
        leggiCC();
        while (true) {
            printMenu();
            String choise = readMenu.nextLine();
            choise = choise.toLowerCase();
            // caso saldo attuale
            if (choise.equals("s"))
                getSaldo();
            if (choise.equals("l"))
                insListaMovimenti();
            if (choise.equals("v"))
                insVersamento();
            if (choise.equals("p"))
                insPrelievo();
            if (choise.equals("e"))
                break;
        }
        readMenu.close();
    }

    public static void setContoCorrente() {
        System.out.println("Inserisci il numero del tuo CC: [es.:010203] ");
        Scanner readCC = new Scanner(System.in);
        String cc = "";
        while (true) {
            cc = readCC.nextLine();
            cc = cc.replaceAll(" ", "_");
            if (cc.length() > 0)
                break;
            else
                System.out.println("Conto errato!!!");
        }
        contoCorrente = cc;
    }

    public static float chiediFloat(String domanda) {
        float ris = 0;
        while (true) {
            Scanner getFloat = new Scanner(System.in);
            System.out.println(domanda);
            try {
                ris = getFloat.nextFloat();
                break;
            } catch (Exception err) {
                System.out.println("WARNING!!! Attenzione inserire solo numeri decimali [es.: 199.99]!!!");
                System.out.println("Per annullare il versamento, inserire importo 0.0!");
                break;
            }
        }
        return ris;
    }

    private static void insPrelievo() {
        float prelievo = chiediFloat("Ins importo versamento:");
        if (prelievo < 0) {
            System.out.println("importo non valido!");
            return;
        }
        if (prelievo == 0) {
            System.out.println("Operazione annullata!");
            return;
        }
        if (prelievo > insSaldoValue()) {
            System.out.println("Credito insufficente!");
            return;
        }
        movimenti.add(-prelievo);
        aggiornaCC();
        System.out.println("prelievo effettuato. Grazie!");
    }

    private static void insVersamento() {
        float versamento = chiediFloat("Ins importo da VERSARE [es.: 199.99]");
        if (versamento < 0) {
            System.out.println("importo non valido!");
            return;
        }
        if (versamento == 0) {
            System.out.println("Operazione annullata!");
            return;
        }
        movimenti.add(versamento);
        aggiornaCC();
        System.out.println("versamento effettuato. Grazie.");

    }

    static void leggiCC() {
        try {
            File f = new File(contoCorrente + ".txt");
            Scanner readMov = new Scanner(f);
            movimenti.clear();
            while (readMov.hasNextLine()) {
                String newMov = readMov.nextLine();
                float importo = Float.parseFloat(newMov);
                movimenti.add(importo);
            }
        } catch (Exception e) {
            System.out.println("Errore nel caricamento dati!");
            movimenti.clear();
        }
    }

    private static void aggiornaCC() {
        String txfile = "";
        for (float mov : movimenti) {
            txfile = txfile + mov + "\n";
        }
        try {
            FileWriter fw = new FileWriter(contoCorrente + ".txt");
            fw.write(txfile);
            fw.close();
        } catch (Exception Err) {
            System.out.println("impossibile creare il file");
        }
    }

    private static void insListaMovimenti() {
        System.out.println("La tua lista movimenti è:");
        int i = 1;
        for (float mov : movimenti) {
            String riga = i + ")" + mov;
            System.out.println(riga);
            i++;
        }
        getSaldo();

    }

    private static void getSaldo() {
        System.out.println("Il tuo salto corrente è €" + insSaldoValue());
    }

    private static float insSaldoValue() {
        // fare ciclo for che sommi tutti i movimenti contenuti nell'array
        float saldo = 0;
        // scorro tutto movimenti e aggiungo uno per uno i valori
        for (int i = 0; i < movimenti.size(); i++) {
            saldo = saldo + movimenti.get(i);
        }
        return saldo;
    }

    public static void printMenu() {
        System.out.println("***********************************************");
        System.out.println("*             ***MENU BANCA***                *");
        System.out.println("***********************************************");
        System.out.println("*[S] - saldo attuale *** [L] - lista movimenti*");
        System.out.println("*                                             *");
        System.out.println("*[V] - versamenti    *** [P] - prelievo       *");
        System.out.println("*                                             *");
        System.out.println("*[E] - termina esci                           *");
        System.out.println("***********************************************");
    }
}