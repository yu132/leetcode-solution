package redo.p2600_2699;

public class P2672 {

    class Solution {
        public int[] colorTheArray(int n, int[][] queries) {
            int[] ans = new int[queries.length];
            int[] now = new int[n];
            int count = 0;
            for (int i = 0; i < queries.length; ++i) {
                ans[i] = count = count + helper(queries[i][0], queries[i][1], now);
            }
            return ans;
        }

        int helper(int i, int nextColor, int[] now) {
            if (nextColor == now[i]) {
                return 0;
            }
            int count = 0;
            if (i != 0) {
                if (now[i - 1] == now[i] && now[i] != 0) {
                    --count;
                }
                if (now[i - 1] == nextColor) {
                    ++count;
                }
            }
            if (i != now.length - 1) {
                if (now[i + 1] == now[i] && now[i] != 0) {
                    --count;
                }
                if (now[i + 1] == nextColor) {
                    ++count;
                }
            }
            now[i] = nextColor;
            return count;
        }
    }

}
