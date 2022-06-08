package redo.p1900_1999;

import java.util.Arrays;

public class P1981 {

    class Solution {
        public int minimizeTheDifference(int[][] mat, int target) {

            int m = mat.length, n = mat[0].length;

            boolean[][] dp = new boolean[2][target];
            dp[0][0] = true;

            int minMax = Integer.MAX_VALUE;

            int roll = 1;

            for (int i = 0; i < m; ++i) {

                int nextMinMax = Integer.MAX_VALUE;

                for (int j = 0; j < n; ++j) {

                    int num = mat[i][j];

                    for (int k = 0; k < target; ++k) {

                        if (dp[roll ^ 1][k]) {
                            if (k + num >= target) {
                                nextMinMax = Math.min(nextMinMax, k + num);
                            } else {
                                dp[roll][k + num] = true;
                            }
                        }
                    }
                    if (minMax != Integer.MAX_VALUE) {
                        nextMinMax = Math.min(nextMinMax, minMax + num);
                    }
                }
                roll ^= 1;
                Arrays.fill(dp[roll], false);
                minMax = nextMinMax;
            }

            int min = Math.abs(minMax - target);
            for (int i = target - 1; i >= 0; --i) {
                if (dp[roll ^ 1][i]) {
                    min = Math.min(min, target - i);
                    break;
                }
            }

            return min;
        }
    }

}
