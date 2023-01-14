package redo.p2400_2499;

import redo.testUtil.Arrs;

public class P2460 {

    class Solution {
        public int[] applyOperations(int[] nums) {
            int index = 0, i = 0;
            for (; i < nums.length - 1; ++i) {
                if (nums[i] == 0) {
                    continue;
                } else if (nums[i] == nums[i + 1]) {
                    nums[index++] = 2 * nums[i++];
                } else {
                    nums[index++] = nums[i];
                }
            }
            if (i == nums.length - 1) {
                nums[index++] = nums[nums.length - 1];
            }
            for (; index < nums.length; ++index) {
                nums[index] = 0;
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P2460().new Solution().applyOperations(Arrs.build("[847,847,0,0,0,399,416,416,879,879,206,206,206,272]")));
    }
}
