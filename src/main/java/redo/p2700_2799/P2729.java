package redo.p2700_2799;

public class P2729 {

    class Solution {
        public boolean isFascinating(int n) {
            int[] flags = new int[10];
            int tmp = n;
            while (tmp > 0) {
                int mod = tmp % 10;
                flags[mod]++;
                tmp /= 10;
            }
            tmp = 2 * n;
            while (tmp > 0) {
                int mod = tmp % 10;
                flags[mod]++;
                tmp /= 10;
            }
            tmp = 3 * n;
            while (tmp > 0) {
                int mod = tmp % 10;
                flags[mod]++;
                tmp /= 10;
            }
            for (int i = 1; i < 10; ++i) {
                if (flags[i] != 1) {
                    return false;
                }
            }
            return flags[0] == 0;
        }
    }

}
