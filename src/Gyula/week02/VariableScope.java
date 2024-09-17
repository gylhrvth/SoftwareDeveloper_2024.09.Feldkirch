package Gyula.week02;

public class VariableScope {
    public static int globalVariableA = 3;

    public static void main(String[] args) {
        int a = 5;
        // int a = 6;      <== Nicht erlaubt
        a = 6; // Assign a new value


        if (a < 5){
            // System.out.println(b);       <== vor der Definition ist b nicht vorhanden.
            int b = 3;
        } else {
            int b = 4;
            System.out.println(b);
        }
        // System.out.println(b);       <== b ist nicht definiert

        myMagicFunction(5);
        // System.out.println(parameter); <== parameter hat nur in myMagicFunction eine Bedeutung
        System.out.println(globalVariableA); // Hier ist eine globale Variable

        for (int i = 0; i < 5; i++) {
            System.out.print("A");
        }
        // System.out.println(i);        <== i's Scope ist aus, hier hat i keine Bedeutung mehr
        for (long i = 0; i < 3; i++) {
            System.out.print("B");
            // for (int i = 0; i < 3; i++) {}  <== i ist mal definiert, kann ich nicht noch mal anlegen
        }
        System.out.println();
    }


    public static void myMagicFunction(int parameter){
        System.out.println(parameter);
        System.out.println(globalVariableA);
        globalVariableA *= 2;
    }
}
