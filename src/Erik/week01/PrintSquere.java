package Erik.week01;

public class PrintSquere {
    public static void main(String[] args) {
        // printChars("X", 10);
        printSquere("X ", 4);
    }

    public static void printChars(String text, int count){
        for (int i = 0; i < count; i++) {
            System.out.print(text);
        }
        System.out.println();
    }

    public static void printSquere(String text, int count){
        for (int row = 0; row < count; row++) {
            for (int column = 0; column < count; column++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }
}
