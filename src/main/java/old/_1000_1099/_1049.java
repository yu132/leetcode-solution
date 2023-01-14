package old._1000_1099;

/**  
 * @ClassName: _1049  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月9日  
 *  
 */
public class _1049 {

    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int sum = 0;
            for (int each : stones) {
                sum += each;
            }
            int[] dp = new int[sum / 2 + 1];
            for (int i = 0; i < stones.length; ++i) {
                for (int j = sum / 2; j >= stones[i]; --j) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }
            return sum - 2 * dp[sum / 2];
        }
    }

}
