package Gyula.week09.zoo;

import Gyula.ConsoleTools;
import Gyula.WildColors;

import java.util.Random;
import java.util.Vector;

public class Enclosure {
    private static Random random = new Random();
    private String name;
    private Vector<Animal> animalList;
    private boolean hasProcessed;

    public Enclosure(String name){
        this.name = name;
        this.animalList = new Vector<>();
        this.hasProcessed = false;
    }

    public String getName() {
        return name;
    }

    public Animal searchAndCreateAnimal(String name, String species, String gender, int maxHealth, int attack){
        Animal result = null;
        for (Animal ani : animalList){
            if (result == null && ani.getName().equals(name)){
                result = ani;
            }
        }
        if (result == null){
            result = new Animal(name, species, gender, maxHealth, attack);
            animalList.add(result);
        }
        return result;
    }

    public void printStructure(){
        System.out.printf("    %s\n", this);
        for (Animal ani: animalList){
            ani.printStructure();
        }
    }

    public void resetProceeded(){
        hasProcessed = false;
    }

    public void observeRandomAnimal(ZooKeeper zooKeeper){
        Animal randomAnimal = animalList.get(random.nextInt(animalList.size()));
        if (zooKeeper.getFavoriteSpecies().equals(randomAnimal.getSpecies())){
            System.out.println(zooKeeper + " admires " + randomAnimal);
        } else {
            System.out.println(zooKeeper + " observes " + randomAnimal);
        }
    }

    public void simulateFight(){
        System.out.println("There is some aggression in " + this);
        for (Animal ani: animalList){
            Animal victim = animalList.get(random.nextInt(animalList.size()));
            ani.simulateFight(victim);
        }
        removeDeadAnimals();
    }

    private void removeDeadAnimals(){
        for (int i = 0; i < animalList.size(); i++) {
            if (!animalList.get(i).isAlive()){
                System.out.println(animalList.get(i) + " has been removed from " + this + ".");
                animalList.remove(i);
                --i;
            }
        }
    }

    public void simulateDay(ZooKeeper zooKeeper){
        if (!hasProcessed){
            if (animalList.isEmpty()){
                System.out.printf("%s founds no animals in %s\n", zooKeeper, this);
            } else {
                System.out.printf("%s feeds the animals in %s\n", zooKeeper, this);
                observeRandomAnimal(zooKeeper);
            }
            hasProcessed = true;
        } else {
            System.out.printf("%s has been processed. %s takes the next enclosure\n", this, zooKeeper);
        }
    }

    @Override
    public String toString() {
        return WildColors.getColorFromHSL(120, 1.0, 0.5) + name + WildColors.resetColor();
    }
}
