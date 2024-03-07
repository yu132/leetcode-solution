package redo.p3000_3099;

public class P3065 {

    class Solution {
        public int minOperations(int[] nums, int k) {
            int count = 0;
            for (int num : nums) {
                if (num < k) {
                    ++count;
                }
            }
            return count;
        }
    }

}
