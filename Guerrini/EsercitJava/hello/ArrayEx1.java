package hello;

public class ArrayEx1 {

    static int num[] = new int[10];
    static int npp[] = { 1, 2, 3, 5, 7, 11 };
    static String parole[] = { "Pina", "Massi", "Dami", "Davi" };
    static int numeri[] = new int[10];
    static int nn[];

    public static void main(String[] args) {
        nn = new int[10];
        // int tabellina = 6; // decido di inserirla a mano

        for (int tabella = 1; tabella <= nn.length; tabella++) {
            //
            for (int i = 0; i < nn.length; i++) { // while (i<nninteri.length){ System.out.println(nninteri[i] + " ");
                                                  // i++;}
                nn[i] = tabella * (i + 1);
            } System.out.println();
            //
            for (int i = 0; i < nn.length; i++) // System.out.println(nninteri[i] + " ");
                System.out.print(nn[i] + " "); // i++;}
        }  
    }
}