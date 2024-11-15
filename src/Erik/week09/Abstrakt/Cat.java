package Erik.week09.Abstrakt;

public class Cat extends FourLegs {

    // Attribute
    private String meow;


    // Konstruktor
    public Cat(String name, int age, int legs, String fur, String color, String meow) {
        super(name, age, legs, fur, color);
        this.meow = meow;
    }


    // Methode
    public void meows() {
        System.out.println("meow");
    }

    @Override
    public void getsOlder() {
        System.out.println("gets older");
    }

    @Override
    public void walks() {

    }
}