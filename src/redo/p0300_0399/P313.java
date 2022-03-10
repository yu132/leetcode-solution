package redo.p0300_0399;

/**  
 * @ClassName: P313  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P313 {

    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {

            int m = primes.length;

            int[] indexes = new int[m];

            int[] dp = new int[n];

            dp[0] = 1;

            for (int i = 1; i < n; ++i) {
                int min = Integer.MAX_VALUE;

                for (int j = 0; j < m; ++j) {
                    min = Math.min(min, primes[j] * dp[indexes[j]]);
                }

                dp[i] = min;

                for (int j = 0; j < m; ++j) {
                    if (primes[j] * dp[indexes[j]] == dp[i]) {
                        ++indexes[j];
                    }
                }
            }

            return dp[n - 1];
        }
    }

}
