package Gyula.week09.zoo;

import java.util.Vector;

public class Enclosure {
    private String name;
    private Vector<Animal> animalList;

    public Enclosure(String name){
        this.name = name;
        this.animalList = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public Animal searchAndCreateAnimal(String name, String species, String gender){
        Animal result = null;
        for (Animal ani : animalList){
            if (result == null && ani.getName().equals(name)){
                result = ani;
            }
        }
        if (result == null){
            result = new Animal(name, species, gender);
            animalList.add(result);
        }
        return result;
    }

    public void printStructure(){
        System.out.printf("    Gehege: %s\n", name);
        for (Animal ani: animalList){
            ani.printStructure();
        }
    }
}
