package redo.p2000_2099;

public class P2022 {

    class Solution {
        public int[][] construct2DArray(int[] original, int m, int n) {
            if (original.length != m * n) {
                return new int[0][];
            }
            int[][] arr = new int[m][n];
            for (int i = 0, x = 0; i < m && x < original.length; ++i) {
                for (int j = 0; j < n; ++j, ++x) {
                    arr[i][j] = original[x];
                }
            }
            return arr;
        }
    }

}
