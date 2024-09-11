package Gyula.week01;

public class BooleanExample {
    public static void main(String[] args) {
        boolean a = false;
        boolean b = true;

        int x = 4;
        int y = 5;
        boolean c = (x <= y);

        System.out.println("A: " + a + " B: " + b + " C: " + c);
        System.out.println("UND      / AND => A: " + a + " B: " + b + " a&&b " + (a && b));
        System.out.println("ODER     /  OR => A: " + a + " B: " + b + " a||b " + (a || b));
        System.out.println("UMDREHEN / NOT => A: " + a + " !a " + !a);
        System.out.println("UMDREHEN / NOT => B: " + b + " !b " + !b);

        functionWithBoolean(b);
        functionWithBoolean(!b);
    }

    public static void functionWithBoolean(boolean a){
        if (a){
            System.out.println("Aaaaaah!");
        } else {
            System.out.println("Kein Kommentar");
        }
    }
}
