package Erik.week08.Zoo;

import Sandro.Colors;

import java.util.HashMap;
import java.util.Vector;

public class Gehege {

    // Attribute
    private String name;
    private Vector<Tier> tierListe;


    // Konstruktor
    public Gehege(String name) {
        this.name = name;
        this.tierListe = new Vector<>();
    }


    // Getter - Setter
    public String getName() {
        return name;
    }

    // Methoden
    public void addTiereToTierList(Tier ti){
            if (!tierListe.contains(ti)) {
                tierListe.add(ti);
            }
    }

    // Printet ob Gehege Empty ist, sonst leitet er weiter in Klasse Tiere
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

    public void getEveryFood(HashMap<Essen, Integer> wholeFood){
        for (Tier ti : tierListe){
            ti.getEveryFood(wholeFood);     // Bei jedem Tier wird die Funktion aufgerufen
        }
    }

    public void simulationStart(){
        System.out.println(Colors.COLORS[2] + "Im " + getName() + " Gehege passiert" + Colors.RESET);    // Was passiert ... (für Simulation)
        for (Tier ti : tierListe){
            ti.simulationStart();       // Bei jedem Tier wird die Simulation gestartet bzw. aufgerufen
        }
        System.out.println("─".repeat(80));
    }
}