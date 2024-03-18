package EsercitazioniBase;

import java.util.Comparator;

class NameComparator implements Comparator <String> {

    public int compare(String s1, String s2){

        return s1.compareTo(s2);
    }
}

