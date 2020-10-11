package _0300_0399;

/**  
 * @ClassName: _304  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月21日  
 *  
 */
public class _304 {

    class NumMatrix {

        int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                dp = null;
                return;
            }

            dp = matrix;

            for (int j = 1; j < dp[0].length; ++j) {
                dp[0][j] += dp[0][j - 1];
            }

            for (int i = 1; i < dp.length; ++i) {
                dp[i][0] += dp[i - 1][0];
                for (int j = 1; j < dp[i].length; ++j) {
                    dp[i][j] += dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (dp == null) {
                return 0;
            }
            return dp[row2][col2] - (col1 != 0 ? dp[row2][col1 - 1] : 0) - (row1 != 0 ? dp[row1 - 1][col2] : 0)
                + (row1 != 0 && col1 != 0 ? dp[row1 - 1][col1 - 1] : 0);
        }
    }

}
