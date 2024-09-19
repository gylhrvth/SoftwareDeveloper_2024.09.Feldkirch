package Aylin.week01;

public class PrintChristmastree {
    public static void main(String[] args) {
        System.out.println("Print Christmastree");
        System.out.println();
        printChristmastree(8);
    }

    public static void printChristmastree(int count) {
        if (count % 2 == 0) {
            count--;
        }
        String greenStar = "\u001B[32m*\u001B[0m";
        String brownStamm = "\u001B[33m+\u001B[0m";

        for (int row = 0; row < count; row++) {
            for (int dot = 0; dot < count - row - 1; dot++) {
                System.out.print(" ");
            }
            for (int star = 0; star < 2 * row + 1; star++) {
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
        }else if(count < 3 && count >= 0) {
            System.out.println(brownStamm);
        }else{
            for(int stammHöhe = 0; stammHöhe < count / 4; stammHöhe++) {
                for (int stammBreite = 0; stammBreite < 3 * (count / 2); stammBreite++) {
                    if (stammBreite > count / 2) {
                        System.out.print(brownStamm);
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
