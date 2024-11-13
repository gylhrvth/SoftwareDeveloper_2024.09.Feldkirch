package Gyula.week09.zoo;

import Gyula.WildColors;

public class Animal {
    private String name;
    private String species;
    private String gender;

    public Animal(String name, String species, String gender){
        this.name = name;
        this.species = species;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void printStructure(){
        System.out.printf("        Animal: %s %s (%s)\n", this, gender, species);
    }

    @Override
    public String toString() {
        return WildColors.getColorFromHSL(210, 1.0, 0.4) + name + WildColors.resetColor();
    }
}
