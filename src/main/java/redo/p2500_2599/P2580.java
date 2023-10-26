package redo.p2500_2599;

import java.util.Arrays;
import java.util.Comparator;

public class P2580 {

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int countWays(int[][] ranges) {
            Arrays.sort(ranges, Comparator.<int[]>comparingInt(x -> x[0]).thenComparing(x -> x[1]));
            int count = 1;
            int maxR = ranges[0][1];
            for (int i = 1; i < ranges.length; ++i) {
                if (maxR >= ranges[i][0]) {
                    maxR = Math.max(maxR, ranges[i][1]);
                } else {
                    ++count;
                    maxR = ranges[i][1];
                }
            }
            return myPow(2, count, MOD);
        }

        public int myPow(long x, int n, int mod) {
            long num = 1;
            while (n > 0) {
                if (n % 2 == 1) {
                    num = (num * x) % mod;
                }
                n >>= 1;
                x = (x * x) % mod;
            }
            return (int) num;
        }

    }

}
