package Furkan.week09.Zoo;

import java.util.HashMap;

public class Tier {
    private String name;
    private String gattung;
    private Food food;
    private double amount;


    public Tier(String name, String gattung, Food food , int amount) {
        this.name = name;
        this.gattung = gattung;
        this.food = food;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getGattung() {
        return gattung;
    }

    public void simu(){
        System.out.println("Was macht das Tier--> " + name);
    }

    public void collectFoodRequirement(HashMap<Food,Double> foodRquiert){
        if (foodRquiert.containsKey(food)){
            foodRquiert.put(food,foodRquiert.get(food) + amount);
        }else {
            foodRquiert.put(food,amount);
        }
    }


}
