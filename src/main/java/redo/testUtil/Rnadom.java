package redo.testUtil;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Rnadom {

    static void printRandomArr(int len, int min, int max) {
        int[] arr = new int[len];
        ThreadLocalRandom r = ThreadLocalRandom.current();
        for (int i = 0; i < len; ++i) {
            arr[i] = (int) (r.nextLong((long) max - min) + min);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        printRandomArr(1000, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

}
