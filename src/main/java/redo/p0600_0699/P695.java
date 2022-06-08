package redo.p0600_0699;

/**  
 * @ClassName: P695  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月23日  
 *  
 */
public class P695 {

    class Solution {
        public int maxAreaOfIsland(int[][] grid) {

            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }

            int m = grid.length, n = grid[0].length;

            int max = 0;

            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (visited[i][j]) {
                        continue;
                    }
                    max = Math.max(max, dfs(i, j, m, n, grid, visited));
                }
            }

            return max;
        }

        int dfs(int x, int y, int m, int n, int[][] grid, boolean[][] visited) {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return 0;
            }
            if (visited[x][y]) {
                return 0;
            }
            visited[x][y] = true;
            if (grid[x][y] == 0) {
                return 0;
            }
            int count = 1;
            count += dfs(x + 1, y, m, n, grid, visited);
            count += dfs(x - 1, y, m, n, grid, visited);
            count += dfs(x, y + 1, m, n, grid, visited);
            count += dfs(x, y - 1, m, n, grid, visited);
            return count;
        }
    }

}
