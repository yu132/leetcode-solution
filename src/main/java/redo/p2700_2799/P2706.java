package redo.p2700_2799;

import java.util.Arrays;

public class P2706 {

    class Solution {
        public int buyChoco(int[] prices, int money) {
            Arrays.sort(prices);
            if (prices[0] + prices[1] > money) {
                return money;
            } else {
                return money - (prices[0] + prices[1]);
            }
        }
    }

}
