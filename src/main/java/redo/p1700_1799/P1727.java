package redo.p1700_1799;

import java.util.Arrays;

public class P1727 {

    class Solution {
        public int largestSubmatrix(int[][] matrix) {

            int m = matrix.length, n = matrix[0].length;

            for (int i = 1; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == 1) {
                        matrix[i][j] += matrix[i - 1][j];
                    }
                }
            }

            int ans = 0;

            for (int i = 0; i < m; ++i) {
                Arrays.sort(matrix[i]);
                for (int j = n - 1; j >= 0; --j) {
                    ans = Math.max(ans, matrix[i][j] * (n - j));
                }
            }

            return ans;
        }
    }

}
