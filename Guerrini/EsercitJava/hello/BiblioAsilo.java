package hello;

import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.Scanner;

// carico i libri nel file BiblioAsilo.csv
// caricalibri();
// inizia ciclo infinito while per chiedere i comandi da eseguire
// presento le voci di menù disponibili
// A - aggiungo libro; L - lista libri; P - prestito libro; R - restituisco
// libro; E - Esci; X - rimuovo libro; T - trovo libro;
// printMenu
public class BiblioAsilo {
    Util helper = new Util();
    String nomeasilo;
    static ArrayList<Libro> elencoLibri = new ArrayList<Libro>();

    public static void main(String[] args) {
        while (true) {
            String voce = getMenuVoice();
            switch (voce) {
                case "A":
                    aggiungoLibro();
                    break;
                default:
                    System.out.println("\"" + voce + "\" non è una voce di menù!");
                case "L":
                    listaLibri();
                    break;
                case "E":
                    break; // stop = true;
                case "P":
                    prestitoLibro();
                    break;
                case "R":
                    resoLibro();
                    break;
                case "T":
                    trovolibro();
                    break;
                // fine switch
            }
            if (voce.equals("E"))
                break;
        } // fine ciclo while

    }

    private static void resoLibro() {
        // caso restituzione libro
        int posLibro;
        posLibro = trovolibro();
        if (posLibro >= 0)
            elencoLibri.get(posLibro).restituzioneLibro();
        else
            System.out.println("Libro non trovato!");
    }

    private static int trovolibro() {
        int r;
        int ris = -1; // caso non trovato posizione libro in elenco
        System.out.println("scrivi il titolo del libro che stai cercando: ");
        Scanner posLibro = new Scanner(System.in);
        String titoloToFind = posLibro.nextLine();
        titoloToFind = titoloToFind.trim().toUpperCase();
        for (int i = 0; i < elencoLibri.size(); i++) {
            String curr_title = elencoLibri.get(i).title;
            if (titoloToFind.equalsIgnoreCase(curr_title))
                ris = i;
            break;
        }
        return ris;
    }

    private static void prestitoLibro() {
        // metodo libro in prestito
        int posLibro = -1;
        posLibro = trovolibro();
        if (posLibro >= 0) {
            boolean ok = elencoLibri.get(posLibro).inPrestito();
            if (ok)
                System.out.println("Prestito confermato");
            else
                System.out.println("Libro già in prestito");
        } else
            System.out.println("Libro non trovato!");
    }

    private static void aggiungoLibro() {
        // metodo listalibri
        Scanner creaLibro = new Scanner(System.in);
        System.out.println("Benvenuto nel menù dell'inserimento libro");
        System.out.println("Inserisci il titolo del libro: ");
        String titolo = creaLibro.nextLine();
        titolo = titolo.trim().toUpperCase();
        System.out.println("Inserisci il nome dell'autore");
        String autore = creaLibro.nextLine();
        autore = autore.trim().toUpperCase();
        // se entrambi compilati
        if (autore.length() > 0 && titolo.length() > 0) {
            Libro libro = new Libro(autore, titolo);
            elencoLibri.add(libro);
        } else {
            System.out.println("Dati insufficenti per creare un libro!");
        }
    }

    private static void aggiornaBiblio() {
        String txfile = "titolo;autore;dataOut;dataBack\n";
        for (Libro l : elencoLibri) {
            txfile += l.getInfoCSV();
        }
        helper.salvaFileTesto("biblio.csv", txfile);
    }

    private static void listaLibri() {
        // metodo addlibro alternativo
        System.out.println("Questo è l'elenco dei libri disponibili nella biblioteca dell'Asilo: ");
        int n = 1;
        for (Libro libro : elencoLibri) {
            String ris = "";
            ris += n++;
            ris += ") ";
            ris += libro.getInfoLibro();
            System.out.println(ris);
        }
    }

    public static String getMenuVoice() {
        System.out.println("******Benvenuto nella Biblioteca dell'Asilo******");
        System.out.println("*************************************************");
        System.out.println("*[A] - aggiungo libro *** [L] - lista libri     *");
        System.out.println("*[P] - prestito L     *** [R] - reso L          *");
        System.out.println("*[T] - trova L        *** [X] - rimozione L     *");
        System.out.println("*[E] - esci                                     *");
        System.out.println("*************************************************");
        Scanner input = new Scanner(System.in);
        // domanda e richiesta voce menù
        System.out.print("Scegli voce: ");
        String voce = input.nextLine();
        return voce.trim().toUpperCase();
    }
}
