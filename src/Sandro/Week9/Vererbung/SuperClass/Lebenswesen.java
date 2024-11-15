package Sandro.Week9.Vererbung.SuperClass;

public class Lebenswesen {
    private String name;
    private int age;

    public Lebenswesen(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("Ich bin der Lebewesen Konstruktor");
    }


    public void die(){
        System.out.println("die");
    }

    public void grow(){
        System.out.println("grow");
    }



}
