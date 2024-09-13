package Thiemo.week01;

public class christmastree3 {

    public static void main(String[] args) {
        System.out.println();
        christmastree(30);
        System.out.println();
    }

    public static void christmastree(int count) {
        if (count % 2 == 0) {
            count++;
        }

        for (int rowBaum = 0; rowBaum < count; rowBaum++) {
            for (int spacebar = 0; spacebar < count - rowBaum - 1; spacebar++) {
                System.out.print(" ");
            }
            for (int column = 0; column <= 2 * rowBaum; ++column) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int rowEnd = 0; rowEnd < count; rowEnd++) {
            System.out.print("O ");
        }
        System.out.println();

        int zeileStamm = count / 3 - 1;
        int spacebar = (count * 2) / 3;
        int spalteStamm = (count * 2) / 3 - 1;

        if (count <=3) {
            printtext(".", count - 1);
            printLn("+" , 1);

        }else if (count <=5){
            printtext(".", 3);
            printLn("+" , 3);
        }
        else {
            for (int i = 0; i < zeileStamm; i++) {
                printtext(" ", spacebar);
                printLn("+", spalteStamm);

            }

        }


//       for (int zeileStamm = 0; zeileStamm < count / 3; zeileStamm++) {
//           for (int spacebar = 0; spacebar < count / 3 + 1; ++spacebar) {
//                if (zeileStamm < (count) / 3 - 1) {
//                    System.out.print("+");
//                } else
//                    System.out.print(". ");
//
//            }
//
//        for (int rowTrunk = 0; rowTrunk < count / 3 - 1 ; rowTrunk++) {
//            for (int spacebar = 0; spacebar <  count / 3 + 1 ; ++spacebar) {
//                System.out.print(". ");
//            }
//
//            for (int columnTrunk = 0; columnTrunk  < (count*2 ) / 3  - 1;  columnTrunk++) {
//
//                System.out.print("+");
//            }

        System.out.println();
    }

    public static void printtext(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(text);
        }
    }

    public static void printLn(String text, int count) {
        printtext(text, count);
        System.out.println();
    }
}



