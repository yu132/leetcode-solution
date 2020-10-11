package _1100_1199;

/**  
 * @ClassName: _1162  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月6日  
 *  
 */
public class _1162 {

    class Solution {
        public int maxDistance(int[][] grid) {
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (grid[i][j] == 1) {
                        dfs(i + 1, j, 2, grid);
                        dfs(i - 1, j, 2, grid);
                        dfs(i, j + 1, 2, grid);
                        dfs(i, j - 1, 2, grid);
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    max = Math.max(max, grid[i][j]);
                }
            }

            return max == 1 ? -1 : max - 1;
        }

        public void dfs(int x, int y, int dis, int[][] grid) {
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
                return;
            }
            if (grid[x][y] != 0 && grid[x][y] <= dis) {
                return;
            }
            grid[x][y] = dis;

            dfs(x + 1, y, dis + 1, grid);
            dfs(x - 1, y, dis + 1, grid);
            dfs(x, y + 1, dis + 1, grid);
            dfs(x, y - 1, dis + 1, grid);
        }
    }

}
