package redo.p0300_0399;

import java.util.Arrays;

/**  
 * @ClassName: P322  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P322 {

    class Solution {
        public int coinChange(int[] coins, int amount) {
            double[] dp = new double[amount + 1];
            Arrays.fill(dp, Double.POSITIVE_INFINITY);
            dp[0] = 0;
            for (int i = 0; i < coins.length; ++i) {
                for (int j = coins[i]; j <= amount; ++j) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
            if (dp[amount] == Double.POSITIVE_INFINITY) {
                return -1;
            }
            return (int)dp[amount];
        }
    }

}
