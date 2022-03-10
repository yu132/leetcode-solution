package redo.p2100_2199;

public class P2133 {

    class Solution {
        public boolean checkValid(int[][] matrix) {
            int n = matrix.length;
            boolean[][][] shown = new boolean[2][n + 1][n + 1];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    shown[0][i][matrix[i][j]] = true;
                    shown[1][j][matrix[i][j]] = true;
                }
            }
            for (int i = 0; i < 2; ++i) {
                for (int j = 1; j <= n; ++j) {
                    for (int k = 1; k <= n; ++k) {
                        if (!shown[i][j][k]) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

}
