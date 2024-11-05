package Gyula.week08;

import java.util.Random;
import java.util.Vector;

public class VectorMerge {
    public static Random random = new Random();

    public static void main(String[] args) {
        Vector<Integer> left = generateAscVector(10000);
        Vector<Integer> right = generateAscVector(10000);
        System.out.println(left);
        System.out.println(right);

        Vector<Integer> result = mergeVector(left, right);
        System.out.println(result);
    }

    public static Vector<Integer> mergeVector(Vector<Integer> left, Vector<Integer> right){
        Vector<Integer> result = new Vector<>();
        while (!left.isEmpty() && !right.isEmpty()){
            if (left.firstElement() < right.firstElement()){
                result.add(left.removeFirst());
            } else {
                result.add(right.removeFirst());
            }
        }
        while (!left.isEmpty()){
            result.add(left.removeFirst());
        }
        while (!right.isEmpty()){
            result.add(right.removeFirst());
        }
        return result;
    }

    public static Vector<Integer> generateAscVector(int count){
        Vector<Integer> result = new Vector<>();
        int nextValue = 0;
        for (int i = 0; i < count; i++) {
            nextValue += random.nextInt(10);
            result.add(nextValue);
        }
        return result;
    }
}
