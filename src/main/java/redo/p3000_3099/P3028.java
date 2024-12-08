package redo.p3000_3099;

public class P3028 {

    class Solution {
        public int returnToBoundaryCount(int[] nums) {
            int count = 0;
            int idx = 0;
            for (int num : nums) {
                idx += num;
                if (idx == 0) {
                    ++count;
                }
            }
            return count;
        }
    }

}
