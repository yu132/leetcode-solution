package redo.p2500_2599;

public class P2536 {

    class Solution {
        public int[][] rangeAddQueries(int n, int[][] queries) {
            int[][] ans = new int[n][n];
            for (int[] query : queries) {
                int x1 = query[0], y1 = query[1];
                int x2 = query[2], y2 = query[3];
                ++ans[x1][y1];
                if (y2 + 1 < n) {
                    --ans[x1][y2 + 1];
                }
                if (x2 + 1 < n) {
                    --ans[x2 + 1][y1];
                }
                if (y2 + 1 < n && x2 + 1 < n) {
                    ++ans[x2 + 1][y2 + 1];
                }
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    int xL = i == 0 ? 0 : ans[i - 1][j];
                    int yL = j == 0 ? 0 : ans[i][j - 1];
                    int xyL = i == 0 || j == 0 ? 0 : ans[i - 1][j - 1];
                    ans[i][j] += xL + yL - xyL;
                }
            }
            return ans;
        }
    }

}
