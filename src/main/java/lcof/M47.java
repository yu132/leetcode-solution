package lcof;

/**  
 * @ClassName: M47  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月21日  
 *  
 */
public class M47 {

    class Solution {
        public int maxValue(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];

            for (int i = 0, sum = 0; i < grid.length; ++i) {
                sum      += grid[i][0];
                dp[i][0]  = sum;
            }

            for (int i = 0, sum = 0; i < grid[0].length; ++i) {
                sum      += grid[0][i];
                dp[0][i]  = sum;
            }

            for (int i = 1; i < grid.length; ++i) {
                for (int j = 1; j < grid[0].length; ++j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }

            return dp[grid.length - 1][grid[0].length - 1];
        }
    }

}
