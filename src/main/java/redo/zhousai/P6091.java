package redo.zhousai;

import java.util.Arrays;

public class P6091 {

    class Solution {
        public int partitionArray(int[] nums, int k) {
            Arrays.sort(nums);
            int ans = 1, min = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] - min > k) {
                    ++ans;
                    min = nums[i];
                }
            }
            return ans;
        }
    }

}
