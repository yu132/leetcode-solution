package redo.Util;

import java.util.Arrays;
import java.util.Comparator;

/**  
 * @ClassName: Sort  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月27日  
 *  
 */
public class Sort {

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
