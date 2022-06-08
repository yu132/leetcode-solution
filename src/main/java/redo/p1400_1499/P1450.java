package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1450  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1450 {

    class Solution {
        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            int count = 0;
            for (int i = 0; i < startTime.length; ++i) {
                if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                    ++count;
                }
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.busyStudent(new int[] {1, 2, 3}, new int[] {3, 2, 7}, 4));
        Assert.assertEquals(1, s.busyStudent(new int[] {4}, new int[] {4}, 4));
        Assert.assertEquals(0, s.busyStudent(new int[] {4}, new int[] {4}, 5));
    }

}
