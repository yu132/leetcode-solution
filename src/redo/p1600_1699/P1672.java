package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1672  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1672 {

    static//

    class Solution {
        public int maximumWealth(int[][] accounts) {
            int max = 0;
            for (int[] wealth : accounts) {
                max = Math.max(max, sum(wealth));
            }
            return max;
        }

        public static int sum(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.maximumWealth(Arrs.build2D("[[1,2,3],[3,2,1]]")));
        Assert.assertEquals(10, s.maximumWealth(Arrs.build2D("[[1,5],[7,3],[3,5]]")));
        Assert.assertEquals(17, s.maximumWealth(Arrs.build2D("[[2,8,7],[7,1,3],[1,9,5]]")));
    }

}
