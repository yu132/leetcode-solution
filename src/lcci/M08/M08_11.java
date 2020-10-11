package lcci.M08;

/**  
 * @ClassName: M08_11  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月6日  
 *  
 */
public class M08_11 {

    class Solution {
        public int waysToChange(int n) {
            int[] dp    = new int[n + 1];
            int[] coins = {1, 5, 10, 25};

            for (int i = 0; i <= n; ++i) {
                dp[i] = 1;
            }

            for (int i = 1; i < 4; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (j >= coins[i]) {
                        dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
                    }
                }
            }
            return dp[n];
        }
    }

}
