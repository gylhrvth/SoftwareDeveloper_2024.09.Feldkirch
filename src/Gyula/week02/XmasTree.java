package Gyula.week02;

public class XmasTree {
    public static void main(String[] args) {
        printXmasTreeWithLoops(9);
        printXmasTreeWithMatrix(9);
    }

    public static int getTrunkWidth(int treeSize){
        return ((2 * treeSize - 1) / 8) * 2 + 1;
    }


    public static void printXmasTreeWithMatrix(int size){
        int trunkHeight = size / 8 + 1;
        int trunkWidth = getTrunkWidth(size);
        int placeNextToTrunk = ((2 * size - 1) - trunkWidth) / 2;

        for (int row = 0; row < size + 1 + trunkHeight; row++) {
            for (int col = 0; col < 2 * size - 1; col++) { // Tree
                if ((row < size) && (col + row >= size - 1) && (col <= row + size -1)) {
                    System.out.print("*");
                } else if ((row == size) && (col % 2 == 0)) { // Balls
                    System.out.print("O");
                } else if (row > size && col >= placeNextToTrunk && col < placeNextToTrunk + trunkWidth){ // Trunk
                    System.out.print("+");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void printXmasTreeWithLoops(int size){
        if (size < 3){
            System.out.println("Du braucht eine größere XMAS Überraschung");
            return;
        }
        for (int row = 0; row < size; row++) {
            // Place left from Tree
            for (int column = 0; column < size - row - 1; column++) {
                System.out.print(" ");
            }
            // The Tree
            for (int column = 0; column < 2 * row + 1; column++) {
                System.out.print("*");
            }
            // Place right from Tree
            for (int column = 0; column < size - row - 1; column++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int column = 0; column < 2 * size - 1; column++) {
            if (column % 2 == 0) {
                System.out.print("O");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
        // Stamm
        int trunkWidth = getTrunkWidth(size);
        int placeNextToTrunk = ((2 * size - 1) - trunkWidth) / 2;
        for (int row = 0; row < size / 8 + 1; row++) {
            // Space left from trunk
            for (int column = 0; column < placeNextToTrunk; column++) {
                System.out.print(" ");
            }
            // The trunk
            for (int column = 0; column < trunkWidth; column++) {
                System.out.print("+");
            }
            // Space right from trunk
            for (int column = 0; column < placeNextToTrunk; column++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
