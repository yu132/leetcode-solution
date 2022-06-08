package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1523  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1523 {

    class Solution {
        public int countOdds(int low, int high) {
            if ((high - low) % 2 == 0) {
                if (low % 2 == 0) {
                    return (high - low) / 2;
                } else {
                    return (high - low) / 2 + 1;
                }
            } else {
                return (high - low) / 2 + 1;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.countOdds(3, 7));
        Assert.assertEquals(1, s.countOdds(8, 10));
        Assert.assertEquals(2, s.countOdds(9, 11));
        Assert.assertEquals(2, s.countOdds(9, 12));
    }

}
