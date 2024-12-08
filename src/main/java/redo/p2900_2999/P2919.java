package redo.p2900_2999;

public class P2919 {

    class Solution {
        public long minIncrementOperations(int[] nums, int k) {
            int n = nums.length;
            long upperbound = Long.MAX_VALUE / 10;
            // 0 -> ?, 1
            // 1 -> 1, 0,
            // 2 -> 1, 0, 0
            // dp表示当前所需添加的次数
            long[][] dp = new long[n][5];
            dp[0][0] = Math.max(0, k - nums[0]);
            dp[0][2] = upperbound;
            dp[0][1] = nums[0] >= k ? upperbound : 0;
            for (int i = 1; i < n; ++i) {
                if (nums[i] >= k) {
                    dp[i][0] = min(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]);
                    dp[i][1] = dp[i][2] = upperbound;
                } else {
                    dp[i][0] = k - nums[i] + min(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]);
                    dp[i][1] = dp[i - 1][0];
                    dp[i][2] = dp[i - 1][1];
                }
            }
            return min(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]);
        }

        long min(long... nums) {
            long ans = Long.MAX_VALUE;
            for (long num : nums) {
                ans = Math.min(ans, num);
            }
            return ans;
        }
    }

}
