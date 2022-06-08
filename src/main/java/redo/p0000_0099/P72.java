package redo.p0000_0099;

/**  
 * @ClassName: P72  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P72 {

    class Solution {
        public int minDistance(String word1, String word2) {

            int m = word1.length(), n = word2.length();

            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; ++i) {
                dp[i][0] = i;
            }

            for (int j = 1; j <= n; ++j) {
                dp[0][j] = j;
            }

            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    dp[i][j] =
                        Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                            dp[i - 1][j - 1]
                                + (word1.charAt(i - 1) == word2.charAt(j - 1)
                                    ? 0 : 1));
                }
            }

            return dp[m][n];
        }
    }

}
