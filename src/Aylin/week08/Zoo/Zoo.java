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

    public void printZooStructure(){
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
        System.out.println();
        System.out.println(Colors.COLORS[4] + "***********************************************" + Colors.RESET);
        HashMap<Food, Double> foodRequired = new HashMap<>();
        for (Enclosure enc : enclosureList){
            enc.collectFoodRequirement(foodRequired);
        }

        //Berechnung mit der HashMap von Food Cost
        double cost = 0;
        for (Food food : foodRequired.keySet()) {
            System.out.printf(Colors.COLORS[4] + "*" + Colors.RESET + " %-12s : %3.0f %s / € per Unit: %4.0f €" + Colors.COLORS[4] + "  *\n" + Colors.RESET, food.getName(), cost, food.getUnit(), food.getPrice());
            double amount = foodRequired.get(food);
            double price = food.getPrice() * amount;
            cost += price;
        }
        System.out.printf(Colors.COLORS[4] + "*" + Colors.RESET + " Total costs for all required food: %5.0f €" + Colors.COLORS[4] + "  *\n" + Colors.RESET , cost );
        System.out.println(Colors.COLORS[4] + "***********************************************" + Colors.RESET);
    }
}
