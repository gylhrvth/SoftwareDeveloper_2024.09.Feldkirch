package Gyula.week09.zoo;

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
        System.out.printf("        Animal: %s %s (%s)\n", name, gender, species);
    }
}
