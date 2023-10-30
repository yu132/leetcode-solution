package redo.p2600_2699;

public class P2640 {

    class Solution {
        public long[] findPrefixScore(int[] nums) {
            long[] ans = new long[nums.length];
            long max = 0;
            long last = 0;
            for (int i = 0; i < nums.length; ++i) {
                max = Math.max(max, nums[i]);
                last = ans[i] = nums[i] + max + last;
            }
            return ans;
        }
    }

}
