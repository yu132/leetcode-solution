package redo.p1100_1199;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1122  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月27日  
 *  
 */
public class P1122 {

    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] order = new int[1001];
            for (int i = 0; i < arr2.length; ++i) {
                order[arr2[i]] = i + Integer.MIN_VALUE;
            }
            sort(arr1, (a, b) -> {
                if (order[a] == order[b]) {
                    return Integer.compare(a, b);
                }
                return Integer.compare(order[a], order[b]);
            });
            return arr1;
        }

        public void sort(int[] arr, Comparator<Integer> comparator) {
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



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19},
            s.relativeSortArray(new int[] {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[] {2, 1, 4, 3, 9, 6}));
    }

}
