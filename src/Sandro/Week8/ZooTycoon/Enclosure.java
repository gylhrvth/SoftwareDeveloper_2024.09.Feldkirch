package Sandro.Week8.ZooTycoon;

import java.util.HashMap;
import java.util.Vector;

public class Enclosure {
    private String name;
    private String description;
    private String climate;
    private Vector<Animal> animalList;

    public Enclosure(String name, String climate, String description) {
        this.name = name;
        this.climate = climate;
        this.description = description;
        this.animalList = new Vector<>();
    }


    @Override
    public String toString() {
        return "Name: " + name + "\nDescription: " + description + "\nClimate: " + climate;
    }



    public void addAnimal (Animal ani){
        if(!animalList.contains(ani)){
            animalList.add(ani);
        }
    }
    public boolean isClean(){
        return true;
    }

    public void simu(int day){
        System.out.println("Was passiert im Gehege --> "+name);
        for (Animal ani : animalList){
            ani.simu(day);
        }
        isClean();
    }

    public void collectFoodRequirement(HashMap<Food, Double> foodRequiert) {
        //durch alle tiere mit foreach, aufruf der Funktion in Tierklasse
        for (Animal a : animalList) {
            //für jedes Tier im Gehege die Funktion bei der TierKlasse aufrufen
            a.collectFoodRequirement(foodRequiert);
        }
    }


    public void printZooStructure() {
        //print alle Attribute der klasse
        System.out.println("│   ├── " + "Enclosure: " + name + ", " + description + " (" + climate + ")");
        //gibt es eine liste mit objekte gib dem job weiter in die dafür bestehende ObjektKlasse
        if (!animalList.isEmpty()){
            for (Animal ani : animalList){
                ani.printZooStructure();
            }
        }else {
            System.out.println("│   │   ├── Animal: " + " (Empty) ");
        }

    }

}
