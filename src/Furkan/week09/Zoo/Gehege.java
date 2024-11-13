package Furkan.week09.Zoo;

import Sandro.Colors;

import java.util.HashMap;
import java.util.Vector;

public class Gehege {
    private String name;
    private Vector<Tier> tierList;

    public Gehege(String name) {
        this.name = name;

        this.tierList = new Vector<>();

    }

    public String getName() {
        return name;
    }



    public void addTier(Tier tier) {
        tierList.add(tier);
    }

    public Vector<Tier> getTierList(){
        return tierList;
    }


    public void printZoo() {
        System.out.println("│   ├──Gehege: " + name + ":" );
        for (Tier tier : tierList) {
            System.out.println("│       ├──" + tier.getName() + ", " + tier.getGattung());
        }
        if (tierList.isEmpty()) {
            System.out.println("│       ├── (leer)");
        }

    }

    public void simu() {
        System.out.println(Colors.COLORS[2] +"Was passiert im Gehege -->" + name + Colors.RESET);

        for (Tier tier : tierList) {
            tier.simu();
        }


    }

    public void collectFoodRequirement(HashMap<Food, Double> foodRequiert) {
        for (Tier tier : tierList) {
            tier.collectFoodRequirement(foodRequiert);
        }

    }


}
