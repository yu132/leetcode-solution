package redo.p2500_2599;

public class P2527 {

    class Solution {
        public int xorBeauty(int[] nums) {
            int temp = 0;
            for (int num : nums) {
                temp ^= num;
            }
            return temp;
        }
    }
}
