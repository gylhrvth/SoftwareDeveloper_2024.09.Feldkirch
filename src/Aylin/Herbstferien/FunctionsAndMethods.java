package Aylin.Herbstferien;

public class FunctionsAndMethods {
    public static void main(String[] args) {
        System.out.println("========= Aufgabe 1.1 =========");
        countBackwards();
        System.out.println();
        System.out.println("========= Aufgabe 1.2 =========");
        modulo();
        System.out.println();
        System.out.println("========= Aufgabe 1.3 =========");
        whileLoop();
        System.out.println();
        System.out.println("========= Aufgabe 2.1 =========");
        stripple("x", 10);
        System.out.println();
        System.out.println("========= Aufgabe 2.2 =========");
        strippleL("a", 3);
    }

    public static void countBackwards(){
        for (int i = 10; i >= 0; i--){
            System.out.print(i + " ");
        }
    }

    public static void modulo() {
        for (int i = -30; i <= 30; i++){
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void whileLoop(){
        int number = 0;

        while(number <= 10){
            System.out.println(number);;
            if(number > 5){
                System.out.println();
                System.out.println();
            }
            number++;
        }
    }

    public static void stripple(String text, int count){
        for (int i = 0; i < count; i++) {
            System.out.print(text + " ");
        }
    }

    public static void strippleL(String text, int count){
        stripple(text, count);  //hab nicht herausgefunden wie ich es untereinander printe
    }
}
