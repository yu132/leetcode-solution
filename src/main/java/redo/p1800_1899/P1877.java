package redo.p1800_1899;

import java.util.Arrays;

public class P1877 {

    class Solution {
        public int minPairSum(int[] nums) {
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0, j = nums.length - 1; i < j; ++i, --j) {
                ans = Math.max(ans, nums[i] + nums[j]);
            }
            return ans;
        }
    }

}
