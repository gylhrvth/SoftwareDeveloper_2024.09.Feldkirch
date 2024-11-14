package Sandro.Week9.Vererbung.Abstraktion;

public class Hund extends Vierbeiner {
    public String bellen;

    public Hund(String name, int age, int legs, String bellen) {
        super(name, age, legs);
        this.bellen = bellen;
    }

    @Override
    public void eats() {
        System.out.println("hund eats");
    }

    @Override
    public void sleeps() {
        System.out.println("hund sleeps");
    }

    public void bringtZeitung(){
        System.out.println("bringt zeitung");
    }


}
