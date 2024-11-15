package Thiemo.week09.Vererbung.Konsruktor;

import javax.swing.plaf.metal.MetalComboBoxEditor;

public class Main {
    public static void main(String[] args) {


        Member one = new Member("name");
        Member two = new Member("name","male");
        Member three = new Member("name","male",12,"who knows");


        System.out.println(one.getAge());
        System.out.println(two.getAge());
        System.out.println(three.getAge());

    }
}
