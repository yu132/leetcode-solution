package redo.p2100_2199;

public class P2140 {

    class Solution {
        public long mostPoints(int[][] questions) {
            int n = questions.length;
            long[] dp = new long[n];
            for (int i = n - 1; i >= 0; --i) {
                dp[i] = Math.max(questions[i][0] + helper(dp, i + questions[i][1] + 1),
                        helper(dp, i + 1));
            }
            return dp[0];
        }

        long helper(long[] dp, int n) {
            if (n >= dp.length) {
                return 0;
            } else {
                return dp[n];
            }
        }
    }

}
