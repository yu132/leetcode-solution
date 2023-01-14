package old._0200_0299;

/**  
 * @ClassName: _276  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月26日  
 *  
 */
public class _276 {

    class Solution {
        public int numWays(int n, int k) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return k;
            } else if (n == 2) {
                return k * k;
            }

            int[] dp = new int[n];

            dp[0] = k;
            dp[1] = k * k;

            for (int i = 2; i < n; ++i) {
                dp[i] = (dp[i - 2] + dp[i - 1]) * (k - 1);
            }

            return dp[n - 1];
        }
    }

}
