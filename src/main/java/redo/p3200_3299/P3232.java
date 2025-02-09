package redo.p3200_3299;

public class P3232 {

    class Solution {
        public boolean canAliceWin(int[] nums) {
            int val1 = 0, val10 = 0;
            for (int num : nums) {
                if (num < 10) {
                    val1 += num;
                } else {
                    val10 += num;
                }
            }
            return val1 != val10;
        }
    }

}
