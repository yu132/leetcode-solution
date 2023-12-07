package redo.p2700_2799;

import java.util.ArrayList;
import java.util.List;

public class P2787 {


    class Solution {

        public final static int MOD = 1_000_000_007;

        public int numberOfWays(int n, int x) {
            long[] dp = new long[n + 1];
            dp[0] = 1;
            List<Integer> list = new ArrayList<>();
            for (int i = 1; ; ++i) {
                int temp = (int) Math.pow(i, x);
                if (temp > n) {
                    break;
                }
                list.add(temp);
            }
            for (int j = 0; j < list.size(); ++j) {
                for (int i = n - list.get(j); i >= 0; --i) {
                    dp[i + list.get(j)] = (dp[i + list.get(j)] + dp[i]) % MOD;
                }
            }
            return (int) dp[n];
        }
    }

}
