package Aylin.week01;

public class PrintChristmastree {
    public static void main(String[] args) {
        System.out.println("Print Christmastree");
        System.out.println();
        printChristmastree(13);
    }

    public static void printChristmastree(int count) {
        if (count % 2 == 0) {
            count--;
        }
        for (int row = 0; row < count; row++) {
            for (int p = 0; p < count - row - 1; p++) {
                System.out.print(".");
            }
            for (int stern = 0; stern < 2 * row + 1; stern++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int boden = 0; boden < count; boden++) {
            System.out.print("O ");
        }
        System.out.println();

        if(count < 5 && count > 2){
            System.out.println("  +");
        }else if(count < 3) {
            System.out.println("+");
        }else{
            for(int stamm = 0; stamm < count / 4; stamm++) {
                for (int j = 0; j < 3 * (count / 2); j++) {
                    if (j > count / 2) {
                        System.out.print("+");
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
