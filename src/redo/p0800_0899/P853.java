package redo.p0800_0899;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P853  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月28日  
 *  
 */
public class P853 {

    static//

    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            int[] sortedIndex = indexSort(position);
            double nowTime = 0;
            int count = 0;
            for (int i = position.length - 1; i >= 0; --i) {
                int index = sortedIndex[i];
                double timeNow = (target - position[index]) / (double)speed[index];
                if (timeNow > nowTime) {
                    ++count;
                    nowTime = timeNow;
                }
            }
            return count;
        }

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



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.carFleet(12, new int[] {10, 8, 0, 5, 3}, new int[] {2, 4, 1, 1, 3}));
    }

}
