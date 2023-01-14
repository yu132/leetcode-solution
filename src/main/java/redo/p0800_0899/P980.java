package redo.p0800_0899;

public class P980 {

    class Solution {

        int[][] grid;
        boolean[][] visited;
        int ans;
        int m, n;
        int count0;

        public int uniquePathsIII(int[][] grid) {
            this.grid = grid;
            ans = 0;
            m = grid.length;
            n = grid[0].length;
            visited = new boolean[m][n];

            int startX = 0, startY = 0;

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 0) {
                        ++count0;
                    } else if (grid[i][j] == 1) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            backtrack(startX, startY, 1);

            return ans;
        }

        void backtrack(int x, int y, int visitCount) {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return;
            }
            if (grid[x][y] == 2) {
                if (visitCount == count0 + 2) {
                    ++ans;
                }
                return;
            }
            if (grid[x][y] == -1) {
                return;
            }
            if (visited[x][y]) {
                return;
            }
            visited[x][y] = true;
            backtrack(x + 1, y, visitCount + 1);
            backtrack(x - 1, y, visitCount + 1);
            backtrack(x, y + 1, visitCount + 1);
            backtrack(x, y - 1, visitCount + 1);
            visited[x][y] = false;
        }
    }

}
