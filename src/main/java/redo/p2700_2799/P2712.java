package redo.p2700_2799;

public class P2712 {

    class Solution {
        public long minimumCost(String s) {
            long[] dpL0 = new long[s.length()], dpR0 = new long[s.length()];
            long[] dpL1 = new long[s.length()], dpR1 = new long[s.length()];
            long dpLL0 = 0, dpLL1 = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '0') {
                    dpL0[i] = dpLL0;
                    dpL1[i] = dpLL1 = dpLL0 + i + 1;
                } else {
                    dpL1[i] = dpLL1;
                    dpL0[i] = dpLL0 = dpLL1 + i + 1;
                }
            }
            long dpRR0 = 0, dpRR1 = 0;
            for (int i = s.length() - 1; i >= 0; --i) {
                if (s.charAt(i) == '0') {
                    dpR0[i] = dpRR0;
                    dpR1[i] = dpRR1 = dpRR0 + (s.length() - i);
                } else {
                    dpR1[i] = dpRR1;
                    dpR0[i] = dpRR0 = dpRR1 + (s.length() - i);
                }
            }
            long min = Math.min(dpR0[0], dpR1[0]);
            min = Math.min(min, Math.min(dpL0[s.length() - 1], dpL1[s.length() - 1]));
            for (int i = 0; i < s.length() - 1; ++i) {
                min = Math.min(min, dpL0[i] + dpR0[i + 1]);
                min = Math.min(min, dpL1[i] + dpR1[i + 1]);
            }
            return min;
        }
    }

    public static void main(String[] args) {
        new P2712().new Solution().minimumCost("0011");
    }

}
