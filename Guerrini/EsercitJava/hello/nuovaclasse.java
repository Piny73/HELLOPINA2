package hello;

import java.util.Scanner;

public class nuovaclasse {
	public static void printwelcome (){
		System.out.println("*****Wellcome*****");
	}
	public static int sumNumber(int n1, int n2){
		int res=0;
		res=n1+n2;
		return res;		
	}
	// creo una nuova metodo per fare domande
	public static int askNumber(String question) {
		System.out.println("Richiesta numero intero");
		int result = -1;
		boolean ko = true;
		do {
			System.out.println(question);
			try {
				Scanner in = new Scanner(System.in);
				result = in.nextInt();
				ko = false;
			} catch (Exception errore) {
				System.out.println(errore.toString());
				ko = true;
				System.out.println("Attenzione inserire solo numeri interi! [ad es.: 12]");
			}
		} while (ko == true);
		return result;
	}

	public static void main(String[] args) {
		System.out.println("Ciao da While.");
		Scanner in = new Scanner(System.in);
		Scanner inl = new Scanner(System.in);		
		boolean ok = false;
		int cont = 0;
		boolean ok1 = false;
		boolean ok2 = false;
		// chiedere la domanda e valutare la risposta			
		do {
			if (cont == 4) {
				System.out.println("Raggiunto limite massimo di risposte!!!\n Arrivederci CAPRA CAPRA CAPRA!!!");
				// ok=true;
				break;
			}
			cont++;
			// domanda 1
			if (ok1 == false) {
				String dom = "Quanti giorni ha Maggio?";
				int ng_maggio = askNumber(dom);
				int somma=sumNumber(ng_maggio, ng_maggio);
				System.out.println(somma);
				if (ng_maggio == 31) {
					System.out.println("Bravo, ha 31 giorni Maggio!");
					ok1 = true;
				} else {
					System.out.println(ng_maggio + "! Risposta errata! Ritenta!");
				}
			}
			// domanda 2
			if (ok2 == false) {
				System.out.println("Qual'è il mese del Natale??");
				// in = new Scanner(System.in);
				String mese_natale = inl.nextLine();
				mese_natale = mese_natale.toLowerCase();
				mese_natale = mese_natale.trim();
				if (mese_natale.equals("dicembre")) {
					System.out.println("Bravo, dicembre è il mese del Natale");
					ok2 = true;
				} else {
					System.out.println(mese_natale + "! Risposta errata! Non è il mese del Natale!");
				}
			}
			if (ok1 && ok2){
				ok = true;
				System.out.println("Bravissimo! Hai risposto correttamente a tutte le domande!");
			}
		} while (ok == false); // !ok
	}
}