package Sandro.Week5;

public class CountChars {
    public static void main(String[] args) {

        String text = data.Texts.getSimpleText();
        System.out.println(text);

       // printMyCharList(countChars(text));
       // biggestCharCount(countChars(text));
        printCharsByNumber(countChars(text),10);


    }

    public static int[] countChars (String text){
        int[] databank = new int[Character.MAX_VALUE];

        char WelcherCharBinIch = ' ';
        for (int i = 0; i < text.length(); i++) {
            WelcherCharBinIch = text.charAt(i);
            ++databank[text.charAt(i)];
        }
        return databank;
    }

    public static void printMyCharList (int[] array){

        for (int i = 0; i < array.length; i++) {
            if(array[i] >0){
                System.out.printf("%-5c ) --> (%4d)  =  %10d" ,(char)i, i, array[i]);
                System.out.println();
            }

        }
    }

    public static void biggestCharCount (int[]array){
        int max = -1;
        int index = -1;

        for (int i = 0; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
                index = i;
            }
        }

        System.out.printf("The Char: (%c) was found %d times in the text!",(char)index,max);
        System.out.println();

    }

    public static void printCharsByNumber (int[] array, int count){

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= count){
                System.out.printf("%-5c ) --> (%4d)  =  %10d" ,(char)i, i, array[i]);
                System.out.println();
            }
        }


    }

}
