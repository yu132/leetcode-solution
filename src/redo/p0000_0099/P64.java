package redo.p0000_0099;

/**  
 * @ClassName: P64  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月25日  
 *  
 */
public class P64 {

    class Solution {
        public int minPathSum(int[][] grid) {

            int m = grid.length, n = grid[0].length;

            for (int j = 1; j < n; ++j) {
                grid[0][j] += grid[0][j - 1];
            }

            for (int i = 1; i < m; ++i) {
                grid[i][0] += grid[i - 1][0];
                for (int j = 1; j < n; ++j) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }

            return grid[m - 1][n - 1];
        }
    }

}
