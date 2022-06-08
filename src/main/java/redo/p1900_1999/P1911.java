package redo.p1900_1999;

public class P1911 {

    class Solution {
        public long maxAlternatingSum(int[] nums) {

            int n = nums.length;

            long[][] dp = new long[n][2];
            dp[0][0] = nums[0];
            dp[0][1] = Integer.MIN_VALUE;

            for (int i = 1; i < nums.length; ++i) {
                dp[i][0] = max(nums[i], dp[i - 1][1] + nums[i], dp[i - 1][0]);
                dp[i][1] = max(dp[i][0] - nums[i], dp[i - 1][1]);
            }

            return Math.max(dp[n - 1][0], dp[n - 1][1]);
        }

        long max(long... nums) {
            long ans = Integer.MIN_VALUE;
            for (long num : nums) {
                ans = Math.max(ans, num);
            }
            return ans;
        }
    }

}
