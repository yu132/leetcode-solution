package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P892  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月23日  
 *  
 */
public class P892 {

    class Solution {
        public int surfaceArea(int[][] grid) {
            int sum = 0;
            for (int[] each : grid) {
                for (int num : each) {
                    if (num != 0) {
                        sum += 1 + 1 + 4 * num;
                    }
                }
            }
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 1; j < grid[0].length; ++j) {
                    sum -= 2 * Math.min(grid[i][j], grid[i][j - 1]);
                }
            }

            for (int j = 0; j < grid[0].length; ++j) {
                for (int i = 1; i < grid.length; ++i) {
                    sum -= 2 * Math.min(grid[i][j], grid[i - 1][j]);
                }
            }

            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(10, s.surfaceArea(Arrs.build2D("[[2]]")));
        Assert.assertEquals(34, s.surfaceArea(Arrs.build2D("[[1,2],[3,4]]")));
        Assert.assertEquals(16, s.surfaceArea(Arrs.build2D("[[1,0],[0,2]]")));
        Assert.assertEquals(32, s.surfaceArea(Arrs.build2D("[[1,1,1],[1,0,1],[1,1,1]]")));
        Assert.assertEquals(46, s.surfaceArea(Arrs.build2D("[[2,2,2],[2,1,2],[2,2,2]]")));
    }

}
