package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1401  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月9日  
 *  
 */
public class P1401 {

    class Solution {
        public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
            int xDiff = min(x_center, x1, x2), yDiff = min(y_center, y1, y2);
            return xDiff * xDiff + yDiff * yDiff <= radius * radius;
        }

        int min(int center, int p1, int p2) {
            if (center < p1) {
                return p1 - center;
            } else if (p1 <= center && center <= p2) {
                return 0;
            } else {// p2<center
                return center - p2;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.checkOverlap(1, 0, 0, 1, -1, 3, 1));
        Assert.assertEquals(true, s.checkOverlap(1, 0, 0, -1, 0, 0, 1));
        Assert.assertEquals(true, s.checkOverlap(1, 1, 1, -3, -3, 3, 3));
        Assert.assertEquals(false, s.checkOverlap(1, 1, 1, 1, -3, 2, -1));
    }

}
