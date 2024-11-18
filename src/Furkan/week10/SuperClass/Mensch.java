package Furkan.week10.SuperClass;

public class Mensch extends Lebewesen {
    private String gender;
    private String name;
    private int age;


    public Mensch(String gender, String name, int age) {
        super(name, age);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void humanThings(){
        System.out.println(getName() + " wacht auf und geht aufs Wc.");

    }



}
