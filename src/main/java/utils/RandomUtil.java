package utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

    public static int[] randomArr(int len, int valFrom, int valEnd) {
        int[] arr = new int[len];
        ThreadLocalRandom r = ThreadLocalRandom.current();
        for (int i = 0; i < len; ++i) {
            arr[i] = r.nextInt(valEnd - valFrom) + valFrom;
        }
        return arr;
    }

}
