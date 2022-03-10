package redo.p2100_2199;

import java.util.Arrays;

public class P2171 {

    class Solution {
        public long minimumRemoval(int[] beans) {
            Arrays.sort(beans);
            long sum = sum(beans);
            int n = beans.length;
            long min = Long.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                long drop = sum - (long) beans[i] * (n - i);
                min = Math.min(min, drop);
            }
            return min;
        }

        long sum(int[] nums) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
    }

}
