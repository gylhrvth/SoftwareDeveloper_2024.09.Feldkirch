package Thiemo.week06;

import java.io.File;
import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class FunWithFiles {
    public static void main(String[] args) {

        File target = new File("C:\\Users\\dcv\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Thiemo");
        File target2 = new File("C:\\Users\\dcv\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src");
        File target3 = new File("C:\\Users\\dcv\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Thiemo\\HelloWorld.java");

        System.out.println(target.isFile());
        System.out.println(target.isDirectory());
        System.out.println(target2.isFile());
        System.out.println(target2.isDirectory());
        System.out.println(target3.isFile());
        System.out.println(target3.isDirectory());


        File[] content = target.listFiles();
        System.out.println(Arrays.toString(content));
//        System.out.println(Arrays.toString(target.listFiles()));
        File[] content1 = target2.listFiles();
        System.out.println(Arrays.toString(content1));
//        System.out.println(Arrays.toString(target2.listFiles()));
        File[] content2 = target3.listFiles();
        System.out.println(Arrays.toString(content2));
//        System.out.println(Arrays.toString(target3.listFiles()));


        System.out.println(Arrays.toString(target.list()));
        System.out.println(target.compareTo(target2));
        System.out.println(Arrays.toString(target2.list()));
        System.out.println(target2.compareTo(target3));
        System.out.println(Arrays.toString(target3.list()));
        System.out.println(target3.length() < target.length());
//        bubblesortDescendingLex(content);
//        System.out.println(content);

        System.out.println(Arrays.toString(content1));
        for (int i = 0; i < target.length(); i++) {
            swap(content1, i, i + 1);
        }
        System.out.println(Arrays.toString(content1));
        System.out.println();
        System.out.println(Arrays.toString(content2));
        for (int i = 0; i < target2.length(); i++) {
            for (int j = 0; j < target2.length(); j++) {
                swap(content1, j, j + 1);
            }
        }
        System.out.println(Arrays.toString(content2));

    }

    public static void swap(File[] arr, int i, int j) {
        if (i >= 0 && j >= 0 && i < arr.length && j < arr.length) {
            File temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

//    public static void bubblesortDescendingLex(File[] target) {
//        Collator collator = Collator.getInstance(Locale.GERMAN);
//        for (int i = 0; i < target.length; i++) {
//            for (int j = 0; j < target.length - 1; j++) {
//                if (collator.compare(target[j], target[j + 1]) < 0) {
//                    swap(target, j, j + 1);
//                }
//            }
//        }
//    }
}

