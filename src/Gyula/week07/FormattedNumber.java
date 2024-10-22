package Gyula.week07;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public class FormattedNumber {
    public static void main(String[] args) {
        float value = 9912.25f;

        DecimalFormat df = new DecimalFormat("#.00€");

        String text = df.format(value);

        float value2 = 0f;
        try {
            value2 = df.parse(text).floatValue();
        } catch (ParseException pe){
            System.out.println("Falsche Formatierung");
        }
        System.out.println("Value: " + value);
        System.out.println(text);
        System.out.println("Value2: " + value2);
    }
}
