package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P883  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class P883 {

    class Solution {
        public int projectionArea(int[][] grid) {
            int[] x = new int[grid.length];
            int[] y = new int[grid[0].length];
            int base = 0;
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    x[i] = Math.max(x[i], grid[i][j]);
                    y[j] = Math.max(y[j], grid[i][j]);
                    base += (grid[i][j] != 0 ? 1 : 0);
                }
            }
            int sum = 0;
            for (int num : x) {
                sum += num;
            }
            for (int num : y) {
                sum += num;
            }
            return sum + base;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(5, s.projectionArea(Arrs.build2D("[[2]]")));
        Assert.assertEquals(17, s.projectionArea(Arrs.build2D("[[1,2],[3,4]]")));
    }

}
