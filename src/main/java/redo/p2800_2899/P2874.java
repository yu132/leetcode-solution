package redo.p2800_2899;

public class P2874 {

    class Solution {
        public long maximumTripletValue(int[] nums) {
            long ans = 0;
            int[] left = new int[nums.length];
            int[] right = new int[nums.length];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; ++i) {
                left[i] = max;
                max = Math.max(max, nums[i]);
            }
            max = Integer.MIN_VALUE;
            for (int i = nums.length - 1; i >= 0; --i) {
                right[i] = max;
                max = Math.max(max, nums[i]);
            }
            for (int i = 1; i < nums.length - 1; ++i) {
                ans = Math.max(ans, (long) (left[i] - nums[i]) * right[i]);
            }
            return ans;
        }
    }

}
