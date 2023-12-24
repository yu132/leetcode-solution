package redo.p0500_0599;

public class P552 {

    class Solution {
        public int checkRecord(int n) {
            //      p   l   ll  a   al  all
            //  a   a   a   a   X   X   X
            //  l   l   ll  X   al  all X
            //  p   p   p   p   a   a   a
            // 0 p = p + l + ll
            // 1 l = p
            // 2 ll = l
            // 3 a = p + l + ll + al + all + a
            // 4 al = a
            // 5 all = al

            int[][] dp = new int[2][6];
            dp[0][0] = dp[0][1] = dp[0][3] = 1;
            int roll = 1;
            for (int i = 1; i < n; ++i, roll ^= 1) {
                dp[roll][0] = add(dp[roll ^ 1][0], dp[roll ^ 1][1], dp[roll ^ 1][2]);
                dp[roll][1] = dp[roll ^ 1][0];
                dp[roll][2] = dp[roll ^ 1][1];
                dp[roll][3] = add(dp[roll ^ 1][0], dp[roll ^ 1][1], dp[roll ^ 1][2], dp[roll ^ 1][3], dp[roll ^ 1][4], dp[roll ^ 1][5]);
                dp[roll][4] = dp[roll ^ 1][3];
                dp[roll][5] = dp[roll ^ 1][4];
            }

            return add(dp[roll ^ 1][0], dp[roll ^ 1][1], dp[roll ^ 1][2], dp[roll ^ 1][3], dp[roll ^ 1][4], dp[roll ^ 1][5]);
        }

        public final static int MOD = 1_000_000_007;

        int add(int... a) {
            long ans = 0;
            for (long num : a) {
                ans += num;
            }
            return (int) (ans % MOD);
        }
    }

    public static void main(String[] args) {
        new P552().new Solution().checkRecord(2);
    }

}
