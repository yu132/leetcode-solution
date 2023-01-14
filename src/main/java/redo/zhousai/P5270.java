package redo.zhousai;

public class P5270 {

    class Solution {
        public int minPathCost(int[][] grid, int[][] moveCost) {
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < n; ++i) {
                dp[0][i] = grid[0][i];
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < n; ++k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j]);
                    }
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                ans = Math.min(dp[m - 1][i], ans);
            }
            return ans;
        }
    }

}
