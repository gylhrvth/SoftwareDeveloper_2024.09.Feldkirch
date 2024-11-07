package Sandro.Week8.Person2;

public class MinMaxAvg {

    private int min;
    private int max;
    private double avg;


    public MinMaxAvg() {
    }

    public int getMax() {
        return max;
    }
    public int getMin() {
        return min;
    }
    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "MinMaxAvg{" +
                "min=" + min +
                ", max=" + max +
                ", avg=" + avg +
                '}';
    }
}
