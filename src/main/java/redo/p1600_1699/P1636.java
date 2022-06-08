package redo.p1600_1699;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1636  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1636 {

    static//

    class Solution {
        public int[] frequencySort(int[] nums) {
            int[] count = count(nums, -100, 101);
            sort(nums, (a, b) -> {
                if (count[a + 100] == count[b + 100]) {
                    return Integer.compare(b, a);
                }
                return Integer.compare(count[a + 100], count[b + 100]);
            });
            return nums;
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

        public static int[] count(int[] nums, int start, int end) {
            int[] count = new int[end - start];
            for (int num : nums) {
                ++count[num - start];
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {3, 1, 1, 2, 2, 2}, s.frequencySort(new int[] {1, 1, 2, 2, 2, 3}));
        Assert.assertArrayEquals(new int[] {1, 3, 3, 2, 2}, s.frequencySort(new int[] {2, 3, 1, 3, 2}));
        Assert.assertArrayEquals(new int[] {5, -1, 4, 4, -6, -6, 1, 1, 1},
            s.frequencySort(new int[] {-1, 1, -6, 4, 5, -6, 1, 4, 1}));

    }

}
