package Sandro.Week8.ZooTycoon;

import java.util.HashMap;
import java.util.Vector;

public class Zoo {

    private String name;
    private String place;
    private int foundingYear;
    //List
    private Vector<Enclosure> enclosureList;


    public Zoo(String name, String place, int foundingYear) {
        this.name = name;
        this.place = place;
        this.foundingYear = foundingYear;
        this.enclosureList = new Vector<>();
    }


    public void addEnclosure(Enclosure enc){
        //prüft ob das Gehege schon vorhanden, wenn icht wird .add ausgeführt
        if(!enclosureList.contains(enc)){
            enclosureList.add(enc);
        }
    }

    public Vector<Enclosure> getEnclosureList() {
        return enclosureList;
    }

    @Override
    public String toString() {

        return "*+- "+ name + ", " +place +" -+*" +"\n       since: "+foundingYear + "\n";
    }

    public void startSimu(){
        System.out.println("Simulation start ...");
        for (int i = 1; i < 14; i++) {
            System.out.println("Tag ("+i+")....");
            for(Enclosure enc : enclosureList){
                enc.simu();
            }

        }
    }




    public void printFoodCost (){
        //HashMap erstellen aka. Einkaufskorb
        //Food ist der Key der Map!!!
        HashMap<Food,Double> foodRequiert = new HashMap<>();
        //durch alle Gehege forEach, aufruf der Funktion vom Gehege


        for (Enclosure enclosure : enclosureList) {
            enclosure.collectFoodRequirement(foodRequiert);
        }
        System.out.println();



        //Berechnung mit der Hashmap von Food Cost
        System.out.println("Food requierment stats");
        //Variable für cost
        double cost = 0;
        //foreach Food in der Hashmap .keySet
        for (Food food : foodRequiert.keySet()) {
            //print für übersicht
            System.out.println(food.getName() + " ==> " + foodRequiert.get(food) + " " + food.getUnit() + " / $ per Unit: " + food.getUnitprice());
            //amount von der Hashmap für den aktellen KEY mit .get(welches Food)
            double amount = foodRequiert.get(food);
            //price berechenen mit den informationen, aktelles Food * der berechnete Amount
            double price = food.getUnitprice() * amount;
            //cost alle price Values zusammen rechenen
            cost += price;
        }
        System.out.println("Total costs for all Food requiered: " + cost + " $");

    }

    public void printZooStructure(){
        //print alle Attribute der klasse
        System.out.println("├── " + "*+- "+ name + ", " +place +" -+*" +  "     Since: " + foundingYear);
        //gibt es eine liste mit objekte gib dem job weiter in die dafür bestehende ObjektKlasse
        for (Enclosure enc : enclosureList){
            enc.printZooStructure();
        }
        System.out.println("├──────────────────────────────────────────────────────────────────────");

    }

}
