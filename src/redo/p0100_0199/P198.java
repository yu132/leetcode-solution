package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P198  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P198 {

    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) {
                return 0;
            } else if (nums.length == 1) {
                return nums[0];
            }
            int[][] dp = new int[2][nums.length];
            dp[0][1] = nums[0];
            dp[1][0] = nums[0];
            dp[1][1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; ++i) {
                dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
                dp[1][i] = nums[i] + Math.max(dp[0][i - 1], dp[1][i - 2]);
            }
            return Math.max(dp[0][nums.length - 1], dp[1][nums.length - 1]);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(1, s.rob(new int[] {1}));
        assertEquals(2, s.rob(new int[] {1, 2}));
        assertEquals(4, s.rob(new int[] {1, 2, 3, 1}));
        assertEquals(12, s.rob(new int[] {2, 7, 9, 3, 1}));
    }

}
