package redo.p2900_2999;

public class P2908 {

    class Solution {
        public int minimumSum(int[] nums) {
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; ++i) {
                for (int j = i + 1; j < nums.length; ++j) {
                    for (int k = j + 1; k < nums.length; ++k) {
                        if (nums[i] < nums[j] && nums[k] < nums[j]) {
                            ans = Math.min(ans, nums[i] + nums[j] + nums[k]);
                        }
                    }
                }
            }
            if (ans == Integer.MAX_VALUE) {
                return -1;
            }
            return ans;
        }
    }

}
