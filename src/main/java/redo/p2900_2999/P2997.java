package redo.p2900_2999;

public class P2997 {

    class Solution {
        public int minOperations(int[] nums, int k) {
            int val = k;
            for (int num : nums) {
                val ^= num;
            }
            return Integer.bitCount(val);
        }
    }

}
