package redo.p1900_1999;

public class P1975 {

    class Solution {
        public long maxMatrixSum(int[][] matrix) {
            long total = 0, min = Integer.MAX_VALUE, countPos = 0;

            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[0].length; ++j) {
                    total += Math.abs(matrix[i][j]);
                    min = Math.min(min, Math.abs(matrix[i][j]));
                    if (matrix[i][j] < 0) {
                        ++countPos;
                    }
                }
            }

            if (countPos % 2 == 0) {
                return total;
            } else {
                return total - 2 * min;
            }
        }
    }

}
