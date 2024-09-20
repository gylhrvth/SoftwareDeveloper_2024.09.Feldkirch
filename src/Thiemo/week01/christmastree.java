package Thiemo.week01;

public class christmastree {
    public static void main(String[] args) {
        System.out.println();
        christmastree(10);
        System.out.println();

    }

    public static void christmastree(int count) {

        String leafes = "\u001B[32m*\u001B[0m";
        String trunk = "\u001B[33m+\u001B[0m";

        for (int rowleafes = 0; rowleafes < count; rowleafes++) {
            for (int spacebar = 0; spacebar < count - rowleafes - 1; spacebar++) {
                System.out.print(".");
            }
            for (int columnleafes = 0; columnleafes <= 2 * rowleafes; ++columnleafes) {
                System.out.print(leafes);
            }
            System.out.println();
        }
        for (int balls = 0; balls < count; balls++) {
            System.out.print("O ");
        }
        System.out.println();

        for (int rowTrunk = 0; rowTrunk < count / 3 - 1; rowTrunk++) {
            for (int spacebar = 0; spacebar < count / 3; ++spacebar) {
                System.out.print(". ");
            }

                for (int columnTrunk = 0; columnTrunk < count / 2 ;  columnTrunk++) {

                    System.out.print(trunk);
                }

                System.out.println();
            }
        }
    }

