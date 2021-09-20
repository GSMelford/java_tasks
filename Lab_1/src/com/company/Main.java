package com.company;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;

public class Main {
    private static final int bound = 9;
    private static final int rowSize = 9;
    private static final int columnSize = 9;

    public static void main(String[] args) {
        int[][] array = fillArray(rowSize, columnSize);
        printArray(array);

        printEvenNumber(array, n -> n % 2 == 0 && n != 0); //if 0 isn't even
        printEvenNumber(array, n -> n % 2 == 0); //if 0 is even

        System.out.println(Arrays.toString(fillArray(0, 10, 2)));
    }

    private static int[][] fillArray(int rowSize, int columnSize){
        Random random = new Random();
        int[][] array = new int[rowSize][columnSize];

        for (int i = 0; i < rowSize; i++){
            for (int j = 0; j < columnSize; j++){
                array[i][j] = random.nextInt(bound);
            }
        }

        return array;
    }

    private static void printEvenNumber(int[][] array, Predicate<Integer> getCondition){
        System.out.print("Even number: ");
        for (int i = 0; i < array.length; i++){
            int number = array[i][array.length - i - 1];
            if (getCondition.test(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    private static void printArray(int[][] array){
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[] fillArray(int begin, int end, int step){
        int[] array = new int[end];

        int temp = 0;
        for(int i = begin; i < array.length - 1; i++){
            array[i + 1] = temp += step;
        }

        return array;
    }
}