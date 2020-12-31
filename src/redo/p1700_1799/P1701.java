package redo.p1700_1799;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1701  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class P1701 {

    class Solution {
        public double averageWaitingTime(int[][] customers) {
            int finish = 0;
            long wait = 0;
            for (int[] customer : customers) {
                if (customer[0] > finish) {
                    finish = customer[0];
                }
                wait += (finish - customer[0]) + customer[1];
                finish += customer[1];
            }
            return (double)wait / customers.length;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5.0, s.averageWaitingTime(Arrs.build2D("[[1,2],[2,5],[4,3]]")), 0.00001);
        Assert.assertEquals(3.25, s.averageWaitingTime(Arrs.build2D("[[5,2],[5,4],[10,3],[20,1]]")), 0.00001);
    }

}
