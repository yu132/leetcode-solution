package redo.p2400_2499;

import redo.testUtil.Arrs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2438 {

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int[] productQueries(int n, int[][] queries) {
            List<Integer> list = new ArrayList<>();
            for (int i = 30; i >= 0; --i) {
                if (n >= (1 << i)) {
                    n -= (1 << i);
                    list.add(1 << i);
                }
            }
            Collections.reverse(list);
            int m = list.size();
            int[][] dp = new int[m][m];
            for (int i = 0; i < m; ++i) {
                int pro = 1;
                for (int j = i; j < m; ++j) {
                    dp[i][j] = pro = multiply(pro, list.get(j), MOD);
                }
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                ans[i] = dp[queries[i][0]][queries[i][1]];
            }
            return ans;
        }

        int multiply(long a, long b, int mod) {
            return (int) (((a % mod) * (b % mod)) % mod);
        }
    }

    public static void main(String[] args) {
        new P2438().new Solution().productQueries(14, Arrs.build2D("[[0,0]]"));
    }

}
