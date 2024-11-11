package Aylin.week08.Zoo;

public class Food {
    private String name;
    private String unit;
    private double price;

    public Food(String name, String unit, double price){
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getUnit(){
        return unit;
    }

    public double getPrice(){
        return price;
    }
}
