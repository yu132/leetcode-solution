package redo.p1000_1099;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1094  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月15日  
 *  
 */
public class P1094 {

    static//

    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int countNow = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
            Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
            for (int[] trip : trips) {
                while (!pq.isEmpty() && pq.peek()[2] <= trip[1]) {
                    countNow -= pq.poll()[0];
                }
                countNow += trip[0];
                if (countNow > capacity) {
                    return false;
                }
                pq.offer(trip);
            }
            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(false, s.carPooling(Arrs.build2D("[[2,1,5],[3,3,7]]"), 4));
        Assert.assertEquals(true, s.carPooling(Arrs.build2D("[[2,1,5],[3,3,7]]"), 5));
        Assert.assertEquals(true, s.carPooling(Arrs.build2D("[[2,1,5],[3,5,7]]"), 3));
        Assert.assertEquals(true, s.carPooling(Arrs.build2D("[[3,2,7],[3,7,9],[8,3,9]]"), 11));
    }

}
