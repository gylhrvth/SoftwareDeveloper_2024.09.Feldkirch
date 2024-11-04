package Aylin.week08.Data;

public class DataClass {
    private int min;
    private int max;
    private double avrg;

    private DataClass(int min, int max, double avrg){
        this.min = min;
        this.max = max;
        this.avrg = avrg;
    }

    public static DataClass getMinMaxAvrg(int[] arr){
        DataClass dc  = new DataClass(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < dc.min){
                dc.min = arr[i];
            }
            if(arr[i] > dc.max){
                dc.max = arr[i];
            }
            sum += arr[i];
        }
        dc.avrg = (double)sum / arr.length;
        return dc;
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
