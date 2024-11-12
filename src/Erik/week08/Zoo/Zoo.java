package Erik.week08.Zoo;

import Sandro.Colors;

import java.util.HashMap;
import java.util.Vector;

public class Zoo {

    // Attribute
    private String name;
    private String place;
    private int foundation;
    private Vector<Gehege> gehegeListe;
    private Vector<Pfleger> pflegerListe;


    // Konstruktor
    public Zoo(String name, String place, int foundation) {
        this.name = name;
        this.place = place;
        this.foundation = foundation;
        this.gehegeListe = new Vector<>();
        this.pflegerListe = new Vector<>();
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

    // Zoo printent seine Infos und ruft gleichzeitig die Gehege Print Funktion auf
    public void printZooStructure() {
        System.out.println("├── Zoo: " + name + " / " + place + " / " + foundation);
        for (Gehege gh : gehegeListe) {
            gh.printGehegeStructure();
        }
        System.out.println("─".repeat(80));
        System.out.println("Zoo Pfleger:");
        for (Pfleger pf : pflegerListe){
            pf.printStructure();
        }
        System.out.println("─".repeat(80));
    }

    // Simulation von dem Zoo
    public void startSimulation() {
        System.out.println(Colors.COLORS[3] + "Simulation des Zoo's wird gestartet: ..." + Colors.RESET);
        for (int i = 0; i < 7; i++) {
            System.out.println(Colors.COLORS[1] + "Tag: >> " + i + " <<" + Colors.RESET);
            for (Gehege gh : gehegeListe) {
                gh.simulationStart();           // Bei jedem Gehege in der Gehege Liste wird die Simulation gestartet
            }
        }
    }

    // Pfleger adden!!!!!!
    public void addPfleger(Pfleger pf){
        if (!pflegerListe.contains(pf)) {
            pflegerListe.add(pf);
        }
    }

}