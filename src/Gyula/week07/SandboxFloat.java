package Gyula.week07;

import java.text.NumberFormat;
import java.text.ParseException;

public class SandboxFloat {
    public static void main(String[] args) {
        int value = 10040;


        System.out.printf("Value: %.2f\n", value / 100.0f);

        NumberFormat nf = NumberFormat.getInstance();
        String text = "123,45";
        try {
            float f = nf.parse(text).floatValue();
            int value2 = Math.round(100 * f);
            System.out.printf("Value 2: %d\n", value2);
        } catch (ParseException pe){
            pe.printStackTrace();
        }
    }
}
