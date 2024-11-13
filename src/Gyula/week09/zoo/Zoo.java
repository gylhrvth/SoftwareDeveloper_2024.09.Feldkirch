package Gyula.week09.zoo;

import java.util.Vector;

public class Zoo {
    private String name;
    private int establishedYear;
    private Vector<Enclosure> enclosureList;
    private Vector<ZooKeeper> zookKeeperList;

    public Zoo(String name, int establishedYear){
        this.name = name;
        this.establishedYear = establishedYear;
        this.enclosureList = new Vector<>();
        this.zookKeeperList = new Vector<>();
    }

    public Enclosure searchAndCreateEnclosure(String name){
        Enclosure result = null;
        for (Enclosure enc : enclosureList){
            if (result == null && enc.getName().equals(name)){
                result = enc;
            }
        }
        if (result == null){
            result = new Enclosure(name);
            enclosureList.add(result);
        }
        return result;
    }

    public Animal searchAndCreateAnimal(String enclosureName, String animalName, String species, String gender, int maxHealth, int attack){
        Enclosure enc = searchAndCreateEnclosure(enclosureName);
        return enc.searchAndCreateAnimal(animalName, species, gender, maxHealth, attack);
    }

    public ZooKeeper searchAndCreateZooKeeper(String name, String enclosureName, String favoriteSpecies){
        ZooKeeper result = null;
        for (ZooKeeper zk : zookKeeperList){
            if (result == null && zk.getName().equals(name)){
                result = zk;
            }
        }
        if (result == null){
            result = new ZooKeeper(name, favoriteSpecies);
            zookKeeperList.add(result);
        }
        Enclosure enc = searchAndCreateEnclosure(enclosureName);
        result.addTask(enc);
        return result;
    }


    public void printStructure(){
        System.out.printf("Zoo: %s (gegründet: %d)\n", name, establishedYear);
        System.out.println("Zoo keepers:");
        for (ZooKeeper zk: zookKeeperList){
            zk.printStructure();
        }
        System.out.println("Enclosures:");
        for (Enclosure enc : enclosureList){
            enc.printStructure();
        }
    }


    public void simulateDay(int day){
        System.out.println("Day " + day + " starts...");
        for (Enclosure enc: enclosureList){
            enc.resetProceeded();
        }
        for (ZooKeeper zk: zookKeeperList){
            zk.simulateDay();
        }
        for (Enclosure enc: enclosureList){
            enc.simulateFight();
        }

        System.out.println();
        printStructure();
    }
}
