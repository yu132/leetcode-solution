package redo.p1700_1799;

public class P1765 {

    class Solution {

        public int[][] highestPeak(int[][] isWater) {
            reverse(isWater);
            return updateMatrix(isWater);
        }

        void reverse(int[][] isWater) {
            for (int i = 0; i < isWater.length; ++i) {
                for (int j = 0; j < isWater[0].length; ++j) {
                    isWater[i][j] ^= 1;
                }
            }
        }

        public int[][] updateMatrix(int[][] mat) {

            final int INF = Integer.MAX_VALUE / 2;

            int m = mat.length, n = mat[0].length;

            int[][] ans = new int[m][n];

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (mat[i][j] == 0) {
                        continue;
                    }
                    ans[i][j] = min(i == 0 ? INF : ans[i - 1][j] + 1, j == 0 ? INF : ans[i][j - 1] + 1);
                }
                for (int j = n - 1; j >= 0; --j) {
                    if (mat[i][j] == 0) {
                        continue;
                    }
                    ans[i][j] = min(ans[i][j], j == n - 1 ? INF : ans[i][j + 1] + 1);
                }
            }

            for (int i = m - 1; i >= 0; --i) {
                for (int j = 0; j < n; ++j) {
                    if (mat[i][j] == 0) {
                        continue;
                    }
                    ans[i][j] = min(ans[i][j], i == m - 1 ? INF : ans[i + 1][j] + 1, j == 0 ? INF : ans[i][j - 1] + 1);
                }
                for (int j = n - 1; j >= 0; --j) {
                    if (mat[i][j] == 0) {
                        continue;
                    }
                    ans[i][j] = min(ans[i][j], j == n - 1 ? INF : ans[i][j + 1] + 1);
                }
            }

            return ans;
        }

        int min(int... nums) {
            int ans = Integer.MAX_VALUE;
            for (int num : nums) {
                ans = Math.min(ans, num);
            }
            return ans;
        }


    }


}
