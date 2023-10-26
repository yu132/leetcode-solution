package redo.p2500_2599;

public class P2505 {

    class Solution {
        public long subsequenceSumOr(int[] nums) {
            long a = 0, b = 0;
            for (int num : nums) {
                b += num;
                a |= num | b;
            }
            return a;
        }
    }

}
