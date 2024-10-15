package Sandro.Week6;

import data.Texts;

public class SearchHesse {
    public static void main(String[] args) {

        String text = Texts.HESSE;
        System.out.println(text);

        String search = "Hesse";

        int indexOf = text.indexOf(search);                                 //Start index, first time we find Word
        int counter = 0;                                                    //init Var for counter

        while (indexOf != -1) {                                             //Word not found = -1

            counter++;                                                      //Found word in text, Counter ++ add
            System.out.println("Hesse found on Index --> " + indexOf);      //Print Info, where we found Word
            int newIndex = indexOf + 1;                                     //NewIndex we are now looking, lastIndex+1
            indexOf = text.indexOf(search, newIndex);
        }

        System.out.println("Total found : " + counter + " times, the Word " + search);  //final Print with count

    }

}
