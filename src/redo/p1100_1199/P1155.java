package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1155  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1155 {

    class Solution {

        public final static int MOD = 1000000007;

        public int numRollsToTarget(int d, int f, int target) {
            int[][] dp = new int[d + 1][Math.max(d * f + 1, target + 1)];

            for (int i = 1; i <= Math.min(f, target); ++i) {
                dp[1][i] = 1;
            }

            for (int i = 2; i <= d; ++i) {
                for (int j = i; j <= d * f; ++j) {
                    for (int k = 1; j - k >= 0 && k <= f; ++k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                    }
                }
            }

            return dp[d][target];
        }

    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.numRollsToTarget(1, 6, 3));
        Assert.assertEquals(6, s.numRollsToTarget(2, 6, 7));
        Assert.assertEquals(1, s.numRollsToTarget(2, 5, 10));
        Assert.assertEquals(0, s.numRollsToTarget(1, 2, 3));
        Assert.assertEquals(87756311, s.numRollsToTarget(30, 20, 193));
        Assert.assertEquals(222616187, s.numRollsToTarget(30, 30, 500));
    }
}
