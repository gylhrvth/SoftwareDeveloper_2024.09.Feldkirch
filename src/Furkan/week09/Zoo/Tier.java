package Furkan.week09.Zoo;

public class Tier {
    private String name;
    private String gattung;

    public Tier(String name, String gattung) {
        this.name = name;
        this.gattung = gattung;
    }

    public String getName() {
        return name;
    }

    public String getGattung() {
        return gattung;
    }
}
