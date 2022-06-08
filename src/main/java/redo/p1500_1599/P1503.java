package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1503  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月6日  
 *  
 */
public class P1503 {

    class Solution {
        public int getLastMoment(int n, int[] left, int[] right) {
            int max = 0;
            for (int index : left) {
                max = Math.max(max, index);
            }
            for (int index : right) {
                max = Math.max(max, n - index);
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.getLastMoment(4, new int[] {4, 3}, new int[] {0, 1}));
        Assert.assertEquals(7, s.getLastMoment(7, new int[] {}, new int[] {0, 1, 2, 3, 4, 5, 6, 7}));
        Assert.assertEquals(7, s.getLastMoment(7, new int[] {0, 1, 2, 3, 4, 5, 6, 7}, new int[] {}));
        Assert.assertEquals(5, s.getLastMoment(9, new int[] {5}, new int[] {4}));
        Assert.assertEquals(6, s.getLastMoment(6, new int[] {6}, new int[] {0}));
    }

}
