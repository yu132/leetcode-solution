package redo.p2900_2999;

public class P2965 {

    class Solution {
        public int[] findMissingAndRepeatedValues(int[][] grid) {
            int n = grid.length;
            boolean[] visited = new boolean[n * n + 1];
            int ans = -1;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (visited[grid[i][j]]) {
                        ans = grid[i][j];
                    } else {
                        visited[grid[i][j]] = true;
                    }
                }
            }
            for (int i = 1; i <= n * n; ++i) {
                if (!visited[i]) {
                    return new int[]{ans, i};
                }
            }
            return null;
        }
    }

}
