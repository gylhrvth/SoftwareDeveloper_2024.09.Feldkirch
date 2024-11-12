package Furkan.week09.Zoo;

import java.util.Vector;

public class ZooPfleger {
    private String name;
    private int age;
    private Vector<Gehege> gehegeListe;



    public ZooPfleger(String name, int age) {
        this.name = name;
        this.age = age;
        this.gehegeListe = new Vector<>();
    }

    public void addTask(){


    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
