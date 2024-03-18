import java.util.ArrayList;
import java.util.Scanner;

public class ListaInvitati {
    public static void main(String[] args) {
        ArrayList<String> listaInvitati = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Aggiungi invitato");
            System.out.println("2. Visualizza lista invitati");
            System.out.println("3. Elimina invitato");
            System.out.println("4. Esci");

            int scelta = scanner.nextInt();
