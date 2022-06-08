package _0800_0899;

/**  
 * @ClassName: _807  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月3日  
 *  
 */
public class _807 {

    class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {

            int[] x = new int[grid.length], y = new int[grid[0].length];

            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    if (grid[i][j] > x[i]) {
                        x[i] = grid[i][j];
                    }
                    if (grid[i][j] > y[j]) {
                        y[j] = grid[i][j];
                    }
                }
            }

            int ans = 0;

            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    ans += Math.min(x[i], y[j]) - grid[i][j];
                }
            }

            return ans;
        }
    }

}
