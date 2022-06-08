package redo.p2000_2099;

import java.util.Arrays;

public class P2033 {

    class Solution {
        public int minOperations(int[][] grid, int x) {
            int[] flat = flatComplete1D(grid);
            Arrays.sort(flat);
            int ans = 0;
            for (int i = 0; i < flat.length; ++i) {
                if (Math.abs(flat[i] - flat[flat.length / 2]) % x != 0) {
                    return -1;
                }
                ans += Math.abs(flat[i] - flat[flat.length / 2]) / x;
            }
            return ans;
        }

        int[] flatComplete1D(int[][] arr) {
            if (arr.length == 0) {
                return new int[0];
            }
            int m = arr.length, n = arr[0].length;
            int[] flat = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    flat[i * n + j] = arr[i][j];
                }
            }
            return flat;
        }

    }

}
