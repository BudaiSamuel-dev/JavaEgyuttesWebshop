package classes;

public class Polo extends Termek{

    private char meret;
    private String szin;

    public Polo(String cikkSzam, String megnevezes, int ar, int keszlet, char meret, String szin) {
        super(cikkSzam, megnevezes, ar, keszlet);
        this.meret = meret;
        this.szin = szin;
    }

    public char getMeret() {
        return meret;
    }

    public String getSzin() {
        return szin;
    }

    @Override
    public String getInfo() {
        return String.format("%s\n*Méret: %C\n*Szín: %s", super.getInfo(), meret, szin);
    }
}
