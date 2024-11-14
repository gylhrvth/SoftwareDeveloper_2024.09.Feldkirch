package Akif_Malik.ZOO;

import Sandro.Colors;

import java.util.Vector;

public class Zoo {

    //------------Attributes---------------\\

    private String name;

    private int year;

    private Vector<Gehege> gehegen;

    private Vector<Tiere> tiere;

    private Vector<Essen> foods;

    //---------------Constuctor---------------\\

    public Zoo(String name, int year) {
        this.name = name;
        this.year = year;
        this.gehegen = new Vector<>();
        this.tiere = new Vector<>();
        this.foods = new Vector<>();
    }

    //---------------Functions---------------\\

    public void addGehege(Gehege gehegeName) {
        gehegen.add(gehegeName);
    }

    public void addFoods(Essen foodName) {
        foods.add(foodName);
    }

    //---------------ToString---------------\\

    public void printStructure() {
        String result = Colors.COLORS[2] + "\n├── Zoo: " + Colors.RESET + Colors.COLORS[4] + name + Colors.RESET +
                ", gegründet " + Colors.COLORS[5] + year + Colors.RESET + "\n";

        for (Gehege gehege : gehegen) {
            result += "│    ├── Gehege: " + Colors.COLORS[1] + gehege.getName() + Colors.RESET + "\n";

            if (gehege.getAnimals().isEmpty()) {
                result += "│       ├── (leer)\n";
            } else {
                for (Tiere tier : gehege.getAnimals()) {
                    result += "│       ├── " + tier + "\n";
                }
            }
        }
        System.out.println(result);
    }

}
