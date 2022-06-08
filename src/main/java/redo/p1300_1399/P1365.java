package redo.p1300_1399;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1365  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1365 {

    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {

            int[] copy = Arrays.copyOf(nums, nums.length);
            Arrays.sort(copy);

            for (int i = 0; i < nums.length; ++i) {
                nums[i] = lowerBound(copy, nums[i], 0, copy.length);
            }

            return nums;
        }

        public int lowerBound(int[] nums, int target, int start, int end) {
            int low = start, high = end;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {4, 0, 1, 1, 3}, s.smallerNumbersThanCurrent(new int[] {8, 1, 2, 2, 3}));
        Assert.assertArrayEquals(new int[] {2, 1, 0, 3}, s.smallerNumbersThanCurrent(new int[] {6, 5, 4, 8}));
        Assert.assertArrayEquals(new int[] {0, 0, 0, 0}, s.smallerNumbersThanCurrent(new int[] {7, 7, 7, 7}));

    }

}
