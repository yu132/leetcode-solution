package redo.p1800_1899;

public class P1828 {

    class Solution {
        public int[] countPoints(int[][] points, int[][] queries) {
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                int count = 0;
                for (int[] point : points) {
                    if (inCircle(point[0], point[1], queries[i][0], queries[i][1], queries[i][2])) {
                        ++count;
                    }
                }
                ans[i] = count;
            }
            return ans;
        }

        public boolean inCircle(int x, int y, int cx, int cy, int cr) {
            return (x - cx) * (x - cx) + (y - cy) * (y - cy) <= cr * cr;
        }
    }

}
