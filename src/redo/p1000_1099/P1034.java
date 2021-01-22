package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1034  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1034 {

    class Solution {
        public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
            if (grid[r0][c0] == color) {
                return grid;
            }
            helper(grid, new boolean[grid.length][grid[0].length], r0, c0, grid[r0][c0], color);
            return grid;
        }

        void helper(int[][] grid, boolean[][] visited, int x, int y, int oldColor, int newColor) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return;
            }
            if (grid[x][y] != oldColor) {
                return;
            }
            if (visited[x][y]) {
                return;
            }
            visited[x][y] = true;

            boolean paint = !same(grid, x + 1, y, x, y) || !same(grid, x - 1, y, x, y) || !same(grid, x, y + 1, x, y)
                || !same(grid, x, y - 1, x, y);

            helper(grid, visited, x + 1, y, oldColor, newColor);
            helper(grid, visited, x - 1, y, oldColor, newColor);
            helper(grid, visited, x, y + 1, oldColor, newColor);
            helper(grid, visited, x, y - 1, oldColor, newColor);

            if (paint) {
                grid[x][y] = newColor;
            }
        }

        boolean same(int[][] grid, int x, int y, int x1, int y1) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return false;
            }
            return grid[x][y] == grid[x1][y1];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[3,3],[3,2]]", Arrs.toStr(s.colorBorder(Arrs.build2D("[[1,1],[1,2]]"), 0, 0, 3)));

        Assert.assertEquals("[[1,3,3],[2,3,3]]", Arrs.toStr(s.colorBorder(Arrs.build2D("[[1,2,2],[2,3,2]]"), 0, 1, 3)));

        Assert.assertEquals("[[2,2,2],[2,1,2],[2,2,2]]",
            Arrs.toStr(s.colorBorder(Arrs.build2D("[[1,1,1],[1,1,1],[1,1,1]]"), 1, 1, 2)));

    }

}
