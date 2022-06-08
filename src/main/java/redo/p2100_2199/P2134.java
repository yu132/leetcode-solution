package redo.p2100_2199;

public class P2134 {

    class Solution {
        public int minSwaps(int[] nums) {
            int count1 = 0;
            for (int num : nums) {
                count1 += num;
            }
            int count0InRange = 0;
            for (int i = 0; i < count1; ++i) {
                count0InRange += 1 - nums[i];
            }
            int min = count0InRange;
            for (int i = 0; i < nums.length; ++i) {
                count0InRange = count0InRange - (1 - nums[i]) + (1 - nums[(i + count1) % nums.length]);
                min = Math.min(min, count0InRange);
            }
            return min;
        }
    }

}
