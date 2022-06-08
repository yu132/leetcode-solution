package lcof;

/**  
 * @ClassName: M60  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月24日  
 *  
 */
public class M60 {

    class Solution {
        public double[] twoSum(int n) {

            int[][] dp = new int[n + 1][6 * n + 1];

            for (int i = 1; i <= 6; ++i) {
                dp[1][i] = 1;
            }

            for (int i = 2; i <= n; ++i) {
                for (int j = i; j <= 6 * i; ++j) {
                    for (int k = j - 6 >= 0 ? j - 6 : 0; k < j; ++k) {
                        dp[i][j] += dp[i - 1][k];
                    }
                }
            }

            int      sum = (int)Math.pow(6, n);

            double[] ans = new double[5 * n + 1];

            for (int i = n; i <= 6 * n; ++i) {
                ans[i - n] = (double)dp[n][i] / sum;
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        new M60().new Solution().twoSum(5);
    }

}
