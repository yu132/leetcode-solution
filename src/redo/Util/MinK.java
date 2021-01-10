package redo.Util;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: MinK  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class MinK {

    // 这个返回的minK是没有顺序的，只是k个最小的值，不保证第k-1位是第k小的数
    @SuppressWarnings("unchecked")
    public static <T> T[] minKList(T[] arr, int k, Comparator<T> comparator) {

        if (arr.length == 0) {
            return (T[])new Object[0];
        }

        int low = 0, high = arr.length - 1;

        int pviotIndex = partition(arr, low, high, comparator);

        while (pviotIndex != k) {
            if (pviotIndex > k) {
                high = pviotIndex - 1;
            } else {
                low = pviotIndex + 1;
            }
            pviotIndex = partition(arr, low, high, comparator);
        }

        return Arrays.copyOf(arr, k);
    }

    // 返回准确的第k小的数
    public static <T> T minK(T[] arr, int k, Comparator<T> comparator) {

        if (arr.length == 0) {
            return null;
        }

        int low = 0, high = arr.length - 1;

        int pviotIndex = partition(arr, low, high, comparator);

        while (pviotIndex != k - 1) {
            if (pviotIndex > k - 1) {
                high = pviotIndex - 1;
            } else {
                low = pviotIndex + 1;
            }
            pviotIndex = partition(arr, low, high, comparator);
        }

        return arr[k - 1];
    }

    public static <T> int partition(T[] arr, int low, int high, Comparator<T> comparator) {
        T pivot = arr[low];// 取最低位为主元
        while (low < high) {
            while (low < high && comparator.compare(arr[high], pivot) >= 0) {
                --high;
            }
            arr[low] = arr[high];
            while (low < high && comparator.compare(arr[low], pivot) <= 0) {
                ++low;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }



    @Test
    public void test() {
        Integer[] arr = {9, 1, 2, 6, 23, 1, 66, 3, 2, 23, 3};
        Integer[] after = {3, 1, 2, 6, 2, 1, 3, 9, 66, 23, 23};
        partition(arr, 0, arr.length - 1, (a, b) -> Integer.compare(a, b));
        Assert.assertArrayEquals(after, arr);
    }

    @Test
    public void test2() {
        Integer[] arr = {9, 1, 2, 6, 23, 1, 66, 3, 2, 23, 3};
        Integer[] minKExpected = {1, 1, 2, 2, 3};
        Integer[] minK = minKList(arr, 5, (a, b) -> Integer.compare(a, b));
        Arrays.sort(minK);
        Assert.assertArrayEquals(minKExpected, minK);
    }

}
