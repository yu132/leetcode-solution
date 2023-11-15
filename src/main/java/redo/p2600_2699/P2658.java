package redo.p2600_2699;

public class P2658 {

    class Solution {
        public int findMaxFish(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int ans = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    ans = Math.max(ans, dfs(i, j, m, n, grid));
                }
            }
            return ans;
        }

        int dfs(int i, int j, int m, int n, int[][] grid) {
            if (i < 0 || i >= m || j < 0 || j >= n) {
                return 0;
            }
            if (grid[i][j] <= 0) {
                return 0;
            }
            int ans = grid[i][j];
            grid[i][j] = -1;
            ans += dfs(i + 1, j, m, n, grid);
            ans += dfs(i - 1, j, m, n, grid);
            ans += dfs(i, j + 1, m, n, grid);
            ans += dfs(i, j - 1, m, n, grid);
            return ans;
        }
    }

}
