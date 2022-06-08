package redo.p1900_1999;

import java.util.Arrays;

public class P1959 {

    class Solution {
        public int minSpaceWastedKResizing(int[] nums, int k) {

            int n = nums.length;

            int[][] g = new int[n][n];

            for (int i = 0; i < n; ++i) {

                int max = nums[i], sum = 0;

                for (int j = i; j < n; ++j) {
                    max = Math.max(max, nums[j]);
                    sum += nums[j];
                    g[i][j] = max * (j - i + 1) - sum;
                }
            }

            int[][] dp = new int[n][k + 2];

            for (int i = 0; i < n; ++i) {
                Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            }

            for (int i = 0; i < n; ++i) {
                for (int j = 1; j <= k + 1; ++j) {
                    for (int i0 = 0; i0 <= i; ++i0) {
                        dp[i][j] = Math.min(dp[i][j], (i0 == 0 ? 0 : dp[i0 - 1][j - 1]) + g[i0][i]);
                    }
                }
            }

            return dp[n - 1][k + 1];
        }
    }

}
