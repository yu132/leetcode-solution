package redo.p2900_2999;

public class P2923 {

    class Solution {
        public int findChampion(int[][] grid) {
            for (int i = 0; i < grid.length; ++i) {
                int count = 0;
                for (int j = 0; j < grid[0].length; ++j) {
                    count += grid[i][j];
                }
                if (count == grid.length - 1) {
                    return i;
                }
            }
            return -1;
        }
    }

}
