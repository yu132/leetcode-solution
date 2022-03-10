package redo.p1900_1999;

public class P1995 {

    class Solution {
        public int countQuadruplets(int[] nums) {
            int[][] dp = new int[4][101];

            dp[0][0] = 1;

            int ans = 0;

            for (int num : nums) {
                ans += dp[3][num];
                for (int i = 3; i >= 1; --i) {
                    for (int j = 100; j >= num; --j) {
                        dp[i][j] += dp[i - 1][j - num];
                    }
                }
            }

            return ans;
        }
    }

}
