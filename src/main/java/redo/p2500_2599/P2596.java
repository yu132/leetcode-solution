package redo.p2500_2599;

public class P2596 {

    class Solution {
        public boolean checkValidGrid(int[][] grid) {
            if (grid[0][0] != 0) {
                return false;
            }
            int n = grid.length;
            int[][] resorted = new int[n * n][2];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    resorted[grid[i][j]][0] = i;
                    resorted[grid[i][j]][1] = j;
                }
            }
            int[][] dis = new int[][]{{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2, -1}};
            for (int i = 1; i < n * n; ++i) {
                boolean flag = false;
                int x0 = resorted[i - 1][0], y0 = resorted[i - 1][1];
                int x1 = resorted[i][0], y1 = resorted[i][1];
                for (int j = 0; j < dis.length; ++j) {
                    if (x0 - x1 == dis[j][0] && y0 - y1 == dis[j][1]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    return false;
                }
            }
            return true;
        }
    }

//    [24,11,22,17,4],
//    [21,16,5,12,9],
//    [6,23,10,3,18],
//    [15,20,1,8,13],
//    [0,7,14,19,2]]


}