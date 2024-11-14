package Sandro.Week9.Vererbung.SuperClass;


public class Mensch extends Lebenswesen{
    private String gender;

    public Mensch (String name, int age, String gender){
        super(name, age);
        this.gender = gender;
        System.out.println("Ich bin der Mensch Konstruktor");
    }

    public void humanThings(){
        System.out.println("human things");
    }

    @Override
    public void grow() {
        System.out.println("get older");
    }

    @Override
    public String toString (){
        return "re...f";
    }
}
