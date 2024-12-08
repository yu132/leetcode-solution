package redo.p2300_2399;

import java.util.Arrays;

public class P2357 {

    class Solution {
        public int minimumOperations(int[] nums) {
            Arrays.sort(nums);
            int ans = nums[0] != 0 ? 1 : 0;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] != nums[i - 1]) {
                    ++ans;
                }
            }
            return ans;
        }
    }

}
