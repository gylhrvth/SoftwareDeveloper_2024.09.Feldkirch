package Akif_Malik.ZOO;

import Gyula.WildColors;
import Sandro.Colors;
import java.util.Vector;

public class Zoo {

    //------------Attributes---------------\\
    private String name;
    private int year;
    private Vector<Enclosure> gehegen;
    private Vector<Tiere> tiere;
    private Vector<Essen> foods;
    private Vector<ZooKeeper> zooKeepers;
    //---------------Constuctor---------------\\
    public Zoo(String name, int year) {
        this.name = name;
        this.year = year;
        this.gehegen = new Vector<>();
        this.tiere = new Vector<>();
        this.foods = new Vector<>();
        this.zooKeepers = new Vector<>(); }
    //---------------Functions---------------\\
    public void addGehege(Enclosure gehegeName) {
        gehegen.add(gehegeName);
    }
    public void addFoods(Essen foodName) {
        foods.add(foodName);
    }
    public void addTiere(Tiere tierName) {
        tiere.add(tierName);
    }
    public void addZooKeeper(ZooKeeper keeperName) {
        zooKeepers.add(keeperName);
    }
    //---------------big functions---------------\\
    public void printStructure() {
        String result = Colors.COLORS[2] + "\n├── Zoo: " + Colors.RESET + Colors.COLORS[4] + name + Colors.RESET +
                ", gegründet " + Colors.COLORS[5] + year + Colors.RESET + "\n";
        for (Enclosure gehege : gehegen) {
            result += "│    ├── Gehege: " + Colors.COLORS[1] + gehege.getName() + Colors.RESET + "\n";
            if (gehege.getAnimals().isEmpty()) {
                result += "│       ├── (leer)\n";
            } else {
                for (Tiere tier : gehege.getAnimals()) {
                    result += "│       ├── " + tier + "\n";
                }
            }
        }
        System.out.println(result);
    }

    public void simulateDay(int day) {
        System.out.println(WildColors.getColor("#4BDC8B") + "Day " + day + " starts..." + WildColors.resetColor());
        for (Enclosure enc : gehegen) {
            enc.resetProceeded();
        }
        for (ZooKeeper zk : zooKeepers) {
            zk.simulateDay();
        }
        for (Enclosure enc : gehegen) {
            enc.simulateFight();
        }
        System.out.println();
    }

    public ZooKeeper searchAndCreateZooKeeper(String name, String enclosureName, String favoriteSpecies) {
        ZooKeeper result = null;
        for (ZooKeeper zk : zooKeepers) {
            if (result == null && zk.getName().equals(name)) {
                result = zk;
            }
        }
        if (result == null) {
            result = new ZooKeeper(name, favoriteSpecies);
            zooKeepers.add(result);
        }
        Enclosure enc = searchAndCreateEnclosure(enclosureName);
        result.addTask(enc);
        return result;
    }

    public Enclosure searchAndCreateEnclosure(String name) {
        Enclosure result = null;
        for (Enclosure enc : gehegen) {
            if (result == null && enc.getName().equals(name)) {
                result = enc;
            }
        }
        if (result == null) {
            result = new Enclosure(name);
            gehegen.add(result);
        }
        return result;
    }

    public Tiere searchAndCreateAnimal(String enclosureName, String animalName, String species, String gender, int maxHealth, int attack) {
        Enclosure enc = searchAndCreateEnclosure(enclosureName);
        return enc.searchAndCreateAnimal(animalName, species, gender, maxHealth, attack);
    }

}
