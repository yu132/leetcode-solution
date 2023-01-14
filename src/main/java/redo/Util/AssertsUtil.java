package redo.Util;

public class AssertsUtil {

    boolean assertArraysAllEquals(int[] arr, int val) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != val) {
                return false;
            }
        }
        return true;
    }

    boolean assertArraysAllEquals(int[] arr, int val, int start, int end) {
        for (int i = start; i < end; ++i) {
            if (arr[i] != val) {
                return false;
            }
        }
        return true;
    }

}
