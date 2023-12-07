package redo.p2700_2799;

public class P2786 {

    class Solution {
        public long maxScore(int[] nums, int x) {
            long odd = 0, even = 0;
            if ((nums[0] & 1) == 1) {
                odd = nums[0];
                even = nums[0] - x;
            } else {
                odd = nums[0] - x;
                even = nums[0];
            }
            for (int i = 1; i < nums.length; ++i) {
                int num = nums[i];
                if ((num & 1) == 1) {
                    odd = Math.max(odd, even - x) + num;
                } else {
                    even = Math.max(odd - x, even) + num;
                }
            }
            return Math.max(odd, even);
        }
    }

}
