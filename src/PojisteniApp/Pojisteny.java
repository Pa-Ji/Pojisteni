package PojisteniApp;

public class Pojisteny {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telefon;

    public Pojisteny(String jmeno, String prijmeni, int vek, String telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public String getTelefon() {  // Přidáno pro možnost vyhledávání podle čísla
        return telefon;
    }

    @Override
    public String toString() {
        return jmeno + " " + prijmeni + ", " + vek + " let, Tel: " + telefon;
    }
}
