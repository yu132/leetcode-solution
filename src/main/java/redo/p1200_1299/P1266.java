package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1266  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1266 {

    class Solution {
        public int minTimeToVisitAllPoints(int[][] points) {
            int ans = 0;
            for (int i = 1; i < points.length; ++i) {
                ans += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(7, s.minTimeToVisitAllPoints(Arrs.build2D("[[1,1],[3,4],[-1,0]]")));
        Assert.assertEquals(5, s.minTimeToVisitAllPoints(Arrs.build2D("[[3,2],[-2,2]]")));
    }

}
