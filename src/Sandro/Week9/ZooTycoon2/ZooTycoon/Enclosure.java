package Sandro.Week9.ZooTycoon2.ZooTycoon;

import Sandro.Colors;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class Enclosure {
    private String name;
    private String description;
    private String climate;
    private Vector<Animal> animalList;
    private Zoo zoo;

    private boolean alreadyVisit;
    static Random rand = new Random();

    public Enclosure(Zoo zoo, String name, String description, String climate) {
        this.zoo = zoo;
        this.name = Colors.COLORS[3] + name + Colors.RESET;
        this.description = description;
        this.climate = climate;
        this.animalList = new Vector<>();
        this.alreadyVisit = false;

    }

    public void setAlreadyVisit(boolean alreadyVisit) {
        this.alreadyVisit = alreadyVisit;
    }

    public boolean isAlreadyVisit() {
        return alreadyVisit;
    }

    public String getName() {
        return name;
    }

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animalList.remove(animal);
    }
public void potentialFight(Animal vic, Animal agr){
    int trigger = rand.nextInt(0, 100);
    if (trigger < 50){
        System.out.println("#############################################################");
        System.out.println("A fight starts between: " +vic.getName() + " and " +agr.getName());
        vic.animalfight(vic, agr);
        System.out.println("#############################################################");
    }
}
    public void potentialBite() {

        for (int i = 0; i < animalList.size(); i++) {
            int trigger = rand.nextInt(0, 100);
            if (trigger < 40) {
                int target = rand.nextInt(animalList.size());
                Animal animalAgg = animalList.get(i);
                Animal animalVic = animalList.get(target);

                if (animalVic == animalAgg) {
                    //noop
                } else {
                    //  System.out.println(Colors.COLORS[1] + "WARNING!!! " + animalAgg.getName() + " bites " + animalVic.getName() + Colors.RESET);
                    animalAgg.animalgetsBit(animalVic, animalAgg);
                    potentialFight(animalVic,animalAgg);
                }

//                if (animalList.get(i) == animalList.lastElement()) {
//                    animalVic = animalList.get(i - 1);
//                } else {
//                    animalVic = animalList.get(i + 1);
//                }


            }
        }
    }

    public void collectFoodRequirement(HashMap<Food, Double> foodRequiert) {
        for (Animal a : animalList) {
            a.collectFoodRequirement(foodRequiert);
        }
    }

//    public void isAnimalDead(Animal ani) {
//        if (ani.getCurrentHealth() < 1) {
//            System.out.println(ani.getName() + " died");
//            ani.setAlive(false);
//        }
//    }

    public void simulate() {
        potentialBite();
        for (Animal a : animalList) {
            if (!a.isAlive()) {
                System.out.println(a.getName() + " died from fatal injuries");
            }
//            if (!a.isAlive()) {
//                it.remove();
//            }
        }
    }


    Animal findlowestAnimal(Animal bestChoise) {
        for (Animal animal: animalList){
            bestChoise = animal.findlowestAnimal(bestChoise);
        }
        return bestChoise;
    }

    public Animal findLowestLifeAnimal() {
        if(animalList.isEmpty()) {
            return null;
        }
        Animal enclowest = animalList.get(0);   //null or ?
        for (Animal a:animalList) {
            if (a.getHealthprecent() < enclowest.getHealthprecent()){
                enclowest = a;
            }
        }
        return enclowest;
    }

    public void vetTask (){

//        int lowlife = Integer.MAX_VALUE;
//        Animal toheal = null;
//        for (Animal a:animalList) {
//            if (a.getHealthprecent() < lowlife){
//                lowlife = a.getHealthprecent();
//                toheal = a;
//            }
//        }
//        toheal.animalGetsHeal(toheal);
//        System.out.println(toheal.getName() +" gets patched up and heals complete");
   }

   private void removeDeadAnimals(ZooKeeper keeper){
       for (int i = 0; i < animalList.size(); i++) {
           Animal a = animalList.get(i);
           if (!a.isAlive()){
               zoo.incremnetDeadAnimals();
               animalList.remove(i);
               --i;
               System.out.println(keeper.getName() + " takes " + a.getName() + " out of " + name);
           }
       }
   }

   private void feedAnimals(ZooKeeper keeper){
       for (Animal a :animalList) {
            System.out.println(keeper.getName() + " feeds " + a.getName() + " (Health: " + a.getCurrentHealth() + "\\" + a.getMaxHealth() +") " + " with " + a.getAmount() + " " + a.getFood().getUnit() + " of " + a.getFood().getName());
            a.feedAnimal(a);
       }
   }

    public void processedBy(ZooKeeper keeper) {

        Random rand = new Random();

//        if (!animalList.isEmpty()) {
//
//            Iterator<Animal> it = animalList.iterator();
//            while (it.hasNext()) {
//                Animal a = it.next();
//                if (!a.isAlive()) {
//                    System.out.println("takes " + a.getName() + " out of " + name);
//                    it.remove();
//                } else {
//                    System.out.println("feeds " + a.getName() + " (Health: " + a.getCurrentHealth() + "\\" + a.getMaxHealth() +") " + " with " + a.getAmount() + " " + a.getFood().getUnit() + " of " + a.getFood().getName());
//                    a.feedAnimal(a);
//                }
//            }
//        }

        removeDeadAnimals(keeper);
        feedAnimals(keeper);

        if (!animalList.isEmpty()) {
//            if(Math.random() > 0.5) {
//                Animal a = animalList.get(0);
//                a.bites(keeper);
//            }

        int animalIndex = rand.nextInt(animalList.size());
            System.out.println("looks at " + animalList.get(animalIndex).getName());
        } else {
            System.out.println("Constructs the new " + name);
        }
    }


    public void printZoo() {
        System.out.println("│   ├── " + "Enclosure: " + name + ", " + description + " (" + climate + ")");
        if (animalList.isEmpty()) {
            System.out.println("│   │   ├── (is Empty)");
        } else {
            for (Animal ani : animalList) {
                ani.printZoo();
            }
        }

    }
}
