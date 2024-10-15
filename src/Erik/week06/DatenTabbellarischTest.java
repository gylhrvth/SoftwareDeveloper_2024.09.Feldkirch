package Erik.week06;

public class DatenTabbellarischTest {
    public static void main(String[] args) {

        String[] firstName = {"Alfonso", "Beatrix-Eleonor", "Cecil", "Daniel", "Elmar"};
        String[] lastName = {"Klein", "Kinderdorfer", "Al Elmenar", "Schmidt", "Simma"};
        int[] age = {40, 78, 5, 18, 81};
        String[] place = {"Wien", "Schwarzach in Vorarlberg nördlich von Dornbirn", "Wiener Neudorf", "Sankt Pölten", "Sankt Pölten"};
        float[] distanceFromCapital = {0f, 654.4f, 12.457634366f, 120.0f, 119.9999f};

        printFormat(firstName, lastName, age, place, distanceFromCapital);
    }

    public static void printFormat(String[] firstName, String[] lastName, int[] age, String[] place, float[] distanceFromCapital) {

        String[] headLine = new String[]{"First Name", "Last Name", "Age", "Place", "Distance from Capital"};
        int ageSize = formatIntSize(headLine[2], age);
        int firstNameSize = formatStringSize(headLine[0], firstName);
        int lastNameSize = formatStringSize(headLine[1], lastName);
        int placeSize = formatStringSize(headLine[3], place);
        int distanceSize = formatFloatSize(headLine[4], distanceFromCapital);

        // Kopfzeile
        System.out.println("╔═" + "═".repeat(firstNameSize) + "═╦═" + "═".repeat(lastNameSize) + "═╦═" + "═".repeat(ageSize) + "═╦═" + "═".repeat(placeSize) + "═╦═" + "═".repeat(distanceSize) + "═╗");
        System.out.printf("║ %-" + firstNameSize + "s ║ %-" + lastNameSize + "s ║ %" + ageSize + "s ║ %-" + placeSize + "s ║ %" + distanceSize + "s ║" + "\n", headLine[0], headLine[1], headLine[2], headLine[3], headLine[4]);
        System.out.println("╚═" + "═".repeat(firstNameSize) + "═╩═" + "═".repeat(lastNameSize) + "═╩═" + "═".repeat(ageSize) + "═╩═" + "═".repeat(placeSize) + "═╩═" + "═".repeat(distanceSize) + "═╝");

        // Tabelle
        System.out.println("╔═" + "═".repeat(firstNameSize) + "═╦═" + "═".repeat(lastNameSize) + "═╦═" + "═".repeat(ageSize) + "═╦═" + "═".repeat(placeSize) + "═╦═" + "═".repeat(distanceSize) + "═╗");
        for (int i = 0; i < firstName.length; i++) {
            System.out.printf("║ %-" + firstNameSize + "s ║ %-" + lastNameSize + "s ║ %" + ageSize + "d ║ %-" + placeSize + "s ║ %" + distanceSize + ".4f ║", firstName[i], lastName[i], age[i], place[i], distanceFromCapital[i]);
            System.out.println();
            if (i < firstName.length - 1) {
                System.out.println("╠═" + "═".repeat(firstNameSize) + "═╬═" + "═".repeat(lastNameSize) + "═╬═" + "═".repeat(ageSize) + "═╬═" + "═".repeat(placeSize) + "═╬═" + "═".repeat(distanceSize) + "═╣");
            }
            if (i == firstName.length - 1) {
                System.out.println("╚═" + "═".repeat(firstNameSize) + "═╩═" + "═".repeat(lastNameSize) + "═╩═" + "═".repeat(ageSize) + "═╩═" + "═".repeat(placeSize) + "═╩═" + "═".repeat(distanceSize) + "═╝");
            }
        }
    }

    public static int formatIntSize(String headTitel, int[] ages) {
        int result = headTitel.length();
        for (int i = 0; i < ages.length; i++) {
            String text = String.valueOf(ages[i]);
            if (result < text.length()) {
                result = text.length();
            }
        }
        return result;
    } // String headTitel kommt zum einsatz, um es Dynamisch zu machen

    public static int formatStringSize(String headTitel,String[] count) {
        int result = headTitel.length();
        for (int i = 0; i < count.length; i++) {
            if (result < count[i].length()) {
                result = count[i].length();
            }
        }
        return result;
    }

    public static int formatFloatSize(String headTitel, float[] distanceFromCapital) {
        int result = headTitel.length();
        for (int i = 0; i < distanceFromCapital.length; i++) {
            String text = String.format("%.2f", distanceFromCapital[i]);
            if (result < text.length()) {
                result = text.length();
            }
        }
        return result;
    }
}