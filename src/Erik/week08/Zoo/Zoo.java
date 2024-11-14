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
    private int workDone;

    // Konstruktor
    public Zoo(String name, String place, int foundation) {
        this.name = name;
        this.place = place;
        this.foundation = foundation;
        this.gehegeListe = new Vector<>();
        this.pflegerListe = new Vector<>();
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


    public void startTagesSimulation() {
        // Reset Gehege Status
        for (Gehege gh : gehegeListe){
            gh.resetGehegeStatus();
        }
        System.out.println(Colors.COLORS[3] + ">> Pfleger starten mit ihrer Arbeit. <<" + Colors.RESET);
        // Pfleger start
        for (Pfleger pf : pflegerListe) {
            pf.startTagesSimulation();
        }
        System.out.println("─".repeat(80));

    }
}
