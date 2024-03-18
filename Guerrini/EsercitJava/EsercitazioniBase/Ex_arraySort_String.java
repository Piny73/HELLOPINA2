package EsercitazioniBase;

import java.util.Arrays;

public class Ex_arraySort_String {

    public static void main(String[] args) {
        String[] carte = {"Paolo     ", "     Mario", "\n\n\n\n\nLetizia", "  Elena", "Dario  "}; 
        String[] scarte = new String [carte.length];
    
        System.out.println("Original string array : " + Arrays.toString(carte));

        for (int i = 0; i < carte.length; i++){
            String tx = carte[i];
            tx = tx.trim();
            tx = tx.toUpperCase();
            carte[i] = tx;
        }
             
        for (int j = 0; j < carte.length; j++) {            
            String newmin = carte[0];
            int posmin = 0;
                for (int i = 1; i < carte.length; i++) {
                 if (carte[i].compareToIgnoreCase(newmin) < 0) {
                    newmin = carte[i];
                    posmin = i;
                }
            }
            scarte[j] = carte [posmin];            
            carte [posmin] = "zzzzzzzzzz";       
        }
        System.out.println("Sorted string array : " + Arrays.toString(scarte));
    }
}
        

        


            

        
    
