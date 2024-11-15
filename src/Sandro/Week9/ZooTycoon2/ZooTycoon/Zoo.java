package Sandro.Week9.ZooTycoon2.ZooTycoon;



import Sandro.Colors;

import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

public class Zoo {
    private String name;
    private int year;
    private Vector<Enclosure> enclosureList;
    private Vector<ZooKeeper> zooKeeperList;
    private Vector<Vet> vetList;
    private int deathcount;

    public Zoo(String name, int year) {
        this.name = name;
        this.year = year;
        this.enclosureList = new Vector<>();
        this.zooKeeperList = new Vector<>();
        this.vetList = new Vector<>();
        this.deathcount = 0;
    }

    public void addVet(Vet vet) {
        if (!vetList.contains(vet)) {
            vetList.add(vet);
        }
    }

    public void addZooKeeper(ZooKeeper zooKeeper) {
        if (!zooKeeperList.contains(zooKeeper)) {
            zooKeeperList.add(zooKeeper);
        }
    }

    public void removeZooKeeper(ZooKeeper zooKeeper) {
        zooKeeperList.add(zooKeeper);
    }

    public Vector<ZooKeeper> getZooKeeperList() {
        return zooKeeperList;
    }

    public void addenc(Enclosure enclosure) {
        if (!enclosureList.contains(enclosure)) {
            enclosureList.add(enclosure);
        }
    }

    public void removeenc(Enclosure enclosure) {
        enclosureList.remove((enclosure));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void incremnetDeadAnimals (){
        ++deathcount;
    }
    public void printTaskprogression(int daysToSimulate) {
//        int count = 0;
//        for (int i = 0; i < zooKeeperList.size(); i++) {
//            zooKeeperList.get(i).printTaskprogression(count);
//            count ++;
//        }
//        for (int i = 0; i < zooKeeperList.size(); i++) {
//            zooKeeperList.get(i).printTaskprogression();
//        }


        for (int day = 1; day <= daysToSimulate; day++) {
            Colors.clearScreen();
            System.out.println("Start Tag " + day);
            System.out.println("*******************************************************************************");
            System.out.println("They fight and bite, and fight and bite, ... bite bite bite, fight fight fight! ");
            for (Enclosure enc : enclosureList) {
                enc.simulate();
            }

//            for (Enclosure enc:enclosureList) {
//                enc.vetTask();
//            }

            System.out.println("*******************************************************************************");
            System.out.println("Start Zookeeper-Task...");

            Vector<Enclosure> tasksForToday = new Vector<>();
            tasksForToday.addAll(enclosureList);
            Collections.shuffle(tasksForToday);

            Vector<ZooKeeper> zookeeperHasToWork = new Vector<>();
            zookeeperHasToWork.addAll(zooKeeperList);
            Collections.shuffle(zookeeperHasToWork);

            while (!tasksForToday.isEmpty() && !zookeeperHasToWork.isEmpty()) {
                for (int i = 0; i < zookeeperHasToWork.size(); i++) {
                    ZooKeeper zk = zookeeperHasToWork.get(i);

                    if (!zk.simulateDay(tasksForToday)) {
                        // zk is ready, remove from the list
                        System.out.println(zk.getName() + " goes Home");
                        zookeeperHasToWork.remove(i);
                        --i;
                    }
                }
            }
            if (!tasksForToday.isEmpty()) {
                System.out.println("ALARM !!! Animals didnt get fed");
                System.out.println(tasksForToday);
            }
            System.out.println("*******************************************************************************");
            System.out.println("Start Vet-Tasks ...");


            for (Vet vet : vetList) {
                vet.dailyRoutine(this);
            }
            System.out.println("*******************************************************************************");
            System.out.println("All daily Tasks are done TEST TEST TEST");
            int deathcount = 0;

            System.out.println("Tag " + day + " FINISH...\n\n");

            try {
                Thread.sleep(100);
            }catch (InterruptedException ie) {}
        }


    }


    Animal findlowestAnimal() {
        Animal overallLowest = null;
        for (Enclosure enc : enclosureList) {
            overallLowest = enc.findlowestAnimal(overallLowest);
        }
        return overallLowest;
    }

    Animal findOverallLowestAnimal() {
        Animal overallLowest = null;
        for (Enclosure enc : enclosureList) {
            Animal encLowest = enc.findLowestLifeAnimal();
            if (encLowest == null) {
                continue;
            }
            if (encLowest.getCurrentHealth() == encLowest.getMaxHealth()) {
                continue;
            }
            if (overallLowest == null) {
                overallLowest = encLowest;
            } else if (encLowest.getHealthprecent() < overallLowest.getHealthprecent()) {
                overallLowest = encLowest;
            }
//
//            if(encLowest != null && (overallLowest == null || encLowest.getHealthprecent() < overallLowest.getHealthprecent())){
//                overallLowest = encLowest;
//            }
        }
        return overallLowest;
    }

    public void printZoo() {
        System.out.println("├── " + "Zoo: " + name + " " + "Since: " + year);
        for (Enclosure enc : enclosureList) {
            enc.printZoo();
        }
        System.out.println("├──────────────────────────────────────────────────────────────────────");


    }

    public void printFoodCost() {
        HashMap<Food, Double> foodRequiert = new HashMap<>();

        for (Enclosure enclosure : enclosureList) {
            enclosure.collectFoodRequirement(foodRequiert);

        }
        System.out.println();
        System.out.println("Food requierment stats");
        double cost = 0;
        for (Food food : foodRequiert.keySet()) {
            System.out.println(food.getName() + " ==> " + foodRequiert.get(food) + " " + food.getUnit() + " / $ per Unit: " + food.getUnitprice());
            double amount = foodRequiert.get(food);
            double price = food.getUnitprice() * amount;

            cost += price;
        }
        System.out.println("Total costs for all Food requiered: " + cost + " $");
    }
}
