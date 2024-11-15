package Sandro.Week9.ZooTycoon2.ZooTycoon;

import Sandro.Colors;

public class Food {
    private String name;
    private String unit;
    private double unitprice;


    public Food(String name, String unit, double unitprice) {
        this.name = Colors.COLORS[7]+ name +Colors.RESET;
        this.unit = unit;
        this.unitprice = unitprice;
    }

    public String getName() {
        return name;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public String getUnit() {
        return unit;
    }
}
