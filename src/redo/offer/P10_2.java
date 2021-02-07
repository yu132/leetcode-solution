package redo.offer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P10_2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月2日  
 *  
 */
public class P10_2 {

    class Solution {

        final static int MOD = 1000000007;

        public int numWays(int n) {
            if (n == 0) {
                return 1;
            } else if (n == 1) {
                return 1;
            }
            int[] dp = new int[2];
            dp[0] = 1;
            dp[1] = 1;
            int scroll = 0;
            for (int i = 2; i <= n; ++i, scroll ^= 1) {
                dp[scroll] = (dp[scroll ^ 1] + dp[scroll]) % MOD;
            }
            return dp[scroll ^ 1];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.numWays(2));
        Assert.assertEquals(21, s.numWays(7));
        Assert.assertEquals(1, s.numWays(0));
    }
}
