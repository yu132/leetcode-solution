package redo.p1900_1999;

import java.util.ArrayList;
import java.util.List;

public class P1992 {

    class Solution {
        public int[][] findFarmland(int[][] land) {
            List<int[]> ans = new ArrayList<>();

            int m = land.length, n = land[0].length;

            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (land[i][j] == 0) {
                        continue;
                    }
                    if (visited[i][j]) {
                        continue;
                    }
                    int x = i, y = j;
                    while (x < m - 1 && land[x + 1][j] == 1) {
                        ++x;
                    }
                    while (y < n - 1 && land[i][y + 1] == 1) {
                        ++y;
                    }
                    for (int a = i; a <= x; ++a) {
                        for (int b = j; b <= y; ++b) {
                            visited[a][b] = true;
                        }
                    }
                    ans.add(new int[]{i, j, x, y});
                }
            }
            return ans.toArray(new int[0][]);
        }
    }

}
