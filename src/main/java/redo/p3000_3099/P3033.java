package redo.p3000_3099;

public class P3033 {

    class Solution {
        public int[][] modifiedMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            for (int j = 0; j < n; ++j) {
                int max = 0;
                for (int i = 0; i < m; ++i) {
                    max = Math.max(max, matrix[i][j]);
                }
                for (int i = 0; i < m; ++i) {
                    if (matrix[i][j] == -1) {
                        matrix[i][j] = max;
                    }
                }
            }
            return matrix;
        }
    }

}
