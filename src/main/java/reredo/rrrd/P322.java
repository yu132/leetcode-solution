package reredo.rrrd;

import java.util.Arrays;

/**  
 * @ClassName: P322  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月24日  
 *  
 */
public class P322 {

    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int coin : coins) {
                for (int j = coin; j <= amount; ++j) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
            if (dp[amount] > amount) {
                return -1;
            }
            return dp[amount];
        }
    }

}
