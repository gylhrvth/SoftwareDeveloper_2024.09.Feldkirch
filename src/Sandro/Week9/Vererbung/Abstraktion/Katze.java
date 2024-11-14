package Sandro.Week9.Vererbung.Abstraktion;

public class Katze extends Vierbeiner {
    public String miau;

    public Katze(String name, int age, int legs, String miau) {
        super(name, age, legs);
        this.miau = miau;
    }

    public void wirftSachenVomTisch(){
        System.out.println("typisch katze");
    }


    @Override
    public void eats() {

    }

    @Override
    public void sleeps() {
        System.out.println("Katze sleeps");
    }
}
