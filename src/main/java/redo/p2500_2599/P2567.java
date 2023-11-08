package redo.p2500_2599;

import java.util.Arrays;

public class P2567 {

    class Solution {
        public int minimizeSum(int[] nums) {
            Arrays.sort(nums);
            int min = Integer.MAX_VALUE;
            int n = nums.length;
            min = Math.min(min, nums[n - 1] - nums[2]);
            min = Math.min(min, nums[n - 2] - nums[1]);
            min = Math.min(min, nums[n - 3] - nums[0]);
            return min;
        }
    }

}
