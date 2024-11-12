package Furkan.week09.Zoo;

import Sandro.Colors;

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
        for (Gehege gehege : gehegeListe) {
            gehege.printZoo();
        }
        System.out.println("-".repeat(80));
    }

    public void startSimu(int days) {
        System.out.println("Simulation start für " + days + " Tage...");
        for (int i = 1; i <= days; i++) {
            System.out.println(Colors.COLORS[3] + "Tag (" + i + ") beginnt:" + Colors.RESET);
            for (ZooPfleger zooPfleger : pflegerListe) {
                zooPfleger.workOnGehege();
            }
            System.out.println();
        }

    }

    public void printFoodCost() {
        HashMap<Food, Double> foodRequiert = new HashMap<>();

        for (Gehege gehege : gehegeListe) {
            gehege.collectFoodRequirement(foodRequiert);
        }
        System.out.println();

        System.out.println("Food requirement stats");
        double cost = 0;
        for (Food food : foodRequiert.keySet()) {
            System.out.println(Colors.COLORS[5] + food.getName() + " ==> " + foodRequiert.get(food) + " " + food.getUnit() + " / $ per Unit: " + food.getUnitprice() + Colors.RESET);
            double amount = foodRequiert.get(food);
            double price = food.getUnitprice() * amount;
            cost += price;
        }
        System.out.println(Colors.COLORS[5] + "Total costs for all Food requiered: " + cost + " $" + Colors.RESET);
    }

//    public Gehege seatchAndCreateGehege(String name){
//        Gehege result = null;
//        for (Gehege gehege : gehegeListe){
//            if (result == null && gehege.getName().equals(name)){
//                result = gehege;
//            }
//        }
//        if (result == null){
//            result = new Gehege(name);
//            gehegeListe.add(result);
//        }
//        return result;
//    }


    public void searchAndCreateZooKeeper(String name, String gehegeName) {
        ZooPfleger pfleger = new ZooPfleger(name);
        for (Gehege gehege : gehegeListe) {
            if (gehege.getName().equals(gehegeName)) {
                pfleger.addTask(gehege);
            }
        }
        pflegerListe.add(pfleger);
    }


}
//        ZooPfleger result = null;
//        for (ZooPfleger zooPfleger : pflegerListe) {
//            if (result == null && zooPfleger.getName().equals(name)) {
//                result = zooPfleger;
//            }
//        }
//        if (result == null) {
//            result = new ZooPfleger(name);
//            pflegerListe.add(result);
//
//        }
//
//
//        return result;
//    }

