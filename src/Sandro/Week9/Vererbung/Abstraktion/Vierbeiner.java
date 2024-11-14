package Sandro.Week9.Vererbung.Abstraktion;

public abstract class Vierbeiner {
    protected String name;
    protected int age;
    protected int legs;

    public Vierbeiner(String name, int age, int legs) {
        this.name = name;
        this.age = age;
        this.legs = legs;
    }

    public abstract void eats();
    public abstract void sleeps();

}
