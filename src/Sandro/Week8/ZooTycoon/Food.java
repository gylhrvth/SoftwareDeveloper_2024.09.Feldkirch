package Sandro.Week8.ZooTycoon;

public class Food {
    private String name;
    private String unit;
    private double unitprice;

    public Food(String name, String unit, double unitprice) {
        this.name = name;
        this.unit = unit;
        this.unitprice = unitprice;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }
}
