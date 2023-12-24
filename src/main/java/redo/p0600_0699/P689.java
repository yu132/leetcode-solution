package redo.p0600_0699;

public class P689 {

    class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            long[] sumK = new long[nums.length - k + 1];
            int sumNow = 0;
            for (int i = 0; i < k; ++i) {
                sumNow += nums[i];
            }
            sumK[0] = sumNow;
            for (int i = k; i < nums.length; ++i) {
                sumNow += nums[i];
                sumNow -= nums[i - k];
                sumK[i - k + 1] = sumNow;
            }
            long[][] dp = new long[nums.length + 1][4];
            for (int i = k; i <= nums.length; ++i) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - k][0] + sumK[i - k]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - k][1] + sumK[i - k]);
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - k][2] + sumK[i - k]);
            }
            int[] ans = new int[3];
            for (int i = nums.length, l = 3; i >= k; ) {
                if (dp[i][l] == dp[i - 1][l]) {
                    --i;
                    continue;
                }
                i -= k;
                --l;
                ans[l] = i;
            }
            return ans;
        }
    }

}
