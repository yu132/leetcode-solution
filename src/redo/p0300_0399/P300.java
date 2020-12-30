package redo.p0300_0399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P300  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P300 {

    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] stack = new int[nums.length];
            int len = 0;
            for (int num : nums) {
                if (len == 0 || num > stack[len - 1]) {
                    stack[len++] = num;
                } else {
                    stack[lowerBound(stack, num, 0, len - 1)] = num;
                }
            }
            return len;
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
        Assert.assertEquals(3, s.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 4}));
        Assert.assertEquals(4, s.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        Assert.assertEquals(4, s.lengthOfLIS(new int[] {0, 1, 0, 3, 2, 3}));
        Assert.assertEquals(1, s.lengthOfLIS(new int[] {1, 1, 1, 1, 1, 1}));
    }

}
