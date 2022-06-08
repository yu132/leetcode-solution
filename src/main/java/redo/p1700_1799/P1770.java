package redo.p1700_1799;

public class P1770 {

    static//

    class Solution {
        public int maximumScore(int[] nums, int[] multipliers) {

            final int n = nums.length, m = multipliers.length;

            int[][] dp = new int[m + 1][m + 1];

            int ans = Integer.MIN_VALUE;

            for (int k = 1; k <= m; ++k) {
                for (int i = 0; i <= k; i++) {
                    if (i == 0) {
                        dp[i][k - i] = dp[i][k - i - 1] + nums[n - k + i] * multipliers[k - 1];
                    } else if (i == k) {
                        dp[i][k - i] = dp[i - 1][k - i] + nums[i - 1] * multipliers[k - 1];
                    } else {
                        dp[i][k - i] = Math.max(dp[i][k - i - 1] + nums[n - k + i] * multipliers[k - 1],
                                dp[i - 1][k - i] + nums[i - 1] * multipliers[k - 1]);
                    }
                    if (k == m) {
                        ans = Math.max(ans, dp[i][k - i]);
                    }
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        new Solution().maximumScore(new int[]{1, 2, 3}, new int[]{3, 2, 1});
    }

}
