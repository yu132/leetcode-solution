package redo.p2600_2699;

public class P2639 {

    class Solution {
        public int[] findColumnWidth(int[][] grid) {
            int[] ans = new int[grid[0].length];
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    ans[j] = Math.max(ans[j], (grid[i][j] + "").length());
                }
            }
            return ans;
        }
    }

}
