package hello;

import java.util.Scanner;

public class AppWhile2 {
	public static void main(String[] args) {
		System.out.println("Ciao da While.");
		Scanner in = new Scanner(System.in);
		Scanner inl = new Scanner(System.in);
		// chiedere la domanda e valutare la risposta
		boolean ok = false;
		int cont = 0;
		do {
			boolean ok1 = false;
			boolean ok2 = false;
			if (cont == 4) {
				System.out.println("Raggiunto limite massimo di risposte!!!\n Arrivederci CAPRA CAPRA CAPRA!!!");
				// ok=true;
				break;
			}
			cont++;
			System.out.println("Quanti giorni ha Maggio?");
			int ng_maggio = in.nextInt();
			if (ng_maggio == 31) {
				System.out.println("Bravo, ha 31 giorni Maggio");
				ok1 = true;
			} else {
				System.out.println(ng_maggio + "! Risposta errata! Ritenta!");
			}
				System.out.println("Qual'è il mese del Natale??");
				//in = new Scanner(System.in);
				String mese_natale = inl.nextLine();
				mese_natale = mese_natale.toLowerCase();
				mese_natale=mese_natale.trim();
				if (mese_natale.equals("dicembre")) {
				System.out.println("Bravo, dicembre è il mese del Natale");
				ok2 = true;
			} 	else {
				System.out.println(mese_natale + "! Risposta errata! Non è il mese del Natale!");
			}
			if (ok1 && ok2)
				ok = true;
		} while (ok == false); // !ok
	}
}