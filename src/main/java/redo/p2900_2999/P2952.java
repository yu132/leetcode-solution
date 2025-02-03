package redo.p2900_2999;

import java.util.Arrays;

public class P2952 {

    class Solution {
        public int minimumAddedCoins(int[] coins, int target) {
            Arrays.sort(coins);
            long max = 0;
            int ans = 0;
            for (int coin : coins) {
                while (max < coin - 1) {
                    ++ans;
                    max = max + max + 1;
                }
                max = max + coin;
            }
            while (max < target) {
                ++ans;
                max = max + max + 1;
            }
            return ans;
        }
    }

}
