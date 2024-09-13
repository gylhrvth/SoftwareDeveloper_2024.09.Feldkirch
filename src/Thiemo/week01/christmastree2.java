package Thiemo.week01;

public class christmastree2 {

    public static void main(String[] args) {
    System.out.println();
    christmastree(13);
    System.out.println();
}

    public static void christmastree(int count) {
        if (count % 2 == 0){
            count++;
        }

        for (int rowBaum = 0; rowBaum < count; rowBaum++) {
            for (int spacebar = 0; spacebar < count - rowBaum - 1; spacebar++) {
                System.out.print(".");
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

        for (int rowTrunk = 0; rowTrunk < count / 3 ; rowTrunk++) {
            for (int spacebar = 0; spacebar <  count / 3   ; ++spacebar) {
               System.out.print(". ");
           }

            for (int columnTrunk = 0; columnTrunk  < (count*2 ) / 3  ;  columnTrunk++) {

                System.out.print("+");
            }

            System.out.println();
        }
    }
}



