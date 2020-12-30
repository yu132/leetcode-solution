package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1184  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1184 {

    class Solution {
        public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            int s2d = 0, d2s = 0;
            boolean s2dNow = true;
            for (int i = start;; ++i) {
                if (i == distance.length) {
                    i = 0;
                }
                if (i == start && !s2dNow) {
                    break;
                }
                if (i == destination) {
                    s2dNow = false;
                }
                if (s2dNow) {
                    s2d += distance[i];
                } else {
                    d2s += distance[i];
                }
            }
            return Math.min(s2d, d2s);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.distanceBetweenBusStops(new int[] {1, 2, 3, 4}, 0, 1));
        Assert.assertEquals(3, s.distanceBetweenBusStops(new int[] {1, 2, 3, 4}, 0, 2));
        Assert.assertEquals(4, s.distanceBetweenBusStops(new int[] {1, 2, 3, 4}, 0, 3));
    }

}
