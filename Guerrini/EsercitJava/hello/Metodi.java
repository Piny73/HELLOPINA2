package hello;

import java.util.Date;

public class Metodi {
	public static void main(String[] args) {
		int num1, num2, num3, num4;
		num1 = 12;
		num2 = 8;
		num3 = 22;
		num4 = 22;
		System.out.println(getmaggiore(num1, num2));
		System.out.println(getmaggiore(num1, num2, num3));
		System.out.println(getmaggiore(num1, num2, num3, num4));
		// richiamo metodo ora
		stampaDataOra();
	}

	// metodo senza parametri
	// stampa l'ora corrente
	public static void stampaDataOra() {
		Date orologio = new Date();
		String dataora = orologio.toLocaleString();
		System.out.println(dataora);
	}

	// metodo con parametri
	// ritorna il valore maggiore
	public static int getmaggiore(int n1, int n2) {

		int risultato = 0;
		if (n1 > n2) {
			risultato = n1;
		} else {
			risultato = n2;
		}
		return risultato;
	}

	public static int getmaggiore(int n1, int n2, int n3) {

		int risultato = 0;
		if (n1 > n2) {
			if (n1 > n3) {
				risultato = n1;
			} else {
				risultato = n3;
			}
		} else { // caso n1 non vince
			if (n2 > n3) {
				risultato = n2;
			} else {
				risultato = n3;
			}
		}
		return risultato;

	}
	public static int getmaggiore(int n1, int n2, int n3,int n4) {

		int risultato = 0;
		if (n1>=n2 && n1>=n3 && n1>=n4) risultato=n1;
		if (n2>=n1 && n2>=n3 && n2>=n4) risultato=n2;
		if (n3>=n1 && n3>=n2 && n3>=n4) risultato=n3;
		if (n4>=n1 && n4>=n2 && n4>=n3) risultato=n4;
		return risultato;

	}


}