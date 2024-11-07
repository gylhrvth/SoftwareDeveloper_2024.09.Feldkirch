package Sandro.Week8;

import java.util.Vector;

public class VectorRehearsal {
    public static void main(String[] args) {
        //Create Vector, init with new Vector
        Vector<Integer> data = new Vector<>();
        //Add Integers to VectorList with .add(value)
        data.add(123);
        data.add(34);
        data.add(5);
        data.add(15);
        //Print out Vector sout(name)
        System.out.println(data);
        //Add an Integer at a specific index Positon with .add(index,value)
        data.add(0, 7);
        //Print out Vector to see difference
        System.out.println(data);
        //Print only a specific Index with .elementAt(index)
        System.out.println(data.elementAt(3));

        //Try to print an Index from the Vector, that does not exist. Use Try Catch for Exception handling
        try {
            System.out.println(data.elementAt(7));
        } catch (IndexOutOfBoundsException ioobe){
            System.out.println(ioobe);
        }
        //Choose a specific Index and set the Value to 100
        data.set(0, 100);
        //Print Vector for control
        System.out.println("Test --- "+data);
        data.removeLast();
        System.out.println("Test ... "+data);

        //Useful Information about the Vector ist .size and .capacity
        System.out.println("Size: " + data.size());
        System.out.println("Capacity: " + data.capacity());

        //Make a Loop and add more Inputs to the Vector, print out the Size and Capacity with every Step
        for (int i = 0; i < 25; i++) {
            data.add(i);
            System.out.println("Size: " + data.size() + " Capacity: " + data.capacity());
        }

        //print Vector for control
        System.out.println(data);
        //remove a specific Value from the Vector
        data.remove(Integer.valueOf(1));
        //print Vector for control
        System.out.println(data);
        //remove a specific index from the Vector
        data.remove(0);
        //print Vector for control
        System.out.println(data);

        //Look through the Vector and find Values with .contains and .indexOf
        System.out.println("Ist ein 17-er da? " + data.contains(17));
        System.out.println("Wo ist mein 34-er? " + data.indexOf(34));

        //Print the whole Vector with a For-i Loop
        System.out.println("Mit for-i");
        for (int i = 0; i < data.size(); i++) {
            System.out.print(data.elementAt(i) + " ");
        }
        System.out.println();
        //Print the whole Vector with a For-Each Loop
        System.out.println("mit For-Each");
        for (Integer value: data){
            System.out.print(value + " ");
        }
        System.out.println();
        //Find the First and Last Index and print out the Value .firstElememnt .lastElement
        System.out.println("first: " + data.firstElement());
        System.out.println("last : " + data.lastElement());
        System.out.println("=======================");

    }
}
