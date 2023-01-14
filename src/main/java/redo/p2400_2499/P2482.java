package redo.p2400_2499;

public class P2482 {

    class Solution {
        public int[][] onesMinusZeros(int[][] grid) {
            int[][] countRow = new int[grid.length][2],
                    countCol = new int[grid[0].length][2];
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    ++countRow[i][grid[i][j]];
                    ++countCol[j][grid[i][j]];
                }
            }
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    grid[i][j] = countRow[i][1] + countCol[j][1] - countRow[i][0]
                            - countCol[j][0];
                }
            }
            return grid;
        }
    }

}
