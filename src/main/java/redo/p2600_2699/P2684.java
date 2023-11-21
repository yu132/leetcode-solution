package redo.p2600_2699;

public class P2684 {

    class Solution {

        int max = 0;

        public int maxMoves(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m][n];
            for (int j = 1; j < n; ++j) {
                helper(grid, dp, 0, j - 1, 0, j);
                helper(grid, dp, 1, j - 1, 0, j);
                for (int i = 1; i < m - 1; ++i) {
                    helper(grid, dp, i - 1, j - 1, i, j);
                    helper(grid, dp, i, j - 1, i, j);
                    helper(grid, dp, i + 1, j - 1, i, j);
                }
                helper(grid, dp, m - 2, j - 1, m - 1, j);
                helper(grid, dp, m - 1, j - 1, m - 1, j);
            }
            return max;
        }

        public void helper(int[][] grid, int[][] dp, int i, int j, int x, int y) {
            if (j != 0 && dp[i][j] == 0) {
                return;
            }
            if (grid[i][j] >= grid[x][y]) {
                return;
            }
            dp[x][y] = Math.max(dp[x][y], dp[i][j] + 1);
            max = Math.max(max, dp[x][y]);
        }
    }

    /*
    [187,167,209,251,152,236,263,128,135],
    [267,249,251,285,73,204,70,207,74],
    [189,159,235,66,84,89,153,111,189],
    [120,81,210,7,2,231,92,128,218],
    [193,131,244,293,284,175,226,205,245]]
     */

}
