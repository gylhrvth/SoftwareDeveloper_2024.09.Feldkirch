package Akif_Malik.ZOO;

import Gyula.WildColors;
import Sandro.Colors;
import java.util.Random;
import java.util.Vector;

public class Enclosure {
    Random random = new Random();
    private String name;
    private Vector<Tiere> tiere;
    private boolean hasProcessed;

    public Enclosure(String name) {
        this.name = name;
        this.hasProcessed = false;
        this.tiere = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public Vector<Tiere> getAnimals() {
        return tiere;
    }

    public void observeRandomAnimal(ZooKeeper zooKeeper) {
        Tiere randomAnimal = tiere.get(random.nextInt(tiere.size()));
        if (zooKeeper.getFavoriteSpecies().equals(randomAnimal.getDescription())) {
            System.out.println(zooKeeper + " admires " + randomAnimal);
        } else { System.out.println(zooKeeper + " observes " + randomAnimal);
        }
    }

    public void simulateDay(Akif_Malik.ZOO.ZooKeeper zooKeeper) {
        if (!hasProcessed) {
            if (tiere.isEmpty()) {
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

    private void removeDeadAnimals() {
        for (int i = 0; i < tiere.size(); i++) {
            if (!tiere.get(i).isAlive()) {
                System.out.println(tiere.get(i) + " has been removed from " + this + ".");
                tiere.remove(i);
                --i;
            }
        }
    }

    public void resetProceeded() {
        hasProcessed = false;
    }

    public void simulateFight() {
        System.out.println(WildColors.getColor("#35A9F4") + "There is some aggression in " + this + WildColors.resetColor());
        for (Tiere tier : tiere) {
            Vector<Tiere> possibleVictims = new Vector<>();
            for (Tiere testAnimal : tiere) {
                if (!tier.getDescription().equals(testAnimal.getDescription())) {
                    possibleVictims.add(testAnimal);
                }
            }
            if (!possibleVictims.isEmpty()) {
                Tiere victim = possibleVictims.get(random.nextInt(possibleVictims.size()));
                tier.simulateFight(victim);
            }
        }
        removeDeadAnimals();
    }

    public Tiere searchAndCreateAnimal(String name, String species, String gender, int maxHealth, int attack) {
        Tiere result = null;
        for (Tiere tiere : tiere) {
            if (result == null && tiere.getName().equals(name)) {
                result = tiere;
            }
        }
        if (result == null) {
            result = new Tiere(name, species, maxHealth, attack);
            tiere.add(result);
        }
        return result;
    }

    @Override
    public String toString() {
        return Colors.COLORS[1] + name + Colors.RESET;
    }
}
