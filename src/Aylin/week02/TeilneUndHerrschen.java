package Aylin.week02;

public class TeilneUndHerrschen {
    public static void main(String[] args) {
        double withDecimal = 5.0;
        int withoutDecimal = 5;
        int start = 0;
        int ende = 20;

        for (int i = start; i <= ende ; i++) {
            System.out.println(i + " / " + withoutDecimal + " = " + (i / withoutDecimal));
            System.out.println(i + " / " + withDecimal + " = " + i / withDecimal);
        }

        for (int i = start; i <= ende ; i++) {
            System.out.println(i + " / 5 = " + (i / 5));
            System.out.println(i + " / 5.0 = " + i / 5.0);
        }
    }
}
