package Erik.week12.DBSelbsttestMitOOP;

import Sandro.Colors;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class Enclosure {
    private static Random rand = new Random();

    // Attribute
    private String name;
    private int workDone;
    private Vector<Animal> animalList;


    // Konstruktor
    public Enclosure(String name) {
        this.name = name;
        this.workDone = -1;
        this.animalList = new Vector<>();
    }


    // Getter - Setter
    public String getName() {
        return name;
    }


    // Methoden

    @Override
    public String toString() {
        return Colors.COLORS[5] + name + Colors.RESET;
    }

    public void addAnimalToList(Animal ti) {
        if (!animalList.contains(ti)) {
            animalList.add(ti);
        }
    }

    public void printGehegeStructure() {
        System.out.println("│   ├── Gehege: " + name);

        if (animalList.isEmpty()) {
            System.out.println("│   │   ├── Tier: " + " (Leer) ");
        } else {
            for (Animal ti : animalList) {
                ti.printTierStructure();
            }
        }
    }

    public void getEveryFood(HashMap<Food, Integer> wholeFood) {
        for (Animal ti : animalList) {
            ti.getEveryFood(wholeFood);     // Bei jedem Tier wird die Funktion aufgerufen
        }
    }

    public void resetGehegeStatus() {
        workDone = -1;
    }

    public void randomTierBeobachten(ZooKeeper pfleger) {
        Animal randTier = animalList.get(rand.nextInt(animalList.size()));

        if (randTier.getGattung().equals(pfleger.getLieblingsGattung())) {
            System.out.println(Colors.COLORS[6] + pfleger.getName() + Colors.RESET + Colors.COLORS[1] + " beobachtet fav. Tier " + Colors.RESET + randTier.getGattung() + " " + randTier.getName());
        } else {
            System.out.println(Colors.COLORS[6] + pfleger.getName() + Colors.RESET + " schaut sich rdm " + randTier.getGattung() + " " + randTier.getName() + " an.");
        }

    }

    public void startDaySimulationForPfleger(ZooKeeper pfleger) {
        // Pfleger start
        System.out.println(Colors.COLORS[6] + pfleger.getName() + Colors.RESET + " geht ins Gehege " + Colors.COLORS[6] + name + Colors.RESET);
        System.out.println(Colors.COLORS[6] + pfleger.getName() + Colors.RESET + " checkt ...");

        // checkt ob Gehege schon gemacht wurde
        if (workDone == -1) {
            System.out.println(".. Gehege wurde noch nicht bearbeitet. " + Colors.COLORS[6] + pfleger.getName() + Colors.RESET + " macht seinen Job ... ");
            for (Animal ti : animalList) {
                ti.giveTierEssen(pfleger);  // jedes tier füttern
            }
            randomTierBeobachten(pfleger);  // tier beobachten
            workDone = 0;                   // Arbeit erledigt
        } else {
            System.out.println("Gehege wurde schon bearbeitet. Pfleger geht weiter ...");
        }
        System.out.println("─".repeat(80));
    }

    public void startFightSimulation() {
        System.out.println("Aggressivität steigt im Gehege ..." + this);

        for (Animal tier : animalList) {
            Animal victim = animalList.get(rand.nextInt(animalList.size())); // Wählt bei jedem durchlauf ein neues Opfer
            tier.startFightSimulation(victim);
        }
    }


    public Animal searchForLowestHealth() {
        Animal best = null;
        for (Animal animal : animalList) {
            if (best == null || best.getRelativeHealth() > animal.getRelativeHealth()) {
                best = animal;
            }
        }
        return best;
    }
}