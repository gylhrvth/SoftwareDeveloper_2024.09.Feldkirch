package Thiemo.week09.Zoo;

import Sandro.Colors;

import java.util.Vector;

public class Zoo {
    private String name;
    private String location;
    private int foundingyear;
    private int size;
    private int maxCapacitiyVisitors;
    private Vector<Enclosure> enclosureList;

    public Zoo(String name, String location, int foundingyear, int size, int maxCapacitiyVisitors) {
        this.name = name;
        this.location = location;
        this.foundingyear = foundingyear;
        this.size = size;
        this.maxCapacitiyVisitors = maxCapacitiyVisitors;
        this.enclosureList = new Vector<>();
    }

    public void addEnclosure(Enclosure enclosure) {
        if (enclosureList.contains(enclosure)) {
            return;
        }
        enclosureList.add(enclosure);
    }

    public void printZoo() {
        System.out.println("├── "+Colors.COLORS[4]+  name +Colors.RESET+ " in " +Colors.COLORS[4]+ location + " " + foundingyear +Colors.RESET+ " ("+Colors.COLORS[4] + size + "km2"+Colors.RESET+") maxCap:" +Colors.COLORS[4]+ maxCapacitiyVisitors+Colors.RESET);
        for (Enclosure enc : enclosureList) {
            enc.printEnclosure();
        }
    }



    @Override
    public String toString() {
        return "Zoo: " +
                "name = " + name +
                ", location = " + location +
                ", foundingyear = " + foundingyear +
                ", size = " + size + "km2" +
                ", maxCapacitiyVisitors = " + maxCapacitiyVisitors;
    }

}

