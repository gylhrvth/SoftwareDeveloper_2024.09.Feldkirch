package Gyula.week02;

public class Rhombus {
    public static void main(String[] args) {
        printRhombus(5);
    }

    public static void printRhombus(int size){
        // 1. For Schleife für Row
        // 2. For Schleife für Column
        // 3. Print X and add line break
        // 4. Extend field for 2*size
        // 5. If-else block
        // 6. Kriterium: row + colum == size
        // 7. Kriterium: row + colum == size - 1
        // 8. for loop 2*size -1
        // 9. else-if mit Kriterium row + column == 2 * (size - 1)
        // 10. überarbeiten das Kriterium für column == row + size - 1
        // 11. neue else-if row == column + size - 1
        // 12. neue else-if mit Kriterium: 3 * (size - 1)
        // 13. clean up
        for (int row = 0; row < 2 * size - 1; row++) {
            for (int column = 0; column < 2 * size - 1; column++) {
                if ((row + column == size - 1) ||
                    (column == row + size - 1) ||
                    (row == column + size - 1) ||
                    (row + column == 3 * (size - 1))){
                    System.out.print(" X");
                } else {
                    System.out.print(" .");
                }
            }
            System.out.println();
        }
    }
}
