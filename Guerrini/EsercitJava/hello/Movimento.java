package hello;

import java.time.LocalDateTime;

public class Movimento {
    // attributi o proprietà della classe
    float importo = 0;
    LocalDateTime data;
    String txdata = "";

    public String getRigaCSV() {
        String ris = "";
        ris = importo + ";" + txdata + "\n";
        return ris;
    }

    public String getRigaCSVXL() {
        String ris = "";
        ris = importo + ";" + txdata + ";\n";
        return ris;
    }

    public String getHeadCSV() {
        return "\"importo, data, \n";
    }

    public String getHeadCSVXL() {
        return "\"importo, data, \n";
    }
}
