package Erik.week08.Zoo;

import java.util.HashMap;
import java.util.Vector;

public class Tier {

    // Attribute
    private String name;
    private String gattung;
    private Vector<Essen> essensListe;
    private Essen food;
    private int amountOfFood;


    // Konstruktor
    public Tier(String gattung, String name, Essen food, int amountOfFood) {
        this.gattung = gattung;
        this.name = name;
        this.food = food;
        this.amountOfFood = amountOfFood;
        this.essensListe = new Vector<>();
    }


    // Getter - Setter
    public String getName() {
        return name;
    }

    public String getGattung() {
        return gattung;
    }

    // Methoden
    public void printTierStructure() {
        System.out.printf("│   │   ├── Tier:  %-10s │ %-10s │ %-15s │ %3d │\n", name, gattung, food.getName(), amountOfFood);
    }

    public void getEveryFood(HashMap<Essen, Integer> neededFood) {

        if (neededFood.containsKey(food)) {                               // Prüft, ob das jeweilige Essen schon vorhanden ist
            neededFood.put(food, neededFood.get(food) + amountOfFood);    // fügt das jeweilige Essen hinzu; erste Value ist der Key; zweite Value was dazu muss
        } else {
            neededFood.put(food, amountOfFood);                           // Fügt das jeweilige Essen hinzu, falls es noch nicht existiert
        }

    }

    public void simulationStart(){
        System.out.println("Tier: " + getGattung() + " mit dem Namen " + getName() + " chillt gerade sein Leben.");
    }
}