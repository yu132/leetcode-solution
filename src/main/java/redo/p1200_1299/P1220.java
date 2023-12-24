package redo.p1200_1299;

public class P1220 {

    class Solution {

        /*
         * a 0 |1
         * e 1 |02
         * i 2 |0134
         * o 3 |24
         * u 4 |0
         */
        public int countVowelPermutation(int n) {
            int[][] dp = new int[n][5];
            int[][] tr = new int[][]{{1}, {0, 2}, {0, 1, 3, 4}, {2, 4}, {0}};

            for (int i = 0; i < 5; ++i) {
                dp[0][i] = 1;
            }

            for (int i = 1; i < n; ++i) {
                for (int k = 0; k < 5; ++k) {
                    for (int t = 0; t < tr[k].length; ++t) {
                        dp[i][k] = add(dp[i][k], dp[i - 1][tr[k][t]]);
                    }
                }
            }

            int ans = 0;

            for (int i = 0; i < 5; ++i) {
                ans = add(ans, dp[n - 1][i]);
            }

            return ans;
        }

        public final static int MOD = 1_000_000_007;

        int add(long a, long b) {
            return (int) ((a % MOD + b % MOD) % MOD);
        }
    }

}
