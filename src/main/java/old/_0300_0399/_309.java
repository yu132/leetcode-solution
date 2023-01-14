package old._0300_0399;

public class _309 {

    class Solution {
        public int maxProfit(int[] prices) {

            if (prices.length == 0) {
                return 0;
            }

            int[] buy = new int[prices.length], cool = new int[prices.length], sell = new int[prices.length];

            buy[0] = -prices[0];

            for (int i = 1; i < prices.length; ++i) {
                sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
                buy[i]  = Math.max(cool[i - 1] - prices[i], buy[i - 1]);
                cool[i] = Math.max(sell[i - 1], Math.max(buy[i - 1], cool[i - 1]));
            }

            return sell[prices.length - 1];
        }
    }
}
