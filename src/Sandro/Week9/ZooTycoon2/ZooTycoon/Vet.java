package Sandro.Week9.ZooTycoon2.ZooTycoon;

import Sandro.Colors;

import java.util.Random;

public class Vet {
    private String name;

    Random rand = new Random();


    public Vet(String name) {
        this.name = Colors.COLORS[6] + name + Colors.RESET;

    }

    public String getName() {
        return name;
    }


    public void reviveAnimal(Animal animal) {
        int reviveTrigger = rand.nextInt(0, 100);

        if (reviveTrigger > 50) {
            healAnimal(animal);
        } else {
            System.out.println(name + " has failed to revive " + animal.getName());
        }
    }

    public void healAnimal(Animal animal) {
        animal.heal(this);
//        int procentheal = rand.nextInt(30, 100);
//        int heal = Math.max(10, (int)(animal.getMaxHealth() * procentheal / 100.0));
//        System.out.println(animal.getName() + " (Health: " + animal.getCurrentHealth() + "\\" + animal.getMaxHealth() + ")");
//        animal.setCurrentHealth(animal.getCurrentHealth() + heal);
//        if (animal.getCurrentHealth() > animal.getMaxHealth()) {
//            animal.setCurrentHealth(animal.getMaxHealth());
//            System.out.println(animal.getName() + " gets healed complete (" + procentheal + "%)" + " from " + name + " / " + animal.getName() + " has now --> (Health: " + animal.getCurrentHealth() + "\\" + animal.getMaxHealth() + ")");
//        } else {
//            System.out.println(animal.getName() + " gets healed for: " + heal + "HP(" + procentheal + "%)" + " from " + name + " / " + animal.getName() + " has now --> (Health: " + animal.getCurrentHealth() + "\\" + animal.getMaxHealth() + ")");
//        }
        //

//        System.out.println(animal.getName() + " (Health: " + animal.getCurrentHealth() + "\\" + animal.getMaxHealth() + ")" + " gets healed complete from " + name);
//        animal.setCurrentHealth(animal.getMaxHealth());
//        System.out.println(animal.getName() + " (Health: " + animal.getCurrentHealth() + "\\" + animal.getMaxHealth() + ")");
    }

    public void dailyRoutine(Zoo zoo) {
        Animal animal = zoo.findlowestAnimal();
        if (animal != null) {
//            if (animal.getCurrentHealth() == 0 || animal.getCurrentHealth() < 0){
//                reviveAnimal(animal);
//            } else {
            healAnimal(animal);
        } else {
            System.out.println(name + " tells you: \"All Animals are in good condition, no heals needed\"");
        }
    }


}
