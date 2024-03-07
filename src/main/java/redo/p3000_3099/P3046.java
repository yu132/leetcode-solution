package redo.p3000_3099;

import java.util.Arrays;

public class P3046 {

    class Solution {
        public boolean isPossibleToSplit(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1, c = 1; i < nums.length; ++i) {
                if (nums[i] == nums[i - 1]) {
                    ++c;
                    if (c == 3) {
                        return false;
                    }
                } else {
                    c = 1;
                }
            }
            return true;
        }
    }

}
