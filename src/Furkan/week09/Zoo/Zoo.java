package Furkan.week09.Zoo;

import java.util.HashMap;
import java.util.Vector;

public class Zoo {
    private String name;
    private int year;
    private Vector<Gehege> gehegeListe;
    private Vector<ZooPfleger> pflegerListe;


    public Zoo(String name, int year) {
        this.name = name;
        this.year = year;
        this.gehegeListe = new Vector<>();
        this.pflegerListe = new Vector<>();
    }

    public void addGehege(Gehege gehege) {
        this.gehegeListe.add(gehege);
    }

    public void removeGehege(Gehege gehege) {
        this.gehegeListe.remove(gehege);
    }


    public void printZoo() {
        System.out.println("├──" + name + ", gegründet " + year);
        for (Gehege gehege : gehegeListe){
            gehege.printZoo();
        }
    }

    public void startSimu(){
        System.out.println("Simulation start ... ");
        for (int i = 0; i < 14; i++) {
            System.out.println("Tag (" +i+ ") ....");
            for (Gehege gehege : gehegeListe){
                gehege.simu();
            }
        }

    }

    public void printFoodCost(){
        HashMap<Food,Double> foodRequiert = new HashMap<>();

        for (Gehege gehege : gehegeListe){
            gehege.collectFoodRequirement(foodRequiert);
        }
        System.out.println();

        System.out.println("Food requirement stats");
        double cost = 0;
        for (Food food : foodRequiert.keySet()){
            System.out.println(food.getName() + " ==> " + foodRequiert.get(food) + " " + food.getUnit()+ " / $ per Unit: " + food.getUnitprice());
            double amount = foodRequiert.get(food);
            double price = food.getUnitprice() * amount;
            cost+= price;
        }
        System.out.println("Total costs for all Food requiered: " + cost + " $");

    }

    public void addPfleger(ZooPfleger zooPfleger){
        pflegerListe.add(zooPfleger);

    }



}
