package redo.p2900_2999;

public class P2946 {

    class Solution {
        public boolean areSimilar(int[][] mat, int k) {
            int m = mat.length, n = mat[0].length;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (mat[i][j] != mat[i][(j + k) % n]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
