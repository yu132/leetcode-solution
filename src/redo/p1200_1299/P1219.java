package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1219  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P1219 {

    class Solution {

        int max = 0;

        public int getMaximumGold(int[][] grid) {
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    backtrack(i, j, 0, new boolean[grid.length][grid[0].length], grid);
                }
            }
            return max;
        }

        public void backtrack(int x, int y, int val, boolean[][] visited, int[][] grid) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return;
            }
            if (grid[x][y] == 0) {
                return;
            }
            if (visited[x][y]) {
                return;
            }
            visited[x][y] = true;
            val += grid[x][y];
            max = Math.max(max, val);
            backtrack(x + 1, y, val, visited, grid);
            backtrack(x - 1, y, val, visited, grid);
            backtrack(x, y + 1, val, visited, grid);
            backtrack(x, y - 1, val, visited, grid);
            visited[x][y] = false;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(24, s.getMaximumGold(Arrs.build2D("[[0,6,0],[5,8,7],[0,9,0]]")));
        Assert.assertEquals(28, s.getMaximumGold(Arrs.build2D("[[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]")));
    }

}
