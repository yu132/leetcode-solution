package redo.p2700_2799;

import java.util.Arrays;

public class P2740 {

    class Solution {
        public int findValueOfPartition(int[] nums) {
            Arrays.sort(nums);
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i < nums.length; ++i) {
                ans = Math.min(ans, nums[i] - nums[i - 1]);
            }
            return ans;
        }
    }

}
