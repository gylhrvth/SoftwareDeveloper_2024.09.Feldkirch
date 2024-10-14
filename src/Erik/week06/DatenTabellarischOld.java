package Erik.week06;
/*
        Todo:   1. Finde welche Formatierungen benötigt werden %f %d %s
                2. Print Methode erstellen
 */
public class DatenTabellarischOld {
    public static void main(String[] args) {

        String[] firstName = {"Alfonso", "Beatrix-Eleonor", "Cecil", "Daniel", "Elmar"};
        String[] lastName = {"Klein", "Kinderdorfer", "Al Elmenar", "Schmidt", "Simma"};
        int[] age = {40, 78, 5, 18, 81};
        String[] place = {"Wien", "Schwarzach in Vorarlberg nördlich von Dornbirn", "Wiener Neudorf", "Sankt Pölten", "Sankt Pölten"};
        float[] distanceFromCapital = {0f, 654.4f, 12.457634366f, 120.0f, 119.9999f};

        printFormat(firstName, lastName, age, place, distanceFromCapital);
    }

    public static void printFormat(String[] firstName, String[] lastName, int[] age, String[] place, float[] distanceFromCapital) {
        System.out.println("╔════════════════════╦═══════════════════╦══════════╦════════════════════╦════════════╗");
        for (int i = 0; i < firstName.length; i++) {
            System.out.printf("║   %-17s║   %-16s║   %6d ║  %-18s║%10.4f  ║", firstName[i], lastName[i], age[i], place[i], distanceFromCapital[i]);
            System.out.println();
            if (i < firstName.length - 1) {
                System.out.println("╠════════════════════╬═══════════════════╬══════════╬════════════════════╬════════════╣");
            }
            if (i == firstName.length - 1) {
                System.out.println("╚════════════════════╩═══════════════════╩══════════╩════════════════════╩════════════╝");
            }
        }
    }
}
