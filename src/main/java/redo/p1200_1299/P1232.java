package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1232  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1232 {

    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            if (coordinates.length <= 2) {
                return true;
            }
            int p2xMinusP1x = coordinates[1][0] - coordinates[0][0];
            int p2yMinusP1y = coordinates[1][1] - coordinates[0][1];
            for (int i = 2; i < coordinates.length; ++i) {
                if ((coordinates[i][0] - coordinates[0][0]) * p2yMinusP1y != (coordinates[i][1] - coordinates[0][1])
                    * p2xMinusP1x) {
                    return false;
                }
            }
            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.checkStraightLine(Arrs.build2D("[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]")));
        Assert.assertEquals(false, s.checkStraightLine(Arrs.build2D("[[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]")));
    }

}
