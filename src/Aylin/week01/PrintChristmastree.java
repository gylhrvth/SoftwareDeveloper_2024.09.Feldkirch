package Aylin.week01;

public class PrintChristmastree {
    public static void main(String[] args) {
        System.out.println("Print Christmastree");
        System.out.println();
        printChristmastree(7);
        System.out.println();
    }

    public static void printChristmastree(int count) {
        if (count % 2 == 0) {
            count--;
        }
        String greenStar = "\u001B[32m*\u001B[0m";
        String brownStamm = "\u001B[33m+\u001B[0m";

        for (int row = 0; row < count; row++) {
            for (int punkt = 0; punkt < count - row - 1; punkt++) {
                System.out.print(".");
            }
            for (int stern = 0; stern < 2 * row + 1; stern++) {
                System.out.print(greenStar);
            }
            System.out.println();
        }
        for (int boden = 0; boden < count; boden++) {
            System.out.print("O ");
        }
        System.out.println();

        if(count < 5 && count > 2){
            System.out.println("  " + brownStamm);
        }else if(count < 3) {
            System.out.println(brownStamm);
        }else{
            for(int stammHöhe = 0; stammHöhe < count / 4; stammHöhe++) {
                for (int stammBreite = 0; stammBreite < 3 * (count / 2); stammBreite++) {
                    if (stammBreite > count / 2) {
                        System.out.print(brownStamm);
                    } else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
