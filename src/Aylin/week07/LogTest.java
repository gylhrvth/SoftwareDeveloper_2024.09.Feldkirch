package Aylin.week07;

public class LogTest {
    public static void main(String[] args) {
        // Bsp. für die Logger Klasse
        for (int i = 0; i < 2000; i++) {
            Logger.log(Logger.ERROR, "Hallo World! ".repeat(20));
        }
    }
}
