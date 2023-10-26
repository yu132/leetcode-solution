package redo.p2500_2599;

import redo.testUtil.Arrs;

import java.util.Arrays;

public class P2576 {

    class Solution {
        public int maxNumOfMarkedIndices(int[] nums) {
            Arrays.sort(nums);
            int left = 0, right = (nums.length + 1) / 2;
            while (right < nums.length) {
                if (nums[left] * 2 <= nums[right++]) {
                    ++left;
                }
            }
            return left * 2;
        }
    }

    public static void main(String[] args) {
        int a = new P2576().new Solution().maxNumOfMarkedIndices(Arrs.build("[9,2,5,4]"));
        System.out.println(a);
    }

}
