package Erik.week05;

/*
            Todo:   1. String [] von vorheriger aufgabe übernehmen
                    2. Mit Bubble Sort von vorheriger Aufgabe sortieren und ausgeben.
                    3. In der Bubble Sort Methode einen weiteren int Parameter hinzufügen. (int steht für den charAt index)
                    4. Nach charAt Sortieren
                    5.
 */


public class StringBubbleSortWithCharIndex {
    public static void main(String[] args) {

        String[] names = new String[]{"AA", "Furkan", "Aylin", "Thiemo", "Erik", "Akif", "Sandro", "Gyula"};
//        String[] names = new String[]{"Gyula hat ein ganz lange Name"};

        int index = 2;
        System.out.println("------------------Bubble Sort Upwards------------------");
        bubbleSortUpwards(names, index);
        if (!isAWordTooShort(names, index)) {
            for (String name : names) {
                System.out.println(name);
            }
        }

    }

    public static boolean isAWordTooShort(String[] names, int index) {
        for (String name : names) {
            if (name.length() > index) {
                return false;
            }
        }
        return true;
    }

    public static void bubbleSortUpwards(String[] names, int index) {
        if (index < 0 || isAWordTooShort(names, index)) {
            System.out.println("Error: Index is not valid");
            return;
        }

        boolean validIndex = index < 0;
//        for (String name : names) {
//            if (index >= name.length()) {
//                validIndex = false;
//            }
//        }

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
        }


    }
}
