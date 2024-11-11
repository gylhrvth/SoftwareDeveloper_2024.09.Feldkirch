package Furkan.week09.Zoo;

import java.util.Vector;

public class Zoo {
    private String name;
    private int year;
    private Vector<Gehege> gehegeListe;


    public Zoo(String name, int year) {
        this.name = name;
        this.year = year;
        this.gehegeListe = new Vector<>();
    }

    public void addGehege(Gehege gehege) {
        this.gehegeListe.add(gehege);
    }

    public void removeGehege(Gehege gehege) {
        this.gehegeListe.remove(gehege);
    }


    public void printZoo() {
        System.out.println("├──" + name + ", gegründet " + year);
        for (Gehege gehege : gehegeListe){
            gehege.printZoo();
        }
    }


}
