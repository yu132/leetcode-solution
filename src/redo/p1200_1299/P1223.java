package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1223  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P1223 {

    static//

    class Solution {

        public final static int MOD = 1000000007;

        public int dieSimulator(int n, int[] rollMax) {
            long[][][] dp = new long[2][6][max(rollMax) + 1];
            for (int i = 0; i < 6; ++i) {
                dp[0][i][0] = 1;
                dp[0][i][1] = 1;
            }
            int now = 1;
            for (int step = 1; step < n; ++step, now ^= 1) {
                for (int i = 0; i < 6; ++i) {
                    dp[now][i][0] = 0;
                    dp[now][i][1] = 0;

                    for (int j = 0; j < 6; ++j) {
                        if (i != j) {
                            dp[now][i][0] = (dp[now][i][0] + dp[now ^ 1][j][0]) % MOD;
                            dp[now][i][1] = (dp[now][i][1] + dp[now ^ 1][j][0]) % MOD;
                        } else {
                            for (int k = 1; k < rollMax[i]; ++k) {
                                dp[now][i][0] = (dp[now][i][0] + dp[now ^ 1][i][k]) % MOD;
                                dp[now][i][k + 1] = dp[now ^ 1][i][k] % MOD;
                            }
                        }
                    }
                }
            }
            long ans = 0;
            for (int i = 0; i < 6; ++i) {
                ans = (ans + dp[now ^ 1][i][0]) % MOD;
            }
            return (int)ans;
        }

        public static int max(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.dieSimulator(1, new int[] {1, 1, 2, 2, 3, 3}));
        Assert.assertEquals(34, s.dieSimulator(2, new int[] {1, 1, 2, 2, 3, 3}));
        Assert.assertEquals(36, s.dieSimulator(2, new int[] {2, 2, 2, 2, 3, 3}));
        Assert.assertEquals(30, s.dieSimulator(2, new int[] {1, 1, 1, 1, 1, 1}));
        Assert.assertEquals(825, s.dieSimulator(4, new int[] {1, 1, 1, 1, 1, 2}));
        Assert.assertEquals(750, s.dieSimulator(4, new int[] {1, 1, 1, 1, 1, 1}));
        Assert.assertEquals(150, s.dieSimulator(3, new int[] {1, 1, 1, 1, 1, 1}));
        Assert.assertEquals(216, s.dieSimulator(3, new int[] {3, 3, 3, 3, 3, 3}));
        Assert.assertEquals(181, s.dieSimulator(3, new int[] {1, 1, 1, 2, 2, 3}));
        Assert.assertEquals(609169880, s.dieSimulator(5000, new int[] {10, 11, 524, 1000, 76, 123}));
    }

}
