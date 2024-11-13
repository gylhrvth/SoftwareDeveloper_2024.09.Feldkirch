package Aylin.week08.Zoo;

import java.util.Vector;

public class Veterinarian {
    private String name;
    private Vector<Veterinarian> vet;
    private Vector<Animals> animalList;

    public Veterinarian(String name){
        this.name = name;
        this.vet = new Vector<>();
        this.animalList = new Vector<>();
    }


}
