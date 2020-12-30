package redo.p0500_0599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P598  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class P598 {

    class Solution {
        public int maxCount(int m, int n, int[][] ops) {
            int minX = m, minY = n;
            for (int[] op : ops) {
                minX = Math.min(minX, op[0]);
                minY = Math.min(minY, op[1]);
            }
            return minX * minY;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.maxCount(3, 3, new int[][] {{2, 2}, {3, 3}}));
        Assert.assertEquals(9, s.maxCount(3, 3, new int[][] {}));
    }

}
