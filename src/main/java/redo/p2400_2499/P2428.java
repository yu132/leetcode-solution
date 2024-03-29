package redo.p2400_2499;

public class P2428 {

    class Solution {
        public int maxSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int max = 0;
            for (int i = 0; i < m - 2; ++i) {
                for (int j = 0; j < n - 2; ++j) {
                    int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2]
                            + grid[i + 1][j + 1]
                            + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
                    max = Math.max(max, sum);
                }
            }
            return max;
        }
    }

}
