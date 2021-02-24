package redo.p0300_0399;

/**  
 * @ClassName: P329  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P329 {

    class Solution {

        int[][] dp;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            int m = matrix.length, n = matrix[0].length, max = 0;
            dp = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    max = Math.max(max, dfs(i, j, m, n, -1, matrix));
                }
            }
            return max;
        }

        int dfs(int i, int j, int m, int n, int last, int[][] matrix) {
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return 0;
            }
            if (matrix[i][j] <= last) {
                return 0;
            }
            if (dp[i][j] == 0) {
                int count = 0;
                count =
                    Math.max(count, dfs(i + 1, j, m, n, matrix[i][j], matrix));
                count =
                    Math.max(count, dfs(i - 1, j, m, n, matrix[i][j], matrix));
                count =
                    Math.max(count, dfs(i, j + 1, m, n, matrix[i][j], matrix));
                count =
                    Math.max(count, dfs(i, j - 1, m, n, matrix[i][j], matrix));
                dp[i][j] = count + 2;
            }
            return dp[i][j] - 1;
        }
    }

}
