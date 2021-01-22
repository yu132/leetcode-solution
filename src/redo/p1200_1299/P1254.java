package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1254  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月12日  
 *  
 */
public class P1254 {

    class Solution {
        public int closedIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int count = 0, times = 2;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 0) {
                        if (dfs(i, j, m, n, times++, grid)) {
                            ++count;
                        }
                    }
                }
            }
            return count;
        }

        boolean dfs(int x, int y, int m, int n, int times, int[][] grid) {
            if (x == 1 && y == 2) {
                System.out.println(1);
            }

            if (x < 0 || x >= m || y < 0 || y >= n) {
                return false;
            }
            if (grid[x][y] == 1) {
                return true;
            }
            if (grid[x][y] == times) {
                return true;
            }
            if (grid[x][y] != 0) {
                return false;
            }
            // grid[x][y] == 0
            grid[x][y] = times;
            return dfs(x + 1, y, m, n, times, grid) && dfs(x - 1, y, m, n, times, grid)
                && dfs(x, y + 1, m, n, times, grid) && dfs(x, y - 1, m, n, times, grid);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(2, s.closedIsland(Arrs
        // .build2D("[[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]")));

        Assert.assertEquals(1, s.closedIsland(Arrs.build2D("[[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]")));

        Assert.assertEquals(2, s.closedIsland(Arrs.build2D(
            "[[1,1,1,1,1,1,1],[1,0,0,0,0,0,1],[1,0,1,1,1,0,1],[1,0,1,0,1,0,1],[1,0,1,1,1,0,1],[1,1,1,1,1,1,1]]")));
    }

}
