package Thiemo.week06;

public class DatenTabellarisch {

        public static void main(String[] args) {

            String[] firstName = {"Alfonso", "Beatrix-Eleonor", "Cecil", "Daniel", "Elmar"};
            String[] lastName = {"Klein", "Kinderdorfer", "Al Elmenar", "Schmidt", "Simma"};
            int[] age = {40, 78, 5, 18, 81};
            String[] place = {"Wien", "Schwarzach in Vorarlberg nördlich von Dornbirn", "Wiener Neudorf", "Sankt Pölten", "Sankt Pölten"};
            float[] distanceFromCapital = {0f, 654.4f, 12.457634366f, 120.0f, 119.9999f};


            printFormat(firstName, lastName, age, place, distanceFromCapital);


        }

        public static void printFormat(String[] firstName, String[] lastName, int[] age, String[] place, float[] distanceFromCapital) {

            int agesize = formatIntSize(age);
            int firstNameSize = formatStringSize(firstName);
            int lastNameSize = formatStringSize(lastName);
            int placeSize = formatStringSize(place);
            int distanceSize = formatFloatSize(distanceFromCapital);
            System.out.println("╔═"+ "═".repeat(firstNameSize)+"═╦═"+ "═".repeat(lastNameSize)+"═╦═"+ "═".repeat(agesize)+"═╦═"+ "═".repeat(placeSize)+"═╦═"+ "═".repeat(distanceSize)+"═╗");
            for (int i = 0; i < firstName.length; i++) {
                System.out.printf("║ %-" + firstNameSize + "s ║ %-" + lastNameSize + "s ║ %" + agesize + "d ║ %-" + placeSize + "s ║ %" + distanceSize + ".2f ║", firstName[i], lastName[i], age[i], place[i], distanceFromCapital[i]);
                System.out.println();
                if (i < firstName.length - 1) {
                    System.out.println("╠═"+ "═".repeat(firstNameSize)+"═╬═"+ "═".repeat(lastNameSize)+"═╬═"+ "═".repeat(agesize)+"═╬═"+ "═".repeat(placeSize)+"═╬═"+ "═".repeat(distanceSize)+"═╣");
                }
                if (i == firstName.length - 1) {
                    System.out.println("╚═"+ "═".repeat(firstNameSize)+"═╩═" + "═".repeat(lastNameSize)+"═╩═"+ "═".repeat(agesize)+"═╩═"+ "═".repeat(placeSize)+"═╩═"+ "═".repeat(distanceSize)+"═╝");
                }
            }
        }

        public static int formatIntSize(int[] age) {
            int result = 0;
            for (int i = 0; i < age.length; i++) {
                String text = String.valueOf(age[i]);
                if (result < text.length()) {
                    result = text.length();
                }
            }
            return result;
        }

        public static int formatStringSize(String[] count) {
            int result = 0;
            for (int i = 0; i < count.length; i++) {
                if (result < count[i].length()) {
                    result = count[i].length();
                }
            }
            return result;
        }

        public static int formatFloatSize(float[] distanceFromCapital) {
            int result = 0;
            for (int i = 0; i < distanceFromCapital.length; i++) {
                String text = String.format("%.2f", distanceFromCapital[i]);
                if (result < text.length()) {
                    result = text.length();
                }
            }
            return result;
        }
    }


