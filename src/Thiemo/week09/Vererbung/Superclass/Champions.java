package Thiemo.week09.Vererbung.Superclass;

public abstract class Champions extends Lane {

    private String name;
    private String gender;
    private int HP;
    private int movementSpeed;
    private String roll;

    public Champions(String position, String name, int movementSpeed, int HP, String gender) {
        super(position);
        this.name = name;
        this.movementSpeed = movementSpeed;
        this.HP = HP;
        this.gender = gender;
        System.out.println("I am the Champion constructor");
    }

    public Champions(String position, String roll) {

        super(position);
        System.out.println("I am the Champion constructor");
    }

    public void die() {
        System.out.println("dies");

    }

    public void heal() {
        System.out.println("heals");
    }

}
