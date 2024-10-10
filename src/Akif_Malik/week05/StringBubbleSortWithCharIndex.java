package Akif_Malik.week05;

/*
            Todo:   1. String [] von vorheriger aufgabe übernehmen
                    2. Mit Bubble Sort von vorheriger Aufgabe sortieren und ausgeben.
                    3. In der Bubble Sort Methode einen weiteren int Parameter hinzufügen. (int steht für den charAt index)
                    4. Nach charAt Sortieren
                    5. Prüfung von Index
*/

public class StringBubbleSortWithCharIndex {

    public static void main(String[] args) {

        String[] names = new String[]{"Furkan", "Aylin", "Thiemo", "Erik", "Akif", "Sandro", "Gyula"

        };
        // String[] names = new String[]{"Gyula hat ein ganz lange Name"};

        System.out.println("------------------Bubble Sort Upwards------------------");
        bubbleSortUpwards(names, 2);
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void bubbleSortUpwards(String[] names, int index) {

        boolean validIndex = true;
        for (String name : names) {

            if (index >= name.length() || index < 0) {
                validIndex = false;
            }
        }

        if (validIndex) {
            for (int i = 0; i < names.length - 1; i++) {
                for (int j = 0; j < names.length - 1; j++) {
                    if (names[j].charAt(index) > names[j + 1].charAt(index)) {
                        String temp = names[j + 1];
                        names[j + 1] = names[j];
                        names[j] = temp;
                    }
                }
            }
        } else {

            System.out.println("Error: Index is not valid");
        }
    }
}
