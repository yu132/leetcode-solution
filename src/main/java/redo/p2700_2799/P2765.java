package redo.p2700_2799;

public class P2765 {

    class Solution {
        public int alternatingSubarray(int[] nums) {
            int pp = -2;
            int len = 0;
            int ans = -1;
            for (int i = 1; i < nums.length; ++i) {
                if (len > 0 && nums[i] == pp && Math.abs(nums[i] - nums[i - 1]) == 1) {
                    ++len;
                } else if (nums[i] - nums[i - 1] == 1) {
                    len = 2;
                } else {
                    len = -1;
                }
                ans = Math.max(ans, len);
                pp = nums[i - 1];
            }
            return ans;
        }
    }

}
