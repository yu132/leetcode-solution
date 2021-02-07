package redo.offer;

/**  
 * @ClassName: P47  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P47 {

    class Solution {
        public int maxValue(int[][] grid) {
            int m = grid.length, n = grid[0].length;

            for (int j = 1; j < n; ++j) {
                grid[0][j] += grid[0][j - 1];
            }

            for (int i = 1; i < m; ++i) {
                grid[i][0] += grid[i - 1][0];
                for (int j = 1; j < n; ++j) {
                    grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
            }

            return grid[m - 1][n - 1];
        }
    }

}
