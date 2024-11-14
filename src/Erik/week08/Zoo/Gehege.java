package Erik.week08.Zoo;

import Sandro.Colors;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class Gehege {
    private static Random rand = new Random();

    // Attribute
    private String name;
    private int workDone;
    private Vector<Tier> tierListe;


    // Konstruktor
    public Gehege(String name) {
        this.name = name;
        this.workDone = -1;
        this.tierListe = new Vector<>();
    }


    // Getter - Setter
    public String getName() {
        return name;
    }

    public Vector<Tier> getTierListe() {
        return tierListe;
    }


    // Methoden
    public void addTiereToTierList(Tier ti) {
        if (!tierListe.contains(ti)) {
            tierListe.add(ti);
        }
    }

    public void printGehegeStructure() {
        System.out.println("│   ├── Gehege: " + name);

        if (tierListe.isEmpty()) {
            System.out.println("│   │   ├── Tier: " + " (Leer) ");
        } else {
            for (Tier ti : tierListe) {
                ti.printTierStructure();
            }
        }
    }

    public void getEveryFood(HashMap<Essen, Integer> wholeFood) {
        for (Tier ti : tierListe) {
            ti.getEveryFood(wholeFood);     // Bei jedem Tier wird die Funktion aufgerufen
        }
    }

    public void resetGehegeStatus() {
        workDone = -1;
    }

    public void randomTierBeobachten(Pfleger pfleger) {
        Tier randTier = tierListe.get(rand.nextInt(tierListe.size()));

        if (randTier.getGattung().equals(pfleger.getLieblingsGattung())) {
            System.out.println(Colors.COLORS[6] + pfleger.getName() + Colors.RESET + Colors.COLORS[1] + " beobachtet fav. Tier " + Colors.RESET + randTier.getGattung() + " " + randTier.getName());
        } else {
            System.out.println(Colors.COLORS[6] + pfleger.getName() + Colors.RESET + " schaut sich rdm " + randTier.getGattung() + " " + randTier.getName() + " an.");
        }

    }

    public void startTagesSimulation(Pfleger pfleger) {
        // Pfleger start
        System.out.println(Colors.COLORS[6] + pfleger.getName() + Colors.RESET + " geht ins Gehege " + Colors.COLORS[6] + name + Colors.RESET);
        System.out.println(Colors.COLORS[6] + pfleger.getName() + Colors.RESET + " checkt ...");

        // checkt ob Gehege schon gemacht wurde
        if (workDone == -1) {
            System.out.println(".. Gehege wurde noch nicht bearbeitet. " + Colors.COLORS[6] + pfleger.getName() + Colors.RESET + " macht seinen Job ... ");
            for (Tier ti : tierListe) {
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
        Tier attacker = tierListe.get(rand.nextInt(tierListe.size()));  // Random Attacker
        Tier victim = tierListe.get(rand.nextInt(tierListe.size()));     // Random Victim

        System.out.println("Aggressivität steigt im Gehege ..." + this);

        for (Tier tier : tierListe) {
            tier.startFightSimulation(victim);
        }

//        if (victim.getName().equals(attacker.getName())){
//            System.out.println(attacker.getName() + " Kann sich nicht selbst beißen!");
//        } else {
//            System.out.println(attacker.getName() + " attackiert " + victim.getName());
//        }
    }





    @Override
    public String toString() {
        return Colors.COLORS[5] + name + Colors.RESET;
    }
}

/*
    public void test() {
        for (Tier tier : tierListe) {
            if (getTierListe().size() < 2) { // wenn tier Liste im gehege leer ist
                System.out.println(Colors.COLORS[8] + getName() + " Hat keine möglichkeit jemanden zu beißen!" + Colors.RESET);
            }
            for (Tier opfer : tierListe) {
                if (!tier.equals(opfer)) { // attacker kann sich nicht selbst angreifen
                    tier.attack(this);
                }
            }
        }
    }
 */