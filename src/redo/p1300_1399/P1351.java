package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1351  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1351 {

    class Solution {
        public int countNegatives(int[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (grid[i][j] < 0) {
                        ++count;
                    }
                }
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(8, s.countNegatives(Arrs.build2D("[[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]")));
        Assert.assertEquals(0, s.countNegatives(Arrs.build2D("[[3,2],[1,0]]")));
        Assert.assertEquals(3, s.countNegatives(Arrs.build2D("[[1,-1],[-1,-1]]")));
        Assert.assertEquals(1, s.countNegatives(Arrs.build2D("[[-1]]")));
    }

}
