package redo.p1900_1999;

public class P1997 {

    class Solution {
        public int firstDayBeenInAllRooms(int[] nextVisit) {
            int n = nextVisit.length;

            long[] dp = new long[n];
            dp[0] = 1;

            long mod = (long) 1e9 + 7;

            for (int i = 1; i < n; ++i) {
                dp[i] = (2 * dp[i - 1] - dp[nextVisit[i - 1]] + mod + 2) % mod;
            }

            return (int) ((dp[n - 1] - 1 + mod) % mod);
        }
    }

}
