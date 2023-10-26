package redo.p2500_2599;

import java.util.Arrays;

public class P2587 {

    class Solution {
        public int maxScore(int[] nums) {
            Arrays.sort(nums);

            long sum = 0;
            for (int i = nums.length - 1; i >= 0; --i) {
                sum += nums[i];
                if (sum <= 0) {
                    return nums.length - i - 1;
                }
            }
            return nums.length;
        }
    }

}
