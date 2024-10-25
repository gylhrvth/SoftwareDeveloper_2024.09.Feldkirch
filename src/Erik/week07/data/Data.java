package Erik.week07.data;

public class Data {

    // Attribute
    private int minValue;
    private int maxValue;
    private int averageValue;


    // Konstruktor
    public Data() {
        this.minValue = 0;
        this.maxValue = 0;
        this.averageValue = 0;
    }

    @Override
    public String toString() {
        return " ";
    }

    public static int[] giveMinValueFromArray(int[] minArray) {
        int minValue = minArray[0];

        for (int i = 0; i < minArray.length; i++) {
            if (minArray[i] < minValue) {
                minValue = minArray[i];
            }
        }
        return minArray;
    }


}
