package redo.p1600_1699;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1637  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1637 {

    class Solution {
        public int maxWidthOfVerticalArea(int[][] points) {
            Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
            int max = 0;
            for (int i = 1; i < points.length; ++i) {
                max = Math.max(max, points[i][0] - points[i - 1][0]);
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.maxWidthOfVerticalArea(Arrs.build2D("[[8,7],[9,9],[7,4],[9,7]]")));
        Assert.assertEquals(3, s.maxWidthOfVerticalArea(Arrs.build2D("[[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]")));
    }

}
