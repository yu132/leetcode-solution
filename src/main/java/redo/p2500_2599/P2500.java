package redo.p2500_2599;

import java.util.Arrays;

public class P2500 {

    class Solution {
        public int deleteGreatestValue(int[][] grid) {
            for (int[] arr : grid) {
                Arrays.sort(arr);
            }
            int ans = 0;
            for (int j = 0; j < grid[0].length; ++j) {
                int max = 0;
                for (int i = 0; i < grid.length; ++i) {
                    max = Math.max(max, grid[i][j]);
                }
                ans += max;
            }
            return ans;
        }
    }

}
