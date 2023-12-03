package redo.p2700_2799;

import java.util.Arrays;

public class P2741 {

    class Solution {
        int[][] dp;
        int n;
        private static final int MOD = (int) 1e9 + 7;

        public int specialPerm(int[] nums) {
            n = nums.length;
            dp = new int[1 << n][n];
            for (int i = 0; i < (1 << n); ++i) {
                Arrays.fill(dp[i], -1);
            }
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans = (ans + dfs(((1 << n) - 1) ^ (1 << i), i, nums)) % MOD;
            }
            return ans;
        }

        int dfs(int mask, int idx, int[] nums) {
            if (mask == 0) {
                return 1;
            }
            if (dp[mask][idx] != -1) {
                return dp[mask][idx];
            }
            int res = 0;
            for (int i = 0; i < n; ++i) {
                if (((mask >> i) & 1) == 1
                        && (nums[idx] % nums[i] == 0 || nums[i] % nums[idx] == 0)) {
                    res = (res + dfs(mask ^ (1 << i), i, nums)) % MOD;
                }
            }
            return dp[mask][idx] = res;
        }
    }

}
