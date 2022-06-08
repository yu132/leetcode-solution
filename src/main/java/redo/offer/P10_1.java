package redo.offer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P10_1  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月2日  
 *  
 */
public class P10_1 {

    class Solution {

        final static int MOD = 1000000007;

        public int fib(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            }
            int[] dp = new int[2];
            dp[0] = 0;
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
        Assert.assertEquals(1, s.fib(2));
        Assert.assertEquals(5, s.fib(5));
        Assert.assertEquals(134903163, s.fib(45));
    }

}
