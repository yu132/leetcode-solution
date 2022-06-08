package redo.p1900_1999;

import java.util.Arrays;

public class P1968 {

    class Solution {
        public int[] rearrangeArray(int[] nums) {
            Arrays.sort(nums);
            int[] ans = new int[nums.length];

            for (int i = 0, j = nums.length - 1, index = 0; i <= j; ++i, --j) {
                if (i == j) {
                    ans[index] = nums[i];
                } else {
                    ans[index++] = nums[i];
                    ans[index++] = nums[j];
                }
            }

            return ans;
        }
    }

}
