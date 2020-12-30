package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1037  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1037 {

    class Solution {
        public boolean isBoomerang(int[][] points) {
            return area(points[0][0], points[0][1], points[1][0], points[1][1], points[2][0], points[2][1]) != 0;
        }

        private double area(int x1, int y1, int x2, int y2, int x3, int y3) {
            return Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2) / 2.0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isBoomerang(Arrs.build2D("[[1,1],[2,3],[3,2]]")));
        Assert.assertEquals(false, s.isBoomerang(Arrs.build2D("[[1,1],[2,2],[3,3]]")));
        Assert.assertEquals(false, s.isBoomerang(Arrs.build2D("[[1,1],[1,2],[1,3]]")));
        Assert.assertEquals(true, s.isBoomerang(Arrs.build2D("[[1,1],[1,2],[2,3]]")));
        Assert.assertEquals(false, s.isBoomerang(Arrs.build2D("[[0,0],[1,1],[1,1]]")));
    }

}
