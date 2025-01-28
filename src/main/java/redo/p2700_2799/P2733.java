package redo.p2700_2799;

import java.util.Arrays;

public class P2733 {

    class Solution {
        public int findNonMinOrMax(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length - 1; ++i) {
                if (nums[i] != nums[0] && nums[i] != nums[nums.length - 1]) {
                    return nums[i];
                }
            }
            return -1;
        }
    }

}
