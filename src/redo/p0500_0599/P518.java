package redo.p0500_0599;

/**  
 * @ClassName: P518  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P518 {

    class Solution {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int i = 0; i < coins.length; ++i) {
                for (int j = coins[i]; j <= amount; ++j) {
                    dp[j] += dp[j - coins[i]];
                }
            }
            return dp[amount];
        }
    }

}
