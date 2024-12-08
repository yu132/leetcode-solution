package redo.p2900_2999;

import java.util.Arrays;
import java.util.List;

public class P2915 {

    class Solution {
        public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
            int[] dp = new int[target + 1];
            Arrays.fill(dp, Integer.MIN_VALUE);
            dp[0] = 0;
            for (int num : nums) {
                for (int val = target; val >= num; --val) {
                    dp[val] = Math.max(dp[val], dp[val - num] + 1);
                }
            }
            if (dp[target] < 0) {
                return -1;
            }
            return dp[target];
        }
    }

}
