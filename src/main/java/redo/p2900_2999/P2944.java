package redo.p2900_2999;

import redo.testUtil.Arrs;

import java.util.Arrays;

public class P2944 {

    class Solution {
        public int minimumCoins(int[] prices) {
            if (prices.length == 1) {
                return prices[0];
            }
            int n = prices.length;
            int[] dp = new int[n];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = dp[1] = prices[0];
            for (int i = 1; i < n; ++i) {
                int opt = Math.min(dp[i - 1], dp[i]) + prices[i];
                for (int j = i; j <= i + i + 1 && j < n; ++j) {
                    dp[j] = Math.min(dp[j], opt);
                }
            }
            return dp[n - 1];
        }
    }

    public static void main(String[] args) {
        new P2944().new Solution().minimumCoins(Arrs.build("[14,37,37,38,24,15,12]"));
    }

}
