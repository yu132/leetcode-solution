package redo.p0400_0499;

public class P494 {

    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            return helper(0, nums, target, 0);
        }

        public int helper(int index, int[] nums, int target, int now) {
            if (index == nums.length) {
                return now == target ? 1 : 0;
            }
            int count = helper(index + 1, nums, target, now + nums[index]);
            count += helper(index + 1, nums, target, now - nums[index]);
            return count;
        }

    }

}
