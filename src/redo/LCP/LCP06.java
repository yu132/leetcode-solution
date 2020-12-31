package redo.LCP;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: LCP06  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class LCP06 {

    class Solution {
        public int minCount(int[] coins) {
            int count = 0;
            for (int coin : coins) {
                count += (coin + 1) / 2;
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.minCount(new int[] {4, 2, 1}));
        Assert.assertEquals(8, s.minCount(new int[] {2, 3, 10}));
    }
}
