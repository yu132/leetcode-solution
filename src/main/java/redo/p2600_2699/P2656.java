package redo.p2600_2699;

public class P2656 {

    class Solution {
        public int maximizeSum(int[] nums, int k) {
            int val = max(nums);
            return val * k + k * (k - 1) / 2;
        }

        int max(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }
    }

}
