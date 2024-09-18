package Gyula.week02;

public class TriangleSymetrical {
    public static void main(String[] args) {
        printTriangle(9);
    }

    public static void printTriangle(int size){
        // 1. Rechwickliger Dreieck
        // 2. for in for
        // 3. Print Stern
        // 4. if-else
        // 5. Kriterium: row + col <= size
        // 6. Kriterium +1
        // 7. for col < 2 * size
        // 8. else if für die andere Hälfte
        // 9. Überarbeiten erste Kriterium
        // 10. Buchstaben A löschen
        // 11 for col < 2 * size - 1
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < 2 * size - 1; col++) {
                if ((row + col +1 >= size) && (col < size + row)){
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
