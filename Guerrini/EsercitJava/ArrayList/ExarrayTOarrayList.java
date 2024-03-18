package ArrayList;

import java.util.ArrayList;

public class ExarrayTOarrayList {    
        
    public static void main(String[] args) {
        String[] Lastn = {"Rossi", "Belli", "Abbronzati", "Bianchi", "Brutti", "Pallidi"}; // creo array statico

        ArrayList<String> LastnList = new ArrayList<String>(); // creo array List

      for (String lastname : Lastn) // scorro array List
        LastnList.add(lastname); // finisco di scorrere ed add     

    int taglia = 0;
    int ultimo = 0;
    String name = "Sinner";
    LastnList.add(0, name);
    
    taglia = LastnList.size(); // assegno a taglia la size dell'array List
    ultimo = taglia - 1; // assegno ad ultimo la taglia-1 così conosco il numero d'indice dell'ultima posizione   
    String tx = LastnList.get(ultimo); // assegno a tx il contenuto dell'indice ultimo dell'arrayList
    tx = tx.toUpperCase(); // assegno a tx il contenuto in maiuscolo
    LastnList.set(ultimo, tx); // assegno all'ultimo posto dell'arrayList il tx in maiuscolo

    String trovaErimuovi = "Abbronzati"; // contenuto che voglio rimuovere
    int postEr = -1; // indice del contenuto da rimuovere
    for (int i = 0; i < LastnList.size(); i++){
        if (LastnList.get(i).equalsIgnoreCase(trovaErimuovi)){
          postEr = i; // trovato ed esco
          break;
        }          
    }
    if (postEr>=0){
      LastnList.remove(postEr);
    }
    System.out.println(LastnList); // stampo array List
    }
}
