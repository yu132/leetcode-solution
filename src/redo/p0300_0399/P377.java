package redo.p0300_0399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P377  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P377 {

    class Solution {
        public int combinationSum4(int[] nums, int target) {
            return helper(nums, target, new int[target + 1]);
        }

        int helper(int[] nums, int now, int[] dp) {
            if (now == 0) {
                return 1;
            }
            if (now < 0) {
                return 0;
            }
            if (dp[now] == 0) {
                int count = 0;
                for (int num : nums) {
                    count += helper(nums, now - num, dp);
                }
                dp[now] = count + 1;
            }
            return dp[now] - 1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1,
            s.combinationSum4(new int[] {3, 33, 333}, 10000));
    }

}
