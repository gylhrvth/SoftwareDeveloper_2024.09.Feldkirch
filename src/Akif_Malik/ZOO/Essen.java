package Akif_Malik.ZOO;

public class Essen {

    private String food;

    private int amount;

    public Essen(String food) {
        this.food = food;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return food + "/Quantity: " + amount;
    }
}
