package hello;

import java.util.Scanner;

public class AppWhile {
	public static void main(String[] args) {
		System.out.println("Ciao da While.");
		Scanner in = new Scanner(System.in);
		// chiedere la domanda e valutare la risposta
		boolean ok = false;
		int cont=0;
		do {
			System.out.println("Quanti giorni ha Maggio?");
			int ng_maggio = in.nextInt();
			if (ng_maggio == 31) {
				System.out.println("Bravo 31 giorni Maggio");
				ok=true;
			} else {
				System.out.println(ng_maggio + "! Risposta errata! Ritenta!");
				ok=false;
			}
			cont++;
			if (cont==10){
				System.out.println ("Raggiunto limite massimo di risposte!!!\n Arrivederci CAPRA CAPRA CAPRA!!!");
				// ok=true;
				break;
			}
		} while (ok==false); // !ok
		
	}

}