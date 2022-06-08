package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1144  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1144 {

    class Solution {
        public int movesToMakeZigzag(int[] nums) {
            return Math.min(helper(0, nums), helper(1, nums));
        }

        public int helper(int odd, int[] nums) {
            int ans = 0;
            for (int i = odd; i < nums.length; i += 2) {
                int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                if (i != 0) {
                    left = nums[i - 1];
                }
                if (i != nums.length - 1) {
                    right = nums[i + 1];
                }
                if (nums[i] >= Math.min(left, right)) {
                    ans += nums[i] - Math.min(left, right) + 1;
                }
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.movesToMakeZigzag(new int[] {1, 2, 3}));
        Assert.assertEquals(4, s.movesToMakeZigzag(new int[] {9, 6, 1, 6, 2}));
    }
}
