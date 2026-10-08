package classes;

public class Hutomagnes extends Termek{

    private String leiras;

    public Hutomagnes(String cikkSzam, String megnevezes, int ar, int keszlet, String leiras) {
        super(cikkSzam, megnevezes, ar, keszlet);
        this.leiras = leiras;
    }

    public String getLeiras() {
        return leiras;
    }

    @Override
    public String getInfo() {
        return String.format("%s\n*Leírás: %s", super.getInfo(), leiras);
    }
}
