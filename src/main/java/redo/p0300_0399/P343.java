package redo.p0300_0399;

/**  
 * @ClassName: P343  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月4日  
 *  
 */
public class P343 {

    class Solution {
        public int integerBreak(int n) {
            return cuttingRope(n);
        }

        public int cuttingRope(int n) {
            int[] dp = new int[n + 1];

            for (int i = 2; i <= n; ++i) {
                for (int j = 1; j <= i / 2; ++j) {
                    int m1 = Math.max(j, dp[j]),
                        m2 = Math.max(i - j, dp[i - j]);
                    dp[i] = Math.max(dp[i], m1 * m2);
                }
            }

            return dp[n];
        }
    }

}
