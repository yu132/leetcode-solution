package redo.p2400_2499;

public class P2466 {

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int countGoodStrings(int low, int high, int zero, int one) {
            int[] dp = new int[high + 1];
            dp[0] = 1;
            int ans = 0;
            for (int i = 1; i <= high; ++i) {
                if (i - zero >= 0) {
                    dp[i] = add(dp[i], dp[i - zero], MOD);
                }
                if (i - one >= 0) {
                    dp[i] = add(dp[i], dp[i - one], MOD);
                }
                if (i >= low) {
                    ans = add(ans, dp[i], MOD);
                }
            }
            return ans;
        }

        int add(long a, long b, int mod) {
            return (int) ((a % mod + b % mod) % mod);
        }

    }

}
