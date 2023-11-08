package redo.p2500_2599;

import redo.testUtil.Arrs;

public class P2556 {

//    class Solution {
//        public boolean isPossibleToCutPath(int[][] grid) {
//            int m = grid.length, n = grid[0].length;
//            return !(dfs(0, 0, m, n, grid) && dfs(0, 0, m, n, grid));
//        }
//
//        boolean dfs(int x, int y, int m, int n, int[][] grid) {
//            System.out.println(Arrs.toStr(grid));
//            if (x < 0 || x >= m || y < 0 || y >= n) {
//                return false;
//            }
//            if (x == m - 1 && y == n - 1) {
//                return true;
//            }
//            if (grid[x][y] != 1) {
//                return false;
//            }
//            if (x != 0 || y != 0) {
//                grid[x][y] = 2;
//            }
//            boolean flag = false;
//            flag = flag || dfs(x + 1, y, m, n, grid);
//            flag = flag || dfs(x, y + 1, m, n, grid);
//            flag = flag || dfs(x - 1, y, m, n, grid);
//            flag = flag || dfs(x, y - 1, m, n, grid);
//            return flag;
//        }
//    }

    class Solution {
        private int[][] g;
        private int m, n;

        public boolean isPossibleToCutPath(int[][] grid) {
            g = grid;
            m = g.length;
            n = g[0].length;
            return !dfs(0, 0) || !dfs(0, 0);
        }

        private boolean dfs(int x, int y) { // 返回能否到达终点
            if (x == m - 1 && y == n - 1) return true;
            g[x][y] = 0; // 直接修改
            return x < m - 1 && g[x + 1][y] > 0 && dfs(x + 1, y) ||
                    y < n - 1 && g[x][y + 1] > 0 && dfs(x, y + 1);
        }
    }


    public static void main(String[] args) {
        boolean a = new P2556().new Solution().isPossibleToCutPath(Arrs.build2D("[[1,1,1,1,1,1],[1,0,1,1,1,1],[1,1,1,0,1,1],[0,0,0,1,1,1]]"));
        System.out.println(a);
        ;
    }

    /*
   [1,1,1,1,1,1],
   [1,0,1,1,1,1],
   [1,1,1,0,1,1],
   [0,0,0,1,1,1]]

     */

}
