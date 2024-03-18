package EsercitazioniBase;

public class Ex15_swaptwovariables {
    public static void main(String[] args) {
        System.out.println("Stampo un nome e cognome qualsiasi: \n");
        String var1 = "Mario";
        String var2 = "Rossi"; 
        String nomeecognome = var1 + " " + var2; // prima dello swap
        System.out.println(nomeecognome);
        String swap = var1;
        var1 = var2;
        var2 = swap;
        System.out.println("After swapping : " + var1 + " " + var2); // dopo lo swap
       
    }
    


}
