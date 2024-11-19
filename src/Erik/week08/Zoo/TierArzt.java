package Erik.week08.Zoo;

import Sandro.Colors;

import java.util.Vector;

public class TierArzt {

    // Attribute
    private String name;
    private Vector<Gehege> taskList;


    // Konstruktor
    public TierArzt(String name){
        this.name = name;
    }


    // Getter - Setter



    // Methoden
    public void startDaySimulation(){
        for (Gehege gh : taskList) {
            gh.searchForLowestHealth(); // this (Pfleger Object mit geben; NICHT die Klasse "Pfleger")
        }



    }


    // Heal Animal with the lowest Health Function
    public void HealAnimals(){

    }

    @Override
    public String toString() {
        return Colors.COLORS[5] + name + Colors.RESET;
    }
}
