package Thiemo.week09.Vererbung.Superclass;

public class Mage extends Champions {
private int mana;


    public Mage(String position, String name, int movementSpeed, int HP, String gender, int mana) {
        super(position, name, movementSpeed, HP, gender);
        this.mana = mana;
        System.out.println("I am the Mage constructor");
    }

    public void Magethings(){
     System.out.println("Mage things");
 }
}

