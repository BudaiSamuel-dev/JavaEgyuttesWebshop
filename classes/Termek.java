package classes;

public class Termek {

    protected String cikkSzam;
    protected String megnevezes;
    protected int ar;
    protected int keszlet;

    public Termek(String cikkSzam, String megnevezes, int ar, int keszlet) {
        this.cikkSzam = cikkSzam;
        this.megnevezes = megnevezes;
        this.ar = ar;
        this.keszlet = keszlet;
    }

    public String getCikkSzam() {
        return cikkSzam;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public int getAr() {
        return ar;
    }

    public int getKeszlet() {
        return keszlet;
    }

    public String getInfo(){
        return String.format("%s (%s)\n*Ár: %d Ft\n*Készlet: %d db", megnevezes, cikkSzam, ar, keszlet);
    }
}
