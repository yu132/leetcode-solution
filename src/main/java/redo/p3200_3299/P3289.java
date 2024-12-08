package redo.p3200_3299;

import redo.testUtil.Arrs;

import java.util.Arrays;

public class P3289 {

    class Solution {
        public int[] getSneakyNumbers(int[] nums) {
            for (int i = 0; i < nums.length; ++i) {
                while (nums[i] != i && nums[nums[i]] != nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
            return Arrays.copyOfRange(nums, nums.length - 2, nums.length);
        }
    }

    public static void main(String[] args) {
        new P3289().new Solution().getSneakyNumbers(Arrs.build("[3,2,0,3,1,2]"));
    }
}
