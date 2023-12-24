package utils;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

    public static int[] randomArr(int len, int valFrom, int valEnd) {
        int[] arr = new int[len];
        ThreadLocalRandom r = ThreadLocalRandom.current();
        for (int i = 0; i < len; ++i) {
            arr[i] = (int) (r.nextLong((long) valEnd - valFrom) + valFrom);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(randomArr(10000, 1, 65535)));
    }

}
