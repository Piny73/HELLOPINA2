package oO_Excercises.Rubrica;

public class VoceRubrica {
    public static enum Tipo {
        LAVORO, AMICI, MUSICA
    }
    private String nome,cognome, ditta;
    private String [] contatti = new String [10];
    private Tipo tipo;

    public VoceRubrica(String nome, String cognome, String ditta, Tipo tipo);{
        
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getDitta() {
        return ditta;
    }

    public String[] getContatti() {
        return contatti;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
