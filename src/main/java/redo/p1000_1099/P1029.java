package redo.p1000_1099;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1029  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1029 {

    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            Arrays.sort(costs, (a, b) -> Integer.compare(a[0] - a[1], b[0] - b[1]));

            int sum = 0;
            int nHalf = costs.length / 2;
            for (int i = 0; i < nHalf; ++i) {
                sum += costs[i][0] + costs[i + nHalf][1];
            }

            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(110, s.twoCitySchedCost(Arrs.build2D("[[10,20],[30,200],[400,50],[30,20]]")));
    }

}
