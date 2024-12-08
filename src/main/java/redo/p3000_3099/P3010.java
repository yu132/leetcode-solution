package redo.p3000_3099;

import java.util.Arrays;

public class P3010 {

    class Solution {
        public int minimumCost(int[] nums) {
            int[] arr = Arrays.copyOfRange(nums, 1, nums.length);
            Arrays.sort(arr);
            return nums[0] + arr[0] + arr[1];
        }
    }

}
