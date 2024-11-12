package Thiemo.week09.Zoo;

import Sandro.Colors;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class Zoo {
    private static Random random = new Random();
    private String name;
    private String location;
    private int foundingyear;
    private int maxCapacitiyVisitors;
    private Vector<Enclosure> enclosureList;
    private Vector<Zookeeper> keeperlist;

    public Zoo(String name, String location, int foundingyear, int maxCapacitiyVisitors) {
        this.name = name;
        this.location = location;
        this.foundingyear = foundingyear;
        this.maxCapacitiyVisitors = maxCapacitiyVisitors;
        this.enclosureList = new Vector<>();
        this.keeperlist = new Vector<>();
    }

    public void addEnclosure(Enclosure enclosure) {
        if (enclosureList.contains(enclosure)) {
            return;
        }
        enclosureList.add(enclosure);
    }

    public void addKeeper(Zookeeper keeper) {
        if (keeperlist.contains(keeper)) {
            return;
        }
        keeperlist.add(keeper);
    }


    public void printZoo() {
        System.out.println(("┌──────────────────────────────────────────────────────────────────────"));
        System.out.println("├── " + Colors.COLORS[4] + name + Colors.RESET + " in " + Colors.COLORS[4] + location + " " + foundingyear + Colors.RESET + " maxCap:" + Colors.COLORS[4] + maxCapacitiyVisitors + Colors.RESET);
        for (Enclosure enc : enclosureList) {
            enc.printEnclosure();
        }
        System.out.println(("├──────────────────────────────────────────────────────────────────────"));
        for (Zookeeper keeper : keeperlist) {
            keeper.printKeeper();
        }
        System.out.println(("└──────────────────────────────────────────────────────────────────────"));

    }

    public void printFoodStats() {
        HashMap<Food, Double> foodRequiert = new HashMap<>();
        for (Enclosure enclosure : enclosureList) {
            enclosure.collectFood(foodRequiert);
        }
        System.out.println();
        double cost = 0;
        for (Food food : foodRequiert.keySet()) {
//        System.out.println(food.getName() + "==>" + foodRequiert.get(food) + " " + food.getUnit() + " / $ per Unit: " + food.getUnitPrice());
            System.out.println();
            System.out.printf("%-10s ==> %4s %5s / $ per Unit: %5d", food.getName(), foodRequiert.get(food), food.getUnit(), food.getUnitPrice());
            double amount = foodRequiert.get(food);
//            double price = food.getUnitPrice() * amount;
//            cost += price;
            cost += (food.getUnitPrice() * amount);
        }
        System.out.println("\n\nTotal costs for all Food requiered: " + cost + " $");
    }

    public void simulateDay(int day) {

        for (Enclosure enc : enclosureList) {
            if (day % 2 != 0) {
                enc.resetCleaningStatus();
            }
            enc.resetFeedingStatus();
        }
        for (Zookeeper keeper : keeperlist) {
            keeper.simulateDayKeeper(day);
        }
//        if (day % 7 == 0) {
//            System.out.println("\nThe Warzone opens at day " + day);
//            for (Enclosure enclosure : enclosureList) {
//                enclosure.simulateDayEnclosure(day);
//            }
//        }
    }

    @Override
    public String toString() {
        return "Zoo: " +
                "name = " + name +
                ", location = " + location +
                ", foundingyear = " + foundingyear +
                ", maxCapacitiyVisitors = " + maxCapacitiyVisitors;
    }

}

