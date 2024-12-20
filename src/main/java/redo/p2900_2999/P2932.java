package redo.p2900_2999;

public class P2932 {

    class Solution {
        public int maximumStrongPairXor(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                for (int j = i; j < nums.length; ++j) {
                    if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j])) {
                        ans = Math.max(ans, nums[i] ^ nums[j]);
                    }
                }
            }
            return ans;
        }
    }

}
