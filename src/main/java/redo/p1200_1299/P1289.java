package redo.p1200_1299;

public class P1289 {

    class Solution {
        public int minFallingPathSum(int[][] grid) {
            int n = grid.length;
            int[][] dp = new int[2][n];
            for (int i = 0; i < n; ++i) {
                dp[0][i] = grid[0][i];
            }
            int roll = 1;
            for (int i = 1; i < n; ++i, roll ^= 1) {
                int[] min2 = min2(dp[roll ^ 1]);
                for (int j = 0; j < n; ++j) {
                    if (dp[roll ^ 1][j] == min2[0]) {
                        dp[roll][j] = min2[1] + grid[i][j];
                    } else {
                        dp[roll][j] = min2[0] + grid[i][j];
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                min = Math.min(min, dp[roll ^ 1][i]);
            }
            return min;
        }

        public int[] min2(int[] nums) {
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

            for (int num : nums) {
                if (num <= min1) {
                    min2 = min1;
                    min1 = num;
                } else if (num < min2) {
                    min2 = num;
                }
            }

            return new int[]{min1, min2};
        }
    }

}
