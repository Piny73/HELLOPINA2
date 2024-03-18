package CreaMetodi;

public class Methods {
    public static void main(String[] args) {
    String[] carte = {"Rossi", "Belli", "Abbronzati", "Bianchi", "Brutti", "Pallidi"};
    int n1 = 30;
    int n2 = 40;
    int minore = getMinus(n1,n2);
    int somma = getSomma (n1,n2);
    String trova = "Abbronzati";
    int pos = findPosCard(trova,carte);
    System.out.println(minore);
    System.out.println(somma);
    }

    private static int findPosCard(String trova, String[] carte) {
       // da creare
        throw new UnsupportedOperationException("Unimplemented method 'findPosCard'");
    }

    public static int getMinus (int n1, int n2) {       
        int ris = 0;
        if ( n1 < n2){
            ris= n1;            
        } else {
            ris = n2;            
        }
        return ris;
    }

    public static int getSomma (int n1, int n2) {
        int sum = n1 + n2;
        return sum;
}

}
