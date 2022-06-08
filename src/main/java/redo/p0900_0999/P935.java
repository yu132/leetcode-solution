package redo.p0900_0999;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P935  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月22日  
 *  
 */
public class P935 {

    class Solution {

        public final static int MOD = 1000000007;

        public int knightDialer(int n) {
            long[][] dp = new long[2][10];
            Arrays.fill(dp[0], 1);
            int scroll = 1;
            for (int i = 1; i < n; ++i, scroll ^= 1) {
                dp[scroll][0] = (dp[scroll ^ 1][4] + dp[scroll ^ 1][6]) % MOD;
                dp[scroll][1] = (dp[scroll ^ 1][6] + dp[scroll ^ 1][8]) % MOD;
                dp[scroll][2] = (dp[scroll ^ 1][7] + dp[scroll ^ 1][9]) % MOD;
                dp[scroll][3] = (dp[scroll ^ 1][4] + dp[scroll ^ 1][8]) % MOD;
                dp[scroll][4] = (dp[scroll ^ 1][0] + dp[scroll ^ 1][3] + dp[scroll ^ 1][9]) % MOD;
                dp[scroll][5] = 0;
                dp[scroll][6] = (dp[scroll ^ 1][0] + dp[scroll ^ 1][1] + dp[scroll ^ 1][7]) % MOD;
                dp[scroll][7] = (dp[scroll ^ 1][2] + dp[scroll ^ 1][6]) % MOD;
                dp[scroll][8] = (dp[scroll ^ 1][1] + dp[scroll ^ 1][3]) % MOD;
                dp[scroll][9] = (dp[scroll ^ 1][2] + dp[scroll ^ 1][4]) % MOD;
            }
            int sum = 0;
            for (long num : dp[scroll ^ 1]) {
                sum = (int)((sum + num) % MOD);
            }
            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(10, s.knightDialer(1));
        Assert.assertEquals(20, s.knightDialer(2));
        Assert.assertEquals(46, s.knightDialer(3));
        Assert.assertEquals(104, s.knightDialer(4));
        Assert.assertEquals(240, s.knightDialer(5));
        Assert.assertEquals(544, s.knightDialer(6));
        Assert.assertEquals(58689536, s.knightDialer(20));
        Assert.assertEquals(879399442, s.knightDialer(4982));
    }

}
