package redo.p1200_1299;

public class P1269 {

    class Solution {
        public int numWays(int steps, int arrLen) {
            int[][] dp = new int[2][Math.min(steps / 2 + 1, arrLen) + 2];
            dp[0][1] = 1;
            int roll = 1;
            for (int i = 0; i < steps; ++i, roll ^= 1) {
                for (int j = 1; j < dp[0].length - 1; ++j) {
                    dp[roll][j] = add(dp[roll ^ 1][j - 1], add(dp[roll ^ 1][j], dp[roll ^ 1][j + 1]));
                }
            }
            return dp[roll ^ 1][1];
        }

        public final static int MOD = 1_000_000_007;

        int add(long a, long b) {
            return (int) ((a % MOD + b % MOD) % MOD);
        }
    }

    public static void main(String[] args) {
        new P1269().new Solution().numWays(3, 2);
    }

}
