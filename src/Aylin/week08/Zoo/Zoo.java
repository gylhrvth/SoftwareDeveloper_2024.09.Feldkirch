package Aylin.week08.Zoo;

import Sandro.Colors;

import java.util.HashMap;
import java.util.Vector;

public class Zoo {
    private String name;
    private int establishment;

    //List
    private Vector<Enclosure> enclosureList;

    public Zoo(String name, int establishment){
        this.name = Colors.COLORS[5] + name + Colors.RESET;
        this.establishment = establishment;
        this.enclosureList = new Vector<>();
    }

    @Override
    public String toString() {
        return name + ", " + Colors.COLORS[4] + establishment + Colors.RESET;
    }

    public void printZooName(){
        System.out.println("├── " + name + ", " + Colors.COLORS[4] + establishment + Colors.RESET);
        for (Enclosure enc : enclosureList){
            enc.printEnclosure();
        }
    }

    public void addEnclosure(Enclosure enc){
        if(!enclosureList.contains(enc)){
            enclosureList.add(enc);
        }
    }

    public void printFoodCost(){
        HashMap<Food, Double> foodRequired = new HashMap<>();
        for (Enclosure enc : enclosureList){

        }
    }
}
