package Erik.week09.Abstrakt;

public abstract class FourLegs {

    // Attribute
    private String name;
    private int age;
    private int legs;
    private String fur;
    private String color;


    // Konstruktor
    public FourLegs(String name, int age, int legs, String fur, String color) {
        this.name = name;
        this.age = age;
        this.legs = legs;
        this.fur = fur;
        this.color = color;
    }


    // Methode
    public abstract void getsOlder();


    public abstract void walks();
}