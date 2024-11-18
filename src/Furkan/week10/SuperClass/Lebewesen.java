package Furkan.week10.SuperClass;

public class Lebewesen {
    private String name;
    private int age;


    public Lebewesen(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void die() {
        System.out.println(getName()+"die");
    }

    public void grow() {
        System.out.println(getName()+" grow");
    }

    public void sleep(){
        System.out.println(getName()+" sleeps");
    }

    public void eat (){
        System.out.println(getName()+" eats");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
