package Aylin.week08.Zoo;

import Sandro.Colors;
import java.util.HashMap;
import java.util.Vector;

public class Zoo {
    private String name;
    private int establishment;
    // List of enclosures and zookeepers
    private Vector<Enclosure> enclosureList;
    private Vector<Zookeeper> zookeeperList;

    public Zoo(String name, int establishment) {
        this.name = Colors.COLORS[5] + name + Colors.RESET;
        this.establishment = establishment;
        this.enclosureList = new Vector<>();
        this.zookeeperList = new Vector<>();
    }

    @Override
    public String toString() {
        return name + ", " + Colors.COLORS[4] + establishment + Colors.RESET;
    }

    // Prints the structure of the zoo
    public void printZooStructure() {
        System.out.println("├── " + name + ", " + Colors.COLORS[4] + establishment + Colors.RESET);
        for (Enclosure enc : enclosureList) {
            enc.printEnclosure();
        }
    }

    // Adds an enclosure to the zoo
    public void addEnclosure(Enclosure enclosure) {
        if (!enclosureList.contains(enclosure)) {
            enclosureList.add(enclosure);
        }
    }

    // Calculates and prints the total food cost for the zoo
    public void printFoodCost() {
        System.out.println();
        System.out.println(Colors.COLORS[4] + "***********************************************" + Colors.RESET);
        HashMap<Food, Double> foodRequired = new HashMap<>();
        for (Enclosure enc : enclosureList) {
            enc.collectFoodRequirement(foodRequired);
        }

        // Calculate food costs
        double cost = 0;
        for (Food food : foodRequired.keySet()) {
            double amount = foodRequired.get(food);
            cost += (food.getPrice() * amount);
            System.out.printf(Colors.COLORS[4] + "*" + Colors.RESET + " %-12s : %3.0f %s / € per Unit: %4.0f €" + Colors.COLORS[4] + "  *\n" + Colors.RESET,
                    food.getName(), amount, food.getUnit(), food.getPrice());
        }
        System.out.printf(Colors.COLORS[4] + "*" + Colors.RESET + " Total costs for all required food: %5.0f €" + Colors.COLORS[4] + "  *\n" + Colors.RESET, cost);
        System.out.println(Colors.COLORS[4] + "***********************************************" + Colors.RESET);
    }

    // Starts the simulation for 10 days
    public void startSimu() {
        for (int day = 1; day <= 100; day++) {
            System.out.println(Colors.COLORS[6] + "|- Tag " + day + " im Zoo. -|" + Colors.RESET);
            for (Enclosure enc : enclosureList){
                enc.resetProcess();
            }
            for (Zookeeper zk : zookeeperList) {
                zk.performDailyTask();
            }
            System.out.println();
        }
    }

    // Adds a zookeeper to the zoo
    public void addZookeeper(Zookeeper zookeeper) {
        if (!zookeeperList.contains(zookeeper)) {
            zookeeperList.add(zookeeper);
        }
    }
}