package redo.p1800_1899;

import java.util.Arrays;

public class P1833 {

    class Solution {
        public int maxIceCream(int[] costs, int coins) {
            Arrays.sort(costs);
            for (int i = 0; i < costs.length; ++i) {
                if (coins < costs[i]) {
                    return i;
                }
                coins -= costs[i];
            }
            return costs.length;
        }
    }

}
