package lcci.M08;

/**  
 * @ClassName: M08_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月3日  
 *  
 */
public class M08_01 {

    class Solution {
        public int waysToStep(int n) {

            int[] dp = new int[Math.max(4, n + 1)];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= n; ++i) {
                dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000007 + dp[i - 3]) % 1000000007;
            }

            return dp[n];
        }
    }

}
