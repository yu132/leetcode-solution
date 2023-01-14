package old._0600_0699;

/**  
 * @ClassName: _651  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _651 {

    class Solution {
        public int maxA(int N) {
            if (N <= 5) {
                return N;
            }
            int[] dp = new int[N];
            dp[0] = 1;
            dp[1] = 2;
            dp[2] = 3;
            dp[3] = 4;
            dp[4] = 5;
            for (int i = 5; i < N; ++i) {
                dp[i] = Math.max(3 * dp[i - 4], 4 * dp[i - 5]);
            }
            return dp[N - 1];
        }
    }

}
