package Thiemo.week09;

import java.util.Random;
import java.util.Vector;

public class VectorMerge {

    public static Random random = new Random();

    public static void main(String[] args) {

        Vector<Integer> vector1 = generateAscVector(20);
        Vector<Integer> vector2 = generateAscVector(20);
        System.out.println(vector1);
        System.out.println(vector2);

        Vector<Integer> result = mergeVector(vector1,vector2);
        System.out.println(result);



    }
    public static Vector<Integer> mergeVector(Vector<Integer> Vector1, Vector<Integer> Vector2){
        Vector<Integer> result = new Vector<>();
        while (!Vector1.isEmpty() && !Vector2.isEmpty()){
            if (Vector1.firstElement() < Vector2.firstElement()){
                result.add(Vector1.removeFirst());
            } else {
                result.add(Vector2.removeFirst());
            }
        }
        while (!Vector1.isEmpty()){
            result.add(Vector1.removeFirst());
        }
        while (!Vector2.isEmpty()){
            result.add(Vector2.removeFirst());
        }
        return result;
    }


    public static Vector<Integer> generateAscVector(int count){
        Vector<Integer> result = new Vector<>();
        int nextValue = 0;
        for (int i = 0; i < count; i++) {
            nextValue += random.nextInt(5);
            result.add(nextValue);
        }
        return result;
    }
}
