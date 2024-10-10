package Erik.week05;

/*
            Todo:   1. String [] erstellen
                    2. Bubblesort kopieren.
                    3. Bubblesort umschreiben von int[] zu String[].
                    4. (Vielleicht eine Kopie erstellen?)
                    5. Mit string.length alle namen sortieren. (If umschreiben mit String.length)
                    6. In der If anweisung mit compareTo vergleichen.
                    7. Die Namen alphabetisch sortieren aufsteigen
                    8.Die Namen alphabetisch sortieren absteigend

 */


public class StringBubblesort {
    public static void main(String[] args) {

        String[] names = new String[]{"Furkan", "Aylin", "Thiemo", "Erik", "Akif", "Sandro", "Gyula"};

        System.out.println("------------------Bubble Sort Upwards------------------");
        bubbleSortUpwards(names);
        for (String name : names){
            System.out.println(name);
        }
        System.out.println("------------------Bubble Sort Downwards------------------");
        bubbleSortDownwards(names);
        for (String name : names){
            System.out.println(name);
        }
        System.out.println("------------------Bubble Sort Upwards in Alphabet------------------");
        bubbleSortUpWardsInAlphabet(names);
        for (String name : names){
            System.out.println(name);
        }
        System.out.println("------------------Bubble Sort Downwards in Alphabet------------------");
        bubbleSortDownWardsInAlphabet(names);
        for (String name : names){
            System.out.println(name);
        }
    }

    public static void bubbleSortUpwards(String[] names) {
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (names[j].length() > names[j + 1].length()) {
                    String temp = names[j + 1];
                    names[j + 1] = names[j];
                    names[j] = temp;
                }
            }
        }
    }

    public static void bubbleSortDownwards(String[] names) {
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (names[j].length() < names[j + 1].length()) {
                    String temp = names[j + 1];
                    names[j + 1] = names[j];
                    names[j] = temp;
                }
            }
        }
    }

    public static void bubbleSortUpWardsInAlphabet(String[] names) {
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (names[j].compareTo(names[j + 1]) < 0 ) {
                    String temp = names[j + 1];
                    names[j + 1] = names[j];
                    names[j] = temp;
                }
            }
        }
    }

    public static void bubbleSortDownWardsInAlphabet(String[] names) {
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = 0; j < names.length - 1; j++) {
                if (names[j].compareTo(names[j + 1]) > 0 ) { //Vergleicht zwei Werte alphabetisch und gibt einen negativen oder positiven wert zurück mit dem 0 wird Sortiert
                    String temp = names[j + 1];
                    names[j + 1] = names[j];
                    names[j] = temp;
                }
            }
        }
    }

}