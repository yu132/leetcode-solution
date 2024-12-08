package redo.p2300_2399;

public class P2373 {

    class Solution {
        public int[][] largestLocal(int[][] grid) {

            int[][] dirs = new int[][]{{0, 0}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, -1}};

            int m = grid.length;
            int n = grid[0].length;
            int[][] ans = new int[m - 2][n - 2];
            for (int i = 1; i < m - 1; ++i) {
                for (int j = 1; j < n - 1; ++j) {
                    for (int[] dir : dirs) {
                        ans[i - 1][j - 1] = Math.max(ans[i - 1][j - 1], grid[i + dir[0]][j + dir[1]]);
                    }
                }
            }
            return ans;
        }
    }

}
