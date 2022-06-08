package redo.p1700_1799;

public class P1774 {

    static
            //
    class Solution {
        public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
            boolean[] dp = new boolean[20001];

            for (int cost : baseCosts) {
                dp[cost] = true;
            }
            for (int x = 0; x < 2; ++x) {
                for (int cost : toppingCosts) {
                    for (int i = 20000; i >= cost; --i) {
                        dp[i] |= dp[i - cost];
                    }
                }
            }

            for (int i = 0; ; ++i) {
                if (target - i >= 0 && dp[target - i]) {
                    return target - i;
                }
                if (target + i <= 20000 && dp[target + i]) {
                    return target + i;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution().closestCost(new int[]{3, 10}, new int[]{2, 5}, 9);
    }

}
