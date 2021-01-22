package redo.p1200_1299;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1288  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class P1288 {

    class Solution {
        public int removeCoveredIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(b[1], a[1]);
                }
                return Integer.compare(a[0], b[0]);
            });
            int maxLast = 0, count = 0;
            for (int[] interval : intervals) {
                if (interval[1] <= maxLast) {
                    ++count;
                } else {
                    maxLast = interval[1];
                }
            }
            return intervals.length - count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.removeCoveredIntervals(Arrs.build2D("[[1,4],[3,6],[2,8]]")));
        Assert.assertEquals(2, s.removeCoveredIntervals(Arrs.build2D("[[3,10],[4,10],[5,11]]")));
    }

}
