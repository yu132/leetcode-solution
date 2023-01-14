package redo.p0800_0899;

public class P810 {

    class Solution {
        public boolean xorGame(int[] nums) {
            int val = 0;
            for (int num : nums) {
                val ^= num;
            }
            return val == 0 || nums.length % 2 == 0;
        }
    }

}
