package redo.p0300_0399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P375  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P375 {

    class Solution {
        public int getMoneyAmount(int n) {
            dp = new int[n + 1][n + 1];

            return helper(1, n + 1);
        }

        int[][] dp;

        int helper(int low, int high) {

            if (low >= high - 1) {
                return 0;
            }

            if (dp[low][high - 1] == 0) {

                int min = Integer.MAX_VALUE;

                for (int i = low; i < high; ++i) {
                    min = Math.min(min,
                        i + Math.max(helper(low, i), helper(i + 1, high)));
                }

                dp[low][high - 1] = min;

            }
            return dp[low][high - 1];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(16, s.getMoneyAmount(10));
    }

}
