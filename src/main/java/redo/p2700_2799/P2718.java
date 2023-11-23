package redo.p2700_2799;

public class P2718 {

    class Solution {
        public long matrixSumQueries(int n, int[][] queries) {
            boolean[] usedX = new boolean[n], usedY = new boolean[n];
            int leftX = n, leftY = n;
            long ans = 0;
            for (int i = queries.length - 1; i >= 0; --i) {
                int line = queries[i][1];
                int val = queries[i][2];
                if (queries[i][0] == 0) {
                    if (!usedX[line]) {
                        usedX[line] = true;
                        --leftY;
                        ans += (long) val * leftX;
                    }
                } else {
                    if (!usedY[line]) {
                        usedY[line] = true;
                        --leftX;
                        ans += (long) val * leftY;
                    }
                }
            }
            return ans;
        }
    }

}
