package redo.p2500_2599;

public class P2529 {

    class Solution {
        public int maximumCount(int[] nums) {
            int cP = 0, cN = 0;
            for (int num : nums) {
                if (num > 0) {
                    ++cP;
                } else if (num < 0) {
                    ++cN;
                }
            }
            return Math.max(cP, cN);
        }
    }

}
