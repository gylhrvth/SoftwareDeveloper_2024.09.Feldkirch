package Thiemo.week09.Zoo;

public class Food {
    private String name;
    private String unit;
    private int unitPrice;

    public Food(String name, String unit, int unitPrice) {
        this.name = name;
        this.unit = unit;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
}
