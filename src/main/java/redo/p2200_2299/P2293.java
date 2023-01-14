package redo.p2200_2299;

public class P2293 {

    class Solution {
        public int minMaxGame(int[] nums) {
            while (nums.length > 1) {
                nums = helper(nums);
            }
            return nums[0];
        }

        int[] helper(int[] nums) {
            int[] ans = new int[nums.length / 2];
            for (int i = 0; i < ans.length; ++i) {
                if (i % 2 == 0) {
                    ans[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
                } else {
                    ans[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
                }
            }
            return ans;
        }
    }

}
