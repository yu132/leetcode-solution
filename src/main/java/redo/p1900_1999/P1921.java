package redo.p1900_1999;

import java.util.Arrays;

public class P1921 {

    class Solution {
        public int eliminateMaximum(int[] dist, int[] speed) {

            int n = dist.length;

            int[] time = new int[n];
            for (int i = 0; i < n; ++i) {
                time[i] = (dist[i] - 1) / speed[i] + 1;
            }

            Arrays.sort(time);

            for (int i = 0; i < n; ++i) {
                if (i >= time[i]) {
                    return i;
                }
            }

            return n;
        }
    }

}
