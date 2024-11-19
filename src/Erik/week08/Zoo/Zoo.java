package Erik.week08.Zoo;

import Sandro.Colors;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class Zoo {
    public Random ran = new Random();
    // Attribute
    private String name;
    private String place;
    private int foundation;
    private Vector<Gehege> gehegeListe;
    private Vector<Pfleger> pflegerListe;
    private Vector<TierArzt> vetList;
    private int workDone;

    // Konstruktor
    public Zoo(String name, String place, int foundation) {
        this.name = name;
        this.place = place;
        this.foundation = foundation;
        this.gehegeListe = new Vector<>();
        this.pflegerListe = new Vector<>();
        this.vetList = new Vector<>();
        this.workDone = -1;
    }


    // Getter - Setter


    // Methoden
    @Override
    public String toString() {
        return String.format("Name: %s / Ort: %s / Gründungsjahr: %s", name, place, foundation);
    }


    public void addGehegeInList(Gehege gh) {
        if (!gehegeListe.contains(gh)) {
            gehegeListe.add(gh);
        }
    }

    public void addPfleger(Pfleger pf) {
        if (!pflegerListe.contains(pf)) {
            pflegerListe.add(pf);
        }
    }

    public void addVet(TierArzt vet) {
        if (!vetList.contains(vet)) {
            vetList.add(vet);
        }
    }


    public void printFoodCost() {
        HashMap<Essen, Integer> neededFood = new HashMap<>();

        for (Gehege gh : gehegeListe) {
            gh.getEveryFood(neededFood);
        }

        System.out.println("Essen's Voraussetzung:");
        int cost = 0;

        for (Essen food : neededFood.keySet()) {
            System.out.println(food.getName() + " ===> " + neededFood.get(food) + " Stk | " + food.getEinheit() + " € pro Einheit; Gesamt Bedarf: " + food.getEinheitsPreis() + " €");
            int amount = neededFood.get(food);
            int price = food.getEinheitsPreis() * amount;
            cost += price;
        }
        System.out.println("Totale Kosten des Essen's Voraussetzung ist: >> " + cost + " €");
        System.out.println("─".repeat(80));
    }

    public void printZooStructure() {
        System.out.println("─".repeat(80));
        System.out.println("├── Zoo: " + name + " / " + place + " / " + foundation);
        for (Gehege gh : gehegeListe) {
            gh.printGehegeStructure();
        }
        System.out.println("─".repeat(80));
        System.out.println("Zoo Pfleger:");
        for (Pfleger pf : pflegerListe) {
            pf.printStructure();
        }
        System.out.println("─".repeat(80));
    }


    // Abfrage überprüfen
    public Tier findOverallLowestAnimal() {
        Tier overallLowestHP = null;
        for (Gehege gh : gehegeListe) {

            Tier lowestHPAnimal = gh.searchForLowestHealth();

            if (overallLowestHP == null || overallLowestHP.getCurrentHP() < lowestHPAnimal.getCurrentHP()) {
                overallLowestHP = lowestHPAnimal;
            }
//            overallLowestHP = gh.searchForLowestHealth();
        }
        return overallLowestHP;
    }





    public void startTagesSimulation() {

        System.out.println(Colors.COLORS[3] + "Simulation des Zoo's wird gestartet: ..." + Colors.RESET);
        for (int tag = 1; tag <= 10; tag++) {
            System.out.println(Colors.COLORS[1] + "Tag: >> " + tag + " <<" + Colors.RESET);

            // Reset Gehege Status
            for (Gehege gh : gehegeListe) {
                gh.resetGehegeStatus();
            }


            // Pfleger start
            System.out.println(Colors.COLORS[3] + ">> Alle Pfleger fangen an zu Arbeiten. <<" + Colors.RESET);
            for (Pfleger pf : pflegerListe) {
                pf.startTagesSimulation();
            }
            System.out.println(Colors.COLORS[3] + ">> Alle Pfleger haben ihre Arbeit beendet. <<" + Colors.RESET);

            System.out.println("─".repeat(80));


            // Kampf start
            System.out.println(Colors.COLORS[3] + ">> Der Kampf beginnt! <<" + Colors.RESET);
            for (Gehege gh : gehegeListe) {
                gh.startFightSimulation();
            }
            System.out.println(Colors.COLORS[3] + ">> Der Kampf ist vorbei! <<" + Colors.RESET);

            System.out.println("─".repeat(80));


            // Tier Arzt start
            System.out.println(Colors.COLORS[3] + ">> Tier Arzt kommt in den Zoo <<" + Colors.RESET);
            for (TierArzt vet : vetList) {
                vet.startDaySim(this);
            }
            System.out.println(Colors.COLORS[3] + ">> Tier Arzt hat die Arbeit erledigt <<" + Colors.RESET);

            System.out.println("─".repeat(80));
        }
    }

}