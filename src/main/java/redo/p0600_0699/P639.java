package redo.p0600_0699;

import java.util.Arrays;

public class P639 {

    /**
     * _____1	    2	    3to9	xx
     * 0	xx	    xx	    ng	    ng
     * 1	1, xx	1, xx	1	    1
     * 2	2, xx	2, xx	2	    2
     * 3	3, xx	3, xx	3	    3
     * 4	4, xx	4, xx	4	    4
     * 5	5, xx	5, xx	5	    5
     * 6	6, xx	6, xx	6	    6
     * 7	7, xx	7	    7	    7
     * 8	8, xx	8	    8	    8
     * 9	9, xx	9	    9	    9
     */

    class Solution {
        public int numDecodings(String s) {
            int[] dp = new int[11];
            if (s.charAt(0) == '*') {
                Arrays.fill(dp, 1);
                dp[10] = 0;
                dp[0] = 0;
            } else if (s.charAt(0) != '0') {
                dp[s.charAt(0) - '0'] = 1;
            }
            for (int i = 1; i < s.length(); ++i) {
                int[] newDp = new int[11];
                int now = s.charAt(i) - '0';
                if (now == 0) {
                    newDp[10] = add(dp[1], dp[2]);
                    if (newDp[10] == 0) {
                        return 0;
                    }
                } else if (0 < now && now <= 6) {
                    for (int j = 1; j < 11; ++j) {
                        newDp[now] = add(newDp[now], dp[j]);
                    }
                    newDp[10] = add(dp[1], dp[2]);
                } else if (6 < now && now <= 9) {
                    for (int j = 1; j < 11; ++j) {
                        newDp[now] = add(newDp[now], dp[j]);
                    }
                    newDp[10] = dp[1];
                } else {
                    for (int k = 1; k <= 9; ++k) {
                        if (k <= 6) {
                            for (int j = 1; j < 11; ++j) {
                                newDp[k] = add(newDp[k], dp[j]);
                            }
                            newDp[10] = add(newDp[10], add(dp[1], dp[2]));
                        } else {
                            for (int j = 1; j < 11; ++j) {
                                newDp[k] = add(newDp[k], dp[j]);
                            }
                            newDp[10] = add(newDp[10], dp[1]);
                        }
                    }
                }
                dp = newDp;
            }
            int ans = 0;
            for (int num : dp) {
                ans = add(ans, num);
            }
            return ans;
        }

        public final static int MOD = 1_000_000_007;

        int add(long a, long b) {
            return (int) ((a % MOD + b % MOD) % MOD);
        }
    }

    public static void main(String[] args) {
        new P639().new Solution().numDecodings("1*");
    }

}
