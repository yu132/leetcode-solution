package redo.p3200_3299;

import java.util.HashMap;
import java.util.Map;

public class P3242 {

    class NeighborSum {

        int[][] grid;
        Map<Integer, int[]> map = new HashMap<>();

        public NeighborSum(int[][] grid) {
            this.grid = grid;
            int n = grid.length;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    map.put(grid[i][j], new int[]{i, j});
                }
            }
        }

        public int adjacentSum(int value) {
            int[] loc = map.get(value);
            return val(loc[0] - 1, loc[1], grid)
                    + val(loc[0] + 1, loc[1], grid)
                    + val(loc[0], loc[1] - 1, grid)
                    + val(loc[0], loc[1] + 1, grid);
        }

        public int diagonalSum(int value) {
            int[] loc = map.get(value);
            return val(loc[0] - 1, loc[1] - 1, grid)
                    + val(loc[0] - 1, loc[1] + 1, grid)
                    + val(loc[0] + 1, loc[1] - 1, grid)
                    + val(loc[0] + 1, loc[1] + 1, grid);
        }

        int val(int x, int y, int[][] grid) {
            int n = grid.length;
            if (x < 0 || x >= n || y < 0 || y >= n) {
                return 0;
            }
            return grid[x][y];
        }
    }

}
