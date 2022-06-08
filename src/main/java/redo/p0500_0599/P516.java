package redo.p0500_0599;

public class P516 {

    class Solution {
        public int longestPalindromeSubseq(String s) {

            if (s.length() == 0) {
                return 0;
            }

            int n = s.length();

            int[][] dp = new int[n][n];

            for (int i = 0; i < n; ++i) {
                dp[i][i] = 1;
            }

            for (int i = 1; i < n; ++i) {
                for (int j = 0; j + i < n; ++j) {
                    if (s.charAt(j) == s.charAt(j + i)) {
                        dp[j][j + i] = dp[j + 1][j + i - 1] + 2;
                    } else {
                        dp[j][j + i] = Math.max(dp[j][j + i - 1], dp[j + 1][j + i]);
                    }
                }
            }

            return dp[0][n - 1];
        }
    }

}
