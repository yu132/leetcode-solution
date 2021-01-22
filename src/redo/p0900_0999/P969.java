package redo.p0900_0999;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P969  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P969 {

    static//

    class Solution {
        public List<Integer> pancakeSort(int[] arr) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < arr.length - 1; ++i) {
                int maxIndex = maxIndex(arr, 0, arr.length - i);
                ans.add(maxIndex + 1);
                ans.add(arr.length - i);
                reverse(arr, 0, maxIndex);
                reverse(arr, 0, arr.length - i - 1);
            }
            return ans;
        }


        public static void reverse(int[] array, int from, int to) {
            for (; from < to; ++from, --to) {
                swap(array, from, to);
            }
        }

        public static void swap(int[] array, int x, int y) {
            int num = array[x];
            array[x] = array[y];
            array[y] = num;
        }

        public static int maxIndex(int[] nums, int start, int end) {
            int max = nums[start], maxIndex = start;
            for (int i = start + 1; i < end; ++i) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            return maxIndex;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(3, 4, 2, 3, 1, 2), s.pancakeSort(new int[] {3, 2, 4, 1}));
    }

}
