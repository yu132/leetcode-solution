package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1217  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1217 {

    class Solution {
        public int minCostToMoveChips(int[] position) {
            int even = 0;
            for (int i = 0; i < position.length; ++i) {
                if (position[i] % 2 == 0) {
                    ++even;
                }
            }
            return Math.min(even, position.length - even);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.minCostToMoveChips(new int[] {1, 2, 3}));
        Assert.assertEquals(2, s.minCostToMoveChips(new int[] {2, 2, 2, 3, 3}));
    }

}
