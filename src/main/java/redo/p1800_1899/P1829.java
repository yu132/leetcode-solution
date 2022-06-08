package redo.p1800_1899;

public class P1829 {

    class Solution {
        public int[] getMaximumXor(int[] nums, int maximumBit) {
            int val = 0;
            for (int num : nums) {
                val ^= num;
            }
            int mask = (int) Math.pow(2, maximumBit) - 1;
            int[] ans = new int[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                ans[i] = mask & (val ^ mask);
                val ^= nums[nums.length - i - 1];
            }
            return ans;
        }
    }

}
