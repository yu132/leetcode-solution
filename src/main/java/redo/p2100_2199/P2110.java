package redo.p2100_2199;

public class P2110 {

    class Solution {
        public long getDescentPeriods(int[] prices) {
            int len = 1;
            long ans = 0;
            for (int i = 1; i < prices.length; ++i) {
                if (prices[i] != prices[i - 1] - 1) {
                    ans += (long) len * (len + 1) / 2;
                    len = 1;
                } else {
                    ++len;
                }
            }
            ans += (long) len * (len + 1) / 2;
            return ans;
        }
    }

}
