package redo.p2900_2999;

public class P2930 {

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int stringCount(int n) {
            long[][][][] dp = new long[n + 1][2][3][2];
            dp[0][0][0][0] = 1;
            for (int i = 1; i <= n; ++i) {
                // l
                for (int e = 0; e <= 2; ++e) {
                    for (int t = 0; t <= 1; ++t) {
                        dp[i][1][e][t] = add(dp[i][1][e][t], dp[i - 1][0][e][t], dp[i - 1][1][e][t]);
                    }
                }
                // e
                for (int l = 0; l <= 1; ++l) {
                    for (int t = 0; t <= 1; ++t) {
                        dp[i][l][1][t] = add(dp[i][l][1][t], dp[i - 1][l][0][t]);
                    }
                }
                for (int l = 0; l <= 1; ++l) {
                    for (int t = 0; t <= 1; ++t) {
                        dp[i][l][2][t] = add(dp[i][l][2][t], dp[i - 1][l][1][t], dp[i - 1][l][2][t]);
                    }
                }
                // t
                for (int e = 0; e <= 2; ++e) {
                    for (int l = 0; l <= 1; ++l) {
                        dp[i][l][e][1] = add(dp[i][l][e][1], dp[i - 1][l][e][1], dp[i - 1][l][e][0]);
                    }
                }
                // else
                for (int e = 0; e <= 2; ++e) {
                    for (int l = 0; l <= 1; ++l) {
                        for (int t = 0; t <= 1; ++t) {
                            dp[i][l][e][t] = add(dp[i][l][e][t], 23 * dp[i - 1][l][e][t]);
                        }
                    }
                }
            }
            return (int) dp[n][1][2][1];
        }

        int add(long... a) {
            long ans = 0;
            for (long num : a) {
                ans += num;
            }
            return (int) (ans % MOD);
        }

    }

    public static void main(String[] args) {
        new P2930().new Solution().stringCount(4);
    }

}
