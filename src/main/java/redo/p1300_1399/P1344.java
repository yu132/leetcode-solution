package redo.p1300_1399;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1344  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1344 {

    class Solution {
        public double angleClock(int hour, int minutes) {
            hour = hour % 12;
            double hourAngle = (double)hour * (360 / 12) + (360 / 12) * ((double)minutes / 60);
            double minAngle = (double)minutes * (360 / 60);
            double diff = Math.abs(hourAngle - minAngle);
            return diff > 180 ? 360 - diff : diff;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(165, s.angleClock(12, 30), 0.00001);
        Assert.assertEquals(75, s.angleClock(3, 30), 0.00001);
        Assert.assertEquals(7.5, s.angleClock(3, 15), 0.00001);
        Assert.assertEquals(155, s.angleClock(4, 50), 0.00001);
        Assert.assertEquals(0, s.angleClock(12, 0), 0.00001);
        Assert.assertEquals(130.5, s.angleClock(6, 9), 0.00001);
        Assert.assertEquals(142.5, s.angleClock(1, 45), 0.00001);
    }

}
