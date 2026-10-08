package classes;

public class Lemez extends Termek{

    private int megjelenesEve;
    private String kiado;

    public Lemez(String cikkSzam, String megnevezes, int ar, int keszlet, int megjelenesEve, String kiado) {
        super(cikkSzam, megnevezes, ar, keszlet);
        this.megjelenesEve = megjelenesEve;
        this.kiado = kiado;
    }

    public int getMegjelenesEve() {
        return megjelenesEve;
    }

    public String getKiado() {
        return kiado;
    }

    @Override
    public String toString() {
        return String.format("* %s (%d)", megnevezes, megjelenesEve);
    }

    @Override
    public String getInfo() {
        return String.format("%s\n*Kiadó: %s\n*Megjelenés: %d", super.getInfo(), kiado, megjelenesEve);
    }
}
