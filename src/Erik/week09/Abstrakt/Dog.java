package Erik.week09.Abstrakt;

public class Dog extends FourLegs {

    // Attribute
    private String bark;


    // Konstruktor
    public Dog(String name, int age, int legs, String fur, String color, String bark) {
        super(name, age, legs, fur, color);

    }


    // Methode
    public void barks(){
        System.out.println("barks");
    }

    @Override
    public void getsOlder() {
        System.out.println("gets older");
    }

    @Override
    public void walks() {
        System.out.println("walks");
    }
}