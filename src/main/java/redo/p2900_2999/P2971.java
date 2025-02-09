package redo.p2900_2999;

import java.util.Arrays;

public class P2971 {

    class Solution {
        public long largestPerimeter(int[] nums) {
            Arrays.sort(nums);
            long ans = -1;
            long sum = nums[0] + nums[1];
            for (int i = 2; i < nums.length; ++i) {
                if (sum > nums[i]) {
                    ans = sum + nums[i];
                }
                sum += nums[i];
            }
            return ans;
        }
    }

}
