package redo.p0200_0299;

/**  
 * @ClassName: P200  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P200 {

    class Solution {
        public int numIslands(char[][] grid) {

            if (grid.length == 0 || grid[0].length == 0) {
                return 0;
            }

            int count = 0;

            int m = grid.length, n = grid[0].length;

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        ++count;
                        dfs(i, j, m, n, grid);
                    }
                }
            }

            return count;
        }

        void dfs(int x, int y, int m, int n, char[][] grid) {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return;
            }
            if (grid[x][y] != '1') {
                return;
            }
            grid[x][y] = 2;
            dfs(x + 1, y, m, n, grid);
            dfs(x - 1, y, m, n, grid);
            dfs(x, y + 1, m, n, grid);
            dfs(x, y - 1, m, n, grid);
        }
    }

}
