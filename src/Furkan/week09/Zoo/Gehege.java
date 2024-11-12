package Furkan.week09.Zoo;

import java.util.HashMap;
import java.util.Vector;

public class Gehege {
    private String name;
    private String info;
    private Vector<Tier> tierList;

    public Gehege(String name, String info) {
        this.name = name;
        this.info = info;
        this.tierList = new Vector<>();

    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public void addTier(Tier tier) {
        tierList.add(tier);
    }

    public void removeTier(Tier tier) {
        tierList.remove(tier);
    }


    public void printZoo() {
        System.out.println("│   ├──Gehege: " + name + ":" + info);
        for (Tier tier : tierList) {
            System.out.println("│       ├──" + tier.getName() + ", " + tier.getGattung());
        }
        if (tierList.isEmpty()) {
            System.out.println("│       ├── (leer)");
        }
    }

    public void simu() {
        System.out.println("Was passiert im Gehege -->" + name);
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
