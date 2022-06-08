package redo.p2100_2199;

public class P2101 {

    class Solution {
        public int maximumDetonation(int[][] bombs) {
            int n = bombs.length;
            boolean[][] graph = new boolean[n][n];
            for (int i = 0; i < n; ++i) {
                graph[i][i] = true;
                for (int j = i + 1; j < n; ++j) {
                    int x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
                    int x2 = bombs[j][0], y2 = bombs[j][1], r2 = bombs[j][2];
                    long dis = ((long) x1 - x2) * ((long) x1 - x2) + ((long) y1 - y2) * ((long) y1 - y2);
                    if (dis <= (long) r1 * r1) {
                        graph[i][j] = true;
                    }
                    if (dis <= (long) r2 * r2) {
                        graph[j][i] = true;
                    }
                }
            }
            for (int k = 0; k < n; ++k) {
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        if (graph[i][k] && graph[k][j]) {
                            graph[i][j] = true;
                        }
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < n; ++i) {
                int sum = 0;
                for (int j = 0; j < n; ++j) {
                    if (graph[i][j]) {
                        ++sum;
                    }
                    max = Math.max(max, sum);
                }
            }

            return max;
        }
    }

}
