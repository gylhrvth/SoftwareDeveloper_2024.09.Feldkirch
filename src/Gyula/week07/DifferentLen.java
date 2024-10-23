package Gyula.week07;

public class DifferentLen {
    public static void main(String[] args) {
        String[] column = new String[]{"A", "AB", "ABC", "Thiemo", "ABCD", "ABCDE", };

        int maxWidth = getMaxWidth(column);
        String formatString = String.format("| %%-%ds |\n", maxWidth);
        System.out.println(formatString);
        for (int i = 0; i < column.length; i++) {
            System.out.printf(formatString, column[i]);
        }
    }

    public static int getMaxWidth(String[] arr){
        int maxWidth = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > maxWidth){
                maxWidth = arr[i].length();
            }
        }
        return maxWidth;
    }
}
