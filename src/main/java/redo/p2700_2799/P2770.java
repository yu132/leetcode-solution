package redo.p2700_2799;

import java.util.Arrays;

public class P2770 {

    class Solution {
        public int maximumJumps(int[] nums, int target) {
            int[] ans = new int[nums.length];
            Arrays.fill(ans, -1);
            ans[0] = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (ans[i] == -1) {
                    continue;
                }
                for (int j = i + 1; j < nums.length; ++j) {
                    if (Math.abs(nums[j] - nums[i]) <= target) {
                        ans[j] = Math.max(ans[j], ans[i] + 1);
                    }
                }
            }
            return ans[nums.length - 1];
        }
    }

}
