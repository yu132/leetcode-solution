package redo.p2700_2799;

public class P2760 {

    class Solution {
        public int longestAlternatingSubarray(int[] nums, int threshold) {
            int left = 0;
            int right = 0;
            int ans = 0;
            while (left < nums.length && right < nums.length) {
                if (nums[left] % 2 == 0 && nums[left] <= threshold) {
                    right = left;
                    while (right + 1 < nums.length && nums[right + 1] % 2 != nums[right] % 2 && nums[right + 1] <= threshold) {
                        ++right;
                    }
                    ans = Math.max(ans, right - left + 1);
                    left = right;
                }
                ++left;
            }
            return ans;
        }
    }

}
