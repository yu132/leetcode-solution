package redo.p2900_2999;

import redo.testUtil.Arrs;

public class P2906 {

    class Solution {

        int mod = 12345;

        public int[][] constructProductMatrix(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[] left = new int[m * n + 1];
            left[0] = 1;
            int[] right = new int[m * n + 1];
            right[m * n] = 1;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    left[idxL(i, j, n)] = multiply(left[idxL(i, j, n) - 1], grid[i][j], mod);
                }
            }

            for (int i = m - 1; i >= 0; --i) {
                for (int j = n - 1; j >= 0; --j) {
                    right[idxR(i, j, n)] = multiply(right[idxR(i, j, n) + 1], grid[i][j], mod);
                }
            }

            int[][] ans = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    ans[i][j] = multiply(left[idxL(i, j, n) - 1], right[idxR(i, j, n) + 1], mod);
                }
            }

            return ans;
        }

        int idxL(int i, int j, int n) {
            return i * n + j + 1;
        }

        int idxR(int i, int j, int n) {
            return i * n + j;
        }

        int multiply(long a, long b, int mod) {
            return (int) (((a % mod) * (b % mod)) % mod);
        }

    }

    public static void main(String[] args) {
        new P2906().new Solution().constructProductMatrix(Arrs.build2D("[[12345],[2],[1]]"));
    }

}
