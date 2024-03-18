package hello;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Libro {
	// elenco attributi o proprietà
	String author;
	String title;
	String edition;
	int numpages;
	String age;
	LocalDateTime dataOut = null;
	LocalDateTime dataBack = null;

	// costruttore libro
	public Libro(String author, String title) {
		this.author = author.toUpperCase().trim(); // oppure posso scrivere (String a1, String a2) e poi author = a1
		this.title = title.toUpperCase().trim();
	}

	// elenco metodi classe
	public String getInfoCSV() { // "PINOCCHIO;COLLODI/n"
		String ris = title + ";" + author + "\n";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm;ss");
        String txdataOut = "";
		if (dataOut!=null)
			txdataOut = dataOut.format(dtf);			
		String txdataBack = dataBack.format(dtf);
		if (dataBack!=null)
			txdataBack=dataBack.format(dtf);
			ris += txdataBack + ";" + txdataOut;
	return ris + "\n";

	}

	public boolean inPrestito() {
		// se il libro non è via
		boolean ris = false;
		if (!(dataBack == null && dataOut != null)) {
			dataBack = null;
			dataOut = LocalDateTime.now();
			ris = true;
		}
		return ris;
	}

	public void restituzioneLibro() {
		dataBack = LocalDateTime.now();
	}

	public int getDaysOut() {
		int ris = 0;
		LocalDateTime adesso = LocalDateTime.now();
		Period period = Period.between(dataOut.toLocalDate(), adesso.toLocalDate());
		ris = period.getDays();
		return ris;
	}

	public String getInfoLibro() {
		String ris = "titolo: " + title + " - Autore: " + author;
		String pre = "[D] ";
		if (dataBack == null && dataOut != null)
			pre = "[X] ";
		return pre + ris;
	}
}
