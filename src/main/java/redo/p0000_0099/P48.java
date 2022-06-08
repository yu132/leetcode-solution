package redo.p0000_0099;

public class P48 {

    class Solution {
        public void rotate(int[][] matrix) {
            transposition(matrix);
            reversse(matrix);
        }

        public void transposition(int[][] matrix) {
            int n = matrix.length;
            for (int i = 1; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    int temp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        }

        public void reversse(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n / 2; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = temp;
                }
            }
        }
    }


}
