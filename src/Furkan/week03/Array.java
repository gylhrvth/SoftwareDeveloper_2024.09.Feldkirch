package Furkan.week03;

import Gyula.ConsoleTools;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
    int size =ConsoleTools.readNumber("Gib die Größe des Arrays ein:",0,100);
    int[] arr= createAndFillArray(size);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] createAndFillArray(int size){
        int[] result = new int[size];
        for (int i = 0; i< result.length; i++){
            result[i] = 1+i;
            for (i = 0; i < result.length; i++){
                result[i]=1+i;
            }

        }
        return result;


        }


    }





