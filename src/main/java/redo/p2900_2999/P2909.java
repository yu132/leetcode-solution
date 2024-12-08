package redo.p2900_2999;

public class P2909 {

    class Solution {
        public int minimumSum(int[] nums) {
            int[] left = new int[nums.length];
            int[] right = new int[nums.length];
            left[0] = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                left[i] = Math.min(left[i - 1], nums[i]);
            }
            right[nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; --i) {
                right[i] = Math.min(right[i + 1], nums[i]);
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i < nums.length - 1; ++i) {
                if (nums[i] > left[i - 1] && nums[i] > right[i + 1]) {
                    ans = Math.min(ans, nums[i] + left[i - 1] + right[i + 1]);
                }
            }
            if (ans == Integer.MAX_VALUE) {
                return -1;
            } else {
                return ans;
            }
        }
    }

}
