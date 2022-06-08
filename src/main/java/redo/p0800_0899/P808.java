package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P808  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月1日  
 *  
 */
public class P808 {

    class Solution {
        public double soupServings(int N) {
            if (N >= 4800) {
                return 1.0;
            }
            N = (int)Math.ceil(N / 25.0);
            double[][] dp = new double[N + 1][N + 1];
            dp[0][0] = 0.5;
            for (int i = 1; i <= N; ++i) {
                dp[0][i] = 1;
            }
            for (int i = 1; i <= N; ++i) {
                int i1 = Math.max(i - 1, 0), i2 = Math.max(i - 2, 0),
                    i3 = Math.max(i - 3, 0), i4 = Math.max(i - 4, 0);
                for (int j = 1; j <= N; ++j) {
                    int j1 = Math.max(j - 3, 0), j2 = Math.max(j - 2, 0),
                        j3 = Math.max(j - 1, 0), j4 = Math.max(j, 0);

                    dp[i][j] = 0.25
                        * (dp[i1][j1] + dp[i2][j2] + dp[i3][j3] + dp[i4][j4]);
                }
            }

            return dp[N][N];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0.625, s.soupServings(50), 0.00001);
    }

}
