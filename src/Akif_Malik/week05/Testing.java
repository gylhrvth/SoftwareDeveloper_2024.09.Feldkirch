package Akif_Malik.week05;

public class Testing {
    public static void main(String[] args) {
        String[] names = {"Anna", "Johannes", "Max", "Lena", "Peter", "Zoe", "Tim"};
        bubbleSortByLengthAndAlphabet(names);

        // Ausgabe der sortierten Namen
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void bubbleSortByLengthAndAlphabet(String[] names) {
        int n = names.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // Vergleiche zuerst die Längen, dann alphabetisch
                if (names[j].length() > names[j + 1].length() ||
                        (names[j].length() == names[j + 1].length() && names[j].compareTo(names[j + 1]) > 0)) {
                    // Tauschen, wenn die Bedingungen erfüllt sind
                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                }
            }
        }
    }
}

