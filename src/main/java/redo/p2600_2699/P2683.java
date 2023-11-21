package redo.p2600_2699;

public class P2683 {

    class Solution {
        public boolean doesValidArrayExist(int[] derived) {
            int first = 0, now = 0;
            for (int num : derived) {
                now ^= num;
            }
            if (first == now) {
                return true;
            }
            first = now = 1;
            for (int num : derived) {
                now ^= num;
            }
            return first == now;
        }
    }

}
