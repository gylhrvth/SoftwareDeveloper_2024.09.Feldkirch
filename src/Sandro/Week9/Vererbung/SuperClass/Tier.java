package Sandro.Week9.Vererbung.SuperClass;

public class Tier extends Lebenswesen{

    private String genus;

    public Tier(String name, int age, String genus){
        super(name,age);
        this.genus = genus;
        System.out.println("Ich bin der Tier Konstruktor");
    }


    public void animalThings(){
        System.out.println("animal things");
    }







}
