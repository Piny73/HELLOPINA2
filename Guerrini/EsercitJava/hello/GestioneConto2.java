package hello;

import java.io.File;
//import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class GestioneConto2 {
    static ArrayList<Float> movimenti = new ArrayList<Float>();
    // formato data standard mondiale "2024-02-22 12:00:00"
    static ArrayList<String> datemovimenti = new ArrayList<String>();
    static ArrayList<Movimento> listaMovimenti = new ArrayList<>();
    static String contoCorrente = "";
    static Util helper = new Util();

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
        // Pronti per inserire il prelievo in movimenti
        // Creo una data e la inserisco in datemovimenti
        LocalDateTime dateTime = LocalDateTime.now();
        // creo un formattatore dtf
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm;ss");
        // creo testo da data con formattatore
        String txData = dateTime.format(dtf);
        datemovimenti.add(txData);
        movimenti.add(-prelievo);
        // creo un nuovo oggetto di tipo ,ovi,ento e lo add a listamovimenti
        Movimento mov = new Movimento();
        mov.data = dateTime;
        mov.txdata = txData;
        mov.importo = -prelievo;
        listaMovimenti.add(mov);
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
        // Creo una data e la inserisco in datemovimenti
        LocalDateTime dateTime = LocalDateTime.now();
        // creo un formattatore dtf
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm;ss");
        // creo testo da data con formattatore
        String txData = dateTime.format(dtf);
        datemovimenti.add(txData);
        movimenti.add(versamento);
        Movimento mov = new Movimento();
        mov.data = dateTime;
        mov.txdata = txData;
        mov.importo = versamento;
        listaMovimenti.add(mov);
        aggiornaCC();
        System.out.println("versamento effettuato. Grazie.");

    }

    static void leggiCC() {
        try {
            File f = new File(contoCorrente + ".csv");
            Scanner readMov = new Scanner(f);
            movimenti.clear();
            datemovimenti.clear();
            String newMov = readMov.nextLine();
            while (readMov.hasNextLine()) {
                String newmov = readMov.nextLine();
                // es newMov è "123.00,2024-02-22 12:00:00"
                // mi serve un array ["123.00,2024-02-22 12:00:00"]
                String[] itemsMov = newMov.split(",");
                float importo = Float.parseFloat(newMov);
                movimenti.add(importo);
                datemovimenti.add(itemsMov[1]);
            }
        } catch (Exception e) {
            System.out.println("Errore nel caricamento dati!");
            movimenti.clear();
        }
    }

    private static void aggiornaCC() {
        String txfile = new Movimento().getHeadCSV();
        for (Movimento mov : listaMovimenti)
            txfile += mov.getRigaCSV();
        helper.salvaFileTesto(contoCorrente + "csv", txfile);

        /*
         * int i = 0;
         * for (float mov : movimenti) {
         * String data = datemovimenti.get(i);
         * // txfile = txfile + mov + "\n";
         * txfile += mov + "," + data + "\n";
         * i++;
         * }
         * try {
         * FileWriter fw = new FileWriter(contoCorrente + ".csv");
         * fw.write(txfile);
         * fw.close();
         * } catch (Exception Err) {
         * System.out.println("impossibile creare il file");
         * }/*
         */
    }

    private static void insListaMovimenti() {
        System.out.println("La tua lista movimenti è:");
        int i = 1;
        for (float mov : movimenti) {
            String riga = i + ")" + mov + " eseguito il: " + datemovimenti.get(i - 1);
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