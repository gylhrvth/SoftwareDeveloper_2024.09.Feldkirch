package Akif_Malik.ZOO;

import Sandro.Colors;

import java.util.Vector;

public class Zoo {

    //------------Attributes---------------\\

    private String name;

    private int year;

    private Vector<Gehege> gehegen;

    private Vector<Tiere> tieren;

    private Vector<Essen> foods;

    //---------------Constuctor---------------\\

    public Zoo(String name, int year) {
        this.name = name;
        this.year = year;
        this.gehegen = new Vector<>();
        this.tieren = new Vector<>();
        this.foods = new Vector<>();
    }

    //---------------Functions---------------\\

    public void addGehege(Gehege gehegeName) {
        gehegen.add(gehegeName);
    }

    public void addTieren(Tiere animalName) {
        tieren.add(animalName);
    }

    public void addFoods(Essen foodName) {
        foods.add(foodName);
    }

    //---------------ToString---------------\\

    //missing toString for Animals and Foods.

    @Override
    public String toString() {
        String result = Colors.COLORS[2] + "\n----|Zoo: " + Colors.RESET + Colors.COLORS[4] + name + Colors.RESET +
                                           ", founded in " + Colors.COLORS[5] + year + Colors.RESET + "\n";

        for (Gehege gehege : gehegen) {
            result += Colors.COLORS[3] + "------|Gehege: " + Colors.COLORS[1] + gehege + Colors.RESET + "\n";
        }
        return result;
    }
}