package redo.p2900_2999;

import java.util.Arrays;

public class P2943 {

    class Solution {
        public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
            Arrays.sort(hBars);
            Arrays.sort(vBars);

            int cH = 1;
            int maxH = 1;
            for (int i = 1; i < hBars.length; ++i) {
                if (hBars[i] == hBars[i - 1] + 1) {
                    ++cH;
                    maxH = Math.max(maxH, cH);
                } else {
                    cH = 1;
                }
            }

            int cV = 1;
            int maxV = 1;
            for (int i = 1; i < vBars.length; ++i) {
                if (vBars[i] == vBars[i - 1] + 1) {
                    ++cV;
                    maxV = Math.max(maxV, cV);
                } else {
                    cV = 1;
                }
            }

            int sq = Math.min(maxV, maxH);

            return (sq + 1) * (sq + 1);
        }
    }

}
