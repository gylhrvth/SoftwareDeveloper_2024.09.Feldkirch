package Aylin.week08.Vector;

public class DataClass {
    private int min;
    private int max;
    private double avrg;

    public DataClass(int min, int max, double avrg){
        this.min = min;
        this.max = max;
        this.avrg = avrg;
    }



    public int getMin(){
        return min;
    }

    public int getMax(){
        return max;
    }

    public double getAvrg(){
        return avrg;
    }

    @Override
    public String toString() {
        return "Smalest Element: " + min + "biggest Element: " + max + "Average: " + avrg + ".";
    }
}
