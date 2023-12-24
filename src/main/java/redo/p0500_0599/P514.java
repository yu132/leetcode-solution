package redo.p0500_0599;

import java.util.Arrays;

public class P514 {

    class Solution {
        public int findRotateSteps(String ring, String key) {
            int n = ring.length();
            int[][] dp = new int[key.length()][ring.length()];
            for (int i = 0; i < dp.length; ++i) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            for (int i = 0; i < ring.length(); ++i) {
                if (ring.charAt(i) == key.charAt(0)) {
                    dp[0][i] = Math.min(i, n - i);
                }
            }
            for (int i = 1; i < key.length(); ++i) {
                for (int j = 0; j < n; ++j) {
                    if (ring.charAt(j) != key.charAt(i - 1)) {
                        continue;
                    }
                    for (int k = 0; k < n; ++k) {
                        if (ring.charAt(k) != key.charAt(i)) {
                            continue;
                        }
                        dp[i][k] = Math.min(dp[i][k], dp[i - 1][j] + Math.min(Math.abs(k - j), n - Math.abs(k - j)));
                    }
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                ans = Math.min(ans, dp[key.length() - 1][i]);
            }
            return ans + key.length();
        }
    }

    public static void main(String[] args) {
        new P514().new Solution().findRotateSteps("aaaaa", "aaaaa");
    }

}
