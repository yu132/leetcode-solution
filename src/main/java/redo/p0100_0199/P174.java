package redo.p0100_0199;

import redo.testUtil.Arrs;

public class P174 {

    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length, n = dungeon[0].length;
            int[][] dp = new int[m][n];

            for (int i = m - 1; i >= 0; --i) {
                for (int j = n - 1; j >= 0; --j) {
                    if (j == n - 1 && i == m - 1) {
                        dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                    } else if (j == n - 1) {
                        dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                    } else if (i == m - 1) {
                        dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                    } else {
                        dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
                    }
                }
            }

            return dp[0][0];
        }
    }

    public static void main(String[] args) {
        new P174().new Solution().calculateMinimumHP(Arrs.build2D("[[-2,-3,3],[-5,-10,1],[10,30,-5]]"));
    }

}
