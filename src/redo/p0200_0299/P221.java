package redo.p0200_0299;

/**  
 * @ClassName: P221  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P221 {

    class Solution {
        public int maximalSquare(char[][] matrix) {

            if (matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }

            int m = matrix.length, n = matrix[0].length;

            int[][] dp = new int[m + 1][n + 1];

            int max = 0;

            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[i][j] =
                            1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
                                dp[i - 1][j - 1]);
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }

            return max * max;
        }
    }

}
