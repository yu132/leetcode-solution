package redo.p0000_0099;

/**  
 * @ClassName: P63  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P63 {

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            int m = obstacleGrid.length, n = obstacleGrid[0].length;

            int[] dp = new int[n];

            for (int j = 0; j < n; ++j) {
                if (obstacleGrid[0][j] == 0) {
                    dp[j] = 1;
                } else {
                    break;
                }
            }

            for (int i = 1; i < m; ++i) {
                if (obstacleGrid[i][0] == 1) {
                    dp[0] = 0;
                }
                for (int j = 1; j < n; ++j) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[j] = 0;
                    } else {
                        dp[j] += dp[j - 1];
                    }
                }
            }

            return dp[n - 1];
        }
    }

}
