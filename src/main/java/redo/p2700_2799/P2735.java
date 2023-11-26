package redo.p2700_2799;

import java.util.Arrays;

public class P2735 {

    class Solution {
        public long minCost(int[] nums, int x) {
            int n = nums.length;
            long[] dp = new long[n];
            Arrays.setAll(dp, i -> nums[i]);
            long ans = Long.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                long total = 0;
                for (int j = 0; j < n; ++j) {
                    total += (dp[j] = Math.min(dp[j], nums[(j - i + n) % n]));
                }
                ans = Math.min(ans, total + (long) x * i);
            }
            return ans;
        }
    }

}
