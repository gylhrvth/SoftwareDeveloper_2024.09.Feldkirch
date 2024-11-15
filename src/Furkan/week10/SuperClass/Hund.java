package Furkan.week10.SuperClass;

public class Hund extends Tier{
    private String rasse;

    public Hund(String name, int age, String rasse) {
        super(name , age , "Hund");
        this.rasse = rasse;
    }

    public void spieltMitBall(){
        System.out.println(getName()+" spielt mit dem Ball");
    }

}
