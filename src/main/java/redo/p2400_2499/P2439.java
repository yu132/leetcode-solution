package redo.p2400_2499;

public class P2439 {

    class Solution {
        public int minimizeArrayValue(int[] nums) {
            long sum = 0;
            long ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i];
                ans = Math.max(ans, sum == 0 ? 0 : (sum - 1) / (i + 1) + 1);
            }
            return (int) ans;
        }
    }

}
