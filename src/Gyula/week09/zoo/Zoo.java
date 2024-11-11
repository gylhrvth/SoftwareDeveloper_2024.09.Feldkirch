package Gyula.week09.zoo;

import java.util.Vector;

public class Zoo {
    private String name;
    private int establishedYear;
    private Vector<Enclosure> enclosureList;

    public Zoo(String name, int establishedYear){
        this.name = name;
        this.establishedYear = establishedYear;
        this.enclosureList = new Vector<>();
    }

    public void addEnclosure(Enclosure enc){
        enclosureList.add(enc);
    }

    public Enclosure searchAndCreateEnclosure(String name){
        Enclosure result = null;
        for (Enclosure enc : enclosureList){
            if (result == null && enc.getName().equals(name)){
                result = enc;
            }
        }
        if (result == null){
            result = new Enclosure(name);
            enclosureList.add(result);
        }
        return result;
    }

    public Animal searchAndCreateAnimal(String enclosureName, String animalName, String species, String gender){
        Enclosure enc = searchAndCreateEnclosure(enclosureName);
        return enc.searchAndCreateAnimal(animalName, species, gender);
    }

    public void printStructure(){
        System.out.printf("Zoo: %s (gegründet: %d)\n", name, establishedYear);
        for (Enclosure enc : enclosureList){
            enc.printStructure();
        }
    }
}
