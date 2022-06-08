package redo.p1700_1799;

import java.util.Arrays;

public class P1798 {

    class Solution {
        public int getMaximumConsecutive(int[] coins) {
            int now = 0;
            Arrays.sort(coins);
            for (int coin : coins) {
                if (coin <= now + 1) {
                    now += coin;
                } else {
                    break;
                }
            }
            return now + 1;
        }
    }

}
