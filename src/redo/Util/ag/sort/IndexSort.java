package redo.Util.ag.sort;

import java.util.Arrays;
import java.util.Comparator;

/**  
 * @ClassName: IndexSort  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月27日  
 *  
 */
public class IndexSort {

    static int[] indexSort(int[] arr) {
        int[] indexes = new int[arr.length];
        Arrays.setAll(indexes, (x) -> x);
        sort(indexes, (i, j) -> Integer.compare(arr[i], arr[j]));
        return indexes;
    }

    public static void sort(int[] arr, Comparator<Integer> comparator) {
        Integer[] copy = new Integer[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            copy[i] = arr[i];
        }
        Arrays.sort(copy, comparator);
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = copy[i];
        }
    }

}
