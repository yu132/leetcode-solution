package _0800_0899;

/**  
 * @ClassName: _808  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月3日  
 *  
 */
public class _808 {

    class Solution {
        public double soupServings(int N) {

            if (N >= 4800) {
                return 1.0;
            }

            int        n  = (int)Math.ceil(N / 25.0);

            double[][] dp = new double[n + 1][n + 1];

            dp[0][0] = 0.5;

            for (int i = 1; i <= n; ++i) {
                dp[i][0] = 0;
                dp[0][i] = 1;
            }

            for (int i = 1; i <= n; ++i) {
                int x1 = i - 4 > 0 ? i - 4 : 0;
                int x2 = i - 3 > 0 ? i - 3 : 0;
                int x3 = i - 2 > 0 ? i - 2 : 0;
                int x4 = i - 1 > 0 ? i - 1 : 0;
                for (int j = 1; j <= n; ++j) {
                    int y1 = j;
                    int y2 = j - 1 > 0 ? j - 1 : 0;
                    int y3 = j - 2 > 0 ? j - 2 : 0;
                    int y4 = j - 3 > 0 ? j - 3 : 0;
                    dp[i][j] = 0.25 * (dp[x1][y1] + dp[x2][y2] + dp[x3][y3] + dp[x4][y4]);
                }
            }

            return dp[n][n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new _808().new Solution().soupServings(50));
    }
}
