package Furkan.week09.Zoo;

import Sandro.Colors;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class Gehege {
    private static  Random random = new Random();
    private String name;
    private Vector<Tier> tierList;
    private boolean hasProcessed;

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

        Random random = new Random();
        int eventChance = random.nextInt(50);

        if (eventChance<10){
            System.out.println(Colors.COLORS[2] + "Achtung! Ein Tier im Gehege " + name + " zeigt ein besonderes Verhalten!" + Colors.RESET);
        }

        for (Tier tier : tierList) {
            tier.simu();
        }


    }

    public void simulateFight(){
        System.out.println("Es gibt eine auseinandersetzung in " + this);
        for (Tier tier: tierList){
            Vector<Tier> possibleVictims = new Vector<>();
            for (Tier tierTest : tierList){
                if (!tier.getGattung().equals(tierTest.getGattung())){
                    possibleVictims.add(tierTest);
                }
            }
            if (!possibleVictims.isEmpty()){
                Tier victim = possibleVictims.get(random.nextInt(possibleVictims.size()));
                tier.simulateFight(victim);
            }

        }
        removeDeadAnimals();
    }

    public void removeDeadAnimals(){
        for (int i = 0; i < tierList.size(); i++) {
            if (!tierList.get(i).isAlive()){
                System.out.println(tierList.get(i) + " wurde entfernt von " + this + " .");
                tierList.remove(i);
                --i;
            }

        }
    }



    public void collectFoodRequirement(HashMap<Food, Double> foodRequiert) {
        for (Tier tier : tierList) {
            tier.collectFoodRequirement(foodRequiert);
        }

    }


    @Override
    public String toString(){
        return name;
    }


}
