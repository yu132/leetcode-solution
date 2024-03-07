package redo.p0600_0699;

public class P600 {

    class Solution {
        public int findIntegers(int n) {
            int[][] dp = new int[31][2];
            int max = 0;
            dp[30][1] = 0;
            dp[30][0] = 1;
            boolean p1 = false;
            for (int i = 29; i >= 0; --i) {
                if (max + (1 << i) <= n) {
                    if (p1) {
                        dp[i][1] = dp[i + 1][0];
                        dp[i][0] = dp[i + 1][0] + dp[i + 1][1];
                    } else {
                        max = max + (1 << i);
                        dp[i][1] = dp[i + 1][0];
                        dp[i][0] = dp[i + 1][0] + dp[i + 1][1];
                    }
                    p1 = true;
                } else {
                    if (p1) {
                        dp[i][1] = dp[i + 1][0];
                        dp[i][0] = dp[i + 1][0] + dp[i + 1][1];
                    } else {
                        dp[i][1] = dp[i + 1][0] - 1;
                        dp[i][0] = dp[i + 1][0] + dp[i + 1][1];
                    }
                    p1 = false;
                }
            }
            return dp[0][0] + dp[0][1];
        }
    }
    /*
     *  000
     *  001
     *  010
     *  100
     *  101
     */

    public static void main(String[] args) {
        System.out.println(new P600().new Solution().findIntegers(5));
    }

}
