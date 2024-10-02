package Gyula;

public class WildColors {
    public static void main(String[] args) {
        for (int red = 0; red < 256; red += 8) {
            for (int green = 0; green < 256; green += 8) {
                for (int blue = 0; blue < 256; blue += 8) {
                    String color = getColor(red, green, blue);
                    System.out.printf("%s%s%s", color, "a", "\u001B[0m");
                }
            }
            System.out.println();
        }
    }

    public static String getColor(int red, int green, int blue){
        if (red >= 0 && red < 256 && green >= 0 && green < 256 && blue >= 0 && blue < 256){
            return String.format("\u001B[38;2;%d;%d;%dm", red, green, blue);
        } else {
            return "\u001B[0m";
        }
    }
}
