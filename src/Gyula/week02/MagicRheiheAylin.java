package Gyula.week02;

public class MagicRheiheAylin {
    public static void main(String[] args) {
        System.out.println(magicRheihe());
        System.out.println(Math.sqrt(2));
    }

    public static double magicRheihe() {
        double wert = 1;
        for (int i = 0; i < 10; i++) {
            wert = wert / 2 + 1 / wert;
        }
        return wert;
    }
}
